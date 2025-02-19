import java.util.LinkedList;
import java.util.Scanner;

public class SWEA1966 {
	public static void main(String[] args) {
		// 삽입 정렬로 구현
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N개 입력받기
			// linkedlist 배웠으니까 같이 써보자
			
			LinkedList<Integer> list = new LinkedList<>(); // list
			// 입력받기
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			
			// 선택정렬 -> 정렬집합 / 미정렬집합과 비교
			// i는 정렬한 인덱스
			for (int i = 0; i < N; i++) {
				// i - 0번째 idx 정렬되어있다고 가정
				for (int j = i+1; j < N; j++) {
					
				}
			}
			
			
		} // tc
		sc.close();
	}
}
