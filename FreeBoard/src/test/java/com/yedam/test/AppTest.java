package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.common.SearchDTO;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

public class AppTest {
	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		SearchDTO search = new SearchDTO();
		search.setPage(2);
		search.setSearchCondition("sample");
		search.setKeyword("writer");
		
		List<BoardVO> list = mapper.listWithPage(search);
		for(BoardVO bvo : list) {
			System.out.println(bvo.toString());
		}
		
	}
}
