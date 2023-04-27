package com.yedam.prod.FrontControl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yedam.prod.control.productListFormControl;
import com.yedam.prod.control.productMainFormControl;



public class FrontController extends HttpServlet{
	String encoding;
	Map <String , Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	
	
	
	@Override
	public void init() throws ServletException {
		map.put("/productListForm.do",new productListFormControl() );
		
		
		map.put("/productMainForm.do",new productMainFormControl() );
		
		
		
		
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인코딩방식 가져오기
		//req.setCharacterEncoding(encoding);
		//path 가져오기
		String uri=req.getRequestURI();
		String context = req.getContextPath();
		String path =uri.substring(context.length());
		
		Control control =map.get(path);
		String viewPage = control.execute(req, resp);
		
		System.out.println(viewPage);
		if(viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return;
		}
		if(viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0,viewPage.length()-5));
			
			return;
		}
		
		//페이지 재지정
		RequestDispatcher rd=req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
		
		
	}
	
	
	
}
