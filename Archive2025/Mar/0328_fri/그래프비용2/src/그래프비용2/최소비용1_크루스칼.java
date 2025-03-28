package 그래프비용2;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 최소비용1_크루스칼 {
  static int[] p; // 대표 저장 배열
  static int[] rank; // 균형있는 트리 > 안 쓴다
  static final int COST = 2;

  static String input = "7 11\r\n" + //
        "0 1 32\r\n" + //
        "0 2 31\r\n" + //
        "0 5 60\r\n" + //
        "0 6 51\r\n" + //
        "1 2 21\r\n" + //
        "2 4 46\r\n" + //
        "2 6 25\r\n" + //
        "3 4 34\r\n" + //
        "3 5 18\r\n" + //
        "4 5 40\r\n" + //
        "4 6 51\r\n" + //
        "";

  // 간선 저장: '간선 배열'이 필요함 
  // 1. Edge class 생성
  // 2. int[] 
	static class Edge implements Comparable<Edge> {
		int s, e, cost;

		public Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
//			return Integer.compare(this.cost, o.cost);
		}
	}// class 선언

  public static void main(String[] args) {
    Scanner sc = new Scanner(input);

    int V = sc.nextInt(); // 정점의 개수 (시작번호 확인 => 예제에선 0부터 시작 )
    int E = sc.nextInt(); // 간선의 개수 

    // 객체배열에 간선 수만큼 저장 / list로 저장할 수도 있음 
    Edge[] edges = new Edge[E];

    // 2차원배열로 저장
    int[][] edges2 = new int[E][3]; // s, e, cost
    
    for (int i = 0; i < E; i++){
      int s = sc.nextInt();
      int e = sc.nextInt();
      int cost = sc.nextInt();
      edges[i] = new Edge(s, e, cost);
      // edges[][] 정렬하는 방법: 가중치 기준으로 정렬해야 함함
      
    } // 간선 입력

		// 1. 정렬을 하자 -> 가중치 오름차순으로 정렬!

    Arrays.sort(edges, new Comparator<Edge>() {
      // compare 함수 직접 가져와서 비교 기준 cost로 넣어주기 
      @Override
      public int compare(Edge o1, Edge o2) {
        return o1.cost - o2.cost;
      }
    });

    Arrays.sort(edges2, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[COST] - o2[COST];
      }
    });

    for (int[] a : edges2) {
      System.out.println(Arrays.toString(a));
    }

    // 2. V-1개 간선 뽑기 (사이클 X), 서로소 집합(union-find 이용할 것 )
    p = new int[V]; 

    // make-set: 각자 본인이 대표되도록 초기화
    for (int i = 0; i < V; i++){
      // makeset(i);
      p[i] = i;
    } 

    int ans = 0; // 누적 비용 (최소 비용 저장용)
    int pick = 0; // 트리에서 간선 몇 개 뽑을까? 
    for (int i = 0; i < E; i++){
      int s = edges[i].s;
      int e = edges[i].e;

      // 1. 사이클 검사 수행
      // if (findSet(s) != findSet(e)){ // 다르면 사이클 없는 것 
        // 사이클이 없다면 합치기

      int px = findSet(s);
      int py = findSet(e);

      // if (findSet(s) != findSet(e))
      if (px != py) {
        union(px, py); // 합쳐: 해당 간선 뽑았음
        pick++;
        ans += edges[i].cost; // 비용 확인 
      }

      if (pick == V-1) break; // 검사 다 했으면 끝 
    }
    System.out.println(ans);


  } // main


  static void makeSet(int x){
    p[x] = x; 
  }

  static int findSet(int x){

    // path compression 적용
    if (x != p[x]) p[x] = findSet(p[x]); 
    return p[x];
  }

  // 지금 rank 고려는 x 
  static void union(int x, int y){
    // x, y가 대표라는 보장이 없기 때문에 한번 더 검사해주기 
    p[findSet(y)] = findSet(x); 

    // p[y] = x 하면 안되나? => s,e가 무조건 대표면 가능
  }
}
