package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	public Connection conn = null;
	public PreparedStatement pstmt;
	public ResultSet rs;
	public void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:Oracle:thin:@192.168.0.26:1521:xe", "java", "1234");
			System.out.println("success connect");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("success exit");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
