<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3>글 목록</h3>
<%
String keyword = (String) request.getAttribute("keyword");
keyword = keyword == null ? "" : keyword;
%>
<form class="row g-3">
  <div class="col-md-4">
    <select name="searchCondition" class="form-select">
      <option selected value="">선책하세요</option>
      <option value="title" ${(searchCondition != null && searchCondition.equals("title") ? "selected" : "")}>제목</option>
      <option value="writer">작성자</option>
      <option value="title_writer">제목 + 작성자</option>
    </select>
  </div>
  <div class="col-md-2">
    <input type="text" class="form-control" name="keyword" value="${keyword}">
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
		<c:forEach var="board" items="${boardList}">
		<tr>
			<td><c:out value="${board.board_num}"></c:out></td>
			<td><a href='board.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${page.page}&board_num=${board.board_num}'>${board.title}</a></td>
			<td><c:out value="${board.writer}"></c:out></td>
			<td><c:out value="${board.view_count}"></c:out></td>
			<td><fmt:formatDate value="${board.write_date}" pattern="yyyy-MM-dd-HH:mm:ss"></fmt:formatDate></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<c:choose>
			<c:when test="${page.isPrev()}">
				<li class="page-item"><a class="page-link"
				href="boardList.do?page=${page.getStartPage() - 1}">Previous</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link">Previous</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="p" begin="${page.getStartPage()}" end="${page.getEndPage()}">
			<c:choose>
				<c:when test="${p != page.getPage()}">
					<li class="page-item"><a class="page-link" 
					href="boardList.do?searchCondition=${searchCondition}&keyword=${keyword}&page=${p}">${p}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item active" aria-current="page">
					<span class="page-link">${p}</span></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${page.isNext()}">
				<li class="page-item"><a class="page-link"
				href="boardList.do?page=${page.getEndPage() + 1}">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled"><a class="page-link">Next</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
<jsp:include page="../includes/footer.jsp"></jsp:include>