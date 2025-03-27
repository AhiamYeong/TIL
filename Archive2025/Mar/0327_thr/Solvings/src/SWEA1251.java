
/* 크루스칼: '최소 비용' & '모든 섬 연결'
 * 비용: 환경부담 세율 * 각 길이^2만큼 지불 필요 -> 나중에 누적합 구해주기
 * 크루스칼 -> 간선 정보 필요 -> 주어지지 않음 -> 직접 계산 
   해저터널 길이의 제곱의 곱만큼 지불: 결국 해저터널 길이에 비례 > 항상 해저터널끼리 가장 작은 간선 사용하기?
  연결 관계가 없는 상태에서 연결 관계를 만들어줘야 함
  사이클이 필요한 건 아니나, 모든 배열의 root가 하나여야 함 (하나로 연결
  1개의 섬에서 나머지까지 전부 연결하는 완전 연결그래프 만들어 준 후 그 중에 선택? (가장 작은 거리 계산 위해)
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA1251 {

  static int[] parents; // root 저장 배열

  static class Land {
    int x;
    int y;

    public Land(int x, int y) {
        this.x = x;
        this.y = y;
    }
  }

  static class Edge {
    Land a;
    Land b;
    double cost; 

    public Edge(Land a, Land b, double cost) {
      this.a = a;
      this.b = b;
      this.cost = cost;
    }

  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); 
    for (int tc = 1; tc <= T; tc++){
      int N = sc.nextInt(); // 섬의 개수
      
      Land[] lands = new Land[N+1]; // 1-based idx 사용 

      // x좌표 먼저 받고 y좌표 받음
      int[] xs = new int[N];
      int[] ys = new int[N];

      for (int i = 0; i < N; i++) xs[i] = sc.nextInt();
      for (int i = 0; i < N; i++) ys[i] = sc.nextInt();
      for (int i = 0; i < N; i++){
        lands[i] = new Land(xs[i], ys[i]);
      } // land 배열에 저장
      
      // 환경부담 세율
      double tax = sc.nextDouble();

      //////////// input /////////////////
      Edge[] edges = new Edge[N]; // n개 저장

      // Edge 배열 채우기: 나 제외 모든 섬들 연결해서 완전연결그래프 만들기
      for (int i = 0; i < lands.length; i++){
        for (int j = i + 1; j < lands.length; j++){
          // 나 제외 계산하기
          Land land1 = lands[i];
          Land land2 = lands[j];
          
          double len = calLength(land1, land2);
          System.out.printf("%.2f\n", len);
          // tax까지 함께 계산해서 가중치로 저장 
          edges[i] = new Edge(land1, land2, len * tax);
        } 
      } // edge 채우기

      /////// 크루스칼 사용 ////////
      // 1. 간선 가중치대로 정렬
      // lambda 이용
      Arrays.sort(edges, new Comparator<Edge>() {
        @Override
        public int compare(Edge o1, Edge o2) {
          // Double 형식 비교
          return Double.compare(o1.cost, o2.cost);
        }
      });

      // 2. V-1개 간선 뽑기 (사이클 X, 서로소 집합 이용)
      parents = new int[N]; 

      // make-set(본인 대표 초기화)
      for (int i = 0; i < N; i++) {
        parents[i] = i;  
      }

      // 누적 비용
      int ans = 0; 
      
      // 그래프 연결해서 최소비용 찾기
      ////////////////////////////////////////
      for (int i = 0; i < edges.length; i++){

      }
    } // tc
    sc.close();
  }

  // x섬, y섬 거리 계산 
  static double calLength(Land a, Land b){
    // 직선의 방정식 
    return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
  }
}
