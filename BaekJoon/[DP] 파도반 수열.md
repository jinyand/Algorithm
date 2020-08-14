# [DP] 파도반 수열

* 2020/08/14
* 9461번

### 문제

![https://www.acmicpc.net/upload/images/pandovan.png](https://www.acmicpc.net/upload/images/pandovan.png)

오른쪽 그림과 같이 삼각형이 나선 모양으로 놓여져 있다. 첫 삼각형은 정삼각형으로 변의 길이는 1이다. 그 다음에는 다음과 같은 과정으로 정삼각형을 계속 추가한다. 나선에서 가장 긴 변의 길이를 k라 했을 때, 그 변에 길이가 k인 정삼각형을 추가한다.

파도반 수열 P(N)은 나선에 있는 정삼각형의 변의 길이이다. P(1)부터 P(10)까지 첫 10개 숫자는 1, 1, 1, 2, 2, 3, 4, 5, 7, 9이다.

N이 주어졌을 때, P(N)을 구하는 프로그램을 작성하시오.

### 입력

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. (1 ≤ N ≤ 100)

### 출력

각 테스트 케이스마다 P(N)을 출력한다.

### 예제 입력 1

2  
6  
12

### 예제 출력 1

3  
16

### 풀이

```java
import java.util.*;

public class Main {
    public static void main(String args[]) {
      
        long dp[] = new long[101];
        Scanner sc = new Scanner(System.in);
        
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        int T = sc.nextInt();
        
        for(int i = 0; i < T; i++) {
            int n = sc.nextInt();
            
            for(int j = 4; j <= n; j++) {
                dp[j] = dp[j-2] + dp[j-3];
            }
            
            System.out.println(dp[n]);
        }
    }
}
```

- P(1) 부터 P(10)까지의 수를 살펴보면 규칙성을 찾을 수 있다.  
→ P(n) = P(n-2) + P(n-3)  
→ 다른 풀이를 보니 P(n) = P(n-1) + P(n-5) 의 규칙도 성립한다고 한다.
- 주의할 점 : dp 문제에서 초반의 수가 낮다고해서 무작정 int로 선언하는 것이 아닌, 뒤의 수가 커질 것을 고려해서 long으로 선언해야한다는 것
- 또한 dp는 0 ~100까지 이므로 배열의 크기를 101로 선언해주어야 한다.
