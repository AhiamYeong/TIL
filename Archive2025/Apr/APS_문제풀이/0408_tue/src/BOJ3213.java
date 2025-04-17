/* 1/4, 1/2, 3/4중 하나
 * 최소 몇 개 해야 최소로 가능? -> 큰 것부터 쳐내보자 
 * 조건: 조각을 나눠서 먹으면 안 되고 한 번에 먹어야한대
 * 3/4 + 1/4는 1판으로 가능, 3/4와 다른 조합은 1판으로 불가능  
 * 1/2 + 2 * (1/4)는 1판으로 가능 -> 개수 매칭해보기
 * */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ3213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 친구 수
		sc.nextLine();
		// 친구들 먹을 수 있는 양
		double[] amount = new double[N];
		
		Map<Double, Integer> map = new HashMap<>();
		
		double max = -1;
		for (int i = 0; i < N; i++) {
			String input = sc.nextLine();
			String[] parts = input.split("/");
			
			double a = Integer.parseInt(parts[0]);
			double b = Integer.parseInt(parts[1]);
			
			double val = a / b;
			
			// 개수 세기 
			if (map.containsKey(val)) {
				map.put(val, map.get(val) + 1);
			} else {
				map.put(val, 1);
			}
			
		}
		Arrays.sort(amount);
		// 1 3/4 + 1/4는 1판 가능 
		
		double sum = 0;
		for (double pizza: amount) {
			System.out.println(pizza);
			sum += pizza;
		}
		System.out.println(sum);
		
		
		sc.close();
	}
}
