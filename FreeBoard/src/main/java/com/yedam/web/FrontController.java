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
