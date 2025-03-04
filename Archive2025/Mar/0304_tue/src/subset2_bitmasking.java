
public class subset2_bitmasking {

	static String[] 재료 = {"단무지", "햄", "오이", "계란"};
	static int N = 4; // 김밥 재료 개수
	
	public static void main(String[] args) {
//		for (int i = 0; i < Math.pow(2, N); i++) {
		// bit-shift 연산 이용 // 이진법으로 생각했을 때 한 칸씩 올린거니깡 
		for (int i = 0; i < (1 << N); i++) {
			System.out.print("김밥: ");
			
			// 무슨 김밥? 재료 개수만큼만 돌아보기 
			for (int j = 0; j < N; j++) {
				// & bit연산 수행 ???
				// i라는 김밥을 가지고 검사하는데
				// 재료 하나씩 shift 하며 검사 > 1이냐로 체크하면 안댐 
				// 1을 j번 shift 연산 -> (i & (1 << j)) but bit연산 int 리턴됨 
				// (i & (1 << j) != 0) 으로 검사해야 boolean 값 나오게 됨
				
				if ((i & (1 << j)) != 0) {
					// 코드 실행이 된다면]
					System.out.print(재료[j]);
				}
			} // 재료 확인 
			System.out.println();
		} // 모든 김밥 경우의 수 
	}
}
