import java.util.*;

class Solution {
    boolean solution(String s) {
        // boolean answer = true;
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push('(');
            }
            else {
                if(stack.empty()) return false;
                else {
                    stack.pop(); // 들어있던 ( 를 pop
                }
            }
        }
        
        if(stack.empty()) { return true; }
        else { return false; }

    }
}