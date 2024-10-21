<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>삭제 화면</h3>
<%
BoardVO board = (BoardVO) request.getAttribute("boardVO");
String msg = (String) request.getAttribute("msg");
if (msg != null) {
%>
<p style="color:blue"><%=msg%></p>
<%
}
%>
<form action="removeBoard.do" method="post">
	<input type="hidden" name="board_num" value="<%=board.getBoard_num()%>">
	<table class="table">
		<tr>
			<th>번호</th>
			<td><%=board.getBoard_num()%></td>
			<th>조회 수</th>
			<td><%=board.getView_count()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><%=board.getContent()%></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th></th>
			<td>
			<input type="submit" value="delete" class="btn btn-danger">
			</td>
		</tr>
	</table>
</form>

