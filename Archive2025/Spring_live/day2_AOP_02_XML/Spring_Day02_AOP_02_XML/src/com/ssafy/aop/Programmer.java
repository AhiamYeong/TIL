package com.ssafy.aop;

import java.util.Random;

public class Programmer implements Person {
	// 필드는 과감하게 생략!

	// 프로그래머 일상
	public int coding() throws OuchException {
		System.out.println("열심히 코드를 작성한다."); // 핵심관심사항

		if (new Random().nextBoolean())
			throw new OuchException();

		return (int) (Math.random() * 10) + 1; // 시간 반환
	}
}
