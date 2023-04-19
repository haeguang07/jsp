package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.notice.contorl.NoticeListControl;


public class FrontController extends HttpServlet {
	String encoding;
	Map <String , Control> map;
	
	public FrontController() {
		map = new HashMap<>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		//첫페이지
		map.put("/main.do",new MainControl());
		//공지사항
		map.put("/noticeList.do", new NoticeListControl());
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(encoding);
		String uri =req.getRequestURI();
		String context= req.getContextPath();
		String path = uri.substring(context.length());
		
		System.out.println(path);
		Control control = map.get(path);
		String viewPage = control.execute(req,resp);
		
		System.out.println(viewPage);
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
	
}
