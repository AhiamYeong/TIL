
public class LinkedList8_삽입정렬 {
	public static void main(String[] args) {
		int[] data = {69, 10, 30, 2, 16, 8, 31, 22};
		//삽입정렬
		// 0번째 요소는 이미 정렬집합에 포함되었다고 생각하기
		// 1번째부터 끝까지 정렬 돌리는걸로 생각하기
		for (int i = 1; i < data.length; i++) {
			int j; // 정렬 포인트
			int key = data[i]; // 정렬하고싶은 데이터 
			
			for (j = i-1; j >= 0 && key < data[j]; j--) {
				// 뒤로 밀어버리기
				data[j+1] = data[j];
				// 정렬하는 값(j)는 key로 이미 갖고 있음 
			}
			data[j+1] = key; // 1회차) j=-1이 되었음 
		}
	}
}
