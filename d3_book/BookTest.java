

/**
 * 도서 객체를 생성하고 정보를 출력하는 클래스
 */
public class BookTest {
	public static void main(String[] args) {
		
		Book b1 = new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법");
		Book b2 = new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링");
		// 4. 객체 생성해 정보 출력 
		System.out.println("*******도서목록********");
		System.out.println(b1.toString());
		System.out.println(b2.toString());

		
		
	}
}
