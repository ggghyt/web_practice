package javadb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert_main {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:Oracle:thin:@localhost:1521:xe", "java", "1234");
			System.out.println("success connect");
			
			String sql = "insert into boards (bno, btitle, bcontent, bwriter, bdate) "
					   + "values(seq_bno.nextVal, ?, ?, ?, sysdate) ";
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno", "btitle"});
			pstmt.setString(1, "title_8");
			pstmt.setString(2, "content_8");
			pstmt.setString(3, "writer_8");
			
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if (rs.next()) {
					int bno = rs.getInt(1);
					String title = rs.getString(2);
					System.out.println("num : " + bno + ", title : " + title);
				}
				System.out.println("success insert");
				rs.close();
			} else {
				System.out.println("something error");
			}
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
