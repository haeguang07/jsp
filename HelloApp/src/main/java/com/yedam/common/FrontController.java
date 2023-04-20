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

import com.yedam.notice.contorl.*;


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
		//공지사항 등록화면
		map.put("/noticeAddForm.do", new NoticeAddForm());
		//공지사항 등록 기능
		map.put("/noticeAdd.do", new NoticeAddControl());
		//공지사항 들어가기(상세보기)
		map.put("/getNotice.do", new GetNoticeControl());
		//공지사항 수정하기 화면
		//수정하기 기능
		map.put("/modifyNotice.do", new ModifyNoticeControl());
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
		if(viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return;
		}
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
		
	}
	
}
