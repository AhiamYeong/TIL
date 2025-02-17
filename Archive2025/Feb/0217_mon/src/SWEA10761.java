import java.util.Scanner;

public class SWEA10761 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 테스트에서 눌러야 하는 버튼 수
			// 버튼 N개
			// O x, B y -> 오렌지가 버튼 x, 블루가 버튼 y 누르기 
			// (담당/버튼) 쌍
			
			int time = 0; // 소요된 시간
			
			// 동작 3가지만 가능
			// move, push, stop (가만히 있기)
			
			System.out.println("#" + tc + " " + time);
		} // tc
		
		sc.close();
	} // main
}
