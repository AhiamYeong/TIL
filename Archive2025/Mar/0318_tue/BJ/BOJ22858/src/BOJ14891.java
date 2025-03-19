/*
 * 톱니바퀴 4개, 각 톱니 8개씩 가짐, 회전 1회 (시계/반시계) 
 * 톱니A, 톱니 B 맞닿은 극 다르면 반대방향 회전, 같으면 회전X 
 * 연쇄적: 회전 시작하면 양쪽 극 확인
 *   극 같으면 회전 > 다음 톱니 극 검사
 *   극 다르면 회전X, 바로 확인 멈춤 
 * 회전 완료할 때마다 상태를 계속해서 저장장
 * K번 회전 완료한 후, 결과는 12시방향(idx 첫 번째) 점수로 계산 
 */
import java.util.Scanner;

// 톱니바퀴 큐로 하면 편할 것 같은데..

public class BOJ14891 {
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    // 12시부터 시계방향 8개 / N극 0 S극 1
    int[][] wheels = new int[4][8];
    for (int i = 0; i < 4; i++){
      for (int j = 0; j < 8; j++){
        wheels[i][j] = sc.nextInt();
      }
    } // input 

    int K = sc.nextInt(); // 회전 횟수 
    // 회전 방법
    for (int i = 0; i < K; i++){
      int target = sc.nextInt() - 1; // 회전시킨 톱니바퀴 번호 (0-based idx)
      int direction = sc.nextInt(); // 1 시계방향, -1 반시계방향 
      
      // 왼쪽, 오른쪽 바퀴 가리키기 > target이 끝값일 때 사용 X
      int left = target - 1;
      int right = target + 1;
      if (target == 0) left = -1;
      if (target == 3) right = -1; 

      // 회전 1회차 수행
      while (true) { 
        // 회전 전 양쪽 값 검사: 값 같으면 회전수행, 다르면 수행X
        // target 왼쪽과 검사: left[2] == target[6]인지 
        if (left[2] == target[6]) 회전수행;
        // target 오른쪽과 검사: right[6] == target[2]인지

        // 왼쪽 다 끝내고 오른쪽 봐야 되는거아냐? 재귀로밖에 못하는거아녀? 
        // -1이 아닐 때만 사용 
        if (right[6] == target[2]) 회전수행;

        // 왼쪽이든 오른쪽이든 회전수행 한 후 상태 배열 업데이트

        // 톱니바퀴 '언제' 업데이트가 핵심인 것 같은데????????
      }


      // 왼쪽/오른쪽 연쇄적으로 일어나야 함 > 밀고 갈 방향 설정

      // 반시계방향 회전: 원소 1칸 왼쪽으로 밀기, 시계방향: 원소 1칸 오른쪽으로 밀기
      // 차라리 큐로 해볼까?

      // 1회전의 종료 조건 > 톱니바퀴 1/4번까지 다 보거나 left or right와 극이 같은 경우

      // target + 양옆 보고 > 다음 것도 돌 수 있으면 > target 이동시켜서 다시 검ㅅ ㅏ
      // left 가야하는 signal > left 계속 이동시키면서 보기
      // right > right 계속 이동시키며 보기 

      // 회전이 연쇄적으로 일어나고 종료 조건 명확하니까 재귀로 쓸 수 있을 것 같은데 

    } // 회전 완료

    // 점수 계산 > 각 바퀴 0번째 idx만 보기 (가중치 다름)
    int score = 0;
    // 각 행별로 0번째 원소에 값 곱하기 
    // 0행은 2^0, 1행은 2^1, 2행은 2^2, 3행은 2^3 점수 곱하기 > 비트시프트 연산 
    for (int i = 0; i < 4; i++){
      // 어차피 0 아니면 1
      score += wheels[i][0] * (1 << i);
    }
    System.out.println(score);

    sc.close();

  } // main
}
