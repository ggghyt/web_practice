package com.yedam.control.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class MemberJsonControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberService svc = new MemberServiceImpl();
		resp.setContentType("text/json;charset=utf-8");
		
		List<MemberVO> list = svc.memberList();
		
		String json = "[";
		for (int i = 0 ; i < list.size() ; i++) {
			json = json + "{\"member_id\":\"" + list.get(i).getMember_id() + "\",";
			json = json + "\"member_name\":\"" + list.get(i).getMember_name() + "\",";
			json = json + "\"phone\":\"" + list.get(i).getPhone() + "\",";
			json = json + "\"responsibility\":\"" + list.get(i).getResponsibility() + "\"";
			json = json + "}";
			if (i != list.size() - 1) {
				json = json + ",";
			}
		}
		json = json + "]";
		resp.getWriter().print(json);
	}

}
