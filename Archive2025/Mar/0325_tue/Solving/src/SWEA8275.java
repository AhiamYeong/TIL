/* 햄스터 우리 n개 
 * l번 우리에서 r번 우리까지 햄스터 수 세었음
 * 만약 3 5 1 -> (1,0,0)(0,1,0)(0,0,1)
 * 1 2 5 -> (5,0)(4,1)(3,2)(2,3)(4,1)(5,0) 가능 
 * 1번부터 N번까지 순서대로 우리에 있는 수 출력 / 가장 많은 것 & 사전순으로 가장 앞선 것 (내림차순) 만족 못하면 -1.
 * 만족 못 한다 = 조건 만족하는 경우의 수가 없다. 
 * 완전탐색으로 전부 하나씩 조합 만들어보고, 모순되지 않을 때 조합 성공
 * 모순 않는다? 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA8275 {

  static int[] hamsters;
  static int N; 

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int T = sc.nextInt(); 
    for (int tc = 1; tc <= T; tc++){
      N = sc.nextInt(); // 우리 개수
      int X = sc.nextInt(); // 각 우리에 0마리 - x마리 있음
      int M = sc.nextInt(); // 기록의 개수

      // 우리 별 햄스터 수 (0-X개)
      List<ArrayList<Integer>> cageCase = new ArrayList<>();
      hamsters = new int[N]; // N개 우리에 들어있는 햄스터들 
      // 우리는 n개 (1-based idx 사용 위함)
      for (int i = 0; i <= N; i++){
        cageCase.add(new ArrayList<>());
      } // 초기화 

      for (int i = 0; i < M; i++){
        // l번부터 r번까지 세었더니 s마리
        // 경우의 수고 우리 순서 중요 -> 순열
        int l = sc.nextInt(); 
        int r = sc.nextInt();
        int s = sc.nextInt();

        // 탐색 구조: 우리 N개를 순차적으로 채우기. i번 우리를 0 - X까지 시도한 후 다음 우리로 넘어가기 

        // 경우의 수는 어떻게? 
        // 우리에 0-X마리까지 있으므로, 우리 하나에 X마리 초과하면 다음 우리로 넘겨야 함 
        calc
      } // 기록 


    } // tc
    sc.close();
  }

  // 순열로 완전탐색 해보고, 가능한 경험 있으면 출력! 
  // 가능하다라는건 어떻게 증명? 
  static void calc(int idx){
    // 종료 조건 > idx == N 할 수는 없음 (전체 햄스터 몇 마린지 몰라)
    
    // visited를 사용한다면 어떻게 채울 수 있을까? 
  }
}