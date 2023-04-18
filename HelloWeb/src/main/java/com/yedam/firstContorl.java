package com.yedam;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.domain.Employee;
import com.yedam.persistence.EmpDAO;

public class firstContorl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("firstControl 실행");
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;

		try {
			out =resp.getWriter();
			EmpDAO dao = new EmpDAO();
			List<Employee> list = dao.getEmpList();
			out.print("<table border ='2px' style ='border-collapse:collapse'> ");
			out.print("<thead><tr><th>employee_id</th><th>first_name</th><th>last_name</th><th>email</th><th>phone_number</th></tr>");
			out.print("<tbody>");
			for(Employee emp :list ) {
				out.print("<tr>"
						+ "<td><a href= 'searchMember?emp_id=" +emp.getEmployeeId()+ "'> "+emp.getEmployeeId()+"</a></td>"
						+ "<td>"+emp.getFirstName()+"</td>"
						+ "<td>"+emp.getLastName()+"</td>"
						+ "<td>"+emp.getEmail()+"</td>"
						+ "<td>"+emp.getPhone()+"</td>"
						+ "</tr>");
//				System.out.print("eid: " + rs.getInt("employee_id"));// 순번을 넣어도 됨
//				System.out.println(" fName " + rs.getString(2));
				
			}

			out.print("</tbody>");
			out.print("</table>");
			

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	

}
