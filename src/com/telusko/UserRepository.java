package com.telusko;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Statement;

import java.sql.Connection;

public class UserRepository {
	private static List<User> usersList = new ArrayList<User>();	
	private static UserRepository repository = new UserRepository();

	private UserRepository() {
		populateUsers();
	}

	// Applied Singleton Pattern hence called only once by the the constructor.
	public void populateUsers() {

		String url = "jdbc:mysql://localhost:3306/alpha";
		String userName = "root";
		String password = "password";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection connection = DriverManager.getConnection(url, userName, password);

			String query = "select * from user";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			while (resultSet.next()) {
				User user = new User();
				user.setUid(resultSet.getInt("uid"));
				user.setUname(resultSet.getString("uname"));
				user.setAge(resultSet.getInt("age"));
				usersList.add(user);				
			}
		} catch (SQLException | ClassNotFoundException e) {			
			e.printStackTrace();
		}

	}

	public static UserRepository getRepository() {
		return repository;
	}

	public List<User> getUsersByContainedText(String txt) {
		List<User> matchingUsers = new ArrayList<User>();
		for (User user : usersList) {
			if (user.getUname().toLowerCase().contains(txt.toLowerCase())) {
				matchingUsers.add(user);
			}
		}

		return matchingUsers;
	}
}
