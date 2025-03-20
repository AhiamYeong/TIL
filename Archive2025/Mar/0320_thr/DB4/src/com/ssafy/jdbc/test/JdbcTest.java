package com.ssafy.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

public class JdbcTest {
	
	public JdbcTest() {
		// 클래스 드라이버 로드 (풀패키지명 작성 필요)
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// jar 파일 내 해당 경로에 'Driver.class' 사용하겠다는 말 
			System.out.println("드라이버 로딩 성공 ");
		} catch (ClassNotFoundException e) {
			System.out.println("loading failed");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// step1 생성자 호출 > 드라이버 호출 
		JdbcTest db = new JdbcTest();
		
		// step2 db 연결 
		
		// 반환받은 거 쓰기
		for (Board board : db.selectAll()) {
			System.out.println(board);
		}
	}
	
	// step2 전체 게시글 조회 메소드
	private List<Board> selectAll(){
		List<Board> list  = new ArrayList<>();
		
		try {			
			// 로딩해둔 드라이버에서 DB와의 연결 통로 뚫기
			// db안에 ssafyboard 등록한 후 연결하기 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC", "ssafy", "ssafy1234");
			
			// step3 질의 
			// statements 객체 추가 
			Statement stmt = conn.createStatement();
			
			// SQL문 준비!
			String sql = "SELECT * FROM board";
			
			// 구문 날리고 결과값 반환받기 
			ResultSet rs = stmt.executeQuery(sql);
			
			// 데이터 몇 개인지 알아? 몰라 > 데이터 있을 때까지
			while(rs.next()) {
				Board board = new Board(); // 바구니 세팅
				
				// board DB에서 columnName을 인자로 받아오기 
				board.setId(rs.getInt("id"));
				board.setWriter(rs.getString("writer"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
//				board.setRegDate(rs.getString("reg_date"));
				// 이거 타입 머임
				// ... 다 채우면
				
				list.add(board);
				
			} // 내용 채우기 > list에 모든 데이터 저장됨 
			
			// 역순으로 닫기
			rs.close();
			stmt.close();
			conn.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
