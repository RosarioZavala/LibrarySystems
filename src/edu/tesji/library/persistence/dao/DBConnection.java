package edu.tesji.library.persistence.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class DBConnection {
	private static final Logger LOG = Logger.getLogger(DBConnection.class);

	public Connection getConnection() {
		try {
			Connection connection;
			InitialContext ctx = new InitialContext();
			Context env = (Context) ctx.lookup("java:comp/env");
			connection = ((DataSource) env.lookup("jdbc/mysql")).getConnection();
			return connection;
		} catch (NamingException e) {
			LOG.error("NamingException", e);
		} catch (SQLException e) {
			LOG.error("SQLException", e);
		}
		return null;
	}

}
