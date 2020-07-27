import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            // 자른 후 정렬한 배열
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            // 정렬한 배열(temp) 에서 n번째 값 추출
            answer[i] = temp[commands[i][2]-1];
        }
        
        return answer;
    }
}