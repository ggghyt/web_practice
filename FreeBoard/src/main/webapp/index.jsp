<%@page import="com.yedam.service.MemberService"%>
<%@page import="com.yedam.service.MemberServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>${login_id}</p>
	<c:set var="name" value="Hong"></c:set>
	<c:out value="${name}"></c:out>
	
	<c:set var="age" value="60"></c:set>
	<c:if test="${age >= 20}">
		<p>not young</p>
	</c:if>
	<c:choose>
		<c:when test="${age >= 60}">
			<p> old</p>
		</c:when>
		<c:when test="${age >= 20}">
			<p> not young</p>
		</c:when>
		<c:otherwise>
			<p> young</p>
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="i" begin="1" end="10" step="3">
		<p> i is ${i}.</p>
	</c:forEach>
	
	<c:set var="page" value="boardList.do"></c:set>
	<jsp:forward page="${page}"></jsp:forward>
</body>
</html>