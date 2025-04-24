package com.ssafy.ws.dto;

import java.sql.Date;

public class Article {
	private int id;
	private String title;
	private String content;
	private int boardId;
	private int userSeq;
	private int viewCnt;
	private int left;
	private int right;
	private int depth;
	private Date createdAt;
	private Date modifiedAt;
	
	public Article(String title, String content) {
		
		this.title = title;
		this.content = content;
	}
}
