import java.util.Scanner;

public class SWEA2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 농장 크기
			int[][] farm = new int[N][N];
			
			// 농작물 가치 -> 입력이 한 줄로 들어와서 따로 떼줘야 함!
			for (int i = 0; i < N; i++) {
				String str = sc.next();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = str.charAt(j) - '0';
                }
			}
			
			// center는 항상 farm[N/2][N/2]
			// 항상 정사각형 마름모 형태 
			// 이차원배열 순회
			int sum = 0;
			int start = N/2;
			int end = N/2;
			
			for (int i = 0; i < N; i++) { 
				// 행별로 중간값 기준, +-1 
				// 값 계산
				for (int j = start; j <= end; j++) {
					sum += farm[i][j];
				}
				
				// 각 행에 대해 수확할 범위는 (center-j, center+j)
				// j는 1, 3, 5, 3, 1로 변함
				// 시작점, 끝점을 행별로 변화시키기 
				if (i < N/2) { // 중심점 전까지 
					start -= 1; // 시작은 하나씩 감소
					end += 1; // 끝은 하나씩 증
				} // 중심 이후로 감소
				else { // 절반 지나면 다시 복구 
					start += 1;	
					end -= 1;
				}								

			} // 행 
			System.out.println("#" + tc + " " + sum);
		} // tc
		sc.close();
	}
}
