package com.yedam.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.control.javaScriptControl;
import com.yedam.control.board.AddBoardControl;
import com.yedam.control.board.AddBoardForm;
import com.yedam.control.board.BoardControl;
import com.yedam.control.board.BoardListControl;
import com.yedam.control.board.ModifyBoardControl;
import com.yedam.control.board.RemoveBoardControl;
import com.yedam.control.member.AddMemberJsonControl;
import com.yedam.control.member.LogOutControl;
import com.yedam.control.member.LoginControl;
import com.yedam.control.member.MemberAddControl;
import com.yedam.control.member.MemberAddFormControl;
import com.yedam.control.member.MemberJsonControl;
import com.yedam.control.member.MemberListControl;
import com.yedam.control.member.RemoveMemberJsonControl;
import com.yedam.control.reply.AddReplyControl;
import com.yedam.control.reply.RemoveReplyControl;
import com.yedam.control.reply.ReplyCountCountrol;
import com.yedam.control.reply.ReplyListControl;

//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	Map<String, Control> map;
	public FrontController() {
		System.out.println("make success");
		map = new HashMap<>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init success");
		map.put("/memberList.do", new MemberListControl());
		map.put("/memberAddForm.do", new MemberAddFormControl());
		map.put("/memberAdd.do", new MemberAddControl());
		
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl());
		
		map.put("/addBoardForm.do", new AddBoardForm());
		map.put("/addBoard.do", new AddBoardControl());
		
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/removeBoard.do", new RemoveBoardControl());
		
		map.put("/loginForm.do", new LoginControl());
		map.put("/logOut.do", new LogOutControl());
		
		map.put("/javascript.do", new javaScriptControl());
		map.put("/memberJson.do", new MemberJsonControl());
		map.put("/addMemberJson.do", new AddMemberJsonControl());
		map.put("/removeMemberJson.do", new RemoveMemberJsonControl());
		
		map.put("/replyList.do", new ReplyListControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/replyCount.do", new ReplyCountCountrol());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service success");
		String uri = req.getRequestURI(); // /FreeBoard/*.do
		String context = req.getContextPath(); // /FreeBoard
		String page = uri.substring(context.length()); // /*.do
		
		Control control = map.get(page);
		control.exec(req, resp);
		
	}
}
