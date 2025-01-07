package com.kh;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kh.domain.Board;

@SpringBootTest
public class LomboksTests {
	@Test
	//디폴트 생성자
	public void testGetter() {
		Board board = new Board();
		System.out.println(board.getTitle());
	}
		@Test
		public void testSetter() {
			Board board = new Board();
			board.setTitle("공지사항");
			System.out.println(board.getTitle());
			System.out.println(board.toString());
	}
}
