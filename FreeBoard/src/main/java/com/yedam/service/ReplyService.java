package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int board_num);
	boolean addReply(ReplyVO reply);
	boolean removeReply(int reply_num);
	ReplyVO getReply(int reply_num);
}
