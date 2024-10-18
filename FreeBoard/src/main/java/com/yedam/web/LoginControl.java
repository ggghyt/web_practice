package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("login_id");
		String pw = req.getParameter("login_pw");
		
		
		if (req.getMethod().equals("GET")) {
			req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
			
		} else if (req.getMethod().equals("POST")) {
			MemberService svc = new MemberServiceImpl();
			if (svc.loginCheck(id, pw) == null) {
				req.setAttribute("msg", "something wrong");
				req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
				return;
			}
			
			HttpSession session = req.getSession();
			session.setAttribute("login_id", id);
			
			resp.sendRedirect("boardList.do");
		}
	}

}
