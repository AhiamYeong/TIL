/* 게시판 CRUD: 자유게시판, 공지사항 등 */

package com.ssafy.ws.dao;

import java.util.List;

import com.ssafy.ws.dto.Article;

public interface BoardDao {
	// C: 게시판 새로 생성하기
	public abstract void createBoard();
	
	// R: 이름 기반 게시판 들어가서 name id와 일치하는 article 반환 
	public abstract List<Article> readBoard(String name);
	
	// U: 이름 기반 게시판 수정하기 (name, description 수정) 
	public abstract void updateBoard(String name);
	
	// D: 이름 기반 게시판 삭제하기
	public abstract void deleteBoard(String name); 
	
}

