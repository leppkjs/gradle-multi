package com.kcb.persistence.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kcb.persistence.board.dto.BoardDto;

@Repository
public class BoardDao {
	//@Autowired
	//private SqlSession sqlSession;
	
	public List<BoardDto> selectList() {
		//return sqlSession.selectList("boardMapper.selectList");
		
		BoardDto board = new BoardDto();
		board.setId(0);
		board.setTitle("kcb-title");
		board.setRegdate("20171212");
		board.setContent("kcb test board\nit is contents...");
		
		List<BoardDto> boards = new ArrayList<BoardDto>();
		boards.add(board);
		
		return boards;
	}
}