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
	private static final String QUERY_SELECT_ALL_AUTOR = "SELECT idautor,nombrecompleto,nacionalidad FROM autor";
	private static final String QUERY_INSERT_AUTOR = "INSERT INTO autor (nombrecompleto, nacionalidad) values (?,?) ";
	private static final String QUERY_DELETE_AUTOR = "DELETE  autor WHERE idautor =?'";
	private static final String QUERY_UPDATE_AUTOR = "UPDATE autor SET nombrecompleto = ?, nacionalidad = ? WHERE Idautor=?";

	public List<Autor> selectAutor() {
		List<Autor> autorList = new ArrayList<Autor>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_AUTOR);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Autor autor = new Autor(resultSet.getInt("idAutor"), resultSet.getString("nombreCompleto"),
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
			prepStatement.setString(1, autor.getNombreCompleto());
			prepStatement.setString(2, autor.getNacionalidad());

			insertedRows = prepStatement.executeUpdate();

			if (insertedRows == 1) {/* Si un registro es afectado pasará a agregarse */
				LOG.info("Se ha insertado correctamente el registro" + "[nombreCompleto=" + autor.getNombreCompleto()
						+ ",nacionalidad=" + autor.getNacionalidad() + "]");
			} else {
				LOG.info("No se ha insertado el registro" + "[nombreCompleto=" + autor.getNombreCompleto()
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
				LOG.info("Se ha eliminado correctamente los registro del id " + autorDe.toString());
			} else {
				LOG.info("No se eliminaron correctamente los registros del id " + autorDe.toString());
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
				LOG.info("Se han actualizado correctamente los registros  Nombre Autor " + autorUp.toString());
			} else {
				LOG.info("No han actualizado correctamente los registros  Nombre Autor " + autorUp.toString());
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