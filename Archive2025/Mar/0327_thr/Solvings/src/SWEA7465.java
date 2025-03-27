
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/* 연결 요소의 개수 찾기 = 서로소 집합 찾기
 * 사이클이 없어도 이어져만 있으면 '연결 요소'로 보기
 * DFS/BFS로 접근 시: 연결리스트 방식으로 저장 (visited 관리 용이)
 * Union-Find로 접근 시: 객체배열로 저장 (union(x, y) 용이)
 */
public class SWEA7465 {
  // edge 정보 저장 
  static class Edge{
    int from, to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
  }

  static int[] parent;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int tc = 1; tc <= T; tc++){
      int N = sc.nextInt(); // 정점 개수 
      int M = sc.nextInt(); // 간선 개수 

      // 그래프 저장하기:  union-find 사용을 위해 edge 배열로
      Edge[] arr = new Edge[M]; // edge 개수만큼 받기

      // 정점 연결 
      for (int i = 0; i < M; i++) {
        int from = sc.nextInt();
        int to = sc.nextInt();
        arr[i] = new Edge(from, to); // 간선별로 from-to 저장 (가중치 X)
      }

      // 처음에는 각자 자기 집 두기 
      parent = new int[N+1]; 
      // makeset - parent의 root는 자기 자신 
      for (int i = 1; i <= N; i++) {
        parent[i] = i; // 문제에서 정점 수는 미리 제공해주므로 
      }

      // union-find 적용: 저장된 정보들을 간선 수만큼 확인한 후, '연결된 요소' = union으로 냅다 붙이기 
      // 간선 끝까지 반복한 후, 마지막에 root 개수만 세면 됨  (find)
      for (int i = 0; i < M; i++){
        // 1 - 2 - 3이 연결되어 있다면 -> 1, 3의 대표를 2로 정하기
        int p1 = arr[i].from;
        int p2 = arr[i].to; 

        // from -> to 연결하기
        union(p1, p2); 
      }

      // union만 돌리니까 parent 배열의 모든 노드가 전부 root를 가리키지 않음 
      // 모든 정점들에 대해 find 연산 다시 해주기
      for (int i = 0; i < parent.length; i++) {
        find(i);
      }

      // System.out.println(Arrays.toString(parent));

      // 마지막으로 연결 정점의 개수 -> parent 집합에서 다른거 세면 됨
      Set<Integer> set = new HashSet<>(); 
      for (int i = 1; i < parent.length; i++){
        set.add(parent[i]);
      }
      
      int chunk = set.size(); 
      System.out.println("#" + tc + " " + chunk);

    } // tc
  } // main

  // x의 root 찾기 > parent 배열 정리하게 만들기
  static int find(int x){
    if (parent[x] != x) parent[x] = find(parent[x]);
    return parent[x];
  }

  // x, y 연결하기
  static void union(int x, int y){
    int rootX = find(x);
    int rootY = find(y);

    // rank 안 줬으므로, x를 y 밑으로 ㄱㄱ
    parent[rootX] = rootY; 
  }
}