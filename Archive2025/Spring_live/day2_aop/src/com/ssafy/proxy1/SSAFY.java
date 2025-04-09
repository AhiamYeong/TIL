package com.ssafy.proxy1;

import java.util.Random;

// 싸피생과 프로그래머가 하는 일이 다르지 않을 때 
public class SSAFY {
	
	// 싸피생의 일상
	public void coding() {
		System.out.println("컴퓨터를 부팅한다"); // 이전에 수행해야 할 기능 
		
		try {
			System.out.println("열심히 코드를 작성한다");
		
			// 강제 예외 발생
			if (new Random().nextBoolean()) throw new OuchException();
			System.out.println("커밋한다"); // 정상종료시
			
		} catch (OuchException e) {
			e.handleException();
			System.out.println("조퇴한다");
			System.out.println("커밋 해달라고 한다");
		} finally {
			System.out.println("침대와 한 몸이 된다");
		}
		
		
		// 비정상종료일경우 
	}
}
