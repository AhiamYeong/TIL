import java.util.Arrays;

public class PermutationAndCombination {
	
	public static int[] arr;
	public static int[] sel;
	public static boolean[] visited;
	public static int N, R;
	// N: 전체 수, R: tmp 배열의 수 (출력 원하는 수) 
	
	public static void main(String[] args) {
		R = 3; 
		N = 4; 
		arr = new int[] {1, 3, 5, 7};
		sel = new int[R];
		visited = new boolean[N]; // 순열 사용여부 확인 배
		// N개 중 R개 만들어내기 
		// 순열: N개 중 R개 순서 고려O 뽑기 
		// {1, 2} != {2, 1}
		System.out.println("순열");
		permute(0);
		
		// 조합: N개 중 R개 순서 고려X 뽑기
		// {1, 2} == {2, 1}
		System.out.println("조합");
		combine(0, 0);
	} // main
	
	public static void permute(int sidx) {
		// 종료 조건
		// 1 sel 배열이 완성되면 종료 
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		// 재귀 조건 
		// 순서 고려해야 하니 1회차 돌며 체크
		// 회차 다 돌면 다시 리셋
		for (int i = 0; i < N; i++) {
			// 사용되지 않은 원소 처리하며 보기
			if(!visited[i]) {
				visited[i] = true; // 사용 처리
				sel[sidx] = arr[i]; // 현재 위치에 arr[i] 대입
				// 다음 자리 채우기 
				permute(sidx + 1); 
				visited[i] = false; // 방문 상태 초기화 
			}
		}
		
		
		
	} // permute
	
	public static void combine(int idx, int sidx) {
		
		// 종료조건
		// 1 sel 배열이 완성되면 종료 (돌아가기) 
		if (sidx == R) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		// 2 원본 배열 전부 확인한 경우도 종료 
		if (idx == N) return; 
		
		// 재귀 조건
		// 1 idx번째 원소 선택 
		sel[sidx] = arr[idx]; 
		// 다음 원소 고려 & sel 다음 위치로 
		combine(idx+1, sidx+1); 
		
		// 2 idx번째 원소 선택X
		// 현재 원소 건너뛰기 & sel 위치는 그대로
		combine(idx+1, sidx);  
		
	} // combine 
}
