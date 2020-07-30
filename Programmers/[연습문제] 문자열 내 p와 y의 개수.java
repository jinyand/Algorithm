import java.util.*;

class Solution {
    boolean solution(String s) {

        int psum = 0;
        int ysum = 0;
        char[] temp = s.toUpperCase().toCharArray(); // 한 글자씩 잘라서 배열에 넣음
        
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] == 'P') {
                psum += 1;
            }
            if(temp[i] == 'Y') {
                ysum += 1;
            }
        }
        
        if(psum != 0 || ysum != 0) {
            if(psum == ysum) return true;
        }
        
        return false;
    }
}