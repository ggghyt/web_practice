package com.yedam.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.common.Dao;
import com.yedam.vo.Member;

public class Member_dao extends Dao {
	public List<Member> member_list() {
		List<Member> result = new ArrayList<>();
		connect();
		
		try {
			pstmt = conn.prepareStatement("select * from tbl_member");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setPassword(rs.getString("password"));
				member.setMember_name(rs.getString("member_name"));
				member.setPhone(rs.getString("phone"));
				member.setResponsibility(rs.getString("responsibility"));
				result.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disconnect();
		return result;
	}
}
