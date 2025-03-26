import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 1 리스트 안에 리스트 
 * 2 리스트 안에 배열
 */

public class graph2_인접리스트 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 보통 V, E 개수 입력받음 
        int V = sc.nextInt(); // 정점 개수 (0/1 시작점 확인하기)
        int E = sc.nextInt(); // 간선 개수

        // ArrayList를 가지고 있는 배열 만들기
        // V개의 배열 안에 arraylist 있는 형태 
        List<Integer> [] adjList = new ArrayList[V];
        // 초기화 해줘야 nullpointexception 안 뜸
        for (int i = 0; i < V; i++ ){
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            // 가중치를 같이 저장하고 싶다면 :
            // 1 클래스 정의해서 저장하기
            // 2 int 배열을 이용해 저장하기 int[0], [1], [2] 각 정보 저장 필요
            adjList[A].add(B);
            adjList[B].add(A); // 무향이면 필요X

        } // 간선 입력 

        sc.close();
    }
}
