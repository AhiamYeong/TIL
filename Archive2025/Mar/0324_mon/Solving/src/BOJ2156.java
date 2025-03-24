/* 연속 3잔 동시X > 백준처럼 2차원배열 사용?
 * 그 안에 들어있는 것 모두 마시고 / 원래 위치에 다시 놓기 
 */

import java.util.Scanner;

public class BOJ2156 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 포도주 잔 개수 
    int N = sc.nextInt(); 

    // 개수 저장
    int[] wines = new int[N+1];
    // 그냥 1 based idx 쓸려고 
    for (int i = 1; i < N+1; i++){
      wines[i] = sc.nextInt();
    }

    // 최대한 많은 양 / 연속 3잔은 불가능 
    

    sc.close();
  }
}
