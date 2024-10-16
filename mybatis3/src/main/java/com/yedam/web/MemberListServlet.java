package com.yedam.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Data_source;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

//@WebServlet("/MemberListServlet")
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
		String str = "<h3>list</h3>";
		str = str + "<table border = '1'>";
		str = str + "<thead><tr><th>id</th><th>name</th><th>phone</th></tr></thead>";
		for (Member member : result) {
			str = str + "<tr><td><a href = 'member.action?user_id=" + member.getMember_id() + "'>" + member.getMember_id() + "</a></td><td>";
			str = str + member.getMember_name() + "</td><td>";
			str = str + member.getPhone() + "</td></tr>";
		}
		str = str + "</table>";
		str = str + "<a href = 'MemberListServlet'>goto index</a>";
		response.getWriter().print(str);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
