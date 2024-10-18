<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>로그인 화면</h3>
<form action="loginForm.do" method="post">
<%
String msg = (String) request.getAttribute("msg");
if (msg != null) {
%>
<p style="color:blue"><%=msg%></p>
<%
}
%>
<table class="table">
	<tr>
		<th>ID</th><td><input type="text" name="login_id"></td>
	</tr>
	<tr>
		<th>PW</th><td><input type="password" name="login_pw"></td>
	</tr>
	<tr>
		<th></th>
		<td>
			<button type="submit" class="btn btn-primary">로그인</button>
		</td>
	</tr>
</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>