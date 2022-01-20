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
<link href='https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css' rel='stylesheet' type='text/css'>
<link href="/css/reset.css" rel="stylesheet" type="text/css">
<link href="/css/common.css" rel="stylesheet" type="text/css">
<style type="text/css">
	.error-area{width:100%; text-align: center; margin-top:61px;}
	h3{width:100%; padding-top:60px; padding-bottom:30px; font-size:40px; color:#444;}
	.title b{color:#ff2d60; display:block; line-height:45px;}
	.subTitle{color:#919191; font-size:15px;}
</style>    
</head>
<body>
	<jsp:include page="../header.jsp"/>
	<section class="error-area">
		<h2 class="hidden">error-area</h2>
		<div class="container">
			<h3 class="title">해당 페이지를<b>찾을 수 없습니다.</b></h3>
			<p class="subTitle">404 - Page is not Found</p>
		</div>
	</section>
</body>
</html>