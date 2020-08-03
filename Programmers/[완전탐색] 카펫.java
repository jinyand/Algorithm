class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 전체 brown 개수 : 2(x + y) - 4
        // 전체 yellow 개수 : (x-2) * (y-2)
        // 가로 x와 세로 y는 brown + yellow 의 약수
        
        int sum = brown + yellow;
        
        for(int i = 1; i <= sum; i++) {
            
            int width = i;
            int height = (sum % i == 0) ? sum / i : sum / i + 1;
            
            if(brown == 2*width + 2*height - 4) {
                answer[0] = width;
                answer[1] = height;
            }
            
        }
        
        return answer;
    }
}