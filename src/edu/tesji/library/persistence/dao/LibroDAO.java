package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;

import edu.tesji.library.entities.Libro;

public class LibroDAO {
	private static final Logger LOG = Logger.getLogger(LibroDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	
	
	private static final String QUERY_SELECT_ALL_LIBRO = "SELECT idlibro,titulo,isbn,descripcion,paginas,precioventa"
			+ ",preciocompra,inventario,status,portada FROM libro";
	private static final String QUERY_SELECT_LIBRO_BY_ID = "SELECT  idlibro,titulo,isbn,descripcion,paginas,precioventa FROM libro WHERE idlibro = ?";
	private String querySelectLibroByFilters = "SELECT idlibro,titulo,isbn,descripcion,paginas,precioventa"
			+ ",preciocompra,inventario,status,portada FROM libro WHERE 1=1 ";
	
///			SELECT  titulo,isbn,descripcion,paginas,preciocompra,inventario FROM libro WHERE isbn LIKE '%84303270%'
	private static final String QUERY_INSERT_LIBRO = "INSERT INTO libro (titulo,isbn,descripcion,paginas,precioventa"
			+ ",preciocompra,inventario,status, portada) VALUES (?,?,?,?,?,?,?,?,?)";

	private static final String QUERY_UPDATE_LIBRO = "UPDATE libro SET titulo =?,isbn = ?, descripción = ?,paginas = ?, precioventa =?, preciocompra =?, inventario =?,status =?, portada=? WHERE idlibro=?";
private String QUERY_SELECT_PORTAIMG = "SELECT portada FROM libro";
	
	public List<Libro> selectAllLibros() {
		List<Libro> libroList = new ArrayList<Libro>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_LIBRO);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Libro libro = new Libro(resultSet.getInt("idlibro"),  resultSet.getString("titulo"),resultSet.getString("isbn"),
						resultSet.getString("descripcion"), resultSet.getString("paginas"),
						resultSet.getBigDecimal("precioventa"),resultSet.getBigDecimal("preciocompra"),
						resultSet.getInt("inventario"), resultSet.getBoolean("status"),resultSet.getBinaryStream("portada"));
				libroList.add(libro);
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

		return libroList;
	}

	public List<Libro> selectLibroByFilters(Libro libroToFind) {
		List<Libro> libroList = new ArrayList<Libro>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(buildQuery(libroToFind));
			buildFilters(libroToFind);

			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Libro libro = new Libro(resultSet.getInt("idlibro"),  resultSet.getString("titulo"),resultSet.getString("isbn"),
						resultSet.getString("descripcion"), resultSet.getString("paginas"),
						resultSet.getBigDecimal("precioventa"),resultSet.getBigDecimal("preciocompra"),
						resultSet.getInt("inventario"), resultSet.getBoolean("status"),resultSet.getBinaryStream("portada"));
				libroList.add(libro);
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

		return libroList;
	}
	
	private String buildQuery(Libro libroToFind) {
		if (libroToFind == null) {
			return querySelectLibroByFilters;
		}
		
		if (libroToFind.getIdLibro() > 0) {
			querySelectLibroByFilters += " AND idlibro = ?";
		}

		if (libroToFind.getIsbn() != null && !libroToFind.getIsbn().trim().isEmpty()) {
			querySelectLibroByFilters += " AND isbn = ?";
		}

		if (libroToFind.getDescripcion() != null && !libroToFind.getDescripcion().trim().isEmpty()) {
			querySelectLibroByFilters += " AND descripcion LIKE ?";
		}

		if (libroToFind.getPaginas() != null && !libroToFind.getPaginas().trim().isEmpty()) {
			querySelectLibroByFilters += " AND paginas = ?";
		}

		if (libroToFind.getTitulo() != null && !libroToFind.getTitulo().trim().isEmpty()) {
			querySelectLibroByFilters += " AND titulo LIKE ?";
		}
		
		return querySelectLibroByFilters;
	}

	private void buildFilters(Libro libroToFind) throws SQLException {
		if (libroToFind == null) {
			return ;
		}
		
		int counter = 1;
		
		if (libroToFind.getIdLibro() > 0) {
			prepStatement.setInt(counter++, libroToFind.getIdLibro());
		}

		if (libroToFind.getIsbn() != null && !libroToFind.getIsbn().trim().isEmpty()) {
			prepStatement.setString(counter++, libroToFind.getIsbn());
		}

		if (libroToFind.getDescripcion() != null && !libroToFind.getDescripcion().trim().isEmpty()) {
			prepStatement.setString(counter++, "%" + libroToFind.getDescripcion() + "%");
		}

		if (libroToFind.getPaginas() != null && !libroToFind.getPaginas().trim().isEmpty()) {
			prepStatement.setString(counter++, libroToFind.getPaginas());
		}

		if (libroToFind.getTitulo() != null && !libroToFind.getTitulo().trim().isEmpty()) {
			prepStatement.setString(counter++, "%" + libroToFind.getTitulo() + "%");
		}
		
	}

	public int insertLibro(Libro libroIn) {
		Connection connection = null;
		int insertedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_INSERT_LIBRO);
			prepStatement.setString(1, libroIn.getIsbn());
			prepStatement.setString(2,libroIn.getTitulo());
			prepStatement.setString(3, libroIn.getDescripcion());
			prepStatement.setString(4, libroIn.getPaginas());
			prepStatement.setBigDecimal(5, libroIn.getPrecioVenta());
			prepStatement.setBigDecimal(6, libroIn.getPrecioCompra());
			prepStatement.setInt(7, libroIn.getInventario());
			prepStatement.setBoolean(8, libroIn.isStatus());
			prepStatement.setBlob(9, libroIn.getPortada());

			insertedRows = prepStatement.executeUpdate();

			if (insertedRows == 1) {
				LOG.info("Se ha registrado correctamente el registro" +"Titulo" + libroIn.getTitulo() + "isbn" + libroIn.getIsbn() + "descripción"
						+ libroIn.getDescripcion() + "páginas" + libroIn.getPaginas() + "Precio Venta"
						+ libroIn.getPrecioVenta() + "Precio Compra" + libroIn.getPrecioCompra() + "Inventario"
						+ libroIn.getInventario() + "status" + libroIn.isStatus());
			} else {
				LOG.info("No se ha registrado correctamente el registro" +"Titulo" + libroIn.getTitulo()+ "isbn" + libroIn.getIsbn() + "descripción"
						+ libroIn.getDescripcion() + "páginas" + libroIn.getPaginas() + "Precio Venta"
						+ libroIn.getPrecioVenta() + "Precio Compra" + libroIn.getPrecioCompra() + "Inventario"
						+ libroIn.getInventario() + "status" + libroIn.isStatus());
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
	
	public int updateLibro (Libro libro) {
		int updatedRows = -3;
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_UPDATE_LIBRO);
			prepStatement.setInt(1,libro.getIdLibro());
			
			updatedRows = prepStatement.executeUpdate();
			if(updatedRows == 1) {
				LOG.info("Se ha actualizado correctamente el registro " + libro.toString());
			}else {
				LOG.info("No se ha actualizado correctamente el registro " + libro.toString());
			}
	}catch (SQLException e) {
		LOG.error("SQLException",e);
	}finally {
		if(connection != null) {
			try {
				connection.close();
				}catch (SQLException e) {
					LOG.error("SQLException",e);
				}
		}
	}
		return updatedRows;
	}
	

}
