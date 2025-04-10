/* 문제 조건 -> 조각 쪼개서는 못 먹음 / 최소 1판으로 정리
 * 3/4 + 1/4 가능, 3/4 + 1/2 불가능 
 * 1/2 + 1/2 가능, 1/2 + 1/2 불가능
 * 1/4는 어느 조건과도 가능 
 * 큰 것부터: 3/4먼저 각 1판씩 배정 후, 개수 맞으면 cnt up
 * */ 
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ3213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		
		// map으로 각 조각별 인원수 카운트
		Map<Double, Integer> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			String input = sc.nextLine();
			String[] inputs = input.split("/");
			System.out.println(Arrays.toString(inputs));
			double val = (double) Integer.parseInt(inputs[0]) / Integer.parseInt(inputs[1]);
			
			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
			// 개수 저장 
		}
		
		System.out.println(map);
		
		// 큰 피자부터 치워보기 
		int pizzas = 0;
		// 3/4 개수만큼 1판 먼저 할당
		pizzas += map.get(0.75);

		// 1/2 > 못 끼워넣음
		// 0.5 짝수개일 때: 두개씩 묶어서 1판 가능 
		if (map.get(0.5) % 2 == 0) {
			pizzas += map.get(0.5) / 2;
		}
		// 0.5 홀수개일 때: 2개 이상이면 1판가넝 미만이면 불가넝
		else {
			if (map.get(0.5) >= 2) pizzas += (map.get(0.5) / 2) + 1;
			else pizzas += 1;
		}
		
		// 1/4: 3/4 & 1/2에 끼워넣기
		 
		
		System.out.println(pizzas);
		
		sc.close();
	}
}
