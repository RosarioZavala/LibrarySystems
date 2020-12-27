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
			+ ",preciocompra,inventario,status FROM libro";
	private String querySelectLibroByFilters = "SELECT idlibro,titulo,isbn,descripcion,paginas,precioventa"
			+ ",preciocompra,inventario,status FROM libro WHERE 1=1 ";
	private static final String QUERY_INSERT_LIBRO = "INSERT INTO libro (titulo,isbn,descripcion,paginas,precioventa"
			+ ",preciocompra,inventario,status) VALUES (?,?, ?,?,?,?,?)";

	public List<Libro> selectLibro() {
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
						resultSet.getBigDecimal("precioventa"), resultSet.getBigDecimal("preciocompra"),
						resultSet.getInt("inventario"), resultSet.getBoolean("status"));
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
						resultSet.getBigDecimal("precioventa"), resultSet.getBigDecimal("preciocompra"),
						resultSet.getInt("inventario"), resultSet.getBoolean("status"));
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

	private String buildFilters(Libro libroToFind) throws SQLException {
		if (libroToFind == null) {
			return querySelectLibroByFilters;
		}
		
		int counter = 1;
		
		if (libroToFind.getIdLibro() > 0) {
			querySelectLibroByFilters += " AND idlibro = ?";
			prepStatement.setInt(counter++, libroToFind.getIdLibro());
		}

		if (libroToFind.getIsbn() != null && !libroToFind.getIsbn().trim().isEmpty()) {
			querySelectLibroByFilters += " AND isbn = ?";
			prepStatement.setString(counter++, libroToFind.getIsbn());
		}

		if (libroToFind.getDescripcion() != null && !libroToFind.getDescripcion().trim().isEmpty()) {
			querySelectLibroByFilters += " AND descripcion LIKE ?";
			prepStatement.setString(counter++, "%" + libroToFind.getDescripcion() + "%");
		}

		if (libroToFind.getPaginas() != null && !libroToFind.getPaginas().trim().isEmpty()) {
			querySelectLibroByFilters += " AND paginas = ?";
			prepStatement.setString(counter++, libroToFind.getPaginas());
		}

		if (libroToFind.getTitulo() != null && !libroToFind.getTitulo().trim().isEmpty()) {
			querySelectLibroByFilters += " AND titulo LIKE ?";
			prepStatement.setString(counter++, "%" + libroToFind.getTitulo() + "%");
		}
		
		return querySelectLibroByFilters;
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
}
