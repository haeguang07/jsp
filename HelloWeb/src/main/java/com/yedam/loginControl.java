package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class loginControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String empId = req.getParameter("empId");
		String email =req.getParameter("email");
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.getEmp(Integer.parseInt(empId));
		req.setAttribute("empInfo", emp);
		try {
			if(email.equals(emp.getEmail())) {
				RequestDispatcher rd=req.getRequestDispatcher("getMember.do");
				rd.forward(req, resp);
			}else {
				resp.sendRedirect("WEB-INF/views/login.jsp");
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
