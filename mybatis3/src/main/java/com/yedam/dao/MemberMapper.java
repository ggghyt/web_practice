package com.yedam.dao;

import java.util.List;

import com.yedam.vo.Member;

public interface MemberMapper {
	public List<Member> members();
	public int insertMember(Member member);
	public int updateMember(Member member);
	public int deleteMember(String member_id);
	public Member selectMember(String member_id);
}
