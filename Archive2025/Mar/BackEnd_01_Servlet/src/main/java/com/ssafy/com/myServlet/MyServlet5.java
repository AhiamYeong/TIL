package com.ssafy.com.myServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/MyServlet2")
public class MyServlet5 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; // 직렬화 처리
	
	// do XX 어쩌구 만들기?
	// get 요청이 날아왔을때 처리하겠다잉
	// request: 요청 객체, response: 응답 객체 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// text를 줄 건데 html로 해석해 
		response.setContentType("text/html;characterset=UTF-8");
		PrintWriter writer = response.getWriter();

//		Java 15 버전에 나온 Block String
		writer.write("""
		<html>
		  <head><title>Hello! SSAFY!</title></head>
		  <body>
		    <h1>Hello! Servlet!</h1>
		  </body>
		</html>
		""");
	}

}
