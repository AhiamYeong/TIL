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
			// i는 정렬 시작할 idx
			for (int i = 1; i < N; i++) {
				int j = i-1;
				int key = list.get(i); // 1번쨰 값부터 정렬
				// idx - 1부터 0까지 
				
				// 정렬하려는 값이 앞 값보다 작으면
				// 가장 작은 값 뒤에 삽입하기 위해 한 칸씩 밀기
				while (j >= 0 && key < list.get(j)) {
					list.set(j+1, list.get(j));
					j--;
				}
				// 가장 마지막 값에 key(정렬하고자 하는 값) 할당
				list.set(j+1, key);
			}
			System.out.print("#" + tc + " " );
			for (int i = 0; i < N; i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
			
		} // tc
		sc.close();
	}
}
