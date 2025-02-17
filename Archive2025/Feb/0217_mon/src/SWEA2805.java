import java.util.Scanner;

public class SWEA2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 농장 크기
			int[][] farm = new int[N][N];
			
			// 농작물 가치
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					farm[i][j] = sc.nextInt();
				}
			}
			
			// center는 항상 [N][N] -> N = 1일 때는 틀리는데?
			
		} // tc
		sc.close();
	}
}
