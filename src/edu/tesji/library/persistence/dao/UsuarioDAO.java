package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.tesji.library.entities.Usuario;

public class UsuarioDAO {
	private static final Logger LOG = Logger.getLogger(UsuarioDAO.class);
	private PreparedStatement prepStatement;
	private ResultSet resultSet;
	private static final String QUERY_SELECT_ALL_AUTOR = "SELECT idusuario, nombre, password, status FROM usuario";

	public List<Usuario> selectusuario() {

		List<Usuario> usuarioList = new ArrayList<Usuario>();
		Connection connection = null;
		try {
			DBConnection dbConnection = new DBConnection();
			connection = dbConnection.getConnection();
			prepStatement = connection.prepareStatement(QUERY_SELECT_ALL_AUTOR);
			resultSet = prepStatement.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = new Usuario(resultSet.getInt("idusuario"), resultSet.getString("nombre"),
						resultSet.getString("password"), resultSet.getBoolean("status"));
				usuarioList.add(usuario);
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
		return usuarioList;
	}

}
