import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BOJ11724 {

    static boolean[] visited;
    static List<Integer>[] adjList;
    static int cnt = 0; 
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 정점 개수, 간선 개수
    int N = sc.nextInt();
    int M = sc.nextInt();

    // 정점 저장: 인접리스트
    adjList = new ArrayList[N+1];
    for(int i = 0; i <= N; i++){
      adjList[i] = new ArrayList<>();
    } // 초기화 

    visited = new boolean[N+1];

    for (int i = 0; i < M; i++){
      int u = sc.nextInt();
      int v = sc.nextInt();

      // 양바얗ㅇ
      adjList[u].add(v);
      adjList[v].add(u);
    } // 입력 받기

    // 연결 요소 찾기 -> 노드 1에서 시작해서 bfs 돌리고, 방문 노드에 visited 체크 > bfs 한 턴 넘어가면 count up

    for (int i = 1; i < adjList.length; i++){
      bfs(i);
    }
    System.out.println(cnt);

    sc.close();
  }

  static void bfs(int start){
    Queue<Integer> q = new LinkedList<>();

    // 시작할 때 한 번 검사
    if (visited[start]) return;
    q.offer(start);
    visited[start] = true;

    while(!q.isEmpty()){
      int curr = q.poll(); 

      // bfs lvl 한 턴 
      for (int next : adjList[curr]){
        if (!visited[next]){
          q.offer(next);
          visited[next] = true;
        }
      }
    } // 큐 순회 끝나면 
    cnt++;
  }
}
