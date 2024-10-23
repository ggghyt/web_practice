package com.yedam.control.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reply_num = req.getParameter("reply_num");
		
		ReplyService svc = new ReplyServiceImpl();
		if (svc.removeReply(Integer.parseInt(reply_num))) {
			resp.getWriter().print("{\"retCode\":\"success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"something error\"}");
		}

	}

}
