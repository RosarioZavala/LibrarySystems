package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.LibroEditorial;

public class LibroEditorialDAO {
	private static final Logger LOG = Logger.getLogger(LibroEditorialDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_ALL_LIBROEDITORIAL = "SELECT idlibro, ideditorial FROM libroeditorial";
	private static final String QUERY_SELECT_BY_IDLIBRO = "SELECT idlibro,idautor FROM libroeditorial WHERE idlibro = ?";
	private static final String QUERY_SELECT_BY_IDAUTOR = "SELECT idlibro, idautor FROM libroeditorial WHERE idautor =?"; 
	private static final String QUERY_INSERT_LIBROEDITORIAL = " INSERT INTO libroeditorial(idlibro,ideditorial) VALUES (?,?)";

	public List<LibroEditorial> selectLibroAutor() {
		List<LibroEditorial> libroEditorialList = new ArrayList<LibroEditorial>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_LIBROEDITORIAL);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				LibroEditorial libroeditorial = new LibroEditorial(resultSet.getInt("idlibro"),
						resultSet.getInt("idlibro"));
				libroEditorialList.add(libroeditorial);

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
		return libroEditorialList;
	}
	
	public List<LibroEditorial> selectLibroEditorialByIdLibro (int idLibro){
		List<LibroEditorial> libroEditorialList = new ArrayList<LibroEditorial>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_BY_IDLIBRO);
			prepStatement.setInt(1, idLibro);
			resultSet = prepStatement.executeQuery();
			
			while (resultSet.next()) {
				LibroEditorial libroEditorial = new LibroEditorial(resultSet.getInt("idlibro"), resultSet.getInt("ideditorial"));
				libroEditorialList.add(libroEditorial);
			}
		}catch (SQLException e) {
			LOG.error("SQLException",e);
		}finally {
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					LOG.error("SQLException", e);
				}
			}
		}
		return libroEditorialList;
	}

	public List<LibroEditorial> selectLibroEditorialByIdEditorial (int idEditorial){
		List<LibroEditorial> libroEditorialList= new ArrayList<LibroEditorial>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_BY_IDAUTOR);
			resultSet = prepStatement.executeQuery();
			
			while (resultSet.next()) {
				LibroEditorial libroEditorial = new LibroEditorial (resultSet.getInt("idlibro"), resultSet.getInt("ideditorial"));
				 libroEditorialList.add(libroEditorial);
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
		return libroEditorialList;
	}
	public int insertLibroEditorial(LibroEditorial libroEditorialIn) {
		Connection connection = null;
		int insertedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_INSERT_LIBROEDITORIAL);
			prepStatement.setInt(1, libroEditorialIn.getIdLibro());
			prepStatement.setInt(2, libroEditorialIn.getIdEditorial());

			insertedRows = prepStatement.executeUpdate();
			if (insertedRows == 1) {
				LOG.info("Se registraron correctamente los siguientes campos" + "idLibro"
						+ libroEditorialIn.getIdLibro() + "IdEditorial" + libroEditorialIn.getIdEditorial());
			} else {
				LOG.info("No se registraron correctamente los siguientes campos" + "idLibro"
						+ libroEditorialIn.getIdLibro() + "IdEditorial" + libroEditorialIn.getIdEditorial());
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
