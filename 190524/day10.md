## 인터페이스

용도 - 사용자(User)와 제공자(Provider) 사이에서 매개체(연결) 역할

구성요소 - public static final 상수속성, abstract 메서드, static 메서드(구현 body 없음), default 메서드

설계시, 서로 다른 시스템을 통합할 때 표준화를 위해서 활용

클래스는 일원화된 구조 - 선언+구현

인터페이스는 이원화된 구조 - 인터페이스는 반드시 인터페이스 구현 클래스가 있어야만 인터페이스 서비스

`public interface 이름 [extends 인터페이스, 인터페이스,...] {...}`

`public class 이름 implements 인터페이스, 인터페이스,... {...}`

인터페이스는 reference 변수(객체명) 타입으로 선언

인터페이스는 new를 사용해서 객체 생성 가능하려면 구현한 클래스



## 예외처리

예외처리 - declare, handle

예외발생 - throw new

1. 예외처리(declare) - throws
2. 예외처리(declare) - try~catch~finally





