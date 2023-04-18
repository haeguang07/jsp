
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@page import="com.yedam.domain.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>

	<%
//	EmpDAO dao = new EmpDAO();//최대한 control에서 다 처리하기
//	List<Employee> list = dao.getEmpList();
	List<Employee> list = (List<Employee>)request.getAttribute("listInfo");
	%>
	<table border= "1">
		<thead>
		<tr><th>사원번호</th><th>이름</th><th>성</th><th>이메일</th><th>전화번호</th></tr>
		</thead>
		<tbody>
		<%for (Employee emp :list) {%>
			<tr><td><a href ="getMember.do?emp_id=<%=emp.getEmployeeId()%>"><%=emp.getEmployeeId()%></a></td>
				<td><a href ="modifyMember.do?emp_id=<%=emp.getEmployeeId()%>"><%= emp.getFirstName()%></a></td>
				<td><%= emp.getLastName()%></td>
				<td><%= emp.getEmail()%></td><td><%= emp.getPhone()%></td>
			</tr>
		<%} %>
		</tbody>
	</table>
	
<jsp:include page="footer.jsp"></jsp:include>