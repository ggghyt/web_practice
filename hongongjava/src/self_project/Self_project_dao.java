package self_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Self_project_dao {
	Connection conn = null;
	PreparedStatement pstmt;
	ResultSet rs = null;
	// DB 접속
	void connect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:Oracle:thin:@192.168.0.26:1521:xe", "java", "1234");
			//System.out.println("success connect");
			} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// DB 연결 해제
	void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				//System.out.println("success disconnect");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 로그인 확인
	User_info login (String id, String pw) {
		connect();
		User_info user_info = new User_info();
		String sql = "select * "
		    	   + "from user_info "
			       + "where user_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("user_pw").equals(pw)) {
					user_info.set_user_id(rs.getString("user_id"));
					user_info.set_user_pw(rs.getString("user_pw"));
					user_info.set_user_name(rs.getString("user_name"));
					user_info.set_user_phone(rs.getString("user_phone"));
					user_info.set_user_addr(rs.getString("user_addr"));
					user_info.set_user_position(rs.getString("user_position"));
					disconnect();
					return user_info;
				} else {
					disconnect();
					return user_info;
				}
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
		return user_info;
	}
	// 회원 가입
	void insert_user(User_info user_info) {
		connect();
		String sql = "insert into user_info (user_id, user_pw, user_name, user_phone, user_addr) "
				   + "values(?, ?, ?, ?, ?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_info.get_user_id());
			pstmt.setString(2, user_info.get_user_pw());
			pstmt.setString(3, user_info.get_user_name());
			pstmt.setString(4, user_info.get_user_phone());
			pstmt.setString(5, user_info.get_user_addr());
			
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
		disconnect();
	}
	// 아이템 전체 리스트
	List<Item> item_array_list() {
		connect();
		List<Item> result = new ArrayList<>();
		String sql = "select item_num, "
				   + "item_name, "
		           + "item_content, "
                   + "item_left, "
		           + "item_price "
		           + "from item";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Item item = new Item();
				item.set_item_num(rs.getInt("item_num"));
				item.set_item_name(rs.getString("item_name"));
				item.set_item_content(rs.getString("item_content"));
				item.set_item_left(rs.getInt("item_left"));
				item.set_item_price(rs.getInt("item_price"));
				result.add(item);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 아이템 구매
	void buy_item(int index, int num) {
		connect();
		String sql = "update item "
			       + "set item_left = ? "
				   + "where item_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setInt(2, index);
				
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("구매 완료");
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 구매 내용 저장
	void user_receipt(String user_id, String item_name, int num) {
		connect();
		String sql = "insert into buy (buy_num, user_id, item_name, user_buy) "
				   + "values(buy_num.nextVal, ?, ?, ?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setString(2, item_name);
			pstmt.setInt(3, num);
			
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("주문 완료");
			} else {
				System.out.println("something error");
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 문의사항 작성
	void send_inquiry (String inquiry_title, String inquiry_content, String user_id) {
		connect();
		String sql = "insert into inquiry (inq_num, inq_title, inq_content, user_id) "
				   + "values(inq_num.nextVal, ?, ?, ?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inquiry_title);
			pstmt.setString(2, inquiry_content);
			pstmt.setString(3, user_id);
			
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("등록 완료");
			} else {
				System.out.println("something error");
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 문의 사항 유저 리스트
	List<Inquiry> inquiry_array_list(String user_id) {
		connect();
		List<Inquiry> result = new ArrayList<>();
		String sql = "select inq_num, "
				   + "inq_title, "
		           + "inq_content, "
                   + "inq_answer, "
		           + "user_id "
		           + "from inquiry "
		           + "where user_id = ? "
		           + "order by 1 desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Inquiry inquiry = new Inquiry();
				inquiry.set_inq_num(rs.getInt("inq_num"));
				inquiry.set_inq_title(rs.getString("inq_title"));
				inquiry.set_inq_content(rs.getString("inq_content"));
				inquiry.set_inq_answer(rs.getString("inq_answer"));
				inquiry.set_user_id(rs.getString("user_id"));
				result.add(inquiry);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 커뮤니티 게시글 작성
	void community_write (String comu_title, String comu_content, String user_id) {
		connect();
		String sql = "insert into community (comu_num, comu_title, comu_content, user_id) "
				   + "values(comu_num.nextVal, ?, ?, ?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comu_title);
			pstmt.setString(2, comu_content);
			pstmt.setString(3, user_id);
			
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("등록 완료");
			} else {
				System.out.println("something error");
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 커뮤니티 전체 리스트
	List<Community> community_array_list(String user_id) {
		connect();
		List<Community> result = new ArrayList<>();
		String sql = "select comu_num, "
				   + "comu_title, "
		           + "comu_content, "
                   + "user_id "
		           + "from community "
                   + "order by 1 desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Community community = new Community();
				community.set_comu_num(rs.getInt("comu_num"));
				community.set_comu_title(rs.getString("comu_title"));
				community.set_comu_content(rs.getString("comu_content"));
				community.set_user_id(rs.getString("user_id"));
				result.add(community);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 댓글 전체 리스트
	List<Comments> comments_array_list(int index) {
		connect();
		List<Comments> result = new ArrayList<>();
		String sql = "select comm_num, "
				   + "comu_num, "
		           + "comm_content, "
                   + "user_id "
		           + "from comments "
                   + "where comu_num = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Comments comments = new Comments();
				comments.set_comm_num(rs.getInt("comm_num"));
				comments.set_comu_num(rs.getInt("comu_num"));
				comments.set_comm_content(rs.getString("comm_content"));
				comments.set_user_id(rs.getString("user_id"));
				result.add(comments);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 댓글 작성
	void comments_write(int comu_num, String comm_content, String user_id) {
		connect();
		String sql = "insert into comments (comm_num, comu_num, comm_content, user_id) "
				   + "values(comm_num.nextVal, ?, ?, ?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comu_num);
			pstmt.setString(2, comm_content);
			pstmt.setString(3, user_id);
			
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("등록 완료");
			} else {
				System.out.println("something error");
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 구매 리스트 (유저 단일 서치)
	List<Buy> user_buy_list(String user_id) {
		connect();
		List<Buy> result = new ArrayList<>();
		String sql = "select buy_num, "
				   + "user_id, "
		           + "item_name, "
                   + "user_buy "
		           + "from buy "
                   + "where user_id = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Buy buy = new Buy();
				buy.set_buy_num(rs.getInt("buy_num"));
				buy.set_user_id(rs.getString("user_id"));
				buy.set_item_name(rs.getString("item_name"));
				buy.set_user_buy(rs.getInt("user_buy"));
				result.add(buy);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 아이템 단일 가격 확인
	int get_single_item_price(String item_name) {
		connect();
		int price = 0;
		String sql = "select item_price "
		           + "from item "
		           + "where item_name = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_name);
			rs = pstmt.executeQuery();
			rs.next();
			price = rs.getInt("item_price");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
		return price;
	}
	// 커뮤니티 게시글 리스트 (유저 단일 서치)
	List<Community> user_community_list(String user_id) {
		connect();
		List<Community> result = new ArrayList<>();
		String sql = "select comu_num, "
				   + "comu_title, "
		           + "comu_content, "
                   + "user_id "
		           + "from community "
                   + "where user_id = ? "
                   + "order by 1 desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Community community = new Community();
				community.set_comu_num(rs.getInt("comu_num"));
				community.set_comu_title(rs.getString("comu_title"));
				community.set_comu_content(rs.getString("comu_content"));
				community.set_user_id(rs.getString("user_id"));
				result.add(community);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 제품 추가
	void insert_item(String item_name, String item_content, int item_left, int item_price) {
		connect();
		String sql = "insert into item (item_num, item_name, item_content, item_left, item_price) "
				   + "values(item_num.nextVal, ?, ?, ?, ?) ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, item_name);
			pstmt.setString(2, item_content);
			pstmt.setInt(3, item_left);
			pstmt.setInt(4, item_price);
			
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("등록 완료");
			} else {
				System.out.println("something error");
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 제품 수정
	void update_item(String edit_item_name, String edit_item_content, int edit_item_left, int edit_item_price, int item_num) {
		connect();
		String sql = "update item "
				   + "set item_name = ?, "
				   + "item_content = ?, "
				   + "item_left = ?, "
				   + "item_price = ? "
				   + "where item_num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, edit_item_name);
			pstmt.setString(2, edit_item_content);
			pstmt.setInt(3, edit_item_left);
			pstmt.setInt(4, edit_item_price);
			pstmt.setInt(5, item_num);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("수정 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 제품 삭제
	void delete_item(int item_num) {
		connect();
		String sql = "delete from item "
				   + "where item_num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, item_num);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 사용자 리스트
	List<User_info> user_array_list() {
		connect();
		List<User_info> result = new ArrayList<>();
		String sql = "select user_id, "
				   + "user_pw, "
		           + "user_name, "
                   + "user_phone, "
		           + "user_addr "
		           + "from user_info "
                   + "where user_position = 'guest'";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				User_info user_info = new User_info();
				user_info.set_user_id(rs.getString("user_id"));
				user_info.set_user_pw(rs.getString("user_pw"));
				user_info.set_user_name(rs.getString("user_name"));
				user_info.set_user_phone(rs.getString("user_phone"));
				user_info.set_user_addr(rs.getString("user_addr"));
				result.add(user_info);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 사용자 정보 변경
	void update_user_info(String user_id, String edit_user_pw, String edit_user_name, String edit_user_phone, String edit_user_addr) {
		connect();
		String sql = "update user_info "
				   + "set user_pw = ?, "
				   + "user_name = ?, "
				   + "user_phone = ?, "
				   + "user_addr = ? "
				   + "where user_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, edit_user_pw);
			pstmt.setString(2, edit_user_name);
			pstmt.setString(3, edit_user_phone);
			pstmt.setString(4, edit_user_addr);
			pstmt.setString(5, user_id);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("수정 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 사용자 삭제
	void delete_user_info(String user_id) {
		connect();
		String sql = "delete from user_info "
				   + "where user_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "delete from community "
			+ "where user_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "delete from comments "
		    + "where user_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql = "delete from buy "
			+ "where user_id = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user_id);
				int rows = pstmt.executeUpdate();
				if (rows > 0) {
					System.out.println("삭제 완료");
				} else {
					System.out.println("something error");
				}
			} catch (SQLException e) {
				e.printStackTrace();
		}
		sql = "delete from inquiry "
			+ "where user_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		disconnect();
	}
	// 게시판 검색 리스트 생성
	List<Community> community_array_search_list (int index, String search_word) {
		connect();
		List<Community> result = new ArrayList<>();
		String sql = "select comu_num, "
				   + "comu_title, "
		           + "comu_content, "
                   + "user_id "
		           + "from community ";
		if (index == 1) {
			sql = sql + "where comu_title like '%'||?||'%' ";
		} else if (index == 2) {
			sql = sql + "where comu_content like '%'||?||'%' ";
		} else if (index == 3) {
			sql = sql + "where user_id like '%'||?||'%' ";
		}
		sql = sql + "order by 1 desc";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_word);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Community community = new Community();
				community.set_comu_num(rs.getInt("comu_num"));
				community.set_comu_title(rs.getString("comu_title"));
				community.set_comu_content(rs.getString("comu_content"));
				community.set_user_id(rs.getString("user_id"));
				result.add(community);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 게시글 삭제
	void delete_community(int index) {
		connect();
		String sql = "delete from community "
				   + "where comu_num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = "delete from comments "
		    + "where comu_num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			int rows = pstmt.executeUpdate();
			if (rows > 1) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		disconnect();
	}
	// 댓글 삭제
	void delete_comments(int index) {
		connect();
		String sql = "delete from comments "
				   + "where comm_num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 댓글 검색 리스트 생성
	List<Comments> comments_array_search_list (int index, String search_word) {
		connect();
		List<Comments> result = new ArrayList<>();
		String sql = "select comm_num, "
				   + "comu_num, "
		           + "comm_content, "
                   + "user_id "
		           + "from comments ";
		if (index == 1) {
			sql = sql + "where comm_content like '%'||?||'%' ";
		} else if (index == 2) {
			sql = sql + "where user_id like '%'||?||'%' ";
		}
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_word);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Comments comments = new Comments();
				comments.set_comm_num(rs.getInt("comm_num"));
				comments.set_comu_num(rs.getInt("comu_num"));
				comments.set_comm_content(rs.getString("comm_content"));
				comments.set_user_id(rs.getString("user_id"));
				result.add(comments);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 관리자 문의 리스트 생성
	List<Inquiry> inquiry_array_list() {
		connect();
		List<Inquiry> result = new ArrayList<>();
		String sql = "select inq_num, "
				   + "inq_title, "
		           + "inq_content, "
                   + "inq_answer, "
		           + "user_id "
		           + "from inquiry "
		           + "order by 1 desc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Inquiry inquiry = new Inquiry();
				inquiry.set_inq_num(rs.getInt("inq_num"));
				inquiry.set_inq_title(rs.getString("inq_title"));
				inquiry.set_inq_content(rs.getString("inq_content"));
				inquiry.set_inq_answer(rs.getString("inq_answer"));
				inquiry.set_user_id(rs.getString("user_id"));
				result.add(inquiry);
			}
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		disconnect();
		return result;
	}
	// 문의 답변 삽입
	void insert_inq_answer(String inq_answer, int inq_num) {
		connect();
		String sql = "update inquiry "
				   + "set inq_answer = ? "
				   + "where inq_num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, inq_answer);
			pstmt.setInt(2, inq_num);
			
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("등록 완료");
			} else {
				System.out.println("something error");
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
	// 문의 삭제
	void delete_inq_answer(int index) {
		connect();
		String sql = "delete from inquiry "
				   + "where inq_num = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, index);
			int rows = pstmt.executeUpdate();
			if (rows == 1) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("something error");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
	}
}
