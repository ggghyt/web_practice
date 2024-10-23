package com.yedam.control.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class ReplyCountCountrol implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bno = req.getParameter("board_num");
		
		ReplyService svc = new ReplyServiceImpl();
		int totalCnt = svc.replyCount(Integer.parseInt(bno));
		resp.getWriter().print("{\"totalCount\":" + totalCnt + "}");
	}

}
