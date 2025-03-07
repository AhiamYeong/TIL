import java.util.Arrays;

public class 순열2_swap {
	static int[] nums;
	static int N;
	
	public static void main(String[] args) {
		nums = new int[] {0, 1, 2};
		N = nums.length;
		perm(0);
	}
	
	// idx: 현재 판단 위치 
	static void perm(int idx) {
		// 기저 조건 - N (모든 경우의 수) 도달하면 
		if (idx == N) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		
		// 재귀 조건 - idx 넘어가기 
		for (int i = idx; i < N; i++) {
			swap(i, idx);
			perm(idx+1);
			swap(i, idx); // 원상복구 
		}
	}
	
	// swap: 사전순은 X. 
	// [2, 0, 1]이 아니라 [2, 1, 0] 이 먼저 나오게 됨 
	// 추가적 메모리 공간은 불필요함 (원본 자체를 내부적으로 swap)
	// 원본 배열을 건드리기 때문에 결과적으로 사전순으로는 안 나오게 됨
	
	// a, b는 값이 아니라 idx.
	// 바꾸고 싶은 배열은 static하게 선언하기
	static void swap(int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
