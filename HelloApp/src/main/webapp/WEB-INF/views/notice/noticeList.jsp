<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="my" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../main.jsp"></jsp:include>
	<my:if test="${list ==null }"> 
	<p>${list }</p>
	</my:if>
	<!-- for문  -->
	<my:forEach begin="0" end="${list.size()-1 }"  var="i"> <!-- step는 지정안하면 1 -->
	<p>${list.get(i)}</p>
	</my:forEach>
	<br>
	<!-- 향상된for문  -->
	<my:forEach var="notice" items="${list }">
	<p>${notice }</p>
	</my:forEach>	
</body>
</html>