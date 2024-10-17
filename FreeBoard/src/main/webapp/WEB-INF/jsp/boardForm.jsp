<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>등록 화면</h3>
<%
String msg = (String) request.getAttribute("msg");
if (msg != null) {
%>
<p style="color:blue"><%=msg%></p>
<%
}
%>
<form action="addBoard.do" method="get">
	<table class="table">
		<tr>
			<th>제목</th>
			<td><input class="form-control" type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" name="content" rows="5" cols="40"></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input class="form-control" type="text" name="writer"></td>
		</tr>
		<tr>
			<th></th>
			<td>
			<input type="submit" value="save" class="btn btn-success">
			<input type="reset" value="cancle" class="btn btn-danger">
			</td>
		</tr>
	</table>
</form>


<jsp:include page="../includes/footer.jsp"></jsp:include>