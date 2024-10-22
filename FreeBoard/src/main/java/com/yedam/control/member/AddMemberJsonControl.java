package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class AddMemberJsonControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService svc = new MemberServiceImpl();
		MemberVO mvo = new MemberVO();
		mvo.setMember_id(req.getParameter("member_id"));
		mvo.setPassword(req.getParameter("password"));
		mvo.setMember_name(req.getParameter("member_name"));
		mvo.setPhone(req.getParameter("phone"));
		try {
			svc.addMember(mvo);
			resp.getWriter().print("{\"retCode\":\"success\"}");
		} catch (Exception e) {
			resp.getWriter().print("{\"retCode\":\"something error\"}");
		}

	}

}
