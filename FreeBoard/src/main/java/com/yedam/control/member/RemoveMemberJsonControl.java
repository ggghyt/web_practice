package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;

public class RemoveMemberJsonControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		MemberService svc = new MemberServiceImpl();
		try {
			svc.retireMember(id);
			resp.getWriter().print("{\"retCode\":\"success\"}");
		} catch (Exception e) {
			resp.getWriter().print("{\"retCode\":\"something error\"}");
		}
	}

}
