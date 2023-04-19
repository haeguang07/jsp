package com.yedam;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoutControl implements Control {
	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp)  {
		HttpSession session = req.getSession();
		session.invalidate();//섹션객체의 정보 삭제 
		try {
			resp.sendRedirect("loginForm.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
