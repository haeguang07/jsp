package com.yedam.prod.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.PageDTO;
import com.yedam.prod.FrontControl.Control;
import com.yedam.prod.domain.ProdVO;
import com.yedam.prod.service.prodService;
import com.yedam.prod.service.prodServiceImpl;

public class productListFormControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		prodService service = new prodServiceImpl();
		String pageStr=req.getParameter("page");
		pageStr = (pageStr==null) ? "1" :pageStr ;
		int page=Integer.parseInt(pageStr) ;
		int total= service.totalCount();
		List<ProdVO> list = service.prodList(page);
		System.out.println(list);
		PageDTO dto =new PageDTO(page,total);
		req.setAttribute("list", list);
		req.setAttribute("pageInfo", dto);
		
		return "prod/prodList.tiles";
	}

}
