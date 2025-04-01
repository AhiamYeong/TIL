import java.util.Scanner;

public class BOJ2563 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    boolean[][] board = new boolean[100][100];

    int N = sc.nextInt(); // 색종이 개수 
    int[][] papers = new int[N][2];
    // 0 x 1 y좌표 

    for (int i = 0; i < N; i++){
      int x = sc.nextInt();
      int y = sc.nextInt();

      // 각 x, y좌표 저장 
      papers[i][0] = x;
      papers[i][1] = y; 
    }

    // 색종이 크기는 10 * 10 정사각형 
    for (int i = 0; i < N; i++){
      int curX = papers[i][0];
      int curY = papers[i][1];

      for (int y = 0; y < 10; y++){
        for (int x = 0; x < 10; x++){
          board[x + curX][y + curY] = true;
        }
      }
    }

    int cnt = 0;
    for (int i = 0; i < 100; i++){
      for (int j = 0; j < 100; j++){
        if (board[i][j] == true) cnt++;
      }
    }
    System.out.println(cnt);
    sc.close();
  }
}
