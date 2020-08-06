import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList<Integer>();
        
        // queue에 들어갈 값 : 기능 개발에 걸리는 일 수
        for(int i = 0; i < progresses.length; i++) {
            int period = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) {
                period++;
            }
            queue.add(period); // 7, 3, 9
        }
        
        List<Integer> result = new ArrayList<Integer>();
        
        while(!queue.isEmpty()) {
            int count = 1;
            int baepo = queue.poll();
            while(!queue.isEmpty() && baepo >= queue.peek()) {
                queue.poll();
                count++;
            }
            result.add(count);
        }
        
        answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}