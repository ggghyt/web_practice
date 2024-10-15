package book_management;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Book_main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		Member_dao member_dao = Member_dao.get_instance();
		Member member = new Member();
		while (true) {
			System.out.print("id : ");
			String id = scanner.nextLine();
			
			System.out.print("pw : ");
			String pw = scanner.nextLine();
			
			member = member_dao.login(id, pw);
			if (member.get_member_name() != null) {
				System.out.println("welcome " + member.get_member_name());
				break;
			}
		}
		if (member.get_responsibility().equals("User")) {
			book_manager();
		} else if (member.get_responsibility().equals("Admin")) {
			member_manager();
		}
		
		scanner.close();
	}
	
	static void book_manager() {
		Book_dao book_dao = new Book_dao();
		ResultSet rs = null;
		book_dao.connect();
		while (true) {
			System.out.println("--------------------------------------");
			System.out.println("1. 도서 등록, 2. 도서 검색, 3. 도서 전체 조회");
			System.out.println("4. 도서 삭제, 5. 도서 정보 변경, 6. 종료");
			System.out.println("--------------------------------------");
			System.out.print("선택 : ");
			int input = Integer.parseInt(scanner.nextLine());
			
			if (input == 1) {
				book_dao.insert_book();
				
			} else if (input == 2) {
				Book book = new Book();
				System.out.print("제목 입력 : ");
				String input_book_title = scanner.nextLine();
				book.set_title(input_book_title);
				System.out.print("작가 입력 : ");
				String input_book_writer = scanner.nextLine();
				book.set_writer(input_book_writer);
				System.out.print("가격 입력 : ");
				int input_book_price = Integer.parseInt(scanner.nextLine());
				book.set_price(input_book_price);
				System.out.print("번호 입력 : ");
				String input_book_bnum = scanner.nextLine();
				book.set_bnum(input_book_bnum);
				
				rs = book_dao.search_book(book);
				try {
					while(rs.next()) {
						book = new Book();
						book.set_title(rs.getString(1));
						book.set_writer(rs.getString(2));
						book.set_price(rs.getInt(3));
						book.set_bnum(rs.getString(4));
						System.out.println(book);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else if (input == 3) {
				rs = book_dao.search_book_all();
				try {
					while(rs.next()) {
						Book book = new Book();
						book.set_title(rs.getString(1));
						book.set_writer(rs.getString(2));
						book.set_price(rs.getInt(3));
						book.set_bnum(rs.getString(4));
						System.out.println(book);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else if (input == 4) {
				System.out.print("책 번호 입력 : ");
				String delete_bnum = scanner.nextLine();
				book_dao.delete_book(delete_bnum);
				
			} else if (input == 5) {
				book_dao.edit_book();
				Book book = new Book();
				System.out.print("번호 : ");
				String bnum = scanner.nextLine();
				book.set_bnum(bnum);
				
				System.out.print("제목 : ");
				String title = scanner.nextLine();
				book.set_title(title);
				
				System.out.print("작가 : ");
				String writer = scanner.nextLine();
				book.set_writer(writer);
				
				System.out.print("가격 : ");
				int price = Integer.parseInt(scanner.nextLine());
				book.set_price(price);
				
			} else if (input == 6) {
				book_dao.disconnect();
				break;
			}
		}
		scanner.close();
	}
	
	static void member_manager() {
		Member_dao member_dao = Member_dao.get_instance();
		if (true) {
			List<Member> list = member_dao.member_list();
			for (Member member : list) {
				System.out.println(member.toString());
			}
		}
	}
}
