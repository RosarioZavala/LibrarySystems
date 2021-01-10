package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.Autor;

public class AutorDAO {

	private static final Logger LOG = Logger.getLogger(AutorDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_ALL_AUTOR = "SELECT idautor, claveautor,nombrecompleto,nacionalidad FROM autor"
			+ " ORDER BY nombrecompleto ASC";
	private static final String QUERY_SELECT_AUTOR_BY_ID = "SELECT idautor, claveautor,nombrecompleto,nacionalidad "
			+ "FROM autor WHERE idautor = ?";
	private static final String QUERY_SELECT_AUTOR_BY_CLAVEAUTOR = "SELECT idautor, claveautor,nombrecompleto,nacionalidad "
			+ "FROM autor WHERE claveautor = ?";
	private static final String QUERY_SELECT_AUTOR_BY_NOMBRECOMPLETO = "SELECT idautor, claveautor,nombrecompleto,nacionalidad "
			+ "FROM autor WHERE nombrecompleto LIKE ?";
	private static final String QUERY_SELECT_AUTOR_BY_NACIONALIDAD = "SELECT idautor, claveautor,nombrecompleto,nacionalidad "
			+ "FROM autor WHERE nacionalidad LIKE ?";
	private static final String QUERY_INSERT_AUTOR = "INSERT INTO autor (claveautor,nombrecompleto, nacionalidad) values (?,?,?) ";
	private static final String QUERY_DELETE_AUTOR = "DELETE  autor WHERE idautor =?";
	private static final String QUERY_UPDATE_AUTOR = "UPDATE autor SET claveautor =?,nombrecompleto = ?, nacionalidad = ? WHERE idautor=?";

	public List<Autor> selectAllAutor() {
		List<Autor> autorList = new ArrayList<Autor>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_AUTOR);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Autor autor = new Autor(resultSet.getInt("idAutor"),resultSet.getString("ClaveAutor"), resultSet.getString("nombreCompleto"),
						resultSet.getString("nacionalidad"));
				autorList.add(autor);
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
		return autorList;
	}

	public List<Autor> findAutorByIdAutor(int idAutor) {
		List<Autor> autorList = new ArrayList<Autor>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_AUTOR_BY_ID);
			prepStatement.setInt(1, idAutor);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Autor autor = new Autor(resultSet.getInt("idAutor"),resultSet.getString("ClaveAutor"), resultSet.getString("nombreCompleto"),
						resultSet.getString("nacionalidad"));
				autorList.add(autor);
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
		return autorList;
	}

	public List<Autor> findAutorByClaveAutor(String claveAutor) {
		List<Autor> autorList = new ArrayList<Autor>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_AUTOR_BY_CLAVEAUTOR);
			prepStatement.setString(1, claveAutor);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Autor autor = new Autor(resultSet.getInt("idAutor"),resultSet.getString("ClaveAutor"), resultSet.getString("nombreCompleto"),
						resultSet.getString("nacionalidad"));
				autorList.add(autor);
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
		return autorList;
	}

	public List<Autor> findAutorByNombreCompleto(String nombreCompleto) {
		List<Autor> autorList = new ArrayList<Autor>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_AUTOR_BY_NOMBRECOMPLETO);
			prepStatement.setString(1, "%" + nombreCompleto + "%");
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Autor autor = new Autor(resultSet.getInt("idAutor"),resultSet.getString("ClaveAutor"), resultSet.getString("nombreCompleto"),
						resultSet.getString("nacionalidad"));
				autorList.add(autor);
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
		return autorList;
	}

	public List<Autor> findAutorByNacionalidad(String nacionalidad) {
		List<Autor> autorList = new ArrayList<Autor>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_AUTOR_BY_NACIONALIDAD);
			prepStatement.setString(1, "%" + nacionalidad + "%");
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Autor autor = new Autor(resultSet.getInt("idAutor"),resultSet.getString("ClaveAutor"), resultSet.getString("nombreCompleto"),
						resultSet.getString("nacionalidad"));
				autorList.add(autor);
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
		return autorList;
	}

	public int insertAutor(Autor autor) {
		Connection connection = null;
		int insertedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_INSERT_AUTOR);
			prepStatement.setString(1, autor.getClaveautor());
			prepStatement.setString(2, autor.getNombreCompleto());
			prepStatement.setString(3, autor.getNacionalidad());

			insertedRows = prepStatement.executeUpdate();

			if (insertedRows == 1) {/* Si un registro es afectado pasará a agregarse */
				LOG.info("Se ha insertado el registro" + "[ claveAutor" + autor.getClaveautor() + "nombreCompleto=" + autor.getNombreCompleto()
						+ ",nacionalidad=" + autor.getNacionalidad() + "]");
			} else {
				LOG.info("No se han insertado correctamente el registro" +"[ claveAutor " + autor.getClaveautor() +"nombreCompleto" + autor.getNombreCompleto()
						+ ", nacionalidad" + autor.getNacionalidad() + "]");
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

	public int deleteAutor(Autor autorDe) {
		Connection connection = null;
		int deletedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_DELETE_AUTOR);
			prepStatement.setInt(1, autorDe.getIdautor());

			deletedRows = prepStatement.executeUpdate();

			if (deletedRows == 1) {
				LOG.info("Se ha eliminado correctamente el registro" + autorDe.toString());
			} else {
				LOG.info("No se elimino correctamente el registro " + autorDe.toString());
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
		return deletedRows;

	}

	public int updateAutor(Autor autorUp) {
		Connection connection = null;
		int updatedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_UPDATE_AUTOR);
			prepStatement.setInt(1, autorUp.getIdautor());

			updatedRows = prepStatement.executeUpdate();

			if (updatedRows == 1) {
				LOG.info("Se ha actualizado correctamente el registro  del Autor " + autorUp.toString());
			} else {
				LOG.info("No se ha actualizado correctamente el registro  del Autor " + autorUp.toString());
			}
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOG.error("SQLExceptión",e);
				}
			}
		}
		return updatedRows;

	}

}
