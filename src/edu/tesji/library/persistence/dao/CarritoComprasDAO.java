package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.CarritoCompras;
import edu.tesji.library.entities.StatusCarritoCompra;

public class CarritoComprasDAO {
	private static final Logger LOG = Logger.getLogger(CarritoComprasDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_ALL_CARRITOCOMPRAS = "SELECT idcarritocompras, fechacompra, fechaentrega"
			+ ", lugarentrega, idstatuscarrito,folio,nombrecomprador FROM carritocompras";
	private static final String QUERY_SELECT_CARRITOCOMPRAS_BY_FECHACOMPRA = "SELECT * FROM carritocompras WHERE"
			+ " fechacompra BETWEEN ? AND ?";
	private static final String QUERY_SELECT_CARRITOCOMPRAS_BY_FECHAENTREGA = "SELECT * FROM carritocompras WHERE"
			+ " fechaentrega BETWEEN ? AND ?";
	private static final String QUERY_SELECT_CARRITOCOMPRAS_BY_LUGARENTREGA = "SELECT * FROM carritocompras WHERE"
			+ " lugarentrega LIKE ?";

	private static final String QUERY_SELECT_CARRITOCOMPRAS_BY_STATUS = "SELECT * FROM carritocompras WHERE"
			+ " idstatuscarrito = ?";
	private static final String QUERY_SELECT_CARRITOCOMPRAS_BY_FOLIO = "SELECT * FROM carritocompras WHERE"
			+ " foliocarritocompras = ?";
	private static final String QUERY_SELECT_CARRITOCOMPRAS_BY_NOMBRECOMPRADOR = "SELECT * FROM carritocompras WHERE"
			+ " nombrecomprador LIKE ?";
	private static final String QUERY_INSERT_CARRITOCOMPRAS = "INSERT INTO carritocompras ( fechacompra,fechaentrega, lugarentrega, idstatuscarrito,foliocarritocompras,nombrecomprador,) values (?,?,?,?,?,?)";
	private static final String QUERY_DELET_CARRITOCOMPRAS = "DELETE FROM carritocompras WHERE idcarritocompras = ? ";
	private static final String QUERY_UPDATE_CARRITOCOMPRAS = "UPDATE carritocompras SET fechacompra  = ? , fechaentrega = ?, lugarentrega = ?, idstatuscarrito = ?,foliocarritocompras = ?, nombrecomprador = ?  WHERE idcarritocompras= ?";

	public List<CarritoCompras> selectAllCarritoCompras() {
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
						resultSet.getString("lugarentrega"), 
						StatusCarritoCompra.valueOfIdStatus(resultSet.getInt("idstatuscarrito")),
						resultSet.getString("folio"), resultSet.getString("nombrecomprador"));
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
	
	public List<CarritoCompras> selectCarritoComprasByFechaCompra(Date fechaInicial, Date fechaFinal) {
		List<CarritoCompras> carritoComprasList = new ArrayList<CarritoCompras>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_CARRITOCOMPRAS_BY_FECHACOMPRA);
			prepStatement.setDate(1, fechaInicial);
			prepStatement.setDate(2, fechaFinal);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				CarritoCompras carritoCompra = new CarritoCompras(resultSet.getInt("idcarritocompras"),
						resultSet.getDate("fechacompra"), resultSet.getDate("fechaEntrega"),
						resultSet.getString("lugarentrega"), 
						StatusCarritoCompra.valueOfIdStatus(resultSet.getInt("idstatuscarrito")),
						resultSet.getString("folio"), resultSet.getString("nombrecomprador"));
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
	
	public List<CarritoCompras> selectCarritoComprasByFechaEntrega(Date fechaInicial, Date fechaFinal) {
		List<CarritoCompras> carritoComprasList = new ArrayList<CarritoCompras>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_CARRITOCOMPRAS_BY_FECHAENTREGA);
			prepStatement.setDate(1, fechaInicial);
			prepStatement.setDate(2, fechaFinal);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				CarritoCompras carritoCompra = new CarritoCompras(resultSet.getInt("idcarritocompras"),
						resultSet.getDate("fechacompra"), resultSet.getDate("fechaEntrega"),
						resultSet.getString("lugarentrega"), 
						StatusCarritoCompra.valueOfIdStatus(resultSet.getInt("idstatuscarrito")),
						resultSet.getString("folio"), resultSet.getString("nombrecomprador"));
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
	
	public List<CarritoCompras> selectCarritoComprasByLugarEntrega(String lugarEntrega) {
		List<CarritoCompras> carritoComprasList = new ArrayList<CarritoCompras>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_CARRITOCOMPRAS_BY_LUGARENTREGA);
			prepStatement.setString(1, "%" + lugarEntrega + "%");
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				CarritoCompras carritoCompra = new CarritoCompras(resultSet.getInt("idcarritocompras"),
						resultSet.getDate("fechacompra"), resultSet.getDate("fechaEntrega"),
						resultSet.getString("lugarentrega"), 
						StatusCarritoCompra.valueOfIdStatus(resultSet.getInt("idstatuscarrito")),
						resultSet.getString("folio"), resultSet.getString("nombrecomprador"));
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

	public List<CarritoCompras> selectCarritoComprasByStatus(StatusCarritoCompra status) {
		List<CarritoCompras> carritoComprasList = new ArrayList<CarritoCompras>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_CARRITOCOMPRAS_BY_STATUS);
			prepStatement.setInt(1, status.idStatus);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				CarritoCompras carritoCompra = new CarritoCompras(resultSet.getInt("idcarritocompras"),
						resultSet.getDate("fechacompra"), resultSet.getDate("fechaEntrega"),
						resultSet.getString("lugarentrega"), 
						StatusCarritoCompra.valueOfIdStatus(resultSet.getInt("idstatuscarrito")),
						resultSet.getString("folio"), resultSet.getString("nombrecomprador"));
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

	public List<CarritoCompras> selectCarritoComprasByFolio(String folio) {
		List<CarritoCompras> carritoComprasList = new ArrayList<CarritoCompras>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_CARRITOCOMPRAS_BY_FOLIO);
			prepStatement.setString(1, folio);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				CarritoCompras carritoCompra = new CarritoCompras(resultSet.getInt("idcarritocompras"),
						resultSet.getDate("fechacompra"), resultSet.getDate("fechaEntrega"),
						resultSet.getString("lugarentrega"), 
						StatusCarritoCompra.valueOfIdStatus(resultSet.getInt("idstatuscarrito")),
						resultSet.getString("folio"), resultSet.getString("nombrecomprador"));
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
	
	public List<CarritoCompras> selectCarritoComprasByNombreComprador(String nombreComprador) {
		List<CarritoCompras> carritoComprasList = new ArrayList<CarritoCompras>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_CARRITOCOMPRAS_BY_NOMBRECOMPRADOR);
			prepStatement.setString(1, "%" + nombreComprador + "%");
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				CarritoCompras carritoCompra = new CarritoCompras(resultSet.getInt("idcarritocompras"),
						resultSet.getDate("fechacompra"), resultSet.getDate("fechaEntrega"),
						resultSet.getString("lugarentrega"), 
						StatusCarritoCompra.valueOfIdStatus(resultSet.getInt("idstatuscarrito")),
						resultSet.getString("folio"), resultSet.getString("nombrecomprador"));
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
			prepStatement.setInt(4, carritoCompras.getStatus().idStatus);
			prepStatement.setString(5, carritoCompras.getFolio());
			prepStatement.setString(6, carritoCompras.getNombrecomprador());

			insertedRows = prepStatement.executeUpdate();

			if (insertedRows == 1) {
				LOG.info("Se ha insertado correctamente el registro: " + carritoCompras.toString());
			} else {
				LOG.info("No se ha insertado correctamente el registro: " + carritoCompras.toString());
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
				LOG.info("El registro " + carritoCompras.toString() + "Ha sido actualizado correctamente");
			} else {
				LOG.info("El registro " + carritoCompras.toString() + "Noo ha sido actualizado correctamente");
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
