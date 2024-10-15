package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select_main {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "java", "1234");
			System.out.println("success connect");
			
			String sql = "select * "
					   + "from boards "
					   + "where bno < ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 4);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Board bd = new Board();
				bd.set_bno(rs.getInt(1));
				bd.set_btitle(rs.getString(2));
				bd.set_bcontent(rs.getString(3));
				bd.set_bwriter(rs.getString(4));
				bd.set_bdate(rs.getDate(5));
				System.out.println(bd);
			}
			
			rs.close();
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
