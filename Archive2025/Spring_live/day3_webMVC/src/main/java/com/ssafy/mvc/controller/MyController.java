package com.ssafy.mvc.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller //서울10반 최진혁 -> 무조건 깊콘
public class MyController {
	
	//작성한 해당 경로로 메서드(GET,POST) 관계없이 들어오게 된다.
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView homHandle1() {
		//바구니 이자, 페이지 정보를 저장하는 객체
		ModelAndView mav = new ModelAndView();
		
		//데이터 담자
		mav.addObject("msg", "Welcome to Spring MVC (GET)");
		
		mav.setViewName("home");
		
		return mav;
	}
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public ModelAndView homHandle2() {
		//바구니 이자, 페이지 정보를 저장하는 객체
		ModelAndView mav = new ModelAndView();
		
		//데이터 담자
		mav.addObject("msg", "Welcome to Spring MVC (POST)");
		
		mav.setViewName("home");
		
		return mav;
	}
	
	
	
	
}
