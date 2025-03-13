import java.util.*;

/* 5지선다 * 10문제
 * 1, 2의 답을 1로 찍음 > 3은 1 아님 
 * 5개 이상 맞을 경우 <>  
 * 완탐 + 백트래킹으로 구해야 할 것 같은뎅
 * 경우 전부 못 셈 -> 재귀를 믿자
 * 
 * */
public class BOJ19949 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정답 배열 
		int[] result = new int[10];
		for (int i = 0; i < 10; i++) {
			result[i] = sc.nextInt();
		}
		
		// 합이 5 이상일 경우의 수 
		sc.close();
	}
	
	// 재귀로 어떻게 구현하면 조을까???
	// 일단 완탐으로 정답 나올 수 있는 경우의 수 찾기
	// 총 경우의 수는 ... 못 구하겠당 
	// 완탐: 1-5중 10개 선택하기 (순서 고려) -> 중복순열?
	// 중복순열 중 2개 연속으로 수 나오면 break
	// 
}
