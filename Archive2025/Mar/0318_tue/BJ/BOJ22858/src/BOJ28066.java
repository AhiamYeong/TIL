
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 재귀로 풀면 되지 않을까? 막연하게 생각 듦 
시계방향으로 K마리 청설모 선택, 1번째만 살려줌 > idx기준으로 덧셈연산, idx는 제거에서 제외
매 제거 회차마다 idx 갱신 / cnt 검사해야 함 
 */

public class BOJ28066 {
  static int N;
  static int K;

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt(); // 청설모 총 수
    K = sc.nextInt(); // 회차마다 청설모 제거할 수
    
    // 청설모 리스트를 ... 뭘로 받을까?
    // 제일 만만한 arraylist > 직접 제거 수행
    List<Integer> squirrel = new ArrayList<>();
    // input
    for (int i = 1; i <= N; i++){
      squirrel.add(i);
    }
    System.out.println(squirrel);

  
    // 첫번째는 살려줘야 하므로
    int idx = 1; 
    while(true){
      // 매 회차마다 종료 조건 검사
      if (squirrel.size() < K) break;
      // idx부터 K개 선택하고, 첫 번째는 남겨주기
      for (int i = idx; i < K; i++){
        squirrel.remove(idx);
      }      

      System.out.println(squirrel + "idx: " + idx);
      // idx 갱신
    }
    // 결과값: 마지막으로 남는 청설모 번호

    sc.close();
  }

  public static void recur(int idx){
    // 종료 조건: 남아있는 청설모가 K마리보다 적을 때


    // 재귀: 
    // 첫 idx 찾기 (인자로 받으면 0부터 시작 )

    // idx + K까지 청설모 제거 (idx 제외)
    

    // 매 제거 회차마다 idx 갱신 / cnt 검사

    // 다음 재귀로 go


  }
}
