package com.ssafy.mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.dto.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// 2가지 데이터 바인딩 방식 비교 예제

// @ModelAttribute: binding 대상이 form data
// html form에서 application/x-www-form-urlencoded 방식으로 제출했을 때. 

// @RequestBody: binding 대상이 JSON data (request body)
// 클라이언트가 JSON 데이터를 전송할 때: http body 전체를 읽어서 jackson 라이브러리로 json -> user 객체로 변환

@RestController
@RequestMapping("/rest5")
public class RestController5 {
	
	// ModelAttribute: form data binding용 (특히나 POST!)
	// user.toString으로 문자열 반환하거나 
	@PostMapping("/board1")
	public String test1(@ModelAttribute User user) {
		//입력 받은 데이터를 활용하여 서비스호출 등록
		return user.toString();
	}
//	@PostMapping("/board1")
//	public User test1(@ModelAttribute User user) {
//		//입력 받은 데이터를 활용하여 서비스호출 등록
//		return user;
//	}
	
	
	@PostMapping("/board2")
	public String test2(@RequestBody User user) {
		return user.toString();
	}
	
//	@PostMapping("/board2")
//	public ResponseEntity<T> test2(@RequestBody User user) {
//		return user.toString();
//	}
	
}
