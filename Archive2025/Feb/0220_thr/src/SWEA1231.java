import java.util.Arrays;
import java.util.Scanner;

public class SWEA1231 {
//	// 중위 순회 - LVR
	// tree[0] 문자열, [1] 왼쪽 자식노드, [2] 오른쪽 자식노드
	public static String inOrder(String[][] tree, int v) {
		// v는 시작 idx, tree를 중위탐색
		int N = tree.length; //tree size -> idx 개수만큼? 
		StringBuilder sb = new StringBuilder();
		if (v < N) {
			// L - 왼쪽 자식 탐색 ([num][1])
			if (tree[v][1] != null) {
				sb.append(inOrder(tree, Integer.parseInt(tree[v][1])));
			}
			// V - 본인 
			if (tree[v][0] != null) {
				sb.append(tree[v][0]);	
			}
			
			// R - 오른쪽 자식 탐색
			if (tree[v][2] != null) {
				sb.append(inOrder(tree, Integer.parseInt(tree[v][2])));
			}
		}
		
		String str = sb.toString();
		
		return str;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt(); // case별 N (정점의 수)
			sc.nextLine(); // 한 번 더 사용해 개행문자 처리
			// 트리의 간선은 항상 N-1개
			// 각 정점 정보 저장 - 1-based 위함
			String [][] tree = new String[N+1][3];
			// idx별 문자 / 왼쪽자식 노드 / 오른쪽 자식 노드
					
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine(); // 한 줄 입력받고 공백 제거
				String[] set = str.split(" ");
				// 개수 따라 다름 
				// 2개 들어오면 본인이 leaf node
				for (int j = 0; j < set.length; j++) {
					// 첫 번째는 무조건 문자열
					int num = Integer.parseInt(set[0]);
					tree[num][0] = set[1]; // 2개까지는 저장 
					// 3개 들어오면 왼쪽 자식노드만 있음
					if (set.length == 3) {
						tree[num][1] = set[2];
						// 4개 들어오면 왼쪽 + 오른쪽 자식노드 
					} else if (set.length == 4) { 
						tree[num][1] = set[2];
						tree[num][2] = set[3];
					}
				}
			} // 입력

			StringBuilder sb = new StringBuilder();
			sb.append("#");
			sb.append(tc);
			sb.append(" ");
			sb.append(inOrder(tree, 1));
			String str = sb.toString();
			// 중위탐색 수행 
			System.out.println(str);
		} // tc
		sc.close();
	} // main
}
