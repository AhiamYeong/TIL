import java.util.Arrays;
import java.util.Scanner;

public class BOJ_24051 {
	public static int insertionSort(int[] arr, int K) {
		// A1-N을 오름차순 정렬
		int N = arr.length;
		int cnt = 0;
		for (int i = 1; i < N; i++) {
			int loc = i - 1; // 정렬할 원소의 바로 전 자리 
			int newItem = arr[i]; // 정렬할 원소 
			
			// 0번부터 바로 전 자리까지 & 오름차순으로 정
			while (0 <= loc && newItem < arr[loc]) {
				arr[loc + 1] = arr[loc];
				loc--;
				cnt++;
				if (cnt == K) return arr[loc+1];

			}
			// key값 저장 
			if (loc + 1 != i) {
				arr[loc+1] = newItem;
				cnt++;
				if (cnt == K) return arr[loc+1];
			}
			
		}
		return -1; // 기본이 -1
		
	} // 삽입정렬 
	
	public static void main(String[] args) {
		// 삽입 정렬
		Scanner sc = new Scanner(System.in);
		int cnt = 0;
		// 배열 A의 크기
		int N = sc.nextInt(); 
		// 저장 횟수
		int K = sc.nextInt();
		int[] arr = new int[N];
		// input
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		cnt = insertionSort(arr, K);
		
		System.out.println(cnt);
		sc.close();
	}
}
