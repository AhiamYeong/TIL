package di1_의존성개념;

public class Programmer {
	
	// 1. 객체 생성 의존성
	
	// 2. 
	
	private String name;
	private int age;
	
	// 프로그래머는 PC가 필요햐ㅐㅐ
	private Desktop computer;
	
	public Programmer() {
		// 컴터 하나 사주자
		this.computer = new Desktop();
		// desktop 안에서 
	}
	
	public void coding() {
		System.out.println(computer.getInfo() +"으로 코딩 고고");
	}
}
