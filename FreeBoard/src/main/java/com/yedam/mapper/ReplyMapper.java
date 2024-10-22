package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> selectList(int board_num);
	int deleteReply (int reply_num);
	int insertReply (ReplyVO reply);
	ReplyVO selectReply(int reply_num);
}
