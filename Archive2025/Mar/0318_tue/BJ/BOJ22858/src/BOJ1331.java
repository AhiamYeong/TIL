/* 나이트 이동은 항상 수직2+수평1 OR 수평2+수평1
 * 입력 받으며 다음 움직임이 아니면 즉시 false
 */

import java.util.*; 

public class BOJ1331 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[][] board = new int[6][6];
    boolean[][] visited = new boolean[6][6];
    
    // 어차피 입력 36줄
    int cnt = 0;
    boolean valid = true;

    // 유효하지 않으면 바로 break
    while(cnt < 36 && valid){
      String next = sc.next();

      // 방문 처리 & 검증
      visited[next.charAt(0)][next.charAt(1)] = true;

      cnt++;
    }

    String res = valid? "Valid" : "Invalid";
    System.out.println(res);
    sc.close();
  }
  
}