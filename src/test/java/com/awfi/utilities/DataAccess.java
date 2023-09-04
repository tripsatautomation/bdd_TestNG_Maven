package com.awfi.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccess {
	ConfigReader config;
	SQLServerConnection sql;
	ResultSet rs;

	public DataAccess() {
		sql = new SQLServerConnection();
		config = new ConfigReader();
	}

	public int getGroupID(String groupname) throws SQLException {
		int groupID = 0;
		ResultSet rs = null;
		try {
			System.out.println(getQueryFromConfig("getgroupID").replace("{{value}}", groupname));
			rs = sql.connectToDatabase(getQueryFromConfig("getgroupID").replace("{{value}}", groupname));
			if (rs.next()) {
				String name = rs.getString("ID");
				System.out.println("ID: " + name);
				// Additional processing using the name value

				groupID = rs.getInt("ID"); // Retrieve the ID column value
			} else {
				System.out.println("No rows found in the result set.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupID;
	}

	public int getUserData(int groupID) throws SQLException {
		ResultSet rs = null;
		try {
			System.out.println(getQueryFromConfig("getUserData").replace("{{value}}", Integer.toString(groupID)));
			rs = sql.connectToDatabase(
					getQueryFromConfig("getgroupID").replace("{{value}}", Integer.toString(groupID)));
			if (rs.next()) {
				
			} else {
				System.out.println("No rows found in the result set.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return groupID;
	}

	private String getQueryFromConfig(String queryName) throws IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(config.getProperty("queries")))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("=", 2);
				if (parts.length == 2 && parts[0].trim().equals(queryName)) {
					return parts[1].trim();
				}
			}
		}
		throw new IllegalArgumentException("Query not found: " + queryName);
	}

}
