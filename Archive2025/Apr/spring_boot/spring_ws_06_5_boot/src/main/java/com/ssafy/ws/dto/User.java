package com.ssafy.ws.dto;

import java.sql.Date;

public class User {
	private int userSeq;
	private String id;
	private String password;
	private String name;
	private String nickname;
	private String email;
	private int userRank;
	private Date joinedAt;
	
	
	public User(String id, String password, String name, String nickname, String email, int userRank,
			Date joinedAt) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.userRank = userRank; // 뭐지 ? 
	}
	
	
}
