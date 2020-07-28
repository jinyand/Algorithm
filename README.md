# :balloon: Algorithm :balloon:

- [HashMap](#mag-hash-map)

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
