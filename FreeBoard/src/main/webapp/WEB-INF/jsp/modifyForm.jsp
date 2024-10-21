<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h3>수정 화면</h3>
<%
BoardVO board = (BoardVO) request.getAttribute("boardVO");
String msg = (String) request.getAttribute("msg");
String pg = (String) request.getAttribute("page");
String searchCondition = (String) request.getAttribute("searchCondition");
String keyword = (String) request.getAttribute("keyword");
String login_id = (String) session.getAttribute("login_id");
if (msg != null) {
%>
<p style="color:blue"><%=msg%></p>
<%
}
%>
<form action="modifyBoard.do" method="post">
	<input type="hidden" name="board_num" value="<%=board.getBoard_num()%>">
	<input type="hidden" name="page" value="<%=pg%>">
	<input type="hidden" name="searchCondition" value="<%=searchCondition%>">
	<input type="hidden" name="keyword" value="<%=keyword%>">
	<table class="table">
		<tr>
			<th>번호</th>
			<td><%=board.getBoard_num()%></td>
			<th>조회 수</th>
			<td><%=board.getView_count()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input class="form-control" type="text" name="title" value="<%=board.getTitle()%>"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea class="form-control" name="content" rows="5" cols="40"><%=board.getContent()%></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3"><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th></th>
			<td colspan="3">
			<input type="submit" value="save" <%=login_id != null && login_id.equals(board.getWriter()) ? "" : "disabled"%> class="btn btn-success">
			<input type="reset" value="cancle" class="btn btn-danger">
			</td>
		</tr>
	</table>
</form>

