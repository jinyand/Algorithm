# [연습문제] N개의 최소공배수

* 2020/10/11

### **문제 설명**

두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

### 제한 사항

- arr은 길이 1이상, 15이하인 배열입니다.
- arr의 원소는 100 이하인 자연수입니다.

### 풀이

```java
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int temp = 0;
        
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i+1] % arr[i] == 0) {
                continue;
            } else {
                for(int j = 1; j < arr[i]; j++) {
                    if(arr[i] % j == 0 && arr[i+1] % j == 0) {
                        temp = (arr[i] * arr[i+1]) / j;
                    }
                }
                arr[i+1] = temp;
            }
        }
        answer = arr[arr.length-1];
        return answer;
    }
}
```

- `[연습문제] 최대공약수와 최소공약수` 문제를 참고해서 푼 문제이다.
- 배열의 시작부터 두 수를 비교해 나가면서 최소공배수를 구하고, 또 그 다음수와의 최소공배수를 구하는 방식을 반복하여 풀었다.
- temp에는 두 수의 최소공배수값이 들어가는데, 이를 다시 배열에 넣어주어 계산 작업을 반복하는 식이다.
