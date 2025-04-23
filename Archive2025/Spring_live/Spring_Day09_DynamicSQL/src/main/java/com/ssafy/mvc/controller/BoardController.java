package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.Board;


@Controller
public class BoardController {
	// 등록 페이지 주세염
	@GetMapping("/writeform")
	public String writeform() {
		return "board/writeform";
	}
	
	@PostMapping("/write")
	public String write(@ModelAttribute Board board) {
		
		return entity;
	}
	
	
}
