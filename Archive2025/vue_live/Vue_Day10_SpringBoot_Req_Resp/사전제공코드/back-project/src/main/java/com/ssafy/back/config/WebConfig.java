package com.ssafy.back.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.back.interceptor.JWTInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private JWTInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(interceptor).addPathPatterns("/**")
		.excludePathPatterns("/api-user/**", "/swagger-ui/**", "/v3/api-docs/**"); 
		// api-user에서의 요청 제외 전부 인터셉터 걸기
		// 놀랍게도 swagger에서도 요청 제외 처리할 수 있다! 
	}
}

