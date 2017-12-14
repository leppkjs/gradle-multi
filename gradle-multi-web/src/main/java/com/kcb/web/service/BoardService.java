package com.kcb.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcb.persistence.board.dao.BoardDao;
import com.kcb.persistence.board.dto.BoardDto;

@Service
public class BoardService {

	@Autowired
	private BoardDao boardDao;
	
	public List<BoardDto> selectList() {
		return boardDao.selectList();
	}
}