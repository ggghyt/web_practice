<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String login_id = (String) session.getAttribute("login_id");
    %>
<div class="border-end bg-white" id="sidebar-wrapper">
	<div class="sidebar-heading border-bottom bg-light">User</div>
	<div class="list-group list-group-flush">
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">Member list</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberAddForm.do">Add Member</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">Board list</a>
		<%
		if (login_id == null) {
		%>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">Login</a>
		<%
		} else {
		%>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="addBoardForm.do">Board add</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="logOut.do">Logout ( <%=login_id%> )</a>
		<%
		}
		%>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="javascript.do">java script</a>
		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="chart.do">chart</a>
	</div>
</div>