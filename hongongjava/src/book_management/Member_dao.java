package book_management;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Member_dao extends Dao {
	private static Member_dao instance = new Member_dao();
	private Member_dao() {}
	public static Member_dao get_instance() {
		return instance;
	}
	//목록(조건), 등록, 수정, 삭제, 단건
	List<Member> member_list() {
		List<Member> result = new ArrayList<>();
		String sql = "select member_id, "
		                   + "password, "
				           + "member_name, "
		                   + "phone, "
				           + "responsibility, "
		                   + "creation_date "
				           + "from tbl_member";
		connect();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Member member = new Member();
				member.set_member_id(rs.getString("member_id"));
				member.set_password(rs.getString("password"));
				member.set_member_name(rs.getString("member_name"));
				member.set_phone(rs.getString("phone"));
				member.set_responsibility(rs.getString("responsibility"));
				member.set_creation_date(rs.getDate("creation_date"));
				result.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	Member login (String id, String pw) {
		connect();
		Member member = new Member();
		String sql = "select * "
		    	   + "from tbl_member "
			       + "where member_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString("password").equals(pw)) {
					member.set_member_id(rs.getString("member_id"));
					member.set_password(rs.getString("password"));
					member.set_member_name(rs.getString("member_name"));
					member.set_phone(rs.getString("phone"));
					member.set_responsibility(rs.getString("responsibility"));
					member.set_creation_date(rs.getDate("creation_date"));
					disconnect();
					return member;
				} else {
					return member;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
		return member;
	}
}
