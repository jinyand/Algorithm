# [정렬] K번째수
* 2020/07/27

### **문제 설명**

배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

1. array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
2. 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
3. 2에서 나온 배열의 3번째 숫자는 5입니다.

배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

### 제한사항

- array의 길이는 1 이상 100 이하입니다.
- array의 각 원소는 1 이상 100 이하입니다.
- commands의 길이는 1 이상 50 이하입니다.
- commands의 각 원소는 길이가 3입니다.

### 입출력 예

array : [1, 5, 2, 6, 3, 7, 4]  
commands : [[2, 5, 3], [4, 4, 1], [1, 7, 3]]  
return : [5, 6, 3]  

### 풀이

```java
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
```
* Arrays.copyOfRange(원본 배열, 복사할 시작 인덱스, 복사할 끝 인덱스)
* Arrays.sort() : 배열을 오름차순으로 정렬


### 다른 풀이

start, end, pos 값을 commands[i][0] .. [2] 로 각각 지정해주는 방법  
→ answer[i] = temp[pos] 로 사용할 수 있음
