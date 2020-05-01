##  class

클래스 : 함수들이 여러개 갖춰진 공장이라고 생각하면 된다.

객체(object)를 잘 설계하기 위한 틀.

```
class Car {
  constructor(name, price) {
    this.name = name;
    this.price = price;
    this.department = "선릉지점";
  }

  applyDiscount(discount) {  
    return this.price * discount;   
  }

  changeDepartment(departmentName) {
    this.department = departmentName;
  }
}
```



#### 생성자(Constructor)

**생성자는 생성자명을 지정할 수 있는 것이 아니라 고정된 명 constructor이다.**

 class를 통해 생성된 객체가 인스턴스


- Car는 class이름입니다. 항상 대문자로 시작하고, CamelCase로 작성해야 합니다.
- Car class의 instance를 생성할때마다 constructor메서드가 호출됩니다.
- constructor()메서드는 name, price 2개의 argument(인자)를 받습니다.
- constructor()메서드에 this 키워드를 사용했습니다. class의 실행범위(context)에서 this는 해당 instance를 의미합니다. 
- constructor()에서 인자로 넘어오는 name과 price를 사용해 Car instance의 name, price 프로퍼티에 값을 할당했습니다.
- 이렇게 클래스 내에서 name, price와 같이 변경 가능한 상태값이자 class내의 컨텍스트에서 어느 곳에서나 사용할 수 있는 변수를 '멤버 변수'라고 부릅니다.
- 멤버 변수는 'this' 키워드로 접근합니다.



#### 인스턴스
위에서 class instance를 생성했습니다.
인스턴스(Instance)는 class를 통해 생성된 객체입니다.
인스턴스는 class의 property이름과 method를 갖는 객체입니다.
인스턴스 마다 모두 다른 property 값을 갖고 있습니다.



```
const morning = new Car('Morning', 20000000);
```

- 인스턴스는 Class 이름에 new를 붙여서 생성합니다.
- 클래스 이름 우측에 () 괄호를 열고 닫고, 내부에는 constructor에서 필요한 정보를 인자로 넘겨줍니다.
- Car클래스의 instance를 morning이라는 변수에 저장했습니다.
- 다시 한 번! Car 클래스의 새로운 instance를 생성하려면 new 키워드가 필요합니다. new키워드는 constructor() 메서드를 호출하고 새로운 instance를 return해줍니다.
- 'Morning'이라는 String과 2000000이라는 Number를 Car 생성자에 넘겨주었고, name, price 프로퍼티에 각자의 값이 할당되었습니다.



#### 메서드

메서드는 함수입니다.

그런데 객체가 프로퍼티 값으로 갖고 있는 것을 메서드라고 부릅니다.

Class의 method는 Object(객체)의 문법과 똑같습니다.

다만 객체는 프로퍼티마다 comma(,)로 구분해줘야 했지만, 클래스는 그렇지 않습니다.

Car 객체에 changeDepartment 메서드를 추가했습니다.

