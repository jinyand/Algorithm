# [Summer/Winter Coding(~2018)] 스킬트리

* 2020/09/07

### **문제 설명**

선행 스킬이란 어떤 스킬을 배우기 전에 먼저 배워야 하는 스킬을 뜻합니다.

예를 들어 선행 스킬 순서가 `스파크 → 라이트닝 볼트 → 썬더`일때, 썬더를 배우려면 먼저 라이트닝 볼트를 배워야 하고, 라이트닝 볼트를 배우려면 먼저 스파크를 배워야 합니다.

위 순서에 없는 다른 스킬(힐링 등)은 순서에 상관없이 배울 수 있습니다. 따라서 `스파크 → 힐링 → 라이트닝 볼트 → 썬더`와 같은 스킬트리는 가능하지만, `썬더 → 스파크`나 `라이트닝 볼트 → 스파크 → 힐링 → 썬더`와 같은 스킬트리는 불가능합니다.

선행 스킬 순서 skill과 유저들이 만든 스킬트리를 담은 배열 skill_trees가 매개변수로 주어질 때, 가능한 스킬트리 개수를 return 하는 solution 함수를 작성해주세요.

### 제한 조건

- 스킬은 알파벳 대문자로 표기하며, 모든 문자열은 알파벳 대문자로만 이루어져 있습니다.
- 스킬 순서와 스킬트리는 문자열로 표기합니다.
    - 예를 들어, `C → B → D` 라면 "CBD"로 표기합니다
- 선행 스킬 순서 skill의 길이는 1 이상 26 이하이며, 스킬은 중복해 주어지지 않습니다.
- skill_trees는 길이 1 이상 20 이하인 배열입니다.
- skill_trees의 원소는 스킬을 나타내는 문자열입니다.
    - skill_trees의 원소는 길이가 2 이상 26 이하인 문자열이며, 스킬이 중복해 주어지지 않습니다.

### 입출력 예

|skill|skill_trees|return|
|-----|-----|------|
|"CBD"|["BACDE", "CBADF", "AECB", "BDA"]|2|

### 입출력 예 설명

- BACDE: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트립니다.
- CBADF: 가능한 스킬트리입니다.
- AECB: 가능한 스킬트리입니다.
- BDA: B 스킬을 배우기 전에 C 스킬을 먼저 배워야 합니다. 불가능한 스킬트리입니다.

### 풀이

```java
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        int beforeIdx = 0;
        int currentIdx = 0;
        
        for(int i = 0; i < skill_trees.length; i++) {
            beforeIdx = skill_trees[i].indexOf(skill.charAt(0));
            
            for(int j = 1; j < skill.length(); j++) {
                currentIdx = skill_trees[i].indexOf(skill.charAt(j));
                
                if((beforeIdx > currentIdx && currentIdx != -1) || 
                   (beforeIdx == -1 && currentIdx != -1))  {
                    answer--;
                    break;
                }
                
                beforeIdx = currentIdx;
            }
        }

        return answer;
    }
}
```

- 모든 스킬트리의 개수를 answer 변수에 넣어놓고, 스킬트리가 성립하지 않는 경우 -1 해주는 방식을 사용했다.
- indexOf와 charAt을 사용하면 C, B, D가 들어있는 인덱스 값을 찾을 수 있다.
    - beforeIdx = 현재 skill_trees (BACDE) 에서 skill (CBD) 의 첫번째 문자열 C가 들어있는 index = 2
    - currentIdx = 현재 skill_trees (BACDE) 에서 skill (CBD) 의 다음 문자열 B가 들어있는 index = 0
- 여기서 beforeIdx 가 currentIdx 보다 크다면, 순서가 맞지 않는 불가능한 스킬트리이고  
beforeIdx가 스킬트리에 들어있지 않다면 (-1) 마찬가지로 불가능한 스킬트리이므로 answer에서 -1 해준다.
- 이렇게 앞뒤 인덱스 값을 비교하는 과정을 반복한다.
