import java.util.Scanner;

public class BOJ1806 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 연속된 수들의 부분합 중 그 합이 S 이상인 것 중, 가장 짧은 것의 길이 구하기 
    int N = sc.nextInt(); // 길이 N
    int[] numbers = new int[N];

    long S = sc.nextLong();
    for (int i = 0; i < N; i++){
      numbers[i] = sc.nextInt(); 
    }

    int len = 0; // 최소 길이 

    int left = 0;
    int right = 0;
    int sum = 0;

    // 합이 S 이상일 때까지 end 증가시키다
    // s 이상이 된 순간 start 옮기고, end 옮기기 
    while (left <= right){
      if (numbers[left] )
    }

    System.out.println(len);

    sc.close();
  }
}
