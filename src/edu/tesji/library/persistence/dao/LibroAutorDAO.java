package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.LibroAutor;

public class LibroAutorDAO {
	private static final Logger LOG = Logger.getLogger(LibroAutorDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_LIBROAUTOR = "SELECT idlibro, idautor FROM libroautor";
	private static final String QUERY_INSERT_LIBROAUTOR = "INSERT INTO libroautor(idlibro,idautor) VALUES (?,?)";

	public List<LibroAutor> selectLibroAutor() {
		List<LibroAutor> libroAutorList = new ArrayList<LibroAutor>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_LIBROAUTOR);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				LibroAutor libroAutor = new LibroAutor(resultSet.getInt("idlibro"), resultSet.getInt("idautor"));
				libroAutorList.add(libroAutor);
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
		return libroAutorList;
	}

	public int insertLibroAutor(LibroAutor libroAutorIn) {
		Connection connection = null;
		int insertedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_INSERT_LIBROAUTOR);
			prepStatement.setInt(1, libroAutorIn.getIdLibro());
			prepStatement.setInt(2, libroAutorIn.getIdAutor());
			insertedRows = prepStatement.executeUpdate();

			if (insertedRows == 1) {
				LOG.info("Se ha insertado correctamente el registro" + "idLibro" + libroAutorIn.getIdLibro() + "idAutor"
						+ libroAutorIn.getIdAutor());
			} else {
				LOG.info("No se ha insertado correctamente el registro" + "idLibro" + libroAutorIn.getIdLibro()
						+ "idAutor" + libroAutorIn.getIdAutor());
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

}
