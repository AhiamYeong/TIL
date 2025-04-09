package com.ssafy.proxy2;

public class test {
	public static void main(String[] args) {
		Programmer p = new Programmer();  // component 직접 등록 / 컨테이너가 bean으로 관리해줌 '/
		PersonProxy px = new PersonProxy(); // spring aop가 알잘딱 만들어줌 
		px.setPerson(p);
		
		px.coding();
	}
}
