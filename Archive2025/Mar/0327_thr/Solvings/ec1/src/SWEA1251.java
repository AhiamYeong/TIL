
/* 크루스칼: '최소 비용' & '모든 섬 연결'
 * 비용: 환경부담 세율 * 각 길이^2만큼 지불 필요 -> 나중에 누적합 구해주기
 * 각 정점별로 연결할 때 길이 구해야 함 -> x, y 좌표로 직접 구하기 
 */
import java.util.Scanner;

public class SWEA1251 {

  static class Edge imple{
    int x;
    int y;
    int cost; 

    public Edge(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    // 계산용 
    
    
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt(); 
    for (int tc = 1; tc <= T; tc++){
      int N = sc.nextInt(); // 섬의 개수
      int[][] lands = new int[N][2]; 
      // 길이는 2백만까지 될 수 있음 > int로 안 터질 것 같음 

      // x좌표 먼저 받고 y좌표 받음
      for (int i = 0; i < N; i++){
        int x = sc.nextInt();
        lands[i][0] = x;
      }

      // x좌표 먼저 받고 y좌표 받음
      for (int i = 0; i < N; i++){
        int y = sc.nextInt();
        lands[i][1] = y;
      }

      
      // 환경부담 세율
      double tax = sc.nextDouble();

      //////////// input /////////////////
      // 크루스칼 -> 간선 정보 필요 -> 주어지지 않음 -> 직접 계산 
      // 해저터널 길이의 제곱의 곱만큼 지불해야 함: 결국 해저터널 길이에 비례 
      // 항상 해저터널끼리 가장 작은 간선 사용하기?

      // 연결 관계가 없는 상태에서 연결 관계를 만들어줘야 함
      // 사이클이 필요한 건 아니나, 모든 배열의 root가 하나여야 함 (하나로 연결)
      // 1개의 섬에서 나머지까지 전부 연결하는 완전 연결그래프 만들어 준 후 그 중에 선택하기? (가장 작은 거리 계산 위해)
      for (int i = 0; i < lands.length; i++){
        // 전체 연결리스트 만들어 둔 후 (나 제외) 거리 계산 돌려보기 -> 가중치로 사용
        for (int j = i + 1; j < lands.length; j++){
          // 나 제외 계산하기
          int[] land1 = lands[i];
          int[] land2 = lands[j];

          double len = calLength(land1, land2);
          System.out.printf("%.2f\n", len);
        }
        
      }

    } // tc
    sc.close();
  }

  // x섬, y섬 거리 계산 
  static double calLength(int[] a, int[] b){
    return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
  }
}
