import java.util.*;
public class t {
  // 후보 키: 모든 튜플에 대해 유일하게 하나 & 최소값 
  public static void main(String[] args) {
  
    String[][] relation = new String[4][4];
        int answer = 0; // 유일 '학번' or (이름, 전공)
        
        int row = relation.length; // 행 수 (튜플)
        int col = relation[0].length; // 열 수 (속성)
        
        // 테케 뭐가 나올 지 모름
        // 1. 모든 1개 열에서 중복 있는지 검사하기
        // 컬럼 : 개수 
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < row ; i++){
            for (int j = 0; j < col; j++){
                // 없으면 새로 추가
                if(!map.containsKey(relation[i][j])){
                    map.put(relation[i][j], 1);
                } else {
                    map.put(relation[i][j], map.get(relation[i][j]+1));
                }
            }
        } // 개수 세기 
        
        int cnt = 0;
        
        // 1인 값만 찾아내기 > 유일하므로 전부 가능 
        for (String key : map.keySet()){
            if (map.get(key) == 1) cnt++;
        }
        
        answer += cnt;
        
        // 2. 만약 중복 있는 열이 있다면, 2개 조합? 
        
        
    }
}
