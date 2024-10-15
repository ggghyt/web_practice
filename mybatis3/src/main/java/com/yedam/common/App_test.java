package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

public class App_test {

	public static void main(String[] args) {
		SqlSession sqlSession = Data_source.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		
		Member member_insert = new Member();
		member_insert.setMember_id("sample");
		member_insert.setPassword("sample");
		member_insert.setMember_name("sample");
		member_insert.setPhone("012-3456-7890");
		if (dao.insertMember(member_insert) == 1) {
			sqlSession.commit();
		}
		
		Member member_update = new Member();
		member_update.setMember_id("sample");
		member_update.setPassword("not_sample");
		member_update.setMember_name("not_sample");
		member_update.setPhone("011-2222-3333");
		if (dao.updateMember(member_update) == 1) {
			sqlSession.commit();
		}
		
		if (dao.deleteMember(member_update.getMember_id()) == 1) {
			sqlSession.commit();
		}
		
		List<Member> result = dao.members();
		for (Member member : result) {
			System.out.println(member.toString());
		}
	}

}
