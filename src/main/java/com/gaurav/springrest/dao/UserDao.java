package com.gaurav.springrest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.gaurav.springrest.model.User;

public class UserDao {

	private String driver;
	private String dbUri;


	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getDriver() {
		return driver;
	}

	public void setDbUri(String dbUri) {
		this.dbUri = dbUri;
	}

	public String getDbUri() {
		return dbUri;
	}

	public User getUserById(int id) {
		Connection connection = null;
		try {
			Class.forName(driver).newInstance();
			connection = DriverManager.getConnection(dbUri);
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = " + id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int newId = resultSet.getInt("id");
				String name = resultSet.getString("name");
				User user = new User();
				user.setId(newId);
				user.setName(name);
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertUser(String name) {
		return false;
	}
}
