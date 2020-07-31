import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        Collection<Integer> values = map.values();
        for(Integer value : values) {
            // + 1 : 옷을 안입는 경우
            answer *= (value + 1);
        }
        
        answer--;

        return answer;
    }
}