package com.ssafy.com.myServlet;
import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class MyServlet2 extends GenericServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // 객체직렬화 넣기 

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 요청과 응답만 신경쓰자 
	}
	
	// 통신 규약 중 http > 그럼 http서블릿 클래스를 써라잉 
}
