// 2. 타입 의존성 = laptop: 또 프로그래머는 노트북으로만 코딩할 수 있네?:?
package di3_타입의존성제거;

public class Programmer {
	
	private String name;
	private int age;
	
	// 프로그래머는 PC가 필요햐ㅐㅐ
	// 프로그래머에 laptop & desktop 묶어버리면 '강한 결합' -> '느슨한 결합'으로 바꿀 필요 ㅇ 
	// 1. 상속 객체 만들기 or 인터페이스 만들기 
//	private Laptop laptop;
	private Computer computer;
	
	// 객체 생성 의존성 제거 
	// 돌아다니는 pc 있으면 프로그래머에게 갖고오라하기 
	public Programmer( Computer computer) {
		this.computer = computer;
	}
	
	// desktop 안에서 
	public Programmer() {
		this.computer = new Laptop();
	}
	
	public void coding() {
		System.out.println(computer.getInfo() +"으로 코딩 고고");
	}
}
