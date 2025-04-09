package com.ssafy.proxy2;

import java.util.Random;

public class PersonProxy implements Person {

	// proxy 객체에 주입할 인간 
	private Person person; 
	
	// 설정자 주입
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public void coding() {
		System.out.println("컴퓨터를 부팅한다"); // 이전에 수행해야 할 기능 
		
		try {
//			System.out.println("열심히 코드를 작성한다");
			// 핵심 관심사항 !! 
			// 경우에 따라 공부할 수도/코드 짤 수도 => 동적바인딩.
			// 상위의 메소드를 수행시켰는데, 상속받은 구현체의 메소드가 동작한다면 ?!
			person.coding();
		
			// 강제 예외 발생
			if (new Random().nextBoolean()) throw new OuchException();
			System.out.println("커밋한다"); // 정상종료시
			
		} catch (OuchException e) {
			e.handleException();
			System.out.println("반차를 낸다");
			System.out.println("커밋 해달라고 한다");
		} finally {
			System.out.println("침대와 한 몸이 된다");
		}
	}
	
}
