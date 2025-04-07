package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		
		// 설정 파일에 대한 경로 저ㅏㄱ성 
		// resources는 src랑 동급 위치니깡 
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		// 객체 가져오기
		Desktop desktop = (Desktop) context.getBean("desktop"); 
		Desktop desktop2 = (Desktop) context.getBean("desktop"); 
		Programmer p = context.getBean("programmer", Programmer.class);
		p.setComputer(desktop);
		p.coding();
		
		// 같은데: bean의 scope는 기본적으로[ 싱글턴임!
		// scope 정의에서 작성할 수 있음
		System.out.println(desktop == desktop2);
		System.out.println(desktop);
		System.out.println(desktop2);
	}
}
