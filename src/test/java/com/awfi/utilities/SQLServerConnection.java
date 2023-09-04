package com.awfi.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLServerConnection {
	private static final String DB_STRING_PROPERTY = "dbstring";
	private ConfigReader config;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	public SQLServerConnection() {
		config = new ConfigReader();
	}
	public ResultSet connectToDatabase(String query) throws SQLException {
	    try {
	        conn = getConnection();
	        stmt = conn.createStatement();

	        return stmt.executeQuery(query);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	closeResultSet(rs);
	    }
	    return null;
	}
	
	

	private Connection getConnection() throws SQLException {
		String dbString = config.getProperty(DB_STRING_PROPERTY);
		return DriverManager.getConnection(dbString);
	}

	private void closeResultSet(ResultSet rs) {
	    if (rs != null) {
	        try {
	            rs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
}
