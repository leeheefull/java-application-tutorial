## Today I Learned

2020-12-28
<details>
  <summary>Java Bean Pattern</summary>
  
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