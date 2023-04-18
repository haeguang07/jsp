package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

@WebServlet("/modifyMemberServelt")
public class modifyMemberServelt extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(req.getParameter("emp_id")));
		emp.setFirstName(req.getParameter("first_name"));
		emp.setLastName(req.getParameter("last_name"));
		emp.setEmail(req.getParameter("email"));
		emp.setJobId(req.getParameter("job_id"));
		emp.setPhone(req.getParameter("phone"));
		EmpDAO dao = new EmpDAO();
		boolean result = dao.modifyMember(emp);
		if(result) {
			resp.sendRedirect("main.do");
		}else {
			resp.sendRedirect("modifyMember.do?emp_id=" +emp.getEmployeeId());
		}
	}
}
