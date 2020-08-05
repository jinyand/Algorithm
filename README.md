# :balloon: Algorithm :balloon:

- [HashMap](#mag-hash-map)
- [Stack](#mag-stack)
- [Queue](#mag-queue)

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
