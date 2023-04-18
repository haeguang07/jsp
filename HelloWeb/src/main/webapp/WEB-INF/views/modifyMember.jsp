<%@page import="com.yedam.domain.Employee"%>
<%@page import="com.yedam.persistence.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="nav.jsp"></jsp:include>
	<%
		//사원 번호 조회 => Employee
		//String empId=request.getParameter("emp_id");
		//EmpDAO dao = new EmpDAO();
		//Employee emp = dao.getEmp(Integer.parseInt(empId));
		Employee emp = (Employee)request.getAttribute("empInfo");
	%>
	<div id = "container">
		<form action="modifyMember.do" method="post">
			<table border ="1">
				<tr><th>사원번호</th><td><input class="gray" type="text" name="emp_id" value="<%=emp.getEmployeeId() %>" readonly/></td></tr>
				<tr><th>이름</th><td><input type="text" name=first_name value="<%=emp.getFirstName()%>" ></td></tr>
				<tr><th>성</th><td><input type="text" name=last_name value="<%=emp.getLastName()%>" ></td></tr>
				<tr><th>이메일</th><td><input type="text" name=email value="<%=emp.getEmail()%>" ></td></tr>
				<tr><th>전화번호</th><td><input type="text" name=phone value="<%=emp.getPhone()%>" ></td></tr>
				<tr><th>직무</th><td><input type="text" name=job_id value="<%=emp.getJobId()%>" ></td></tr>
			</table>
				<input type="submit" value= "수정"> <input type="button" value="삭제" >
		</form>
	</div>
	<script>
		let btn=document.querySelector('input[type ="button"]');
		console.log(btn);
		btn.onclick = function() {
			//alert("클릭됨");
			let frm=document.querySelector('form');
			frm.action= "delMember.do";
			frm.submit();
			
		}
		
	</script>
<jsp:include page="footer.jsp"></jsp:include>