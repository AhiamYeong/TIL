
import java.util.LinkedList;
import java.util.Queue;
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
  static boolean[][] removed;
  static int chunk;
  static int N; 

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt(); 
    for (int tc = 1; tc <= T; tc++){

      N = sc.nextInt();
      cheese = new int[N][N];  
      
      for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
          cheese[i][j] = sc.nextInt();
        }
      }

      chunk = 1; // 덩어리 개수 (크게 1개)

      // 치즈 100일동안 상태 바뀜
      // visited 사용하기?! 어차피 없어짐r
      for (int date = 1; date <= 100; date++) {
        // 날짜별 chunkToday 검사
        removed = new boolean[N][N]; // 턴마다 초기화 필요
        int chunkToday = 0; // 하루 지나가고 나온 조각수

        for (int i = 0; i < N; i++){
          for (int j = 0; j < N; j++){
            // bfs 탐색 시작 >> visited 안한거
            // 살아있는 치즈는 오늘 날짜보다 커야함 
            
            if (!removed[i][j] && cheese[i][j] > date){
              bfs(i, j, date); // 치즈 덩어리 하나 찾기
              chunkToday++; // bfs 다 돌면 한 조각 생긴거 
              
            } // 날짜랑 맞을 때 
            chunk = Math.max(chunk, chunkToday);
          }
        }
      } 

      System.out.println("#" + tc + " " + chunk);


    } // tc
    sc.close();
  }

  static void bfs(int x, int y, int date){
    Queue<int[]> q = new LinkedList<>();
    removed[x][y] = true;
    q.offer(new int[]{x, y});

    while (!q.isEmpty()) {
      // 나온 현재 조ㅏ표
      int[] cur = q.poll();
      int curX = cur[0];
      int curY = cur[1];

      // 좌표 기준 4방탐색
      for (int dir = 0; dir < 4; dir++) {
          int nx = curX + dx[dir];
          int ny = curY + dy[dir];

          if (nx >= 0 && ny >= 0 && nx < N && ny < N &&
                  !removed[nx][ny] && cheese[nx][ny] > date) {
                    removed[nx][ny] = true;
              q.offer(new int[]{nx, ny});
          }
      }
    }
  }
}
