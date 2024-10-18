package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MemberVO;

public interface MemberMapper {
	public List<MemberVO> members();
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int deleteMember(String member_id);
	public MemberVO selectMember(String member_id);
	public MemberVO loginMember(@Param("id") String id, @Param("pw") String pw);
}
