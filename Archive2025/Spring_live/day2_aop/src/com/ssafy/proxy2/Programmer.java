package com.ssafy.proxy2;

import java.util.Random;

public class Programmer implements Person {
	// 부가기능은 전부 proxy에 빼 버리고, 여기서는 '핵심기능'만 구현하면 됨 ! 
	public void coding() {
		System.out.println("열심히 공부를 한다");
	}
}
