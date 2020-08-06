import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for(String person : participant) {
            // 참여자 명단을 순회하면서 각 참가자 이름에 + 1
            // 이미 찾는 key가 있으면(동명이인) 1 + 1 = 2
            map.put(person, map.getOrDefault(person, 0) + 1);
        }

        for(String person : completion) {
            // 완주자들의 value만 -1 해서 value가 0이면 완주했다고 판단
            map.put(person, map.get(person) - 1);
        }

        for (String person : participant) {
            if(map.get(person) != 0) {
                answer = person;
            }
        }

        return answer;
    }
}