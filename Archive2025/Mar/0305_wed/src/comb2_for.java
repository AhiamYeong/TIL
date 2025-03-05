
// 조합 구현 - 반복문
public class comb2_for {
	public static void main(String[] args) {
		int[] arr = {0, 1, 2, 3, 4};
		// 반복문 이용시에는 R개가 고정적으로 사용되면 좋음
		int N = arr.length;
		int R = 3; // fix시켜놓기
		
		for (int i = 0; i < N-2; i++) {
			for (int j = i+1; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					System.out.println(arr[i] + " " + arr[j] + " " + arr[k]);
				}
			}
		}
	}
}
