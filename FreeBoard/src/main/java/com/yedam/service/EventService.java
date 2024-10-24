package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.EventVO;

public interface EventService {
	List<Map<String, Object>> eventInput();
	boolean eventInsert(EventVO evo);
	boolean eventDelete(String title);
}
