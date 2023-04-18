<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	form fieldset{
  		border: none;
	}
	form label{
  		float: left;
 	 	width: 144px;
	}
</style>
</head>
<body>
	<form action="delMember.do">
		<fieldset>
			<legend>사원 삭제</legend>
			<label for="emp_id">삭제할 사원번호</label> 
			<input name = "emp_id" >
			<input type ="submit" value = "삭제">
		</fieldset>
	</form>
</body>
</html>