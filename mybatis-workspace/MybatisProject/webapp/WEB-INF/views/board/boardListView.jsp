<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<style>
	.outer a{
		text-decoration : none;
		color : white;
	}
	
	table{
		border : 1px solid white;
		text-align : center;
	}
	
	
</style>
</head>
<body>
	
	<jsp:include page="../common/menubar.jsp" />
	
	<div class="outer" align="center">
		<br>
		<h1 align="center">게시판</h1>
		<br>
		
		
		
		
		<div id="search-area">
			<form action="search.do" method="get">
				<input type="hidden" name="currentPage" value="1">
				<select name="condition" id="select">
					<option value="writer">작성자</option>
					<option value="content">내용</option>
					<option value="title">제목</option>
				</select>
				<input type="text" name="keyword" value="${ keyword }">
				<button type="submit">검색</button>
			</form>
		</div>
		
		<c:if test="${ not empty condition }">
			<script>
				$(function(){
					$('#search-area option[value=${condition}]').attr('selected', true);
				});
			</script>
		</c:if>
		
		
		
		<br>
		
		<table>
			<thead>
				<tr>
					<th>글번호</th>
					<th width="400">글제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${ empty list }">
						<tr>
							<td colspan="5" align="center">조회된 결과가 없습니다.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${ requestScope.list }" var="b">
							<tr>
								<td>${ b.boardNo }</td>
								<td><a href="detail.bo?bno=${ b.boardNo }">${ b.boardTitle }</a></td>
								<td>${ b.boardWriter }</td>
								<td>${ b.count }</td>
								<td>${ b.createDate }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		
		<br>
		
		<div id="paging-area">
		
			
			<c:if test="${ pi.currentPage ne 1 }">
				<c:choose>
					<c:when test="${ empty condition }">
						<a href="list.bo?currentPage=${pi.currentPage - 1}">&lt;</a>
					</c:when>
					<c:otherwise>
						<a href="search.do?currentPage=${pi.currentPage - 1}&condition=${ condition }&keyword=${ keyword }">&lt;</a>
					</c:otherwise>
				</c:choose>
			</c:if>
			
			
			<c:forEach var="p" begin="${ requestScope.pi.startPage }" end="${ requestScope.pi.endPage }">
				<c:choose>
					<c:when test="${ empty condition }" >
						<a href="list.bo?currentPage=${p}">[${ p }]</a>
					</c:when>
					<c:otherwise>
						<a href="search.do?currentPage=${p}&condition=${ condition }&keyword=${ keyword }">[${ p }]</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			
			<c:if test="${ requestScope.pi.currentPage ne pi.endPage }" >
				<c:choose>
					<c:when test="${ empty condition }">
						<a href="list.bo?currentPage=${pi.currentPage + 1}">&gt;</a>
					</c:when>
					<c:otherwise>
						<a href="search.do?currentPage=${pi.currentPage + 1}&condition=${ condition }&keyword=${ keyword }">&gt;</a>
					</c:otherwise>
				</c:choose>
			</c:if>
		
		</div>
		<br><br>
		
		
	</div>
	
	

	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>