package book_management;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Book_dao extends Dao {
	Scanner scanner = new Scanner(System.in);
	
	void insert_book() {
		System.out.print("제목 : ");
		String title = scanner.nextLine();
		
		System.out.print("작가 : ");
		String writer = scanner.nextLine();
		
		System.out.print("가격 : ");
		int price = Integer.parseInt(scanner.nextLine());
		
		System.out.print("번호 : ");
		String bnum = scanner.nextLine();
		
		String sql = "insert into book (title, writer, price, bnum) "
				   + "values(?, ?, ?, ?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, writer);
			pstmt.setInt(3, price);
			pstmt.setString(4, bnum);
			
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("success");
			} else {
				System.out.println("something error");
			}
			
			pstmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	ResultSet search_book(Book book) {
		ResultSet rs = null;
		try {
			String sql = "select * "
			    	   + "from book "
				       + "where title like '%'||?||'%' " 
			           + "and writer like '%'||?||'%' "
				       + "and price like '%'||?||'%' "
			           + "and bnum like '%'||?||'%' ";
			//like '%'||?||'%'"
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book.get_title());
			pstmt.setString(2, book.get_writer());
			pstmt.setInt(3, book.get_price());
			pstmt.setString(4, book.get_bnum());
			rs = pstmt.executeQuery();
			return rs;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	ResultSet search_book_all() {
		ResultSet rs = null;
		try {
			String sql = "select * "
				       + "from book ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	void delete_book(String bnum) {
		String sql = "delete from book "
				   + "where bnum = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bnum);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("success");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void edit_book() {
		System.out.print("책 번호 입력 : ");
		String input_bnum = scanner.nextLine();
		String sql = "select * "
		    	   + "from book "
			       + "where bnum = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, input_bnum);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.print("제목 : ");
				String title = scanner.nextLine();
				System.out.print("작가 : ");
				String writer = scanner.nextLine();
				System.out.print("가격 : ");
				int price = Integer.parseInt(scanner.nextLine());
				
				sql = "update book "
					+ "set title = ?, writer = ?, price = ? "
					+ "where bnum = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setString(2, writer);
				pstmt.setInt(3, price);
				pstmt.setString(4, input_bnum);
				
				rows = pstmt.executeUpdate();
				if (rows == 1) {
					System.out.println("success");
				}
			} else {
				System.out.println("no book");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
