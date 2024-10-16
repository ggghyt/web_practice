<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<form action="memberAdd.do">
	<table class="table">
		<tr>
			<th>ID</th>
			<th><input type="text" name="member_id"></th>
		</tr>
		<tr>
			<th>PW</th>
			<th><input type="password" name="password"></th>
		</tr>
		<tr>
			<th>name</th>
			<th><input type="text" name="member_name"></th>
		</tr>
		<tr>
			<th>phone</th>
			<th><input type="text" name="phone"></th>
		</tr>
		<tr>
			<td colspan='2' align="center"><input type="submit" value="save" class="btn btn-primary"></td>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>