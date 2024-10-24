package com.yedam.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVO;

public class EventServiceImpl implements EventService {
	SqlSession sqlSession = DataSource.getInstance().openSession(true);
	EventMapper mapper = sqlSession.getMapper(EventMapper.class);
	
	@Override
	public List<Map<String, Object>> eventInput() {
		return mapper.eventInput();
	}

	@Override
	public boolean eventInsert(EventVO evo) {
		return mapper.eventInsert(evo) == 1;
	}

	@Override
	public boolean eventDelete(String title) {
		return mapper.eventDelete(title) == 1;
	}

}
