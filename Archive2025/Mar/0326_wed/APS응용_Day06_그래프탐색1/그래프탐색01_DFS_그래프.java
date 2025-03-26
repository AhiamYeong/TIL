import java.util.Scanner;
import java.util.Stack;

public class 그래프탐색01_DFS_그래프 {
	static int V, E; // 정점의 개수, 간선의 개수
	static int[][] adj; // 인접행렬
	static boolean[] visited; // 방문체크

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		V = sc.nextInt();
		E = sc.nextInt();

		adj = new int[V + 1][V + 1]; // 시작정점이 1번부터!
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			adj[A][B] = 1;
			adj[B][A] = 1; // 무향이니까 반대로도 연결!

		} // 간선 입력

		dfs(1);
		System.out.println("--------------------");
		dfsStack(1);

	}// main

	// v : 현재 방문 정점
	static void dfs(int v) {
		visited[v] = true;
		System.out.println(v);
		// 재귀부분
		for (int i = 1; i <= V; i++) {
			// 방문쳌 X && 연결되어있는지 쳌
			if (!visited[i] && adj[v][i] == 1) {
				dfs(i);
			}
		}
	}

	// v : 시작 정점
	static void dfsStack(int v) {
		// 정점만 담을거야!
		Stack<Integer> stack = new Stack<>();
		visited = new boolean[V + 1];
		stack.push(v); // 시작은 넣고 해!

		while (!stack.isEmpty()) {
			int curr = stack.pop();

			if (!visited[curr]) {
				visited[curr] = true;
				System.out.println(curr);

				for (int i = V; i > 0; i--) {
					if (!visited[i] && adj[curr][i] == 1) {
						stack.push(i);
					}
				} // 연결간선 방문하지 않았다면 push
			}
		}

	}

	static String input = "7 9\r\n" + "1 2\r\n" + "1 3\r\n" + "1 6\r\n" + "2 4\r\n" + "2 7\r\n" + "3 4\r\n" + "4 7\r\n"
			+ "5 6\r\n" + "5 7\r\n" + "\r\n" + "";
}
