package com.yedam.prod.control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.prod.FrontControl.Control;
import com.yedam.prod.domain.ProdVO;
import com.yedam.prod.service.prodService;
import com.yedam.prod.service.prodServiceImpl;

public class productMainFormControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		prodService service = new prodServiceImpl();
		String idStr = req.getParameter("pid");
		System.out.println(idStr);
		ProdVO vo = service.getProd(Integer.parseInt(idStr));
		req.setAttribute("prod", vo);
		List<ProdVO> list = service.prodListStar();

		req.setAttribute("list", list);

		return "prod/prodMain.tiles";
	}

}
