# [DP] 가장 긴 증가하는 부분 수열

* 2020/10/07
* 11053번

### 문제

수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {**10**, **20**, 10, **30**, 20, **50**} 이고, 길이는 4이다.

### 입력

첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

### 출력

첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.

### 예제 입력 1

```
6
10 20 10 30 20 50
```

### 예제 출력 1

```
4
```

### 풀이

```java
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] num = new int[N+1];
    	int[] dp = new int[N+1];
    	
    	dp[1] = 1;
    	
    	for(int i = 1; i <= N; i++) {
    		num[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i = 2; i <= N; i++) {
    		dp[i] = 1;
    		for(int j = 1; j < i; j++) {
    			if(num[j] < num[i] && dp[i] <= dp[j]) {
    				dp[i] = dp[j] + 1;
    			}
    		}
    	}
    	
    	int max = 0;
    	for(int i : dp) {
    		max = Math.max(max, i);
    	}
    	
    	System.out.println(max);
    	
    }
}
```

- 처음 실패했던 코드 : 예를 들어 10 50 20 30 40 의 경우 정답은 4가 되어야하는데, 나는 일시적인 숫자 비교를 사용하여 10 50 → 답이 2가 되게 비교하는 방식을 사용하였다. 좀 더 dp에 가까운 방식을 생각해야했다.
- 따라서 다른 풀이를 조금 참고하여 풀어보았다.  
dp 배열은 길이를 나타낸다. 또한 for문을 보면, j 는 i 보다 작은 값들을 차례대로 순회한다.  
→ 이게 키포인트라고 생각한다.
- 표를 그려서 푸니까 훨씬 이해하기 쉬웠다.
