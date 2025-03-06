import java.util.Arrays;

public class 퀵정렬1_hoare {
	// hoare partition
	static int[] arr = {7, 5, 6, 8, 1, 2, 3, 39};
	static int N = arr.length;
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));
		quickSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	static void quickSort(int start, int end) {
		if (start < end) {
			int pivot = partition(start, end);
			// 절반 잘라서 재귀
			quickSort(start, pivot-1);
			quickSort(pivot+1, end);
		}
	}
	
	static int partition (int start, int end) {
		int pivot = arr[start]; // 시작 위치를 0번째 idx로 
		int L = start + 1; // pivot의 바로 다음 요소
		int R = end; // 가장 마지막 요소 
		
		while (L <= R){
			// L은 pivot보다 큰 값 찾을 때까지 이동
			// L <= R 또 안 써주면 에러남! 
			while (L <= R && arr[L] <= pivot) L++;
			// R은 pivot보다 작거나 같은 값 찾을 때까지 이동 
			while (arr[R] > pivot) R--;
			
			// 교차 아직 안 되면
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		
		// 마지막에 R, pivot 위치 교환
		int tmp = arr[start]; 
		arr[start] = arr[R];
		arr[R] = tmp;
		
		return R;
	}
}
