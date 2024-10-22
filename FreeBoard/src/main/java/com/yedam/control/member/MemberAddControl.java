package com.yedam.control.member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberAddControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		System.out.println("MemberAddControl load success");
		String member_id = req.getParameter("member_id");
		String password = req.getParameter("password");
		String member_name = req.getParameter("member_name");
		String phone = req.getParameter("phone");
		
		MemberVO mvo = new MemberVO();
		mvo.setMember_id(member_id);
		mvo.setPassword(password);
		mvo.setMember_name(member_name);
		mvo.setPhone(phone);
		
		MemberService svc = new MemberServiceImpl();
		if (svc.addMember(mvo)) {
			resp.sendRedirect("memberList.do");
		} else {
			resp.sendRedirect("memberAddForm.do");
		}
	}

}
