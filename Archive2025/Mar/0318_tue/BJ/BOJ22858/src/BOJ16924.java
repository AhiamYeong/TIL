/* 십자가는 서로 겹쳐도 됨 
 * x, y 꼭짓점 전부 돌면서 . 거르고 *만 찾아내기
 * *인 결과에 십자가 1 2 3 전부 만들어보기? 
 * 언제 끝내야되지 십자가 만든 다음에 board[nextX][nextY] == . 일 때?
*/
import java.util.Scanner;

public class BOJ16924 {

  // 크기 n인 십자가 > *로 싹 채우기 
  static int[] dx = {0, 0, 0, 1, -1};
  static int[] dy = {0, 1, -1, 0, 0};

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    
    // input 
    int N = sc.nextInt();
    int M = sc.nextInt();

    sc.nextLine();  // \n 정리하기 (nextInt > 숫자만 남김 호록)

    char[][] board = new char[N][M];
    for (int i = 0; i < N; i++){
      board[i] = sc.nextLine().toCharArray();
    }

    for (char[] k : board){
      for (char c : k){
        System.out.print(c + " ");
      }
      System.out.println();
    }

    // 십자가로 격자 못 만들면 -1 출력 
    boolean possible = true; 
    StringBuilder sb = new StringBuilder();

    // 십자가 만들어보고 되면 k(개수), 안 되면 딴거 출력 
    // 가능한 답이 여러 가지면 아무거나 출력 
    // 시작할 수 있는 꼭짓점 
    for (int x = 0; x < N; x++){
      for (int y = 0; y < M; y++){
        // 현재 좌표 
        int curX = x;
        int curY = y;

        // 꼭짓점 기준으로 별 하나씩 찍어보기 
        
      }
    }

    
    // sb.append(possible? k: "-1");
    // System.out.println(sb.toString());

    sc.close();
  } // main
}
