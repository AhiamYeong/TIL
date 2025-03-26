
import java.util.Scanner;

/* 치즈 상태변화: 날짜별로 바뀜(1일째 - 100일째째)
 * '덩어리': 상하좌우로 모두 이어져 있으면 1덩어리로 취급 (여기서 BFS)
 * 하루 지나면 요정이 먹어서 쪼개짐 > 날짜 지나 상태변화하며 덩어리 개수 바껴야댐 
 * 
 */
public class SWEA7733 {

  static int[] dx = {0, 0, -1, 1};
  static int[] dy = {-1, 1, 0, 0};
  static int[][] cheese;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt(); 
    for (int tc = 1; tc <= T; tc++){

      int N = sc.nextInt();
      cheese = new int[N][N]; // 1-based idx 
      
      for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
          cheese[i][j] = sc.nextInt();
        }
      }

      int chunk = 0; // 덩어리 개수



    } // tc
    sc.close();
  }

  static void bfs(){
    
  }
}
