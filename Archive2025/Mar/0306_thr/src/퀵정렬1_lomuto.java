import java.util.Arrays;

public class 퀵정렬1_lomuto {
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
		int pivot = arr[end]; // 시작 위치를 마지막 idx로 
		int i = start - 1; // 작은 값들의 경계

		for (int j = start; j < end; j++) {
			if (arr[j] <= pivot) {
				int tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
			}
		} // 경계 결정됨 

		int tmp = arr[i+1]; 
		arr[i+1] = arr[end];
		arr[end] = tmp;
		
		return i+1;
	}
}
