package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.Libro;

public class LibroDAO {
	private static final Logger LOG = Logger.getLogger(LibroDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;

	private static final String QUERY_SELECT_ALL_LIBRO = "SELECT li.idlibro idlibro, li.titulo titulo, li.isbn isbn\n"
			+ ", li.descripcion descripcion, li.paginas paginas, li.precioventa precioventa\n"
			+ ", li.preciocompra preciocompra, li.inventario inventario\n"
			+ ", li.status status, li.idautor idautor\n"
			+ ", li.ideditorial ideditorial, au.nombrecompleto autor\n"
			+ ", ed.nombreeditorial editorial\n"
			+ " FROM libro li\n"
			+ " INNER JOIN autor au ON li.idautor = au.idautor\n"
			+ " INNER JOIN editorial ed ON li.ideditorial = ed.ideditorial;";
	private String querySelectLibroByFilters = "SELECT li.idlibro idlibro, li.titulo titulo, li.isbn isbn\n"
			+ ", li.descripcion descripcion, li.paginas paginas, li.precioventa precioventa\n"
			+ ", li.preciocompra preciocompra, li.inventario inventario\n"
			+ ", li.status status, li.idautor idautor\n"
			+ ", li.ideditorial ideditorial, au.nombrecompleto autor\n"
			+ ", ed.nombreeditorial editorial\n"
			+ " FROM libro li\n"
			+ " INNER JOIN autor au ON li.idautor = au.idautor\n"
			+ " INNER JOIN editorial ed ON li.ideditorial = ed.ideditorial WHERE 1=1 ";

	private String querySelectLibroByFiltersTituloAutorEditorial = "SELECT li.idlibro idlibro, li.titulo titulo, li.isbn isbn\n"
			+ ", li.descripcion descripcion, li.paginas paginas, li.precioventa precioventa\n"
			+ ", li.preciocompra preciocompra, li.inventario inventario\n"
			+ ", li.status status, li.idautor idautor\n"
			+ ", li.ideditorial ideditorial, au.nombrecompleto autor\n"
			+ ", ed.nombreeditorial editorial\n"
			+ " FROM libro li\n"
			+ " INNER JOIN autor au ON li.idautor = au.idautor\n"
			+ " INNER JOIN editorial ed ON li.ideditorial = ed.ideditorial WHERE "
			+ " li.titulo LIKE ?"
			+ " OR au.nombrecompleto LIKE ?"
			+ " OR ed.nombreeditorial  LIKE ?";
	
	
	
	
	private String querySelectLibroForCliente = "SELECT li.idlibro idlibro, li.titulo titulo"
			+ ", li.isbn, li.descripcion descripcion, li.precioventa precioventa, li.status status"
			+ ",  li.inventario inventario, li.idautor idautor, li.ideditorial ideditorial"
			+ ", au.nombrecompleto autor,ed.nombreeditorial editorial FROM libro li "
			+ " INNER JOIN autor au ON li.idautor = au.idautor INNER JOIN "
			+ " editorial ed ON li.ideditorial = ed.ideditorial WHERE li.idlibro =? ";
	
	
	
///			SELECT  titulo,isbn,descripcion,paginas,preciocompra,inventario FROM libro WHERE isbn LIKE '%84303270%'
	private static final String QUERY_INSERT_LIBRO = "INSERT INTO libro (isbn,titulo,descripcion,paginas,precioventa"
			+ ",preciocompra,inventario,status, idautor, ideditorial) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String QUERY_DELETE_LIBRO = "DELETE  FROM libro WHERE idLibro =?";


	private static final String QUERY_UPDATE_LIBRO = "UPDATE libro SET titulo =?,isbn = ?, descripcion = ?,paginas = ?"
			+ ", precioventa =?, preciocompra =?, inventario =?,status =? , idautor=?, ideditorial=? "
			+ " WHERE idlibro=?";

	public List<Libro> selectAllLibros() {
		List<Libro> libroList = new ArrayList<Libro>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_LIBRO);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Libro libro = new Libro(resultSet.getInt("idlibro"), resultSet.getString("titulo"),
						resultSet.getString("isbn"), resultSet.getString("descripcion"), resultSet.getString("paginas"),
						resultSet.getBigDecimal("precioventa"), resultSet.getBigDecimal("preciocompra"),
						resultSet.getInt("inventario"), resultSet.getBoolean("status"),
						resultSet.getInt("idautor"),resultSet.getInt("ideditorial"), resultSet.getString("autor"),
						resultSet.getString("editorial"));
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
				Libro libro = new Libro(resultSet.getInt("idlibro"), resultSet.getString("titulo"),
						resultSet.getString("isbn"), resultSet.getString("descripcion"), resultSet.getString("paginas"),
						resultSet.getBigDecimal("precioventa"), resultSet.getBigDecimal("preciocompra"),
						resultSet.getInt("inventario"), resultSet.getBoolean("status"),
						resultSet.getInt("idautor"),
						resultSet.getInt("ideditorial"), resultSet.getString("autor"),
						resultSet.getString("editorial"));
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


	public List<Libro> selectLibroByFiltersTituloAutorOrEditorial(Libro libroToFind) {
		List<Libro> libroList = new ArrayList<Libro>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			LOG.info(querySelectLibroByFiltersTituloAutorEditorial);
			prepStatement = connection.prepareStatement(querySelectLibroByFiltersTituloAutorEditorial);

			prepStatement.setString(1, "%" + libroToFind.getTitulo() + "%");
			prepStatement.setString(2, "%" + libroToFind.getAutor() + "%");
			prepStatement.setString(3, "%" + libroToFind.getEditorial() + "%");
			
			
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Libro libro = new Libro(resultSet.getInt("idlibro"), resultSet.getString("titulo"),
						resultSet.getString("isbn"), resultSet.getString("descripcion"), resultSet.getString("paginas"),
						resultSet.getBigDecimal("precioventa"), resultSet.getBigDecimal("preciocompra"),
						resultSet.getInt("inventario"), resultSet.getBoolean("status"),
						resultSet.getInt("idautor"),
						resultSet.getInt("ideditorial"), resultSet.getString("autor"),
						resultSet.getString("editorial"));
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
	
	
	
	public List<Libro> selectLibroForCliente(Libro libroToFind) {
		List<Libro> libroList = new ArrayList<Libro>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(querySelectLibroForCliente);
			prepStatement.setInt(1, libroToFind.getIdLibro());
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Libro libro = new Libro(resultSet.getInt("idlibro"), resultSet.getString("titulo"),
						resultSet.getString("isbn"), resultSet.getString("descripcion"),
						resultSet.getBigDecimal("precioventa"),
						resultSet.getInt("inventario"), resultSet.getBoolean("status"),
						resultSet.getInt("idautor"),
						resultSet.getInt("ideditorial"), resultSet.getString("autor"),
						resultSet.getString("editorial"));
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
	
		if (libroToFind.getAutor() != null && !libroToFind.getAutor().trim().isEmpty()) {
			querySelectLibroByFilters += " AND au.nombrecompleto LIKE ?";
		}
		if (libroToFind.getEditorial() != null && !libroToFind.getEditorial().trim().isEmpty()) {
			querySelectLibroByFilters += " AND ed.nombreeditorial  LIKE ?";
		}
		if (libroToFind.getInventario() != 0 ) {
			querySelectLibroByFilters += " AND inventario = ?";
		}

		return querySelectLibroByFilters;
	}

	private void buildFilters(Libro libroToFind) throws SQLException {
		if (libroToFind == null) {
			return;
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
		if (libroToFind.getAutor() != null && !libroToFind.getAutor().trim().isEmpty()) {
			prepStatement.setString(counter++, "%" + libroToFind.getAutor() + "%");
		}
		if (libroToFind.getEditorial() != null && !libroToFind.getEditorial().trim().isEmpty()) {
			prepStatement.setString(counter++, "%" + libroToFind.getEditorial() + "%");
		}
		
		if (libroToFind.getInventario () > 0) {
			prepStatement.setInt(counter, libroToFind.getInventario());
		}

	}

	public int insertLibro(Libro libroIn) {
		Connection connection = null;
		int insertedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			
			
			prepStatement = connection.prepareStatement(QUERY_INSERT_LIBRO, Statement.RETURN_GENERATED_KEYS);
			prepStatement.setString(1, libroIn.getIsbn());
			prepStatement.setString(2, libroIn.getTitulo());
			prepStatement.setString(3, libroIn.getDescripcion());
			prepStatement.setString(4, libroIn.getPaginas());
			prepStatement.setBigDecimal(5, libroIn.getPrecioVenta());
			prepStatement.setBigDecimal(6, libroIn.getPrecioCompra());
			prepStatement.setInt(7, libroIn.getInventario());
			prepStatement.setBoolean(8, libroIn.isStatus());
			prepStatement.setInt(9, libroIn.getIdAutor());
			prepStatement.setInt(10, libroIn.getIdEditorial());

			insertedRows = prepStatement.executeUpdate();

			ResultSet rs = prepStatement.getGeneratedKeys();
			int key = 0;
			if (rs.next()) {
				key = rs.getInt(1);
			}

			LOG.info("llave insertada: " + key);

			if (key > 0) {
				LOG.info("Se ha registrado correctamente el registro: " + libroIn.toString());
			} else {
				LOG.info("No se ha registrado correctamente el registro: " + libroIn.toString());
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

	public int updateLibro(Libro libro) {
		int updatedRows = -3;
		Connection connection = null;
		try {
		
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_UPDATE_LIBRO);
			prepStatement.setString(1, libro.getTitulo());
			prepStatement.setString(2, libro.getIsbn());
			prepStatement.setString(3, libro.getDescripcion());
			prepStatement.setString(4, libro.getPaginas());
			prepStatement.setBigDecimal(5, libro.getPrecioVenta());
			prepStatement.setBigDecimal(6, libro.getPrecioCompra());
			prepStatement.setInt(7, libro.getInventario());
			prepStatement.setBoolean(8, libro.isStatus());
			prepStatement.setInt(9, libro.getIdAutor());
			prepStatement.setInt(10, libro.getIdEditorial());
			prepStatement.setInt(11, libro.getIdLibro());

			updatedRows = prepStatement.executeUpdate();
			if (updatedRows == 1) {
				LOG.info("Se ha actualizado correctamente el registro " + libro.toString());
			} else {
				LOG.info("No se ha actualizado correctamente el registro " + libro.toString());
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
	
	public int deleteAutor(Libro libroDel) {
		Connection connection = null;
		int deletedRows = -3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_DELETE_LIBRO);
			prepStatement.setInt(1, libroDel.getIdLibro());

			deletedRows = prepStatement.executeUpdate();

			if (deletedRows == 1) {
				LOG.info("Se ha eliminado correctamente el registro" + libroDel.toString());
			} else {
				LOG.info("No se elimino correctamente el registro " + libroDel.toString());
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


}
