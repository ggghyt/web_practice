package com.yedam.control.reply;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/json;charset=utf-8");
		String board_num = req.getParameter("board_num");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoard_num(Integer.parseInt(board_num));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		
		ReplyService svc = new ReplyServiceImpl();
		
		Map<String, Object> result = new HashMap<>();
		
		try {
			svc.addReply(rvo);
			result.put("retCode", "success");
			result.put("retVal", rvo);
			
		} catch (Exception e) {
			result.put("retCode", "something error");
			result.put("retVal", null);
		}
		
		Gson gson = new GsonBuilder().create();
		resp.getWriter().print(gson.toJson(result));
	}

}
