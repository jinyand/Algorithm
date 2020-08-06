import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a_count = 0;
        int b_count = 0;
        int c_count = 0;
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i%a.length]) a_count++;
            if(answers[i] == b[i%b.length]) b_count++;
            if(answers[i] == c[i%c.length]) c_count++;
        }

        int ab = (a_count > b_count) ? a_count : b_count;
        int max = (c_count > ab) ? c_count : ab;
        
        List<Integer> list = new ArrayList<>();
        if(max == a_count) list.add(1);
        if(max == b_count) list.add(2);
        if(max == c_count) list.add(3);
        
        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}