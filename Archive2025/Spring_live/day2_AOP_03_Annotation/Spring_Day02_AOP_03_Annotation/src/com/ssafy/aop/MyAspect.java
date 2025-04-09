package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//공통 관심사항을 저장할 클래스 (단위)
@Component
@Aspect
public class MyAspect {

	//포인트컷 -> 여러개의 Join Point 들 중 내가 들어갈 곳을 결정하는 문장
	@Pointcut("execution(* com.ssafy.aop.*.coding())")
	public void mypt() {
		//메서드 내용은 작성하지 않는다.
		//메서드 명 -> id가 된다.
	}
	
//	@Before("mypt()")
	public void before() {
		System.out.println("컴퓨터를 부팅한다 / 커피 한잔 한다.");
	}

//	@AfterReturning(value="mypt()", returning = "num")
	public void afterReturning(int num) {
		System.out.println("Git Commit 한다. " + num + " 시간을 투자한");
	}

//	@AfterThrowing(value="mypt()", throwing = "th")
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}

//	@After("mypt()")
	public void after() {
		System.out.println("침대와 한몸이 된다.");
	}

	/////////////////////////////////////
	@Around("mypt()")
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
