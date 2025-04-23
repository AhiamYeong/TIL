package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.dto.User;

// Controller 아니고 restcontroller 인식시켜 주기
// 근데 맨 앞에 /rest2 가 붙었으면 좋겠다 일일히 쓰기 넘 귗낳다
@RestController
@RequestMapping("/rest2")
public class RestController4 {
	
	// responsebody 없어도, restcontroller에 붙여놨으니까 200 뜸~~
	@GetMapping("/test1")
	public String test1() {
		return "hello";
	}
	
	// @Responsebody: controller 메소드가 http 응답 본문 직접 반환하는 annotation
	// 기존 컨트롤러: viewresolver 통해 view 찾음 / 데이터 반환 위해서는 @responsebody 필요 
	// 스프링이 반환된 객체럴 json, xml 등 형식으로 반환해~~줌 
	// http://localhost:8080/test2
	@GetMapping("/test2")
	public String test2() {
		return "hello";
	}
	
	// http://localhost:8080/test3
	// map 객체 -> json으로 변환되어 넘어온다~
	@GetMapping("/test3")
	public Map<String, String> test3() {
		Map<String, String> data = new HashMap<>();
		data.put("id", "ssafy");
		data.put("password", "1234");
		return data;
	}
		
	// http://localhost:8080/test3
	// User 객체 단일 조회 -> json으로 변환되어 넘어온다~
	@GetMapping("/test4")
	public User test4() {
		User user = new User("ssafy", "1234", "김싸피");
		return user;
	}
	
	// user 객체 멀티 조회 
	@GetMapping("/test5")
	public List<User> test5() {
		List<User> list = new ArrayList<>();
		list.add(new User("ssafy1", "1234", "김싸피"));
		list.add(new User("ssafy2", "1234", "김싸피"));
		list.add(new User("ssafy3", "1234", "김싸피"));
		list.add(new User("ssafy4", "1234", "김싸피"));
		return list;
	}
}
