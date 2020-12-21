package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.Autor;
import edu.tesji.library.entities.DetalleCarritoCompras;

public class DetalleCarritoComprasDAO {
	private static final Logger LOG = Logger.getLogger(DetalleCarritoComprasDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_ALL_DETALLECARRITOCOMPRAS = "SELECT iddetallecarritocompras,idcarritocompras,idlibro,cantidad,preciounitarioventa,preciounitariocompra FROM detallecarritocompras";
	private static final String QUERY_INSERT_DETALLECARRITOCOMPRAS = "INSERT INTO detallecarritocompras (idcarritocompras, idlibro,cantidad,preciounitarioventa,preciounitariocompra) values (?,?,?,?,?)";
	private static final String QUERY_DELETE_DETALLECARRITOCOMPRAS = "DELETE FROM detallecarritocompras where idcarritocompras = '5'";
	private static final String QUERY_UPDATE_DETALLE_CARRITOCOMPRAS = "UPDATE detallecarritocompras SET idcarritocompras = ?, idlibro = ?, cantidad = ?, preciounitarioventa = ? ,preciounitariocompra = ? WHERE iddetallecarritocompras= ?";

	public List<DetalleCarritoCompras> selectDetalleCarritoCompras() {
		List<DetalleCarritoCompras> detalleCarritoComprasList = new ArrayList<DetalleCarritoCompras>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_DETALLECARRITOCOMPRAS);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				DetalleCarritoCompras detalleCarritoCompras = new DetalleCarritoCompras(
						resultSet.getInt("iddetallecarritocompras"), resultSet.getInt("idcarritocompras"),
						resultSet.getInt("idlibro"), resultSet.getInt("cantidad"),
						resultSet.getBigDecimal("preciounitarioventa"),
						resultSet.getBigDecimal("preciounitariocompra"));
				detalleCarritoComprasList.add(detalleCarritoCompras);
			}
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOG.error("SQLException", e);
				}
			}
		}
		return detalleCarritoComprasList;
	}

	public int insertDetalleCarritoCompras(DetalleCarritoCompras detalleCarritoComprasIn) {
		Connection connection = null;
		int insertedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_INSERT_DETALLECARRITOCOMPRAS);
			prepStatement.setInt(1, detalleCarritoComprasIn.getIdCarritoCompras());
			prepStatement.setInt(2, detalleCarritoComprasIn.getIdLibro());
			prepStatement.setInt(3, detalleCarritoComprasIn.getCantidad());
			prepStatement.setBigDecimal(4, detalleCarritoComprasIn.getPrecioUnitarioCompra());
			prepStatement.setBigDecimal(5, detalleCarritoComprasIn.getPrecioUnitarioVenta());

			insertedRows = prepStatement.executeUpdate();
			if (insertedRows == 1) {
				LOG.info("Se ha insertado correctamente el registo" + "idCarritoCompras"
						+ detalleCarritoComprasIn.getIdDetalleCarritoCompras() + "idLibro"
						+ detalleCarritoComprasIn.getIdLibro() + "Cantidad" + detalleCarritoComprasIn.getCantidad()
						+ "PrecioUnitarioCompra" + detalleCarritoComprasIn.getPrecioUnitarioCompra()
						+ "PrecioUnitarioVenta" + detalleCarritoComprasIn.getPrecioUnitarioVenta());
			} else {
				LOG.info("No se ha insertado correctamente el registo" + "idCarritoCompras"
						+ detalleCarritoComprasIn.getIdDetalleCarritoCompras() + "idLibro"
						+ detalleCarritoComprasIn.getIdLibro() + "Cantidad" + detalleCarritoComprasIn.getCantidad()
						+ "PrecioUnitarioCompra" + detalleCarritoComprasIn.getPrecioUnitarioCompra()
						+ "PrecioUnitarioVenta" + detalleCarritoComprasIn.getPrecioUnitarioVenta());
			}
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOG.error("SQLException", e);
				}
			}
		}
		return insertedRows;
	}

	public int deleteDetalleCarritoCompras(DetalleCarritoCompras detalleCarritoCompras) {
		Connection connection = null;
		int deletedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_DELETE_DETALLECARRITOCOMPRAS);
			prepStatement.setInt(1, detalleCarritoCompras.getIdDetalleCarritoCompras());
			deletedRows = prepStatement.executeUpdate();
			if (deletedRows == 1) {
				LOG.info("Los registros del id" + detalleCarritoCompras.getIdCarritoCompras()
						+ "han sido eliminados Correctamente");
			} else {
				LOG.info("Los registros del id" + detalleCarritoCompras.getIdCarritoCompras()
						+ " No han sido eliminados Correctamente");

			}
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOG.error("SQLException", e);
				}
			}
		}
		return deletedRows;

	}

	public int updateDetalleCC(DetalleCarritoCompras detalleCarritoC) {
		Connection connection = null;
		int updatedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_UPDATE_DETALLE_CARRITOCOMPRAS);
			prepStatement.setInt(1, detalleCarritoC.getIdDetalleCarritoCompras());

			updatedRows = prepStatement.executeUpdate();

			if (updatedRows == 1) {
				LOG.info("Se han actualizado correctamente los registros   " + detalleCarritoC.toString());
			} else {
				LOG.info("No han actualizado correctamente los registros  " + detalleCarritoC.toString());
			}
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOG.error("SQLExceptión");
				}
			}
		}
		return updatedRows;

	}

}
