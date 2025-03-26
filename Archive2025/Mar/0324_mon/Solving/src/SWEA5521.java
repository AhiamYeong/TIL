/* 상원이의 친한 친구 -> 그래프로 연결 
 * 친한 친구의 친한 친구 -> 그래프와 연결관계 쭉 뻗어나가기
 * BFS든 DFS든 써서 연결관계 끝까지 탐색하기
 * 이어져 있는 수 출력 
 * 그래프) 정점=친구의 수, 간선=친한 친구 관계
 * 친구의 친구 (연결 2번까지만 가능) -> depth 2까지만 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class SWEA5521 {

    static boolean[] visited;
    static List<Integer>[] adjList;
    static int friend;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt(); 

        for (int tc = 1; tc <= T; tc++ ){
            int N = sc.nextInt(); // 친구 수 > vertex
            int M = sc.nextInt(); // 친구 관계 수 > edge

            // DFS 사용 위한 배열
            visited = new boolean[N+1];
            friend = 0;

            // 가중치 없음, 인접리스트 방식 (배열 안에 arraylist)
            // 친구 수만큼 배열 만들기
            adjList = new ArrayList[N+1]; // 1-based idx
            // 인접리스트 내부 초기화
            for (int idx = 0; idx < N+1; idx++) {
                adjList[idx] = new ArrayList<>();
            }

            // 친구 관계 만들기 
            for (int p = 1; p <= M; p++ ){
                // 인접리스트 내부 초기화

                int A = sc.nextInt();
                int B = sc.nextInt();
                
                // 양방향 리스트
                adjList[A].add(B);
                adjList[B].add(A);
            }

            // BFS로 탐색해서 depth 2까지의 개수만 세기 
            bfs(1);

            // 1번 본인은 제외
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(friend);
            System.out.println(sb.toString());
        } // tc
        sc.close();
    } // main

    // bfs가 나을거같음
    static void bfs(int st){
        Queue<int[]> queue = new LinkedList<>();
        // 시작 값 넣고 방문 처리 
        int[] start = new int[]{st, 0}; // depth 함께 추적하기 

        queue.add(start);

        visited[st] = true; // 넣은 친구는 방문처리
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currNode = curr[0];
            int currDepth = curr[1]; 
            
            // 넣을 다음 값은 curr과 연결된 값들  
            for (int nextNode : adjList[currNode]){
                // 방문 안 한 값만 처리하기
                // 친구의 친구까지만 받아줌 
                
                if (!visited[nextNode] && currDepth < 2){
                    // 넣었으면 방문 처리 & 깊이 추가 
                    queue.offer(new int[] {nextNode, currDepth + 1});
                    visited[nextNode] = true;
                    friend++;
                }
            }
        }
    }
}