package com.yedam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class GetMemberControl implements Control {
	
	@Override

	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		//매개값으로 사원 정보
		String empId=req.getParameter("emp_id");
		EmpDAO dao = new EmpDAO();
		Employee emp = dao.getEmp(Integer.parseInt(empId));
		req.setAttribute("empInfo", emp);
		//페이지를 재 지정 contorl 에서 getMember.jsp
		try {
			req.getRequestDispatcher("WEB-INF/views/getmember.jsp").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
