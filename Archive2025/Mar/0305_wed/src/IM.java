import java.util.*;

public class IM {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // 선수
			int K = sc.nextInt(); // 실력 차이
			// 선수 집합 (실력)
			int [] arr = new int [N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = 0;
			Arrays.sort(arr);
			
			// 최대 실력부터 한 명씩 전부 비교 
			for (int i = N-1; i >= 0; i--) {
				int sum = 1; // 본인 포함 
				for (int j = i-1; j >= 0; j--) {
					// 실력차이가 K보다 크면 끝 
					if (arr[i] - arr[j] > K) {
						break;
					}
					sum++;
				}
				if (sum > max) max = sum;
			}
			
			System.out.println("#" + tc + " " + max);
		} // tc
		sc.close();
	}
}
