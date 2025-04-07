package di3_타입의존성제거;

public class Test {
	public static void main(String[] args) {
		// programmer가 desktop에 대한 '의존성' 가진다 !
		// programmer 실행 -> desktop이 필요
		// 이러한 관계가 '의존성 관계'
		
		// 만약 desktop -> laptop으로 바뀐다면? 
		Laptop laptop = new Laptop(); 
		Desktop desktop = new Desktop();
		
		// programmer가 가지고 있던 desktop이라는 코드의 객체 생성 코드를 test에 모은 것.
		Programmer p = new Programmer(desktop);
		
		p.coding();
	}
}
