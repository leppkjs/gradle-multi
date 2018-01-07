package com.kcb.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.kcb.app.service.BoardAppService;
import com.kcb.persistence.board.dto.BoardDto;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@ComponentScan("com.kcb")
public class GradleMultiAppMain {

	@Autowired
	private BoardAppService boardService;

	public static void main(String[] args) {
		SpringApplication.run(GradleMultiAppMain.class, args);
	}

	@PostConstruct
	public void run() {
		List<BoardDto> boardDtoList = boardService.selectList();
		for (BoardDto boardDto : boardDtoList) {
			System.out.println("=======================================================");
			System.out.println("title = " + boardDto.getTitle());
			System.out.println("content = " + boardDto.getContent());
			System.out.println("=======================================================");
		}
	}

}