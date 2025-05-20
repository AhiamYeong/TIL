package com.ssafy.back.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.back.jwt.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//	요청 가로채기
@Component
public class JWTInterceptor implements HandlerInterceptor{
	
	private final String HEADER_AUTH = "access-token"; 
	
	@Autowired
	private JwtUtil jwtUtil; 
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		// 클라이언트가 서버에게 요청 보내려 했을 때 사전요청 한 번 보냄
		// 사전요청은 그냥 통과 (클라가 요청 수락 가능상태인지 확인)
		if (request.getMethod().equals("OPTIONS")) {
			return true; 
		}
		// jwt header 안에서 'access-token' 값 훔쳐오기
		String token = request.getHeader(HEADER_AUTH); 
		
		if (token != null) {
			jwtUtil.vaildate(token);
			return true;
		} 
		
		throw new Exception("유효X 접근");
		
	}
}
