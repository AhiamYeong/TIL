package com.ssafy.board.test;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.board.config.MybatisConfig;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dto.Board;

public class MybatisTest {
	public static void main(String[] args) {
//		MybatisConfig config = new MybatisConfig();
		
		//전체 게시글 가져오기
//		try(SqlSession session = MybatisConfig.getFactory().openSession(true)){
////			List<Board> list = session.selectList("com.ssafy.board.model.dao.BoardDao.selectAll");
//			BoardDao dao = session.getMapper(BoardDao.class);
//			for(Board board : dao.selectAll()) {
//				System.out.println(board);
//			}
//		}
		//상세 게시글 가져오기
//		try(SqlSession session = MybatisConfig.getFactory().openSession(true)){
//			BoardDao dao = session.getMapper(BoardDao.class);
//			System.out.println(dao.selectOne(10));
//		}
		
		//게시글 등록
//		try(SqlSession session = MybatisConfig.getFactory().openSession(true)){
//			BoardDao dao = session.getMapper(BoardDao.class);
//			dao.insertBoard(new Board("점심 머먹지?", "양띵균", "오늘 A코스야"));
//		}
		
		//게시글 삭제
//		try(SqlSession session = MybatisConfig.getFactory().openSession(true)){
//			BoardDao dao = session.getMapper(BoardDao.class);
//			dao.deleteBoard(24);
//			System.out.println(dao.selectOne(24));
//		}
		
		//게시글 수정 
		try(SqlSession session = MybatisConfig.getFactory().openSession(true)){
			BoardDao dao = session.getMapper(BoardDao.class);
			Board board = dao.selectOne(1);
			board.setContent("사실은 B코스");
			
			dao.updateBoard(board);
			
			System.out.println(dao.selectOne(1));
			
		}
	}
}
