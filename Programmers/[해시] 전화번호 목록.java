import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> map = new HashMap<String, String>();
        
        for (String number : phone_book) {
	// phone_book 배열의 값들을 해시맵에 key로 저장
            map.put(number, "default");
        }
        
        for (String number : phone_book) {
            for(int i = 0; i < number.length(); i++) {
                if(map.containsKey(number.substring(0, i))) {
                    answer = false;
                }
            }
        }
        
        return answer;
    }
}