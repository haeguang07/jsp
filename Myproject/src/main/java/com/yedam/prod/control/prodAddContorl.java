package com.yedam.prod.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prod.FrontControl.Control;

public class prodAddContorl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pageInfo ="main.do";
		
		if(req.getMethod().equals("GET")) {
			pageInfo = "prod/prodAddForm.tiles";
		}
		
		
		
		return pageInfo;
	}

}
