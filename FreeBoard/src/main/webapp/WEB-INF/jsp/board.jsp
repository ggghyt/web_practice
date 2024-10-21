<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>상세 페이지</h3>
<%
BoardVO board = (BoardVO) request.getAttribute("boardVO");
String pg = (String) request.getAttribute("page");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
String write_date = sdf.format(board.getWrite_date());
String searchCondition = (String) request.getAttribute("searchCondition");
String keyword = (String) request.getAttribute("keyword");
keyword = keyword == null ? "" : keyword;
%>
<table class="table">
	<tr>
		<th>번호</th>
		<td><%=board.getBoard_num()%></td>
		<th>조회수</th>
		<td><%=board.getView_count()%></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><%=board.getWriter()%></td>
		<th>작성 날짜</th>
		<td><%=write_date%></td>
	</tr>
	<tr>
		<th>제목</th>
		<td colspan="3"><%=board.getTitle()%></td>
	</tr>
	<tr>
		<th>내용</th>
		<td colspan="3"><%=board.getContent()%></td>
	</tr>
	<%
	if (board.getImg() != null) { 
	%>
	<tr>
		<th>이미지</th>
		<td colspan="3"><img src="images/<%=board.getImg()%>" width="200px"></td>
	</tr>
	<%
	}
	%>
	<tr>
			<td colspan="4" align="center">
			<input type="button" value="edit" class="btn btn-warning">
			<input type="button" value="delete" class="btn btn-danger">
			</td>
	</tr>
</table>


<script>
	document.querySelector('input[value="edit"]').addEventListener('click', function(e) {
		location.href = 'modifyBoard.do?searchCondition=<%=searchCondition%>&keyword=<%=keyword%>&page=<%=pg%>&board_num=<%=board.getBoard_num()%>'
	});
	document.querySelector('input[value="delete"]').addEventListener('click', function(e) {
		location.href = 'removeBoard.do?board_num=<%=board.getBoard_num()%>'
	});
</script>