package com.ssafy.board.test;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class Test {
	public static void main(String[] args) {
		BoardDao dao = BoardDaoImpl.getInstance();
		
//		System.out.println(dao.selectOne(1));
		// return값이 null이면 그런 거 없다는 뜻 
		
		// update test
//		dao.insertBoard(new Board("이제는 곤란해01", "애옹", "사실 구라"));
		
		
		// 더미데이터 등록하기
//		for (int i = 0; i < 30; i++) {
//			dao.insertBoard(new Board("이제는"+i*100, "ㅇㅇ", "사실 뻥"));
//		}
		dao.deleteBoard(2);
		// 반환값 res가 0이면 (0 rows affected) 이미 지워져서 없다는 뜻
		
		for (Board b : dao.selectAll()) {
			System.out.println(b);
		}
	}
}
