package com.ssafy.mvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.dto.SearchCondition;
import com.ssafy.mvc.model.service.BoardService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


// api naming convention 
@RestController
@RequestMapping("/api")
public class BoardRestController {
	
	// 서비스 의존성 주입 > 생성자 주입 
	private final BoardService boardService;

	public BoardRestController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	// 게시글 전체 조회 
	@GetMapping("/board")
	public ResponseEntity<?> list() {
		List<Board> list = boardService.getBoardList();
		// list 내용 채우기 / 
		
		if (list == null || list.size() == 0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return ResponseEntity.ok(list);
	}
	
	// 게시글 상세보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable("id") int id){
		Board board = boardService.readBoard(id);
		if (board != null) {
			return ResponseEntity.ok(board);
		}
		// board가 null?: 사용자가 url에 직접 입력해서 들어온 경우.  
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	// 검색 search 냅다 넣는 건 곤란~~
	// 근데 board넣으면 겹치자나ㅈ
	// <?>는 '지금 못 결정하겠어 나중에 정할래' 
	// 메소드 오버로딩 
	@GetMapping("/board")
	public ResponseEntity<?> list(@ModelAttribute SearchCondition condition) {

		List<Board> list = boardService.search(condition);
		
		return ResponseEntity.ok(list); 
	}
	
	// 게시글 등록(form data)
	// 1 등록 후 메인/리스트 돌아가기 OR 2 등록 후 상세글로 넘어가기 
	// id 결정 시점은 mapper <> DB 소통 중, DB에 결정되는 순간에.
	// 이 때 결정되는 id를 들고 나와서 사용할 수 있는지? 
	@PostMapping("/board")
	public ResponseEntity<Void> write(@ModelAttribute Board board) {
		System.out.println(board);
		boardService.writeBoard(board);
		System.out.println(board);
		
		// id는 알게됐어 > 어떻게 넘기지 
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	// 게시글 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		
		boolean isdeleted = boardService.removeBoard(id);
		if (isdeleted) return ResponseEntity.status(HttpStatus.OK).body("board deleted");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed");
	}
	
	// 게시글 수정
	@PutMapping("/board/{id}")
	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Board board) {
		// board가 있을수도 / 없을수도 있다?
		board.setId(id);
		boardService.modifyBoard(board);
		
		// 지금은 아주 씸플하게 ok를 넘겼지만... 
		
		// 1. 존재하지 않는 게시글에 대한 수정 요청
		// 2. 요청 본문(@RequestBody)에 필수 데이터 누락
		// 3. DB 수정 실패 시 예외 처리 부족
		// 4. 응답 메시지가 없음
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
