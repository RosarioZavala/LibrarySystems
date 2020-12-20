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
	private static final String QUERY_SELECT_ALL_Libro = "SELECT idlibro,isbn,descripcion,paginas,precioventa,preciocompra,inventario,status FROM libro";
	private static final String QUERY_INSERT_LIBRO = "INSERT INTO libro (isbn,descripcion,paginas,precioventa,preciocompra,inventario,status) VALUES (?,?, ?,?,?,?,?)";
	public List<Libro> selectLibro() {
		List<Libro> libroList = new ArrayList<Libro>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_Libro);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Libro libro = new Libro(resultSet.getInt("idlibro"), resultSet.getString("isbn"),
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
	
	public int insertLibro (Libro libroIn) {
		Connection connection = null;
		int insertedRows =-3;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_INSERT_LIBRO);
			prepStatement.setString(1,libroIn.getIsbn());
			prepStatement.setString(2,libroIn.getDescripcion());
			prepStatement.setString(3,libroIn.getPaginas());
			prepStatement.setBigDecimal(4,libroIn.getPrecioVenta());
			prepStatement.setBigDecimal(5,libroIn.getPrecioCompra());
			prepStatement.setInt(6,libroIn.getInventario());
			prepStatement.setBoolean(7,libroIn.isStatus() );
			
			insertedRows = prepStatement.executeUpdate();
				
		if(insertedRows == 1) {
			LOG.info("Se ha registrado correctamente el registro" + "isbn" +libroIn.getIsbn()
			+ "descripción" + libroIn.getDescripcion() + "páginas" + libroIn.getPaginas()
			+ "Precio Venta" + libroIn.getPrecioVenta() +"Precio Compra" + libroIn.getPrecioCompra()
			+"Inventario" + libroIn.getInventario()+ "status" + libroIn.isStatus());
		}else {
			LOG.info("No se ha registrado correctamente el registro" + "isbn" +libroIn.getIsbn()
			+ "descripción" + libroIn.getDescripcion() + "páginas" + libroIn.getPaginas()
			+ "Precio Venta" + libroIn.getPrecioVenta() +"Precio Compra" + libroIn.getPrecioCompra()
			+"Inventario" + libroIn.getInventario()+ "status" + libroIn.isStatus());
		}
		}catch(SQLException e) {
			LOG.error("SQLException", e);
		}finally {
			if( connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					LOG.error("SQLException", e);
				}
			}
		}
		return insertedRows;
	}
}
