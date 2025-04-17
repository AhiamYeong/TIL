import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ1138 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 사람 수
		// 키가 1인 사람부터 차례대로
		// 큰 사람이 왼쪽에 몇 명이나 있었나?
		int[] count = new int[N];
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			count[i] = sc.nextInt();
		}
		
		// 줄 선 순서대로 키 출력 
		// 키 순서대로 1 - N이라고 생각하기
		// 1번보다 큰 사람들 옆으로 한 칸씩 걍 밀어보기 
		for (int i = 0; i < N; i++) {
			if (count[i] > 0) 
		}

		sc.close();
	}
}
