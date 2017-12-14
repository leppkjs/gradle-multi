package com.kcb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kcb.persistence.board.dao.BoardDao;
import com.kcb.persistence.board.dto.BoardDto;

import java.util.List;

/**
 * Created by yookeun on 2017. 10. 7..
 */

@Service
public class BoardAppService {
    @Autowired
    private BoardDao boardDao;
    public List<BoardDto> selectList() {
        return boardDao.selectList();
    }
}