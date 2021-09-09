<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value = "<%=request.getContextPath()%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>TEMP</title>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script src="${path}/js/bbsList.js" type="text/javascript"></script>
<link href='https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css' rel='stylesheet' type='text/css'>
<link href="${path}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${path}/css/common.css" rel="stylesheet" type="text/css">
<link href="${path}/css/bbsList.css" rel="stylesheet" type="text/css">  
</head>
<body>
	<jsp:include page="header.jsp"/>
	<section class="bbs-area">
		<h2 class="hidden">bbs-list-area</h2>
		<div class="container">
			<h3>게시판</h3>
			<div class="option">
				<a class="add_btn" href="/bbs/insert">추가</a>
				<form action="bbs">
					<input type="text" name="keyword" placeholder="검색어를 입력해주세요." value="${keyword}">
					<input type="submit" value="검색">
				</form>
			</div>
			<table>
				<caption>제목, 작성자, 게시일</caption>
				<colgroup>
					<col style="width:*%">
					<col style="width:20%">
					<col style="width:20%">
				</colgroup>
				<thead>
					<tr>
						<th>제목</th>
						<th>작성자</th>
						<th>게시일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${bbsList}" var="item">
						<tr onClick="selectBbsDetail(${item.bbsNo})">
							<td>${item.bbsTitle}</td>
							<td>${item.userId}</td>
							<td>${item.insertTs}</td>
						</tr>		
					</c:forEach>								
				</tbody>
			</table>
			<%-- 
			<div class="page">
				<c:if test="${bbs.startPage!=1}">
					<a href="bbs?currentPage=1
						<c:if test="${bbs.keyword!=null}">						
							&keyword=${bbs.keyword}							
						</c:if>
					">[처음]</a>
					<a href="bbs?currentPage=${bbs.startPage-1}&keyword=${bbs.keyword}">[이전]</a>
				</c:if> 
				<c:forEach var="pageNo" begin="${bbs.startPage}" end="${bbs.endPage < bbs.pageTotalCnt ? bbs.endPage : bbs.pageTotalCnt}">
					<c:choose>
						<c:when test="${pageNo == bbs.currentPage}">
							<b class="currentPage">${pageNo}</b>
						</c:when>
						<c:otherwise>
							<a class="remainPage" href="bbs?currentPage=${pageNo}
								<c:if test="${bbs.keyword!=null}">						
									&keyword=${bbs.keyword}							
								</c:if>
							">${pageNo}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<c:if test="${bbs.endPage < bbs.pageTotalCnt}">
					<a href="bbs?currentPage=${bbs.endPage+1}
						<c:if test="${bbs.keyword!=null}">						
							&keyword=${bbs.keyword}							
						</c:if>
					">[다음]</a>
					<a href="bbs?currentPage=${bbs.pageTotalCnt}
						<c:if test = "${bbs.keyword!=null}">						
							&keyword=${bbs.kewword}							
						</c:if>
					">[마지막]</a>
				</c:if>
			</div>		
			--%>		 
		</div>
	</section>
</body>
</html>