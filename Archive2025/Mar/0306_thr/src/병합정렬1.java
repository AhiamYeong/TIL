import java.util.Arrays;

public class 병합정렬1 {
	static int[] arr = {7, 5, 6, 8, 1, 2, 3, 39};
	static int N = arr.length;
	
	// 임시공간 필요
	static int[] tmp = new int[N];
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(arr));
		mergeSort(0, N-1);
		System.out.println(Arrays.toString(arr));
	}
	
	// start, end 2pointer
	static void mergeSort(int start, int end) {
		if (start >= end) return;
		int mid = (start + end) / 2;
		mergeSort(start, mid);
		mergeSort(mid+1, end);
		merge(start, mid, end);
//		
//		if (start < end) {
//			int mid = (start + end) / 2;
//			mergeSort(start, mid);
//			mergeSort(mid+1, end);
//			// 병합 메소드 호출
//			
//		}
	}
	
	static void merge(int start, int mid, int end) {
		// 정렬하고자 하는 각 부분 배열들의 시작위치 초기화
		int L = start;
		int R = mid+1; 
		
		int idx = start; // 임시배열의 idx
		// 임시배열은 정렬하고 싶은 값만큼 사용할 것이므로 
		
		// 좌/우 비교해서 
		while (L <= mid && R <= end) {
			if (arr[L] <= arr[R]) {
				// idx는 1개 증가시키기, arr의 왼쪽부터 정렬해서 증가시킥 
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		} // 한 쪽 구간 끝
		
		// 다른 어느 한 구간은 남게 되어있음 -> 내부로 넣어도 되기는 함
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= end; i++) {
				tmp[idx++] = arr[i];
			}
		} // 남은 구간 털기 
		
		// 원본 배열에 덮기
		for (int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		} 
	}
}
