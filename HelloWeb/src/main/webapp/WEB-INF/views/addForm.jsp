<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

	<form action="addMember.do">
	<fieldset>
		<legend>사원 추가</legend>
	 	<label for="fanme">이름</label><input type="text" name = "fname"><br> 
	 	<label>성</label> <input type="text" name = "lname"><br>
		<label>이메일</label><input type="text" name = "email"><br>
		<label>직무</label><input type="text" name = "job"><br>
		<label>입사일</label><input type="text" name = "hire" placeholder=YYYY-MM-DD><br>
		<label>전화번호</label><input type="text" name ="phone"> <br>
		<input type ="submit" value = "저장">
	</fieldset>
	</form>
<jsp:include page="footer.jsp"></jsp:include>