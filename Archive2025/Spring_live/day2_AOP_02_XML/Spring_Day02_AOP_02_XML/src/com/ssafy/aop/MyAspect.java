package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

//공통 관심사항을 저장할 클래스 (단위)
public class MyAspect {

	// 메서드명은 크게 관계 업음 -> 직관적으로 보여주려고...
	public void before() {
		System.out.println("컴퓨터를 부팅한다 / 커피 한잔 한다.");
	}

	public void afterReturning(int num) {
		System.out.println("Git Commit 한다. " + num + " 시간을 투자한");
	}

	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

	public void after() {
		System.out.println("침대와 한몸이 된다.");
	}

	/////////////////////////////////////
	public void around(ProceedingJoinPoint pjt) {
//		System.out.println("컴퓨터를 부팅한다 / 커피 한잔 한다.");
		Integer num = 0;
		this.before();
		try {
			num = (Integer) pjt.proceed(); // 핵심관심사항 동작함
			this.afterReturning(num);
		} catch (Throwable e) {
			this.afterThrowing(e);
		} finally {
			this.after();
		}
	}

}
