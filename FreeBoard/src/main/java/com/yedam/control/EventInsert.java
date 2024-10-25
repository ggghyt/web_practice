package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.EventService;
import com.yedam.service.EventServiceImpl;
import com.yedam.vo.EventVO;

public class EventInsert implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		EventService svc = new EventServiceImpl();
		
		String title = req.getParameter("title");
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		EventVO evo = new EventVO();
		evo.setTitle(title);
		evo.setStart_date(start);
		evo.setEnd_date(end);
				
		if (svc.eventInsert(evo)) {
			resp.getWriter().print("{\"retCode\":\"success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"something error\"}");
		}
	}
	
}
