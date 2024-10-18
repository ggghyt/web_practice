<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글 목록</h3>
<%
List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
PageDTO paging = (PageDTO) request.getAttribute("page");
String searchCondition = (String) request.getAttribute("searchCondition");
String keyword = (String) request.getAttribute("keyword");
keyword = keyword == null ? "" : keyword;
%>
<form class="row g-3">
  <div class="col-md-4">
    <select name="searchCondition" class="form-select">
      <option selected value="">선책하세요</option>
      <option value="title" <%=(searchCondition != null && searchCondition.equals("title") ? "selected" : "") %>>제목</option>
      <option value="writer">작성자</option>
      <option value="title_writer">제목 + 작성자</option>
    </select>
  </div>
  <div class="col-md-2">
    <input type="text" class="form-control" name="keyword" value="<%=keyword%>">
  </div>
  <div class="col-md-5">
    <button type="submit" class="btn btn-primary">조회</button>
  </div>
</form>

<table class="table">
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>작성 날짜</th>
		</tr>
	</thead>
	<tbody>
		<%
		for (BoardVO board : list) {
			String write_date = sdf.format(board.getWrite_date());
		%>
		<tr>
			<td><%=board.getBoard_num()%></td>
			<td><a href='board.do?searchCondition=<%=searchCondition%>&keyword=<%=keyword%>&page=<%=paging.getPage()%>&board_num=<%=board.getBoard_num()%>'><%=board.getTitle()%></a></td>
			<td><%=board.getWriter()%></td>
			<td><%=board.getView_count()%></td>
			<td><%=write_date%></td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<%
		if (paging.isPrev()) {
		%>
			<li class="page-item"><a class="page-link"
				href="boardList.do?page=<%=paging.getStartPage() - 1%>">Previous</a>
			</li>
		<%
		} else {
		%>
			<li class="page-item disabled"><a class="page-link">Previous</a>
			</li>
		<%
		}
		%>
		<%
		for (int p = paging.getStartPage(); p <= paging.getEndPage(); p++) {
		%>
			<%
			if (p != paging.getPage()) {
			%>
				<li class="page-item"><a class="page-link" 
				href="boardList.do?searchCondition=<%=searchCondition%>&keyword=<%=keyword%>&page=<%=p%>"><%=p%></a></li>
			<%
			} else {
			%>
				<li class="page-item active" aria-current="page">
				<span class="page-link"><%=p%></span></li>
			<%
			}
			%>
		<%
		}
		%>
		<%
		if (paging.isNext()) {
		%>
			<li class="page-item"><a class="page-link"
				href="boardList.do?page=<%=paging.getEndPage() + 1%>">Next</a></li>
		<%
		} else {
		%>
			<li class="page-item disabled"><a class="page-link">Next</a></li>
		<%
		}
		%>
	</ul>
</nav>
<jsp:include page="../includes/footer.jsp"></jsp:include>