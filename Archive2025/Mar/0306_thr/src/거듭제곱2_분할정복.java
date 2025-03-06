
public class 거듭제곱2_분할정복 {
	public static void main(String[] args) {
		System.out.println(pow2(2, 3));
	}
	
	static int pow(int C, int N) {
		// 기저조건
		if (N == 1) return C;
		// 재귀부분 -> '절반'으로 나누기 
		//1 홀수일 때
		if (N % 2 == 1) {
			return pow(C, (N-1)/2) * pow(C, (N-1)/2) * C;
		}
		// 2 짝수일 때 
		else {
			return pow(C, N/2) * pow(C, N/2);
		}
		
		// 분할하고, 중복되는 호출은 피해줘야 함
	}
	
	static int pow2(int C, int N) {
		// 기저조건
		if (N == 1) return C;
		// 재귀부분 -> '절반'으로 나누기 
		//1 홀수일 때
		if (N % 2 == 1) {
			int tmp = pow2(C, (N-1)/2);
			return tmp * tmp * C;
		}
		// 2 짝수일 때 
		else {
			
			int tmp = pow2(C, (N-1)/2);
			return tmp * tmp;
		}
		
		// 분할하고, 중복되는 호출은 피해줘야 함
	}
}
