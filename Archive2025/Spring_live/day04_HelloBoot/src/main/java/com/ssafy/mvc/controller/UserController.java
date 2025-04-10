package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	//정석코딩
	
//	의존성 주입 -> 필드 / 설정자 / 생성자 주입
//	@Autowired
//	private UserSrvice userService;
	
	
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}
	
//	@PostMapping("/login")
//	public String login(HttpServletRequest request) {
//		String id = request.getParameter("id");
//	}
	
//	@PostMapping("/login")
//	public String login(@RequestParam("id") String id, @RequestParam("pw")String pw) {
//		// model이라는 바구니로 DTO 정의해서 만들기 (DTO) & 객체 직렬화 
//	}
	
	//로그인 정보는 -> 세션에다가 저장해야겠다!
	@PostMapping("/login")
	// user만을 위한 model을 준비하겠다 ~~ (User DTO) & 직접 저장해서 보내줘야지 -> 로그인은 세션 정보에 저장행야지 
	public String login(@ModelAttribute User user, HttpSession session) {
		System.out.println(user);
//		userService.login(user); //정석
		// 로그인 되어있어~ 자체를 보여주려면 메인에서 id정도만 필요할듯? 결국 어떤 정보를 넘겨줄지 controller에서 저장하는거니까 
		session.setAttribute("loginUser", user.getId());
		
		// 로그인은 redirect가 안전함 - 정보 다시 넘어가면 안되기 땜몬에
		return "redirect:hello";
	}
	
	// 세션에 로그인 정보 저장되어 있으므로 
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//로그아웃을 하는 방법
		//1. 세션에서 해당 로그인 정보만 삭제
//		session.removeAttribute("loginUser");
		//2. 세션 자체를 초기화
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
