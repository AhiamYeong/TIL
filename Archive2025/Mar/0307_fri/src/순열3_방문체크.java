import java.util.Arrays;

public class 순열3_방문체크 {
	static int[] nums;
	static int N;
	static int[] result; // 결과 담기
	static boolean[] visited; // 방문 쳌
	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		result = new int[N];
		visited = new boolean[N];
		
//		perm(0);
		
	}
	
	// idx: 현재 판단 위치 
	static void perm(int idx, int visited) {
		// 기저 조건 - N (모든 경우의 수) 도달하면
		// 원본 배열 손대지 않는 방법. 
//		if (visited == (1 << N) | 1)
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 재귀 조건
		for (int j = idx; j < N; j++) {
			// visited[i] = true; 로 판단했었음 > 김밥말 때 했던거
			// j번째 재료가 있는가 // bit shift 통해 검사 
			// 사용했으면 하지않기
			if((visited & (1 << j)) != 0) {
				continue;
			}
			result[idx] = nums[j];
			perm(idx+1, visited | (1 << j));
			
			// 원상복구
		}
	}
	
}
