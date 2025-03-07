import java.util.*;

public class 햄버거_예시풀이 {
	static int N, L; // 재료수, 제한 칼로리 -> 2d arr로 입력받기 / 각 1d로 받기 선택 가능
	static int[] cals; // 칼로뢰
	static int[] scores; // 재료 수
	static int ans; // 결과
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			// 이렇게 입력받는 건 처음보는 형탠디
			N = sc.nextInt();
			L = sc.nextInt();
			// 초기화
			scores = new int[N];
			cals = new int[N];
			
			for (int i = 0; i < N; i++) {
				scores[i] = sc.nextInt();
				cals[i] = sc.nextInt();
			}
			ans = 0;
			make(0, 0, 0);
			System.out.println(ans);
			
		} // tc
		sc.close();
	} // main
	
	// 1. bitmasking
	
	// 2. 재귀함수 부분집합
	
	// 3. backtracking
	// 어쩄든 재귀 -> 백트래킹 적용하면 유망성 검사 how? 
	// 제한 칼로리를 벗어나지 않는 선에서, 가장 맛이 좋은 조합 
	// 재료 넣었을 때 중간결과 (칼로리, 맛) 들고 다니면서 쳐내기
	static void make(int idx, int sumCal, int sumScore) {
		if (sumCal > L) return; // 정답X
		if (idx == N) {
			// 쳌 - 제한 칼로리 안 벗어나게 햄버거 만들었슴 
			if (ans < sumScore) ans = sumScore; //갱신
			return;
		}
		
		///////////// 요 아래까지는 그냥 완탐 /////////////
		
		// 뽑는 경우
		// 현재 값 누적시켜서 내려보내기
		make(idx+1, sumCal+cals[idx], sumScore+scores[idx]); // 다음껀 언제 봐?
		// 안 뽑는 경우 
		// 누적 없이 그냥 내려보내기 
		make(idx+1, sumCal, sumScore);
		
		
	}
	
	// 나중에 DP로도 풀어볼 수 있슴 
}
