package com.callor.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContract {
	
	private static Connection dbConn;
	static {
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydb";
		String user = "gbUser";
		String pass = "12345";
		
		try {
			Class.forName(jdbcDriver);
			if (dbConn == null) {
				dbConn = DriverManager.getConnection(url, user, pass);
			}
			System.out.println("MySQL 연결 OK!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// getter,setter 자동완성 메뉴에서 확장해서 체크해서 만들어도 된다
	public static Connection getDbConn() {
		return dbConn;
	}
	
	

}
