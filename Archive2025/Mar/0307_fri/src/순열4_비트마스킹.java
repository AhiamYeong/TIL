import java.util.Arrays;

public class 순열4_비트마스킹 {
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
	static void perm(int idx) {
		// 기저 조건 - N (모든 경우의 수) 도달하면
		// 원본 배열 손대지 않는 방법. 
		if (idx == N) {
			System.out.println(Arrays.toString(result));
			return;
		}
		
		// 재귀 조건
		for (int i = idx; i < N; i++) {
			// 사용하지 않은 원소를 사용해야 함 
			// 1 사용했으면 쳐내기
			// 이미 사용했다면 넘기기
			if (visited[i]) continue; 
			// 2 사용 안했으면 해
			if (!visited[i]) {
				result[idx] = nums[i];
				visited[i] = true;
				perm(idx + 1);
				// 재귀 끝난 후는 다음 차례 위해 원상복구해야 함
				// 원상복구~~ 
//				result[idx] = 0; > 다음 반복 돌며 덮어씌워짐 .. 굳이? 불필요  
				visited[i] = false; 
			}
		}
	}
	
}
