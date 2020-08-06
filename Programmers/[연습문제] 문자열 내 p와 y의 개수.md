# [연습문제] 문자열 내 p와 y의 개수

* 2020/07/30

### **문제 설명**

대문자와 소문자가 섞여있는 문자열 s가 주어집니다. s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False를 return 하는 solution를 완성하세요. 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다. 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.

예를 들어 s가 pPoooyY면 true를 return하고 Pyy라면 false를 return합니다.

### 제한사항

- 문자열 s의 길이 : 50 이하의 자연수
- 문자열 s는 알파벳으로만 이루어져 있습니다.

### 입출력 예

|s|answer|
|------|---|
|pPoooyY|true|
|Pyy|false|

### 풀이

```java
import java.util.*;

class Solution {
    boolean solution(String s) {

        int psum = 0;
        int ysum = 0;
        char[] temp = s.toUpperCase().toCharArray(); 
				// 한 글자씩 잘라서 배열에 넣음
        
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
```
* toUpperCase() : 대소문자 구분을 위해 대문자로 통일
* toCharArray() : 문자열을 한 글자씩 잘라서 배열에 넣어주었다. (문자열을 문자배열로 변환)
* P의 개수와 Y의 개수를 세어 그 값이 동일하면 true를 리턴하도록 함

### 다른 풀이

- 람다식을 사용하는 방법
- psum ysum 이 아닌 변수를 하나만 가져가는 방법도 있다.  
p일 때 +1, y일 때 -1 해서 최종 count가 0이면 true로 리턴
