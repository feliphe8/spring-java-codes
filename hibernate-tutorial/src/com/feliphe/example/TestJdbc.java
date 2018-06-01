package com.feliphe.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&useTimezone=true&serverTimezone=UTC";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
