package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.mvc.dto.User;


@Controller
public class RestController1 {
	
	// 기존에는 hello.jsp로 동작했엇는데 ...!~~ 그니까 hello라는 페이지를 찾으려 하는거지 
	// 이제는 client API로 확인할 수 있다는게 컨~~ 셉  
	// http://localhost:8080/rest1/test1
	// responsebody 없으니까 이슈발생~~
	@GetMapping("/rest1/test1")
	public String test1() {
		return "hello";
	}
	
	// @Responsebody: controller 메소드가 http 응답 본문 직접 반환하는 annotation
	// 기존 컨트롤러: viewresolver 통해 view 찾음 / 데이터 반환 위해서는 @responsebody 필요 
	// 스프링이 반환된 객체럴 json, xml 등 형식으로 반환해~~줌 
	// http://localhost:8080/rest1/test2
	@GetMapping("/rest1/test2")
	@ResponseBody
	public String test2() {
		return "hello";
	}
	
	// http://localhost:8080/rest1/test3
	// map 객체 -> json으로 변환되어 넘어온다~
	@GetMapping("/rest1/test3")
	@ResponseBody
	public Map<String, String> test3() {
		Map<String, String> data = new HashMap<>();
		data.put("id", "ssafy");
		data.put("password", "1234");
		return data;
	}
		
	// http://localhost:8080/rest1/test3
	// User 객체 단일 조회 -> json으로 변환되어 넘어온다~
	@GetMapping("/rest1/test4")
	@ResponseBody
	public User test4() {
		User user = new User("ssafy", "1234", "김싸피");
		return user;
	}
	
	// user 객체 멀티 조회 
	@GetMapping("/rest1/test5")
	@ResponseBody
	public List<User> test5() {
		List<User> list = new ArrayList<>();
		list.add(new User("ssafy1", "1234", "김싸피"));
		list.add(new User("ssafy2", "1234", "김싸피"));
		list.add(new User("ssafy3", "1234", "김싸피"));
		list.add(new User("ssafy4", "1234", "김싸피"));
		return list;
	}
}
