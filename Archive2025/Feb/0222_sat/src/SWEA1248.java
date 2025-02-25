import java.util.Arrays;
import java.util.Scanner;

public class SWEA1248 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			// 정점 개수
			int V = sc.nextInt();
			// 간선 개수
			int E = sc.nextInt();
			// 공통 조상찾는 2개 정점 번호
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			// 2차원 배열로 구현 - idx, 왼쪽 자식, 오른쪽 자식 
			int[][] arr = new int[V+1][2];
			
			// 항상 부모 / 자식 순서로 input
//			int parent = 1; // 1
//			int child = parent * 2; // 왼쪽 자식 
			for (int i = 0; i < E; i++) {
				int parent = sc.nextInt(); // 부모 노드 
				int child = sc.nextInt(); // 자식 노드 
				// 왼자부터 채우다겹치는 idx 있으면 오자 채우
				if (arr[parent][0] != 0) {
					arr[parent][1] = child;
				} else {
					arr[parent][0] = child;
				}
			} // input
			
			// v1, v2의 공통조상 찾기
			// v1, v2의 조상 리스트 집합 찾고
			// 조상 리스트 -> 
			// 리스트 집합에서 가장 큰 수 찾기 
			
		} // tc
		
		sc.close();
	}
}
