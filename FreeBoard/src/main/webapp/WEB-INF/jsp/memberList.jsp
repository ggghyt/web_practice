<%@page import="com.yedam.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<title>Insert title here</title>
<h3>member list</h3>
<%
List<MemberVO> list = (List<MemberVO>) request.getAttribute("memberList");
System.out.println(list);
%>
<table class='table'>
	<tbody>
		<%
		for (MemberVO mvo : list) {
		%>
		<tr>
			<td><%=mvo.getMember_id()%></td>
			<td><%=mvo.getMember_name()%></td>
			<td><%=mvo.getPhone()%></td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>

<jsp:include page="../includes/footer.jsp"></jsp:include>