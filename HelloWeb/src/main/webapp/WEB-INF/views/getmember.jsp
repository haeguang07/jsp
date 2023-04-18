<%@page import="com.yedam.domain.Employee"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
	<%
		Employee emp =(Employee)request.getAttribute("empInfo");		
	%>
	<table border="1" style ="border-collapse:collapse">
		<tr><th>사원번호</th><td><%=emp.getEmployeeId() %></td></tr>
		<tr><th>이름</th><td><%=emp.getFirstName() %></td></tr>
		<tr><th>성</th><td><%=emp.getLastName() %></td></tr>
		<tr><th>직무</th><td><%=emp.getJobId() %></td></tr>
		<tr><th>전화번호</th><td><%=emp.getPhone() %></td></tr>
		<tr><th>이메일</th><td><%=emp.getEmail() %></td></tr>
		<tr><th>입사일</th><td><%=emp.getHiredate() %></td></tr>
	</table>

<jsp:include page="footer.jsp"></jsp:include>