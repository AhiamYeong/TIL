// 농작물 수확하기 -> linkedlist로 다시 풀어보기

		// 정사각형 마름모 > 1 / 3 /  5 / 7 / 5 / 3 / 1
		
		// 리스트 특징이 순서가 있다 인데
		
		// 그러면 next로 노드 넘어갈 때마다 사이즈 증가?
		// N / 2만큼 잘라놓고
		
		// idx < N/2일 때 증가, 그 외일 때 1칸씩 감소
		
		// Array 1개짜리를 list로 잇기? 

import java.util.LinkedList;
import java.util.Scanner;

public class SWEA2805 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 농장의 크기
			// 한 행은 array, 각 행을 list로 잇기?
			
			// linkedlist ... 행을 list로 이을까?
			// 1차원배열 + linkedlist
			LinkedList<int[]> cols = new LinkedList<>();
			// 배열 몇 개가 포함될지는 나중에 결정되는 구조? 
			// 그럼 이걸 지역변수로 다루는게 맞아?
			for (int i = 0; i < N; i++) {
				int[] arr = new int[N]; // N개 크기의 배열 N개 생성
				arr[i] = sc.nextInt();
			}
			
//			// input 받기
			for (int i = 0; i < N; i++) {
				System.out.println(arr[i] + " "); // N개 크기의 배열 N개 생성
			}
			
			int center = N / 2; // 가운데 idx는 항상 고정
			// arr별로 순서대로 값을 받아야 하자나
			
			System.out.println(cols);
			
		} // tc
		
		sc.close();
	}
}
