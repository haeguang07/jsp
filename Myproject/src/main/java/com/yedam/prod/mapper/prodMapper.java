package com.yedam.prod.mapper;

import java.util.List;

import com.yedam.prod.domain.ProdVO;

public interface prodMapper {
	public List<ProdVO> prodList();
	public List<ProdVO> prodListStar();
	public ProdVO getProd(int pid);
	
	public List<ProdVO> prodWithPage(int page);
	public int getCount();
}
