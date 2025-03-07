
public class 순열1_반복문 {
	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3};
		// 나열했을 때 나오는 경우의 수 6개.
		int N = nums.length;
		
		// 반복문 이용 - 반복문은 원소 수만큼 중첩 필요
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// 조건문 - 갑자기?
				// i랑 j가 다를때만 생성 > 이미 쓴 원소는 또 못 쓰니까
				if (i != j) {
					for (int k = 0; k < N; k++) {
						if (i != k && j != k) {
							System.out.printf("%d %d %d\n", nums[i], nums[j], nums[k]);
						}
					} // [2]
				}
			} //[1]
		} // [0]
	}
}
