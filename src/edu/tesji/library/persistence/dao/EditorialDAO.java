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
			+ "FROM editorial ORDER BY nombreeditorial ASC";
	private static final String QUERY_INSERT_EDITORIAL = "INSERT INTO editorial(nombreeditorial, lugardeimpresion) VALUES (?,?)";

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
				LOG.info("Se ha insertadp correctamente el registro" + "NombreEditorial"
						+ editorialIn.getNombreEditorial() + "Lugar de Impresion" + editorialIn.getLugarDeImpresion());
			} else
				LOG.info("No se ha insertadp correctamente el registro" + "NombreEditorial"
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
}