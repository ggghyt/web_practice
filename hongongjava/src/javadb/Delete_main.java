package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete_main {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "java", "1234");
			System.out.println("success connect");
			
			String sql = "delete from boards "
					   + "where bno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 9);
			int rows = pstmt.executeUpdate();
			System.out.println("delete : " + rows);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

}
