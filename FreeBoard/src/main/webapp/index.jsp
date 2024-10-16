<%@page import="com.yedam.service.MemberService"%>
<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String my_name = "sample_name";
		MemberService svc = new MemberServiceImpl();
		if (svc.retireMember("Admin01")) {
	%>
		<p>delete success</p>
	<%
		} else {
	%>
		<p>something error</p>
	<%
		}
	%>
	<h3>name : <%=my_name%></h3>
</body>
</html>