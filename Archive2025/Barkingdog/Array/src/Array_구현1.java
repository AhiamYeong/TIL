import java.util.Arrays;

public class Array_구현1 {
	public static void main(String[] args) {
		int[] arr = {1, 10, 5, 3, 2, 9, 8};
		arr = insert(3, 101, arr);
		printArr(arr);
		System.out.println();
		arr = insert(5, 100, arr);
		printArr(arr);
		System.out.println();
		arr = erase(0, arr);
		printArr(arr);
		System.out.println();
		arr = erase(3, arr);
		printArr(arr);
	}
	
	public static int[] insert(int idx, int num, int[] arr) {
		
		int[] newArr = Arrays.copyOf(arr, arr.length + 1);

		// idx 이후 값 전부 복사
		for (int i = 0 ; i < idx; i++) {
			newArr[i] = arr[i]; 
		} // input
		newArr[idx] = num;
		// 이후도 복사
		for (int i = idx; i < arr.length; i++) {
			newArr[i+1] = arr[i];
		}
		return newArr;
	} // insert
	
	public static int[] erase(int idx, int[] arr) {
		for (int i = idx; i < arr.length - 1; i++) {
			arr[i] = arr[i+1];
		}
		// 마지막 원소는 비게 됨 
		int[] newArr = Arrays.copyOfRange(arr, 0, arr.length-1);
		return newArr;
	} // erase
	
	public static void printArr(int[] arr) {
		for (int i : arr) {
			System.out.print(i + " ");
		}
	} // print
}
