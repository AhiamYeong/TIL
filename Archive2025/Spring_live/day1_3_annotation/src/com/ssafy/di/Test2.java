package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		
		// 설정 파일에 대한 경로 저ㅏㄱ성 
		// resources는 src랑 동급 위치니깡 
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");
		// 객체 가져오기
		Programmer p = context.getBean("programmer", Programmer.class);
		p.coding();
	}
}
