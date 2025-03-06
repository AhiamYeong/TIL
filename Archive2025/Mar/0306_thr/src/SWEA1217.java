import java.util.Scanner;

public class SWEA1217 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();
			// N의 M 거듭제곱 구하기
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			// 재귀호출 이용해 구하기
			int res = pow(N, M);
			System.out.println("#" + tc + " " + res);
		} // tc
		
		sc.close();
	}
	
	// n의 m제곱 구하기 - divide&conquer -> N 짝/홀수일 때 나누어 구하기
	public static int pow (int N, int M) {
		if (M == 1) return N;
		// 짝수일 때
		if (M % 2 == 0) {
			// 지수는 반으로 자르기
			int tmp = pow(N, M/2);
			// 중복 계산 방지 위함 
			return tmp * tmp;
		}
		// 홀수일 때
		else {
			// 홀수 지수 = 짝수 + 추가 1번 더 곱할 C
			// 홀수 지수는 짝수 (2로 나눠서 반으로 자르기) * 1개니까 
			int tmp = pow(N, (M-1)/2);
			return tmp * tmp * N;
		}
	}
}
