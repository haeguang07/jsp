package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class loginControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String empId = req.getParameter("emp_id");
		String email =req.getParameter("email");
		Employee emp = new Employee();
		emp.setEmployeeId(Integer.parseInt(empId));
		emp.setEmail(email);
		EmpDAO dao = new EmpDAO();
		emp= dao.loginCheck(emp);
		//request객체 와 session객체
		try {
			if(emp != null) {
				req.setAttribute("reqInfp", emp.getFirstName());
				HttpSession session= req.getSession();
				session.setAttribute("sesInfo", emp.getLastName());
				req.getRequestDispatcher("main.do").forward(req, resp);;
				
//				resp.sendRedirect("main.do");
			}else {
				resp.sendRedirect("loginForm.do");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
