package com.ssafy.proxy2;

// 1. 런타임 계열 예외 처리 vs 일반 예외 처리(checkedexception)
public class OuchException extends Exception {
	public void handleException() {
		System.out.println("병원 가자");
	}
}
