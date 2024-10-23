package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> selectListPaging(@Param("board_num") int board_num, @Param("page") int page);
	List<ReplyVO> selectList(int board_num);
	int deleteReply (int reply_num);
	int insertReply (ReplyVO reply);
	ReplyVO selectReply(int reply_num);
	int selectCount (int board_num);
}
