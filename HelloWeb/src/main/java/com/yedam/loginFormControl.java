package com.yedam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginFormControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)  {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/views/login.jsp");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
