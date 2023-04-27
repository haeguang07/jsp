package com.yedam.prod.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.prod.domain.ProdVO;
import com.yedam.prod.mapper.prodMapper;

public class prodServiceImpl implements prodService {
	SqlSession session = DataSource.getInstance().openSession(true);
	prodMapper mapper = session.getMapper(prodMapper.class);

	@Override
	public List<ProdVO> prodList() {
		return mapper.prodList();
	}

	@Override
	public ProdVO getProd(int pid) {
		
		return mapper.getProd(pid);
	}

	@Override
	public List<ProdVO> prodListStar() {
		return mapper.prodListStar();
	}

	@Override
	public List<ProdVO> prodList(int page) {
		
		return mapper.prodWithPage(page);
	}

	@Override
	public int totalCount() {
		
		return mapper.getCount();
	}
}
