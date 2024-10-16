package com.yedam.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Data_source;
import com.yedam.dao.MemberMapper;
import com.yedam.vo.Member;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/member.action")
public class MemberControlServlet extends HttpServlet {
	public MemberControlServlet() {
		System.out.println("success");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("first : init");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("something income");
		
		SqlSession sqlSession = Data_source.getInstance().openSession(true);
		MemberMapper dao = sqlSession.getMapper(MemberMapper.class);
		String id = req.getParameter("user_id");
		
		if (req.getMethod().equals("GET")) {
			Member member = dao.selectMember(id);
			if (member == null) {
				resp.getWriter().print("not found");
				return;
			} else {
				String str = "<h3>list</h3>";
				str = str + "<form action='member.action' method='post'>";
				str = str + "<input type='hidden' name='user_id' value='" + member.getMember_id() + "'>";
				str = str + "<table border = '1'>";
				str = str + "<tr><th>id</th><td>" + member.getMember_id() + "</td></tr>";
				str = str + "<tr><th>password</th><td>" + member.getPassword() + "</td></tr>";
				str = str + "<tr><th>name</th><td>" + member.getMember_name() + "</td></tr>";
				str = str + "<tr><th>phone</th><td>" + member.getPhone() + "</td></tr>";
				str = str + "<tr><td colspan='2'><input type = 'submit'></td></tr>";
				str = str + "</table>";
				str = str + "</form>";
				str = str + "<a href = 'MemberListServlet'>goto index</a>";
				resp.getWriter().print(str);
			}
			
		} else if (req.getMethod().equals("POST")) {
			if (dao.deleteMember(id) == 1) {
				resp.getWriter().print("<p>delete sueccess</p>");
			} else {
				resp.getWriter().print("<p>something error</p>");
			}
			resp.getWriter().print("<a href = 'MemberListServlet'>goto index</a>");
		}		
	}
	
	@Override
	public void destroy() {
		System.out.println("server down");
	}
}
