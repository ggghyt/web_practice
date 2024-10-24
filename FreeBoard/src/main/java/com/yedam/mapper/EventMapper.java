package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;

public interface EventMapper {
	List<Map<String, Object>> eventInput();
	int eventInsert(EventVO evo);
	int eventDelete(String title);
}
