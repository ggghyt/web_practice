package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList(SearchDTO search) {
		return mapper.listWithPage(search);
	}

	@Override
	public boolean registerBoard(BoardVO board) {
		return mapper.insertBoard(board) == 1;
	}

	@Override
	public boolean removeBoard(int board_num) {
		return mapper.deleteBoard(board_num) > 0;
	}

	@Override
	public boolean modifyBoard(BoardVO board) {
		return mapper.updateBoard(board) > 0;
	}

	@Override
	public BoardVO searchBoard(int board_num) {
		mapper.updateCount(board_num);
		return mapper.selectBoard(board_num);
	}

	@Override
	public int getTotalCount(SearchDTO search) {
		return mapper.selectCount(search);
	}

	@Override
	public List<Map<String, Object>> countByWriter() {
		return mapper.countByWriter();
	}


}
