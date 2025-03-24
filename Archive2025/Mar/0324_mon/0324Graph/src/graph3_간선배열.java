import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 1 리스트 안에 리스트 
 * 2 리스트 안에 배열
 */

public class graph3_간선배열  {

    // 클래스 정의
    static class Edge {
        int A, B, W; // 시작, 끝, 가중치 

        // 문제 풀기 위해 클래스 정의하는 경우 > 바구니용 생성자는 하나씩 만들어두기~
        public Edge(int A, int B, int W) {
            this.A = A;
            this.B = B;
            this.W = W;
        }

        // 그냥 확인용
        @Override
        public String toString() {
            return super.toString();
        }
        
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 보통 V, E 개수 입력받음 
        int V = sc.nextInt(); // 정점 개수 (0/1 시작점 확인하기)
        int E = sc.nextInt(); // 간선 개수

        Edge[] edges = new Edge[E]; // 간선배열 (객체 배열)

        for (int i = 0; i < E; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();

            edges[i] = new Edge(A, B, W);
            // 유향/무향이든 인지만 하면 되지, 그래프 통해 저장할 필요는 없음

        } // 간선 입력 

        //////////////////////////////////////////////////////////////////
        List<Edge> edges2 = new ArrayList<>();
        for (int i = 0; i < E; i++){
            edges2.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        //////////////////////////////////////////////////////////////////
        // 간선 정보가 전부 정수일 때는 2차원 배열 이용 저장 가능
        int[][] edges3 = new int[E][3];
        // 0번은 시작 정점, 1번은 끝 정점, 2번은 가중치
        for (int idx = 0; idx < E; idx++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();
            
            edges[idx][0] = A;
            edges[idx][1] = B;
            edges[idx][2] = W;
        }
        sc.close();
    }
}
