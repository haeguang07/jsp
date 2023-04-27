package com.yedam.prod.service;

import java.util.List;

import com.yedam.prod.domain.ProdVO;

public interface prodService {
	public List<ProdVO> prodList();
	public List<ProdVO> prodListStar();
	
	public ProdVO getProd(int pid);
	public List<ProdVO> prodList(int page);
	public int totalCount();
	
}
