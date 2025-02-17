import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SWEA7102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 1-N개
			int M = sc.nextInt(); // 1-M개
			
			// 등장할 확률이 가장 높은 숫자?
			// 모든 카드 나올 수 있는 경우의 수 다 보고
			// 특정값 나오는 경우의 수 / 전체 경우의 수
			// i, j 모든 경우에 대하여
			// i+j 결과값: 등장 횟수 기록
			// 등장 횟수가 가장 많은 것들 출력하기 (다수 가능)
			
			int res = 0; // 결과값 담기
			Map<Integer, Integer> pair = new HashMap<Integer, Integer>();
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					res = i + j;
					// 근데 i, j가 중복으로 나올 수 있자나 
					// map에 없으면 저장, 있으면 count up
					if (pair.containsKey(res)) pair.put(res, pair.get(res) + 1);
					else {
						pair.put(res, 1);
					}
				}
			}
			// pair 돌며 max값 찾기
			int max = 0;
			for (int a : pair.values()) {
				if (max < a) max = a;
			}

            // 쌍 순회하며 max로 값 가지는 모든 key 출력
			// entryset 사용 -> Map.Entry 객체 통해 key / value에 접근 가능
            System.out.print("#" + tc + " ");
			for (Map.Entry<Integer, Integer> entry : pair.entrySet()) {
				if (entry.getValue().equals(max))
					System.out.print(entry.getKey() + " ");
			}
            System.out.println();
			
//			System.out.println(pair);
		} // tc
		sc.close();
	}
}
