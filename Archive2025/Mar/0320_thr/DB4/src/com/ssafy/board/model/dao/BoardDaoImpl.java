package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	// 싱글턴 관리하기 
	private static BoardDao dao = new BoardDaoImpl();
	
	private BoardDaoImpl() {
		
	}
	
	public static BoardDao getInstance() {
		return dao;
	}
	
	// db 연결 연결/종료하는 객체 
	private DBUtil util = DBUtil.getInstance();
	
	
	@Override
	public List<Board> selectAll() {
		List<Board> list = new ArrayList<>();
		// SQL문 준비!
		// try-catch 블록 위해 선언은 외부에서 하기 
		String sql = "SELECT * FROM board";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; 
		
		try {			
			// 로딩해둔 드라이버에서 DB와의 연결 통로 뚫기
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC", "ssafy", "ssafy1234");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// 데이터 몇 개인지 알아? 몰라 > 데이터 있을 때까지
			while(rs.next()) {
				Board board = new Board(); // 바구니 세팅
				
				// board DB에서 columnName을 인자로 받아오기 
				// dao에서는 관례적으로 snakecase 사용함 
				board.setId(rs.getInt("id"));
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
//				board.setRegDate(rs.getString("reg_date"));
				
				list.add(board);
				
			} // 내용 채우기 > list에 모든 데이터 저장됨 
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try 끝나고 finally에서 util 닫기 
		finally {
			util.close(rs, stmt, conn);
		}
		return list;
	}

	// id(PK)통해 게시글 1개 조회 
	@Override
	public Board selectOne(int id) {
		Board board = null;
		Connection conn  = null;
		// preparedstatement 사용해보기 
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		// 조건 1개면 이렇게 써도 되는데 조건 옴총 많으면??
//		String sql = "SELECT * FROM Board WHERE id =" + id;
		// ?는 빈칸임 (물음표 채워넣기)
		String sql = "SELECT * FROM Board WHERE id=?";
		
		try {
			conn = util.getConnection();
			// stmt는 완성된 sql문 담을 수 있는거고, 
			// pstmt는 물음표로 빵꾸 뚫린 sql문 담아둔 것 
			pstmt = conn.prepareStatement(sql);
			// 물음표에 값 채우기(idx, int)
			// mySQL idx는 1부터 시작 > 1번째 물음표에 대한 답 
			pstmt.setInt(1, id);
			// sql 완성 
			
			// 완성된 sql 날리기
			rs = pstmt.executeQuery();
			
			board = new Board();
			// 데이터 끝날 때까지 
			if(rs.next()) {
				// column idx로도 사용 가능 > 1번째 col 내용을 가져와 'id'에 기록하겠다 
				board.setId(rs.getInt(1));
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setViewCnt(rs.getInt(5));
				
			} else return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try 끝나고 자동 닫기
		finally {
			util.close(rs, pstmt, conn);
		}
		
		return board;
	}

	// update 실행 후에는 '개수' 반환 될 거니까 
	// Board 내용 DB에 업데이트하기 
	@Override
	public void insertBoard(Board board) {
		Connection conn  = null;
		PreparedStatement pstmt = null;
		
		// 게시글 등록용 sql - 안 써도 되는 건 안쓰고 필요한거만 적기 
//		String sql = "INSERT INTO board (title, writer, content) VALUES(...)";
		
		// stringbuilder 이용하면 작성이 좀 더 편해질꺼야 
		// pstmt는 ? 빵꾸 뚫어서 사용 가ㅡㄴㅇ 
		String sql = "INSERT INTO board (title, writer, content) VALUES(?, ?, ?)";
		try {
			// conn 가져올 때 default : autocommit. 
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			// pstmt 준비했으니 물음표 채우기
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			// SQL문 완성됨!
			// table 자체를 업데이트하는거니까 Update ㄱㄱ
			
			// 리턴타입 int 있음
			int result = pstmt.executeUpdate();
			System.out.println(result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			util.close(pstmt, conn);
		}
		
	}

	@Override
	public void deleteBoard(int id) {
		Connection conn  = null;
		PreparedStatement pstmt = null;
		
		// 이번엔 sb 써보기 
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM board WHERE id=");
//		sb.append(id);
		String sql = "DELETE FROM board WHERE id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			util.close(conn, pstmt);
		}
	}

	@Override
	public void updateBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
