package di1_의존성개념;

public class Test {
	public static void main(String[] args) {
		// programmer가 desktop에 대한 '의존성' 가진다 !
		// programmer 실행 -> desktop이 필요
		// 이러한 관계가 '의존성 관계'
		
		// 만약 desktop -> laptop으로 바뀐다면? 
		
		Programmer p = new Programmer();
		
		p.coding();
	}
}
