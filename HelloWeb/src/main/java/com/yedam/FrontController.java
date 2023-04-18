package com.yedam;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
	//key & value 저장할 수 있는 컬랙션 Map
	Map <String , Control> map;
	public FrontController() {
		System.out.println("FrontController() Call.");
		map = new HashMap<>();
	}
	@Override
	public void init() throws ServletException {
		System.out.println("init() Call.");
		map.put("/main.do", new MainControl());
		map.put("/first.do", new firstContorl());
		map.put("/second.do", new secondContorl());
		//단건조회 상제페이지(getMember.jsp)
		map.put("/getMember.do", new GetMemberControl());
		map.put("/modifyMember.do", new modifyMemberControl());
		map.put("/addMemberForm.do", new addMemberFormControl());
		map.put("/addMember.do", new addMemberControl());
		map.put("/delMember.do", new delMemberControl());
		map.put("/loginForm.do", new loginFormControl());
		map.put("/login.do", new loginControl());
		
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("service() Call.");
		//http://localhost:8081/HelloWeb/getmember.jsp?emp_id=206 //URL
		///HelloWeb/getmember.jsp?emp_id=206 URI
		String uri =req.getRequestURI();
		
		String context = req.getContextPath();//context: HelloWeb(프로잭트 이름 최상위)
		String page= uri.substring(context.length());
		System.out.println(page);
		System.out.println(map.get(page));
		Control control = map.get(page);
		control.exec(req, resp);
		
	}
	@Override
	public void destroy() {
		System.out.println("destroy() Call.");
	}
}
