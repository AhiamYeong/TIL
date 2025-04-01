/* stack + dfs */
package day11_위상정렬;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 위상정렬_스택 {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	static int V, E;
	static List<Integer>[] adj;
	static boolean[] visited;
	static Stack<Integer> ans; // 정답 스택  
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		V = sc.nextInt(); // 정점 개수 (1번부터 시작)
		E = sc.nextInt(); // 간선 개수
		visited = new boolean[V+1];
		ans = new Stack<>();
		
		adj = new ArrayList[V+1]; // 인접리스트
		for (int i = 0; i < V+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		int[] degree = new int[V+1]; // indegree 저장
		
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			adj[s].add(e); // 가중치 없으므로 걍 1로 저장, 유향그래프  
		
			// 도착지점의 진입차수 올리기
			degree[e]++; 
			
		}// 간선 입력

		
		for (int i = 1; i < V+1; i++) {
			if (degree[i] == 0) dfs(i);
		}
		

		// ans에서 pop하면 위상정렬 순서!
		while(!ans.isEmpty()) System.out.println(cook[ans.pop()]);
		
		sc.close();
	}
	
	// v: 현재 내가 방문하는 정점
	private static void dfs(int v) {
		// 1. 방문 표시: 중복 불가능용 
		visited[v] = true; 
		
		// v와 연결된 to들에 대해서 (인접행렬같은 체크 불필요)
		for (int to : adj[v]) {
			// 2. 방문하지 않은 노드라면 dfs 재귀 호출 
			if (!visited[to]) dfs(to);
		} 
		
		// 나 다 해써 방문 다해써
		ans.push(v);
	}

	static public String input = "9 9\r\n"
			+ "1 4\r\n"
			+ "1 8\r\n"
			+ "2 3\r\n"
			+ "4 3\r\n"
			+ "8 5\r\n"
			+ "3 5\r\n"
			+ "5 6\r\n"
			+ "9 6\r\n"
			+ "6 7\r\n";
}
