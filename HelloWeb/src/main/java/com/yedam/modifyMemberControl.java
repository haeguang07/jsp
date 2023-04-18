package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class modifyMemberControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		// view에서 요청한 method을 구분 GET/POST
		if (req.getMethod().equals("GET")) {
			String empId = req.getParameter("emp_id");
			EmpDAO dao = new EmpDAO();
			Employee emp = dao.getEmp(Integer.parseInt(empId));
			req.setAttribute("empInfo", emp);

			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/modifyMember.jsp");
			try {
				rd.forward(req, resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else if (req.getMethod().equals("POST")) {
			Employee emp = new Employee();
			emp.setEmployeeId(Integer.parseInt(req.getParameter("emp_id")));
			emp.setFirstName(req.getParameter("first_name"));
			emp.setLastName(req.getParameter("last_name"));
			emp.setEmail(req.getParameter("email"));
			emp.setJobId(req.getParameter("job_id"));
			emp.setPhone(req.getParameter("phone"));
			EmpDAO dao = new EmpDAO();
			boolean result = dao.modifyMember(emp);
			if (result) {
				resp.sendRedirect("main.do");
			} else {
				resp.sendRedirect("modifyMember.do?emp_id=" + emp.getEmployeeId());
			}
		}
	}
}
