# :balloon: Algorithm :balloon:

### 알고리즘
- [HashMap](#mag-hash-map)
- [Stack](#mag-stack)
- [Queue](#mag-queue)
- [Dynamic Programming](#mag-dynamic-programming)

### JAVA
- [ArrayList](#pushpin-arraylist)
- [Comparable / Comparator](#pushpin-comparable)

---

### :mag: Hash Map

* HashMap은 Map의 일종으로 key와 value의 쌍으로 이루어진 데이터를 보관한다.
* null key와 null value를 모두 허용한다.
* 내부적으로 데이터에 접근할 때 동기화를 보장하지 않는다.
* 데이터의 순서를 보장하지 않는다.
* 중복된 key값을 허용하진 않지만, 중복된 값은 가질 수 있다.

#### :heavy_check_mark: 사용법
- HashMap 생성
  ```java
  import java.util.HashMap;
  HashMap<String , Integer> map = new HashMap<String , Integer>();
  ```

* `put(K key, V value)`
  * 각 key, value 타입에 맞게 선언하면 key-value 관계로 HashMap에 저장된다.
* `HashMap.putAll(Map m)`
  * 인자로 전달된 하나의 Map m에 대한 데이터를 저장하여 다른 Map에 추가한다.
* `get(K key)`
  * 인자로 전달된 key에 해당하는 value를 리턴해준다. key가 존재하지 않으면 null을 리턴
* `remove(K key)`
  * 하나의 key를 입력하여 데이터를 삭제한다.
* `size()`
  * HashMap에 저장된 엘리먼트의 개수를 반환한다.
* `clear()`
  * HashMap의 모든 데이터를 삭제한다.
* `isEmpty()`
  * HashMap의 데이터가 비어있다면 true를 리턴하고, 아니라면 false를 리턴한다.
* `keySet()`
  * HashMap에 저장된 key들을 Set 객체로 리턴해준다.
* `values()`
  * HashMap에 저장된 value들을 Collection 객체로 리턴해준다.
* `containsKey(Object Key)`
  * HashMap에 인자로 전달된 key가 존재하면 true를 리턴하고, 아니라면 false를 리턴한다.
* `containsValue(Object Value)`
  * HashMap에 인자로 전달된 value가 존재하면 true를 리턴하고, 아니라면 false를 리턴한다.
* `HashMap.entrySet()`
  * HashMap에 저장된 Key, Value값을 엔트리(키와 값을 결합)의 형태로 Set에 저장하여 리턴한다.
* `replace(K key, V value)`
  * 인자로 전달된 key의 value를 인자로 전달된 value로 교체한다. 교체되어 삭제되는 value가 리턴되며, 존재하지 않는 key가 인자로 전달되면 null이 리턴됩니다.
  
---
### :mag: Stack
- 스택 : LIFO 구조 - 마지막에 저장한 데이터를 가장 먼저 꺼냄  
ex) 0, 1, 2 순서로 넣었다면(push) 꺼낼 때는(pop) 2, 1, 0 순서로 꺼냄

- Stack 생성
  ```java
  Stack<Element> stack = new Stack<>();
  ```

< 메소드 >
* `boolean empty()`
  * 해당 스택이 비어 있으면 true를, 비어 있지 않으면 false를 반환함.
* `E peek()`
  * 해당 스택의 제일 상단에 있는(제일 마지막으로 저장된) 요소를 반환함.
* `E pop()`
  * 해당 스택의 제일 상단에 있는(제일 마지막으로 저장된) 요소를 반환하고, 해당 요소를 스택에서 제거함.
* `E push(E item)`
  * 해당 스택의 제일 상단에 전달된 요소를 삽입함.
* `int search(Object o)`
  * 해당 스택에서 전달된 객체가 존재하는 위치의 인덱스를 반환함. 이때 인덱스는 제일 상단에 있는(제일 마지막으로 저장된) 요소의 위치부터 0이 아닌 1부터 시작함.

- 예제
  ```java
  Stack<Integer> stack = new Stack<>();
  for (int i = 0; i < 5; i++) {
      stack.push(i + 1);
      System.out.println(stack.peek());
  } // 1, 2, 3, 4, 5 가 현재 들어가 있음
  stack.pop(); // 1, 2, 3, 4
  System.out.println(stack.peek()); // 4
  System.out.println(stack.search(1)); // 4
  // 1을 search할 경우 4번째에 위치해있으므로 4를 반환
  System.out.println(stack.empty()); // false
  ```

---
### :mag: Queue
- 큐 : FIFO 구조 - 처음에 저장한 데이터를 가장 먼저 꺼냄  
ex) 0, 1, 2 순서로 넣었다면(offer) 꺼낼 때는(poll) 0, 1, 2 순서로 꺼냄

- Queue 생성
  ```java
  Queue<V> queue = new ArrayDeque<>();
  Queue<V> queue = new LinkedList<>();
  ```

`Queue`는 `Interface`이기 때문에, 위와같이 해당 인터페이스를 구현하는 두 가지 클래스로 생성하여, 저장할 수 있다.
이론적으로는 연결리스트의 특성을 갖는 `LinekdList`가 효율이 좋아야 하지만, 실제로는 `ArrayDeque`이 속도가 조금 더 빠르다고 한다.

< 메소드 >
* `boolean add(E e)`
  * 해당 큐의 맨 뒤에 전달된 요소를 삽입함. 만약 삽입에 성공하면 true를 반환하고, 큐에 여유 공간이 없어 삽입에 실패하면 IllegalStateException을 발생시킴.
* `E element()`
  * 해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환함.
* `boolean offer(E e)`
  * 해당 큐의 맨 뒤에 전달된 요소를 삽입함.
* `E peek()`
  * 해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환함. 만약 큐가 비어있으면 null을 반환함.
* `E poll()`
  * 해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환하고, 해당 요소를 큐에서 제거함. 만약 큐가 비어있으면 null을 반환함.
* `E remove()`
  * 해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 제거함.
* `E clear()`
  * 큐에 저장된 모든 데이터를 삭제하고 큐를 초기화함.

### ➕ 우선순위 큐

우선순위 큐(Priority Queue)는 들어간 순서에 상관없이 일정한 규칙에 따라 우선순위를 선정하고, 우선순위가 가장 높은 데이터가 가장 먼저 나오게 된다.

```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
```

→ 기본적으로 낮은 숫자부터 큰 숫자까지 오름차순으로 정렬됨  
→ `Collections.reversOrder()` 로 생성하면 최대값 기준으로 우선순위가 정렬됨

---

### :mag: Dynamic Programming
다이나믹 프로그래밍(Dynamic Programming) : 동적 계획법(DP) 이란

- 복잡한 문제를 여러 개의 작은 부분 문제(Sub-Problem)로 나누어 해결하는 방법
- 한번의 계산을 통해, 비효율적 계산을 줄인다는 개념
- 대표적인 예시 : 피보나치 수열

#### Memoization

- 반복되는 결과를 메모리에 저장해서, 중복호출 되었을 때 한 번 더 계산하지 않고 메모리에 저장해둔 것을 가져와서 재활용 하는 것

#### DP의 2가지 구현 방식

1. **Top-Down**
    - 뜻 그대로 큰 문제 → 작은 부분문제로 푸는 것
    - `F(n) = F(n-1) + F(n-2)`  
    → F(n)을 구하기 위해서는 F(n-1)과 F(n-2)를 구해야 한다.
    - 장단점 : 재귀함수를 통해 구현되기 때문에 함수 호출에 대한 오버헤드가 발생하지만, Memoization을 잘 활용하면 Botton-Up보다 훨씬 속도가 빠르다.
2. **Botton-Up**
    - 작은 부분문제를 미리 계산해두고, 이 문제들을 모아 큰 문제를 해결

    ```java
    DP[1] = 1;
    DP[2] = 1;
     
    for(int i=3;i<N;i++)
        DP[i] = DP[i-2] + DP[i-1];
    ```

    → F(n-1)과 F(n-2)가 있으면 F(n)을 구할 수 있다.

    - 장단점 : 큰 문제를 해결하기 위해 모든 부분문제를 해결해야하지만, for문으로 구현되므로 시간 및 메모리의 최적화가 쉽다.

---
### :pushpin: ArrayList
- List 인터페이스를 상속받은 클래스, Collection 인터페이스를 구현한 것
- 크기가 가변적으로 변하는 선형리스트, 길이 지정 x, 자유롭게 확장 가능
- 일반적인 배열과 같은 순차리스트이며 인덱스로 내부의 객체를 관리한다는점등이 유사하지만 한번 생성되면 크기가 변하지 않는 배열과는 달리 ArrayList는 객체들이 추가되어 저장 용량(capacity)을 초과한다면 자동으로 부족한 크기만큼 저장 용량(capacity)이 늘어난다

1. ArrayList 생성

    ```java
    ArrayList list = new ArrayList();//타입 미설정 Object로 선언된다.
    ArrayList<Student> members = new ArrayList<Student>();//타입설정 Student객체만 사용가능
    ArrayList<Integer> num = new ArrayList<Integer>();//타입설정 int타입만 사용가능
    ArrayList<Integer> num2 = new ArrayList<>();//new에서 타입 파라미터 생략가능
    ArrayList<Integer> num3 = new ArrayList<Integer>(10);//초기 용량(capacity)지정
    ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,2,3));//생성시 값추가
    ```

2. ArrayList 값 추가

    ```java
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(3); //값 추가
    list.add(null); //null값도 add가능
    list.add(1,10); //index 1뒤에 10 삽입
    ```

    index를 생략하면 ArrayList 맨 뒤에 데이터가 추가되며, index중간에 값을 추가하면 해당 인덱스부터 마지막 인덱스까지 모두 1씩 뒤로 밀려난다.

  <img src="https://user-images.githubusercontent.com/38918396/90011237-334fb900-dcdc-11ea-8099-d9f02237eed1.png" width="600" height="200">

3. ArrayList 값 삭제  
  `list.remove(1)` : index 1 제거  
  `list.clear()` : 모든 값 제거

4. ArrayList 크기 구하기  
`list.size()`

5. ArrayList 값 출력  
`list.get(0)` : 0번째 index 출력

    ```java
    for(Integer i : list) { //for문을 통한 전체출력
        System.out.println(i);
    }
    ```

6. ArrayList 값 검색  
  `list.contains(1)` : list에 1이 있는지 검색 → true or false  
  `list.indexOf(1)` : 1이 있는 index 반환 → 없으면 -1

### ❓ List와 ArrayList의 차이

간단히 설명하면 리스트는 인터페이스,  
ArrayList, LinkedList 등은 List에 상속된 클래스들

- List list = new ArrayList();  
→ 도형 list = new 정사각형();
- ArrayList list = new ArrayList();  
→ 정사각형 list = new 정사각형();

---

### :pushpin: Comparable

- 정의 : 정렬 수행시 기본적으로 적용되는 정렬 기준이 되는 메서드를 정의해 놓는 **인터페이스**
- 사용법 : Comparable 인터페이스를 implements 한 뒤, 내부에 있는 compareTo 메서드를 원하는 정렬 기준대로 구현하여 사용한다.
- 패키지 : java.lang.Comparable
- 자바에서 제공되는 정렬이 가능한 클래스들은 모두 Comparable 인터페이스를 구현하고 있으며, 정렬 시에 Comparable의 구현 내용에 맞춰 정렬된다.
    ```java
    import java.lang.Comparable;

    class Student implements Comparable<Student> {
      @Override
      public int compareTo(Student anotherStudent) { //오버라이딩
        // 원하는 정렬 기준대로 구현
        // TODO Auto-generated method stub
        return 0;
      }
    }
    ```

### :pushpin: Comparator

- 정의 : 정렬 가능한 클래스(= Comparable이 구현된 클래스) 들의 기본 정렬 기준과는 다른 방식으로 정렬하고 싶을 때 사용하는 **클래스**
- 사용법 : Comparator 클래스를 생성하여, 내부에 compare 메서드를 원하는 정렬 기준대로 구현하여 사용한다.
- 패키지 : java.util.Comparator
- 주로 익명클래스(new Comparator(){...})로 사용되며, 기본적으로 오름차순이 정렬 기준인 것을 내림차순으로 정렬하는 등의 용도로 사용된다.
    ```java
    Arrays.sort(student, new Comparator<Student>(){ 
      //익명클래스 사용, 제너릭스 주의
      @Override
      public int compare(Student s1, Student s2) {
        // TODO Auto-generated method stub
        return 0;
      }
    });
    ```
