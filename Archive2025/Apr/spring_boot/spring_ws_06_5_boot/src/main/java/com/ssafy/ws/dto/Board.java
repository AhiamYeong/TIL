package com.ssafy.ws.dto;

import java.sql.Date;

// 자유게시판 & 공지사항 
public class Board {
	private int id;
	private String name;
	private String description;
	private Date createdAt;
	
	public Board(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
