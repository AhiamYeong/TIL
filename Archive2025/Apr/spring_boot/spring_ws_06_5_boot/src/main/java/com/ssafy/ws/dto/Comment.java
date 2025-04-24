package com.ssafy.ws.dto;

import java.sql.Date;

public class Comment {
	private int Id;
	private String content;
	private int userSeq;
	private int articleId;
	private int boardId;
	private int left;
	private int right;
	private int depth;
	private Date createdAt;
	
	public Comment(String content) {
		this.content = content;
	}
}
