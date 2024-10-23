package com.yedam.control.reply;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class ReplyListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String board_num = req.getParameter("board_num");
		String page = req.getParameter("page");
		resp.setContentType("text/json;charset=utf-8");
		ReplyService svc = new ReplyServiceImpl();
		
		List<ReplyVO> list = svc.replyList(Integer.parseInt(board_num), Integer.parseInt(page));
		
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		resp.getWriter().print(json);
	}
}
