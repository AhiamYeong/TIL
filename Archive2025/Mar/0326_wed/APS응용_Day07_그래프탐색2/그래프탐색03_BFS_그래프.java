import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//눈 BFS 잘함 -> 대전3반 전지환
public class 그래프탐색03_BFS_그래프 {
	static int V, E; // 정점의 개수, 간선의 개수
	static List<Integer>[] adj; //인접리스트
	static boolean[] visited; // 방문체크
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) {
		//tc 안에서 새롭게 생성하던지... 초기화하던지...
		
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(input);
		V = sc.nextInt();
		E = sc.nextInt();

		adj = new ArrayList[V+1]; //정점은 1번부터 시작이야~
		for(int i = 1; i<=V; i++)
			adj[i] = new ArrayList<>();
		
		visited = new boolean[V + 1];

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			adj[A].add(B);
			adj[B].add(A); //무향이니까..
		} // 간선 입력
		
		bfs(6);
	}// main
	
	//v : 시작정점
	static void bfs(int v) {
//		Queue<Integer> q = new LinkedList<>();
		
		q.add(v);
		visited[v] = true; //넣음과 동시에 방문쳌
		
		while(!q.isEmpty()) {
			int curr = q.poll(); //deQueue 하나 꺼내
			//꺼낸 정점으로 하고 싶은 작업하기!
			System.out.println(curr);
			//curr 와 인접하면서 방문하지 않았다면....
//			for(int i = 0; i<adj[curr].size(); i++) {
//				int w = adj[curr].get(i);
//			}
			
			for(int w : adj[curr]) {
				if(!visited[w]) {
					q.add(w);
					visited[w] = true;
				}
			}
		}//bfs
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	


	static String input = "7 9\r\n" + "1 2\r\n" + "1 3\r\n" + "1 6\r\n" + "2 4\r\n" + "2 7\r\n" + "3 4\r\n" + "4 7\r\n"
			+ "5 6\r\n" + "5 7\r\n" + "\r\n" + "";
}
