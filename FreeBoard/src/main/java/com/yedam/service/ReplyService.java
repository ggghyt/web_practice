package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int board_num, int page);
	boolean addReply(ReplyVO reply);
	boolean removeReply(int reply_num);
	ReplyVO getReply(int reply_num);
	int replyCount(int board_num);
}
