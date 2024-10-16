package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Data_source;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

//@WebServlet("/MemberAddServlet")
public class MemberAddServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberAddServer() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>web</h1>");
		out.print("<a href = 'index.html'> move to first page </a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("user_id");
		String name = request.getParameter("user_name");
		String pw = request.getParameter("user_pw");
		String phone = request.getParameter("user_phone");

		Member member = new Member();
		member.setMember_id(id);
		member.setMember_name(name);
		member.setPassword(pw);
		member.setPhone(phone);

		SqlSession sqlSession = Data_source.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		try {
			if (dao.insertMember(member) == 1) {
				response.getWriter().print("success");
			}
		} catch (Exception e) {
			response.getWriter().print("something error");
		}
	}
}
