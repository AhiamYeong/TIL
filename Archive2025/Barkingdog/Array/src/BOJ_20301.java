import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_20301 {
	public static void main(String[] args) {
		// M명 제거될 때마다 제거할 방향 돌리기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // N명
		int K = sc.nextInt(); // 제거할 순서
		int M = sc.nextInt(); // M명 제거시마다 순서 돌리기
		
		ArrayList<Integer> arr = new ArrayList<>();
		// 1-based index 
		for (int i = 1; i <= N; i++) {
			arr.add(i); //사람 수 추가 
		}
		// 처음 지울 idx: K - 1
		int idx = K-1;
		
		
		// 사람 수 0 될 때까지 지우기 
		while(arr.size() != 0) {
			System.out.println(arr.get(idx));
			arr.remove(idx);
			
			System.out.println(arr);
			idx = (idx + K-1) % arr.size();
			
			
		} //제거 
		
		sc.close();
	}
}
