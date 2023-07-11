package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");//loading driver
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/igt", "root", "root");//creating connection
			Statement statement=connection.createStatement();//creating statement
			ResultSet resultSet=statement.executeQuery("Select * from employee");//executing query
			while(resultSet.next()) {
				int id=resultSet.getInt("id");
				String name=resultSet.getString("name");
				int age=resultSet.getInt("age");
				int salary=resultSet.getInt("salary");
				String designation=resultSet.getString("designation");
				System.out.println("================================");
				System.out.println("Id: "+id);
				System.out.println("Name: "+name);
				System.out.println("Age: "+age);
				System.out.println("Salary: "+salary);
				System.out.println("Designation: "+designation);
			}
			resultSet.close();//close statement/connection
			statement.close();
			connection.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
