/* 나이트 이동은 항상 수직2+수평1 OR 수평2+수평1 
 * 입력 받으며 다음 움직임이 아니면 즉시 false
 * 모든 칸 1번씩 방문해서 시작점으로 돌아와야 함 
 */

import java.util.*; 

public class BOJ1331 {
  static boolean[][] visited;
  // 1-4 2칸 1칸 5-8 1칸 2칸 
  static int[] dx = {2, -2, 2, -2, 1, -1, 1, -1};
  static int[] dy = {1, 1, -1, -2, 2, 2, -2, -2};
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] board = new int[6][6];
    visited = new boolean[6][6];
    
    // 유효하지 않으면 바로 break
    // 입력은 [A-F][1-6]으로 주어짐 
    int[][] curr = new int[36][2];

    for (int i = 0; i < 36; i++){
      // 이동 좌표 
      String next = sc.next();
      int col = next.charAt(0) - 'A';
      int row = next.charAt(1) - '1';
      curr[i][0] = col;
      curr[i][1] = row; 
    } // input 

    boolean flag = true;
    // 시작 위치는 방문처리
    visited[curr[0][0]][curr[0][1]] = true;

    // 나이트 이동 & 다음 좌표 받기 & 검증
    for (int i = 0; i < 35; i++){
      boolean valid = false;

      int x = curr[i][0];
      int y = curr[i][1];
      int nextX = curr[i+1][0];
      int nextY = curr[i+1][0];
      
      // 이동후보 (나이트 움직임)
      for (int dir = 0; dir < dx.length; dir++){
        int moveX = x + dx[dir];
        int moveY = y + dy[dir];


        // dir 돌린 것과 하나라도 일치하는거 있으면 true
        // 현재 좌표 기준 가능한 경우 & 배열의 입력 비교
        if (isValid(moveX, moveY, 6, 6)) {
          // 다음 주어진 좌표를 방문했으면 일찌감찌 나가기 
          if (visited[moveX][moveY]) {
            flag = false;
            break;
          }
          
          if (moveX == nextX && moveY == nextY) {
            valid = true;
            visited[nextX][nextY] = true; // 다음 좌표 ok얌 
            break; // 다음 칸으로 이동하자 
          }
        }
      } // dir돌리기 - 이동 1번  

      // 다음 칸 못 가게 되면 걍 끝내고 결과 내보내기 
      if (!valid){
        flag = false;
        break;
      }

    } // 나이트 이동 끝 

    // 찐막으로 마지막 == 처음인지 확인
    if (flag){
      flag = (curr[35][0] == curr[0][0] && curr[35][1] == curr[0][1]);
    }
    String res = flag? "Valid" : "Invalid";
    System.out.println(res);
    
    sc.close();
  }
  
  static boolean isValid(int x, int y, int xN, int yN){
    return (x >= 0 && x < xN && y >= 0 && y < yN);
  }
}