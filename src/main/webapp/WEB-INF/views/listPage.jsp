<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list}" var="list">
		<div>
			<span>${list.bno}</span>
			<span>${list.title}</span>
			<span>${list.bCon}</span>
			<span>${list.bDate}</span>
			<span>${list.viewCnt}</span>
		</div>	
	</c:forEach>
	
	<c:if test="${prev}">
		<span>[ <a href="/listPage?num=${startPage - 1}">이</a>]</span>
	</c:if>
	<c:forEach begin="${startPage}" end="${endPageNum}" var="num">
		<span>
			<c:if test="${select != num}">
				<a href="/listPage?num=${num}">${num}</a>
			</c:if>
			<c:if test="${select == num}">
				<b> ${num}</b>
			</c:if>
		</span>
	</c:forEach>
	<c:if test="${next}">
		<span>[ <a href="/listPage?num=${endPageNum + 1}">다</a>]</span>
	</c:if>
	
</body>
</html>