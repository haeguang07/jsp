package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.persistence.EmpDAO;

public class delMemberControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		EmpDAO dao = new EmpDAO();
		String empId = req.getParameter("emp_id");
		try {
			if(dao.deleteEmp(empId)) {
				resp.sendRedirect("main.do");
			}else {
				resp.sendRedirect("modifyMember.do?emp_id="+ empId);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
