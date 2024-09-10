package com.yedam.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardVO;

@SpringBootTest
class BootBoardApplicationTests {
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	void boardList() {
		// 전체조회 : 입력, X -> 출력, 1건이상
		List<BoardVO> list = boardMapper.selectBoardAll();
//		assertTrue(!list.isEmpty());
		System.out.println(list.get(0));
	}
	
	@Test
	void boardInsert() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.getTitle("First board");
//		boardVO.getWriter();
		
		
		BoardVO boardVO 
			= BoardVO.builder()
			 		.title("First board")
			 		.writer("Tester")
			 		.regdate(new Date())
			 		.build();
		System.err.println("before) " + boardVO.getBno());
		int result = boardMapper.insertBoardInfo(boardVO);
		System.err.println("after) " + boardVO.getBno());
		assertEquals(result, 1);
	}
}
