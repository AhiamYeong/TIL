package SWEA;

import java.util.*;

public class SWEA3499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 카드 개수
			String[] cards = new String[N];
			
			for (int i = 0; i < N; i++) {
				cards[i] = sc.next();
 			} // 카드 N개 input 
			
			String[] res = new String[N]; // 출력할 결과 배열 
		
			// 절반 (N/2) 기준
			// 0 N/2+0, 1 N/2+1, 2 N/2+2 ... 순으로 나열하기
			int idx = 0;
			for (int i = 0; i < N/2; i++) {
				res[idx] = cards[i];
				res[idx+1] = cards[i+N/2]; 
				idx += 2;
//				System.out.println(idx);
			}
			
			System.out.print("#" + tc + " ");
			for (String r : res) {
				System.out.print(r + " ");
			}
			System.out.println();
			// 이 방식으로 구현 안됨? 
		} // tc
		
		sc.close();
	}
}
