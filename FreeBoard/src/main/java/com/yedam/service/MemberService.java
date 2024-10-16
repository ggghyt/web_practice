package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberService {
	boolean addMember(MemberVO member);
	boolean retireMember(String memberId);
	
	List<MemberVO> memberList();
}
