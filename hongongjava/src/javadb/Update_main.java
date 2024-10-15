package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class Update_main {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "java", "1234");
			System.out.println("success connect");
			
			String sql = "update boards "
					   + "set btitle = ?, bcontent = ? "
					   + "where bno = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"btitle", "bcontent"});
			pstmt.setString(1, "happy");
			pstmt.setString(2, "yes money");
			pstmt.setInt(3, 3);
			
			/*
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					String title = rs.getString(1);
					String content = rs.getString(2);
					System.out.println("title : " + title + ", content : " + content);
				}
				System.out.println("success insert");
				rs.close();
			} else {
				System.out.println("something error");
			}
			*/
			pstmt.close();
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
