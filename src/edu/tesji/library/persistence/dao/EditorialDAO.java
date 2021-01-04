package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.Editorial;

public class EditorialDAO {

	private static final Logger LOG = Logger.getLogger(EditorialDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_ALL_EDITORIAL = "SELECT ideditorial,nombreeditorial,lugardeimpresion "
			+ " FROM editorial ORDER BY nombreeditorial ASC";
	private static final String QUERY_SELECT_EDITORIAL_BY_ID = "SELECT ideditorial,nombreeditorial,lugardeimpresion "
			+ " FROM editorial WHERE ideditorial = ? ORDER BY nombreeditorial ASC";
	private static final String QUERY_SELECT_EDITORIAL_BY_NOMBREEDITORIAL = "SELECT ideditorial,nombreeditorial,lugardeimpresion "
			+ " FROM editorial WHERE nombreeditorial LIKE ? ORDER BY nombreeditorial ASC";
	private static final String QUERY_SELECT_EDITORIAL_BY_LUGARIMPRESION = "SELECT ideditorial,nombreeditorial,lugardeimpresion "
			+ " FROM editorial WHERE lugardeimpresion LIKE ? ORDER BY nombreeditorial ASC";
	private static final String QUERY_INSERT_EDITORIAL = "INSERT INTO editorial(nombreeditorial, lugardeimpresion) VALUES (?,?)";
	private static final String QUERY_DELETE_EDITORIAL = "DELETE FROM editoriaL WHERE ideditorial = ?  ";
	private static final String QUERY_UPDATE_EDITORIAL = "UPDATE editoriaL SET nombreeditorial =?, lugardeimpresion=?";
	public List<Editorial> selectAllEditorial() {
		List<Editorial> editorialList = new ArrayList<Editorial>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			LOG.info("### Ejecutando Consulta: " + QUERY_SELECT_ALL_EDITORIAL);
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_EDITORIAL);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Editorial editorial = new Editorial(resultSet.getInt("ideditorial"),
						resultSet.getString("nombreeditorial"), resultSet.getString("lugardeimpresion"));
				editorialList.add(editorial);
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
		return editorialList;
	}

	public List<Editorial> selectEditorialById(int idEditorial) {
		List<Editorial> editorialList = new ArrayList<Editorial>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			LOG.info("### Ejecutando Consulta: " + QUERY_SELECT_EDITORIAL_BY_ID);
			prepStatement = connection.prepareStatement(QUERY_SELECT_EDITORIAL_BY_ID);
			prepStatement.setInt(1, idEditorial);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Editorial editorial = new Editorial(resultSet.getInt("ideditorial"),
						resultSet.getString("nombreeditorial"), resultSet.getString("lugardeimpresion"));
				editorialList.add(editorial);
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
		return editorialList;
	}

	public List<Editorial> selectEditorialByNombreEditorial(String nombreEditorial) {
		List<Editorial> editorialList = new ArrayList<Editorial>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			LOG.info("### Ejecutando Consulta: " + QUERY_SELECT_EDITORIAL_BY_NOMBREEDITORIAL);
			prepStatement = connection.prepareStatement(QUERY_SELECT_EDITORIAL_BY_NOMBREEDITORIAL);
			prepStatement.setString(1, "%" + nombreEditorial + "%");
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Editorial editorial = new Editorial(resultSet.getInt("ideditorial"),
						resultSet.getString("nombreeditorial"), resultSet.getString("lugardeimpresion"));
				editorialList.add(editorial);
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
		return editorialList;
	}

	public List<Editorial> selectEditorialByLugarImpresion(String lugarImpresion) {
		List<Editorial> editorialList = new ArrayList<Editorial>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			LOG.info("### Ejecutando Consulta: " + QUERY_SELECT_EDITORIAL_BY_LUGARIMPRESION);
			prepStatement = connection.prepareStatement(QUERY_SELECT_EDITORIAL_BY_LUGARIMPRESION);
			prepStatement.setString(1, "%" + lugarImpresion + "%");
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Editorial editorial = new Editorial(resultSet.getInt("ideditorial"),
						resultSet.getString("nombreeditorial"), resultSet.getString("lugardeimpresion"));
				editorialList.add(editorial);
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
		return editorialList;
	}

	public int insertEditorial(Editorial editorialIn) {
		Connection connection = null;
		int insertedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_INSERT_EDITORIAL);
			prepStatement.setString(1, editorialIn.getNombreEditorial());
			prepStatement.setString(2, editorialIn.getLugarDeImpresion());

			insertedRows = prepStatement.executeUpdate();

			if (insertedRows == 1) {
				LOG.info("Se ha insertado correctamente los registros" + "NombreEditorial"
						+ editorialIn.getNombreEditorial() + "Lugar de Impresion" + editorialIn.getLugarDeImpresion());
			} else
				LOG.info("No se ha insertado correctamente los registros" + "NombreEditorial"
						+ editorialIn.getNombreEditorial() + "Lugar de Impresion" + editorialIn.getLugarDeImpresion());
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
	
	public int deleteEditorial(Editorial editorial) {
		int deletedRows = -3;
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_DELETE_EDITORIAL);
			prepStatement.setInt(1, editorial.getIdEditorial());
			
			deletedRows = prepStatement.executeUpdate();
			
			if (deletedRows == 1) {
				LOG.info("El registro se ha eliminado correctamente" + editorial.toString());
			}else {
				LOG.info("El registro no se ha elimnado correctamente" + editorial.toString());
			}
		}catch(SQLException e) {
			LOG.error("SQLExcepion",e);
		}finally {
			if (connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					LOG.error("SQLException",e);
				}
			}
		}
		return deletedRows;
	}
	
	public int updateEditorial(Editorial editorial) {
		int updatedRows = -3;
		Connection connection = null;
		
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_UPDATE_EDITORIAL);
			prepStatement.setInt(1,editorial.getIdEditorial());
			
			updatedRows = prepStatement.executeUpdate();
			
			if (updatedRows == 1) {
				LOG.info("Se ha actualizado correctamente el registro" + editorial.toString());
			}else {
				LOG.info("No se han actualizado correctamente los registros" + editorial.toString());
			}
		}catch (SQLException e) {
			LOG.error("SQLException", e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					LOG.error("SQLException", e);
				}
			}
		}
		return  updatedRows;
	}
}