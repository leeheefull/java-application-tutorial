## Today I Learned

2020-12-28
<details>
  <summary>Bean Pattern</summary>
  
  ```
  생성자에 전달되는 인자 수가 많을 때 적용이 가능
  단점: 객체의 일관성이 일시적으로 깨질 수 있다.
  ```
  예시
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

2020-12-30
<details>
  <summary>MVC Pattern</summary>
  
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