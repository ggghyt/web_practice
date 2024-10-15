package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Data_source;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;


public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberListServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		SqlSession sqlSession = Data_source.getInstance().openSession();
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		
		List<Member> result = dao.members();
		for (Member member : result) {
			response.getWriter().print(member.getMember_id() + " | ");
			response.getWriter().print(member.getPassword() + " | ");
			response.getWriter().print(member.getMember_name() + " | ");
			response.getWriter().print(member.getPhone() + " | ");
			response.getWriter().println("");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
