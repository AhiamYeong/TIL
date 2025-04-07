// 1. 객체 생성 의존성 제거
package di2_객체생성의존성제거;

public class Programmer {
	
	private String name;
	private int age;
	
	// 프로그래머는 PC가 필요햐ㅐㅐ
	private Desktop desktop;
	
	// 객체 생성 의존성 제거 
	// 돌아다니는 pc 있으면 프로그래머에게 갖고오라하기 
	public Programmer(Desktop desktop) {
		this.desktop = desktop;
	}
	
	// desktop 안에서 
	public Programmer() {
		this.desktop = new Desktop();
	}
	
	public void coding() {
		System.out.println(desktop.getInfo() +"으로 코딩 고고");
	}
}
