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
<script src="/js/schoolList.js" type="text/javascript"></script>
<link href='https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css' rel='stylesheet' type='text/css'>
<link href="/css/reset.css" rel="stylesheet" type="text/css">
<link href="/css/common.css" rel="stylesheet" type="text/css">
<link href="/css/schoolList.css" rel="stylesheet" type="text/css">  
</head>
<body>
	<jsp:include page="header.jsp"/>
	<section class="bbs-area">
		<h2 class="hidden">school-list-area</h2>
		<div class="container">
			<h3>학교정보</h3>
			<div class="option">
				<a class="excel_btn" href="/schools/excel?gubun=${resultData.gubun}&keyword=${resultData.keyword}">엑셀다운</a>
				<form action="schools">
					<select name="gubun">
    					<option value="elem_list" <c:if test="${resultData.gubun eq 'elem_list'}">selected</c:if>>초등학교</option>
    					<option value="midd_list" <c:if test="${resultData.gubun eq 'midd_list'}">selected</c:if>>중학교</option>
    					<option value="high_list" <c:if test="${resultData.gubun eq 'high_list'}">selected</c:if>>고등학교</option>
    					<option value="univ_list" <c:if test="${resultData.gubun eq 'univ_list'}">selected</c:if>>대학교</option>
					</select>
					<input type="text" name="keyword" placeholder="검색어를 입력해주세요." value="${resultData.keyword}">
					<input type="submit" value="검색">
				</form>
			</div>
			<table>
				<caption>학교명, 지역, 주소</caption>
				<colgroup>
					<col style="width:20%">
					<col style="width:10%">
					<col style="width:*%">
				</colgroup>
				<thead>
					<tr>
						<th>학교명</th>
						<th>지역</th>
						<th>주소</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${resultData.schoolList}" var="item">
						<tr onClick="selectSchoolDetail('${item.link}')">
							<td class="leftAlign">${item.schoolName}</td>
							<td class="leftAlign">${item.region}</td>
							<td class="leftAlign">${item.adres}</td>
						</tr>		
					</c:forEach>								
				</tbody>
			</table>
			<%-- page navigation bar pack of 5 --%>
			<div class="page">
				<%-- 
					[처음] : 제일 첫 페이지
					[이전] : 이전 startPage (startPage 1,6,11,16...)					 
				--%>		
				<c:if test="${resultData.startPage!=1}">
					<a href="schools?currentPage=1
						<c:if test="${resultData.keyword!=null}">						
							&keyword=${resultData.keyword}							
						</c:if>
						<c:if test="${resultData.gubun!=null}">						
							&gubun=${resultData.gubun}							
						</c:if>
					">[처음]</a>
					<a href="schools?currentPage=${resultData.startPage-1}&keyword=${resultData.keyword}&gubun=${resultData.gubun}">[이전]</a>
				</c:if> 
				<%-- 
					startPage ~ (endPage or pageTotalCnt) For문 돌며 페이징 네비바의 페이지 번호 표현 	
					
					cf. bbs.endPage < bbs.pageTotalCnt ? bbs.endPage : bbs.pageTotalCnt 조건설명
						페이징 네비바의 마지막 페이징은 pageTotalCnt 사용, 나머지 페이징은 endPage 사용하기 위함
						
						ex) 게시글 101개, 페이지당 10개씩 게시물 노출, 페이징 5개씩 표현 
					 		currentPage  : 10	11	
					 		endPage 	 : 10	15	
					  		pageTotalCnt : 11	11  
				--%>		
				<c:forEach var="pageNo" begin="${resultData.startPage}" end="${resultData.endPage < resultData.pageTotalCnt ? resultData.endPage : resultData.pageTotalCnt}">
					<c:choose>
						<c:when test="${pageNo == resultData.currentPage}">
							<b class="currentPage">${pageNo}</b>
						</c:when>
						<c:otherwise>
							<a class="remainPage" href="schools?currentPage=${pageNo}
								<c:if test="${resultData.keyword!=null}">						
									&keyword=${resultData.keyword}							
								</c:if>
								<c:if test="${resultData.gubun!=null}">						
									&gubun=${resultData.gubun}							
								</c:if>
							">${pageNo}</a>
						</c:otherwise>
					</c:choose>
				</c:forEach> 
				<%-- 
					[다음] : 다음 endPage (endPage 5,10,15,20...)
					[마지막] : 제일 마지막 페이지 					 
					
					cf. bbs.endPage < bbs.pageTotalCnt 조건설명
						endPage : 현재페이지 페이징 네비바의 가장 마지막 페이지 번호 
						pageTotalCnt : 게시글 표현할 수 있는 실제 총 페이지 번호
					 	
					 	ex) 게시글 101개, 페이지당 10개씩 게시물 노출, 페이징 5개씩 표현 
					 		currentPage  : 10	11	
					 		endPage 	 : 10	15	
					  		pageTotalCnt : 11	11 					
				--%>
				<c:if test="${resultData.endPage < resultData.pageTotalCnt}">
					<a href="schools?currentPage=${resultData.endPage+1}
						<c:if test="${resultData.keyword!=null}">						
							&keyword=${resultData.keyword}							
						</c:if>
						<c:if test="${resultData.gubun!=null}">						
							&gubun=${resultData.gubun}							
						</c:if>	
					">[다음]</a>
					<a href="schools?currentPage=${resultData.pageTotalCnt}
						<c:if test = "${resultData.keyword!=null}">						
							&keyword=${resultData.keyword}							
						</c:if>
						<c:if test="${resultData.gubun!=null}">						
							&gubun=${resultData.gubun}							
						</c:if>	
					">[마지막]</a>
				</c:if>
			</div>		 
		</div>
	</section>
</body>
</html>