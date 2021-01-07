## Today I Learned

### 2020-12-28
<details>
  <summary>Bean Pattern</summary>
  
  ---
  ```
  생성자에 전달되는 인자 수가 많을 때 적용이 가능
  단점: 객체의 일관성이 일시적으로 깨질 수 있다.
  ```
  
  > 예시
  ```java
  public class CafeMenu {

    private int coffee = 1;
    private int beverage = 1;
    private int dessert = 0;
    private int bakery = 0;
    private int drinks = 0;

    public CafeMenu(){}

    //setter 
    public void setCoffee(int coffee) {
      this.coffee = coffee;
    }

    public void setBeverage(int beverage) {
      this.beverage = beverage;
    }

    public void setDessert(int dessert) {
      this.dessert = dessert;
    }

    public void setBakery(int bakery) {
      this.bakery = bakery;
    }

    public void setDrinks(int drinks) {
      this.drinks = drinks;
    }
  }
  ```
  ---
</details>

### 2020-12-30
<details>
  <summary>MVC Pattern</summary>
  
  ---
  ![mvc](https://user-images.githubusercontent.com/58816862/103393173-c2af1900-4b64-11eb-9731-7c4d4466dce1.png)
  
  ```
  사용자 인터페이스로부터 비즈니스 로직을 분리하여 애플리케이션의 시각적 요소나 그 이면에서 실행되는 비즈니스 로직을
  서로 영향 없이 쉽게 고칠 수 있는 애플리 케이션을 만들 수 있다.
  ```
  
  ```
  1. Model
  : 모델의 상태에 변화가 있을 때 컨트롤러와 뷰에 이를 통보한다.
    이와 같은 통보를 통해서 뷰는 최신의 결과를 보여줄 수 있고,
    컨트롤러는 모델의 변화에 따른 적용 가능한 명령을 추가·제거·수정할 수 있다.
    어떤 MVC 구현에서는 통보 대신 뷰나 컨트롤러가 직접 모델의 상태를 읽어 오기도 한다.
  ```
  
  ```
  2. View
  : 사용자가 볼 결과물을 생성하기 위해 모델로부터 정보를 얻어 온다.
  ```
  
  ```
  3. Controller
  : 모델에 명령을 보냄으로써 모델의 상태를 변경할 수 있다.
    또, 컨트롤러가 관련된 뷰에 명령을 보냄으로써 모델의 표시 방법을 바꿀 수 있다.
  ```
  ---
</details>

### 2021-01-03
<details>
  <summary>enum</summary>
  
  ---
  ```
  열거형(enumerated type)이라고 부른다.
  열거형은 서로 연관된 상수들의 집합이다고 할 수 있다.
  ```
  
  ```
  1. 코드가 단순해진다.
  2. 인스턴스 생성과 상속을 방지한다.
  3. 키워드 enum을 사용하기 때문에 구현의 의도가 열거임을 분명하게 나타낼 수 있다.
  ```
  
  > 기존의 열거는 복잡함
  ```java
  class Fruit {
    public static final Fruit APPLE = new Fruit();
    public static final Fruit PEACH = new Fruit();
    public static final Fruit BANANA = new Fruit();
  }
  ```
  
  > 문법적으로 지원됨
  ```java
  enum Fruit {
    APPLE, PEACH, BANANA;
  }
  ```
  
  ---
</details>

<details>
  <summary>VO, DAO, DTO, CRUD</summary>
  
  ---
  VO(Value Object)
  ```
  개념
  : DTO와 비슷하지만, read only
  : 관계형데이터베이스의 레코드에 대응되는 자바 클래스
  ```
  ```
  장점
  : 비 서버 측 클라이언트도 네트워크 오버헤드 없이 영속성 데이터에 액세스 할 수 있음
  : Network traffic을 줄일 수 있음
  ```
  ```
  단점
  : 데이터 전달을 위해 가장 효율적인 방법이지만, 클래스의 선언을 위해 많은 코드가 필요 -> 파일 수 증가, 관리 어렵
  ```
  
  DTO(Data Transfer Object)
  ```
  개념
  : 데이터 전송 객체
  : 데이터가 포함된 객체를 한 시스템에서 다른 시스템으로 전달하는 작업을 처리하는 개체
  : Data에 접속하는 객체이다. 여기서 Data란 일반적인 Database도 될 수 있고, 파일도 될 수 있으며,
  메모리도 될 수 있고, 기타 다른 저장소도 될 수 있음
  ```
  
  VO vs DTO
  ```
  DTO는 메소드 호출 횟수를 줄이기 위해 데이터를 담고 있는 녀석으로,
  VO는 값이 같으면 동일 오브젝트라고 볼 수 있는 것으로 표현하고 있다.
  ```
  ```
  VO
  VO a = VO(1);
  VO b = VO(1);
  // a == b
  ```
  ```
  DTO
  DTO a = new DTO(1);
  DTO b = new DTO(1);
  // a != b
  ```
  
  DAO(Data Transfer Object)
  ```
  개념
  : 데이터 접근 객체
  : 커넥션 같은 것을 하나만 두고 여러 사용자가 DAO의 인터페이스를 사용하여 필요한 자료에 접근 하도록 하는 것
  : DB에 대한 insert, update, delete, select를 처리함
  ```
  
  CRUD(Create, Read, Update, Delete)
  ```
  CREATE(INSERT)
  READ(SELECT)
  UPDATE
  DELETE
  ```
  ---
</details>

<details>
  <summary>Comparable vs Comparator</summary>
  
  ---
  ```
  Array 또는 List의 정렬을 돕기 위한 interface
  두 인터페이스 모두 정렬규칙을 설정하기 위해 사용한다는 목적은 동일함
  ```
  
  Comparable
  ```
  Comparable 인터페이스를 구현한 객체 스스로에게 부여하는 한 가지 기본 정렬 규칙을 설정하는 목적으로 사용한다.
  객체의 기본 정렬기준이 되는 메서드를 정의하는 인터페이스이다.
  ```
  ```java
  class Friend implements Comparable<Friend>{
    private String name;
    private int age;
        
    public Friend(String name, int age) {
      super();
      this.name = name;
      this.age = age;
    }        
      @Override
      public int compareTo(Friend o) {
        return this.age - o.age;
    } //  이 객체가 매개변수의 객체보다 작으면 음수, 같으면 0, 크면 양수를 반환
  }
  ```
  
  Comparator
  ```
  Comparator 인터페이스를 구현한 클래스는 정렬 규칙 그 자체를 의미하며,
  기본 정렬 규칙과 다르게 원하는대로 정렬순서를 지정하고 싶을 때 사용한다.
  새로운 정렬 기준을 적용하고 싶은 경우 사용하는 인터페이스이다.
  ```
  ```java
  class SortFriendByNameInAsc implements Comparator<Friend>{
    @Override
    public int compare(Friend o1, Friend o2) {
      return o2.name.compareTo(o1.name);
    }        
  }
  ```
  ---
</details>

### 2020-01-04
<details>
  <summary>static import *</summary>
  
  ---
  ```
  static import
  : 자바 클래스의 static 메소드는 클래스에 대한 인스턴스의 생성없이 메소드를 사용할 수 있다.
  ```
  
  > Before
  ```java
  int i = Math.abs(-3); // 3
  ```
  
  > After
  ```java
  import static java.lang.Math.abs;
  
  int i = abs(-3);  // 3
  ```
  
  > 주의
  ```
  아래의 코드도 사용이 가능하지만 권장하지 않음
  단 Math의 method를 전부 사용한다면 권장됨
  ```
  ```java
  import static java.lang.Math.*;
  
  int i = abs(-3);  // 3
  ```
  ---
</details>

<details>
  <summary>.gitignore</summary>
  
  ---
  > 정의
  ```
  Project에 원하지 않는 파일들을(컴파일 된 파일, .gradle, .idea 등등) git에서 제외시키기 위해 필요한 파일
  ```
  
  > git commit할 때, 포함하면 안되는 파일
  ```
  .setting/
  .classpath
  .project
  .springBeans
  ... etc
  ```
  
  > 이유
  ```
  : 난 잘되는데 왜 넌 안되냐?
  : 개발 환경이 서로 완벽하게 같으면 상관이 없으나 다른 환경의 값을 참조하므로 프로젝트가 꼬인다.
  : 이를 개선하기 위해 보통 소스만 commit한다.
  ```
  
  #### [.gitignore 자동 생성 사이트](https://www.toptal.com/developers/gitignore)
  ---
</details>

### 2020-01-07
<details>
  <summary>Stream</summary>
  
  ---
  ```
  Java 8에서 추가된 기능으로, stream 형태의 요소에 함수형 연산자를 지원해주는 클래스이다.
  ```
  
  ![Stream](https://user-images.githubusercontent.com/58816862/103875144-6a07ef00-5115-11eb-98b3-7154a36e64ba.png)
  
  filter()
  ```
  필터링 조건은 람다함수 또는 메소드 참조를 통해 결정됨
  원하는 요소만 추출하기 위한 메소드
  ```
  
  map()
  ```
  스트림 내 요소를 가공함
  T를 인자로 받아 변환한 값 R을 반환하는 함수
  ```
  
  flatMap()
  ```
  flattening 작업
  중첩 구조를 한 단게 제거하고 단일 컬렉션으로 만들어 주는 역할
  ```
  
  sorted()
  ```
  어떠한 인자도 넣지 않는다면 오름차순으로 정렬
  Comparator를 인자로 넣으면 Comparator의 기준에 따라 정렬
  ```
  
  distinct()
  ```
  중복 값 제거
  ```
  
  peek()
  ```
  중간에 값을 출력해볼 때 이용
  stack에서 쓰는 그 peek
  ```
  
  limit()
  ```
  앞선 n개의 요소만 취함
  ```
  
  Skip()
  ```
  앞선 n개의 요소를 건너뛰고 다음에 오는 요소를 취함
  ```
  
  concat()
  ```
  두 Stream을 연결
  ```
  
  reduce()
  ```
  세 가지의 인자를 받아 처리할 수 있음
  ```
  
  Collectors.toList()
  ```
  리스트 형태로 결과를 반환
  ```
  
  Collectors.joining()
  ```
  스트림 작업 결과를 하나의 스트링으로 연결, 세 가지 인자를 입력할 수 있음
   - delimiter: 각 요소 중간에 들어가는 구분자
   - prefix: 이어붙인 결과 맨 앞에 붙는 문자
   - suffix: 이어붙인 결과 맨 끝에 붙는 문자
  ```
  
  Collectors.groupingBy()
  ```
  특정 조건으로 요소들을 그룹화하여 Map 타입으로 반환
  예를 들어, 나이, 이름, 성별을 가진 클래스를 나이 기준으로 그룹화 할 수 있다.
  ```
  
  forEach()
  ```
  요소를 순회하면서 실행되는 작업
  인자로 넘긴 메소드에 요소를 대입하여 호출
  주로 System.out::println과 같은 출력 함수를 인자로 넘김
  ```
  ---
</details>