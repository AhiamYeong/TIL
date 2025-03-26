import java.util.Scanner;

public class graph1_인접행렬 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 보통 V, E 개수 입력받음 
        int V = sc.nextInt(); // 정점 개수 (0/1 시작점 확인하기)
        int E = sc.nextInt(); // 간선 개수

        // 인접행렬로 2차원배열
        int[][] adjArr = new int[V][V]; // 시작 정점이 1이라면 V+1로 만들기

        for (int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt(); // 가중치: 없다면 1을 저장하세욯옹

            adjArr[A][B] = 1; // 가중치 없으면 1, 있으면 W 저장
            adjArr[B][A] = 1; // 유향 그래프면 필요없고, 무향이면 양방향이므로 작성 필요 

            // ajdArr[A][B] = adjArr[B][A] = W; // 도 가능 
        } // 간선 입력 

        sc.close();
    }
}
