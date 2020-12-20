package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.CarritoCompras;

public class CarritoComprasDAO {
	private static final Logger LOG = Logger.getLogger(CarritoComprasDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_ALL_CARRITOCOMPRAS = "SELECT idcarritocompras, fechacompra, fechaentrega"
			+ ", lugaentrega, idstatuscarrito,folio,nombrecmprador FROM carritocompras";
	private static final String QUERY_INSERT_CARRITOCOMPRAS = "INSERT INTO carritocompras (fechacompra, fechaentrega, lugaentrega, idstatuscarrito) values (?,?,?,?)";
	private static final String QUERY_DELET_CARRITOCOMPRAS = "DELETE FROM carritocompras WHERE idcarritocompras = ? ";
	private static final String QUERY_UPDATE_CARRITOCOMPRAS = "UPDATE carritocompras SET fechacompra  = ? , fechaentrega = ?, lugaentrega = ?, idstatuscarrito = ?,foliocarritocompras = ?, nombrecomprador = ?  WHERE idcarritocompras= ?";

	public List<CarritoCompras> selectCarritoCompras() {
		List<CarritoCompras> carritoComprasList = new ArrayList<CarritoCompras>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_CARRITOCOMPRAS);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				CarritoCompras carritoCompra = new CarritoCompras(resultSet.getInt("idcarritocompras"),
						resultSet.getDate("fechacompra"), resultSet.getDate("fechaEntrega"),
						resultSet.getString("lugaentrega"), resultSet.getInt("idstaitocompra"),
						resultSet.getString("folio"), resultSet.getString("nombrecmprador"));
				carritoComprasList.add(carritoCompra);
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
		return carritoComprasList;

	}

	public int insertCarritoCompras(CarritoCompras carritoCompras) {
		Connection connection = null;
		int insertedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_INSERT_CARRITOCOMPRAS);
			prepStatement.setDate(1, carritoCompras.getFechaCompra());
			prepStatement.setDate(2, carritoCompras.getFehaEntrega());
			prepStatement.setString(3, carritoCompras.getLugarEntrega());
			prepStatement.setInt(4, carritoCompras.getIdStatus());
			prepStatement.setString(5, carritoCompras.getFolio());
			prepStatement.setString(6, carritoCompras.getNombrecmprador());

			insertedRows = prepStatement.executeUpdate();

			if (insertedRows == 1) {
				LOG.info("Se ha insertado correctamente el registro" + "[fechaCompra=" + carritoCompras.getFechaCompra()
						+ "fechaEntrega" + carritoCompras.getFehaEntrega() + "lugarEntrega"
						+ carritoCompras.getLugarEntrega() + "idStatusCarrito" + carritoCompras.getIdStatus() + "folio"
						+ carritoCompras.getFolio() + "nombrecomprador" + carritoCompras.getNombrecmprador());
			} else {
				LOG.info("No se ha insertado correctamente el registro" + "[fechaCompra="
						+ carritoCompras.getFechaCompra() + "fechaEntrega" + carritoCompras.getFechaCompra()
						+ "lugarEntrega" + carritoCompras.getLugarEntrega() + "idStatusCarrito"
						+ carritoCompras.getIdStatus() + "folio" + carritoCompras.getFolio() + "nombrecomprador"
						+ carritoCompras.getNombrecmprador());
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

	public int deleteCarritoCompras(CarritoCompras carritoCompras) {
		int deletedRows = -3;
		Connection connection = null;

		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_DELET_CARRITOCOMPRAS);
			prepStatement.setInt(1, carritoCompras.getIdCarritoCompras());

			deletedRows = prepStatement.executeUpdate();

			if (deletedRows == 1) {
				LOG.info("Los registros del id" + carritoCompras.getIdCarritoCompras()
						+ "Se han eliminado correctamente");
			} else {
				LOG.info("Los registros del id" + carritoCompras.getIdCarritoCompras()
						+ "No se han eliminado correctamente");
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

	public int updateCarritoCompras(CarritoCompras carritoCompras) {
		int updatedRows = -3;
		Connection connection = null;

		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_UPDATE_CARRITOCOMPRAS);
			prepStatement.setInt(1, carritoCompras.getIdCarritoCompras());

			updatedRows = prepStatement.executeUpdate();

			if (updatedRows == 1) {
				LOG.info("Los registros " + carritoCompras.toString() + "Han sido actualizados correctamente");
			} else {
				LOG.info("Los registros " + carritoCompras.toString() + "Noo han sido actualizados correctamente");
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

		return updatedRows;
	}

}
