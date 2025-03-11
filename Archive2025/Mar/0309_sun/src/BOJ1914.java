import java.util.*;
public class BOJ1914 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 원판 수 
		int N = sc.nextInt();
		hanoi(N, 1, 2, 3);
		sc.close();
	}
	
	// N: 원판의 개수 
	static void hanoi(int N, int start, int mid, int end) {
		// 출력 a번째 탑의 가장 위에 있는 원판을 
		// b번째 가장 위로 옮긴다는 뜻 
		
		
		// base case -> 원판 1개 남으면 바로 끝으로 이동
		if (N == 1) {
			hanoi(1, )
		}
		// 재귀: 원판 n개일 때 
		// 1 n-1번째 원판까지 전부 2에 옮김
		
		// 2 n번째 원판을 3에 옮김 
	}
}
