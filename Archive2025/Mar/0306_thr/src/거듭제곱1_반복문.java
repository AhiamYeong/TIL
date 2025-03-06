
public class 거듭제곱1_반복문 {
	public static void main(String[] args) {
		// 
	}
	
	// C: 밑, N: 지수
	// 벗뜨 단점 / 음수승은 구하기 어려움 
	static int pow(int C, int N) {
		int result = 1;
		for (int i = 0; i < N; i++) {
			result *= C; // C를 N번 제곱해서 구하기
		}
		
		return result;
	}
	
	// 재귀호출 방식 
	static int pow2(int C, int N) {
		if (N == 1) return C;
		return C * pow2(C, N-1); 
	}
}
