package com.kcb.web.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kcb.persistence.board.dto.BoardDto;
import com.kcb.web.service.BoardService;

import java.util.List;

/**
 * Created by yookeun on 2017. 10. 7..
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class Board2ControllerTest {


    @Autowired
    private BoardService boardService;

    @Test
    public void board_list() {
        List<BoardDto> boardList = boardService.selectList();
        for (BoardDto boardDto : boardList) {
            System.out.println("title = " + boardDto.getTitle());
            System.out.println("content = " + boardDto.getContent());
        }
    }
}
