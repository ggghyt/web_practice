package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public boolean addReply(ReplyVO reply) {
		// TODO Auto-generated method stub
		return mapper.insertReply(reply) == 1;
	}

	@Override
	public boolean removeReply(int reply_num) {
		// TODO Auto-generated method stub
		return mapper.deleteReply(reply_num) == 1;
	}

	@Override
	public ReplyVO getReply(int reply_num) {
		// TODO Auto-generated method stub
		return mapper.selectReply(reply_num);
	}

	@Override
	public List<ReplyVO> replyList(int board_num, int page) {
		return mapper.selectListPaging(board_num, page);
	}

	@Override
	public int replyCount(int board_num) {
		return mapper.selectCount(board_num);
	}

}
