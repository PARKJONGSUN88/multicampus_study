## 깊이를 더하자!

### 1. 시맨틱 태그(Semantic Tag) VS  태그(non-semantic)
**시맨틱 태그 :** HTML5에서 도입된 태그이름로 그 태그의 의미를 알 수 있도록 제공한 태그. 
```<nav>, <table>```등 그 태그 안에 있는 컨텐트(content)가 어떤 내용이 올지 유추할 수 있도록.
**non-semantic tag의 예 :** ```<div>```등



**그러면 시맨틱 태그의 장점? 쓰면 좋은 이유는? :** 

1. 검색 엔진 최적화(search engine optimization, SEO) : 웹 페이지 검색엔진이 자료를 수집하고 순위를 매기는 방식에 맞게 웹 페이지를 구성해서 검색 결과의 상위에 나올 수 있도록 함
2. 코드 관리(개발자간의 협업에서나 관리 등) 



**```<img>``` 와 ```<div><backgroud-image:></div>```  :  SEO 효율 UP!**

서치엔진에서 ```<img>```는 검색되도  ```<div><backgroud-image:></div>```는 검색되지 않을 수 있다.

그런데 ```<div><backgroud-image:></div>```를 개발자들은 왜 쓸까?

```<div><backgroud-image:></div>```가 원하는 스타일을 적용하기가 ```<img>```에 비해 유연하기 때문.



### 2. CSS를 적용방법과 우선순위

**CSS를 적용하는 3가지가 방법 :** 

1.  태그안에 직접 작성하는 inline styling   ```<p style="color:red">```
2.  ```<style></style>``` 안에 작성
3.  스타일 시트를 따로 작성 ```<link href="index.css" rel="stylesheet" type="text/css" />```



 **CSS selector와 우선순위에 관해**

  \- inline styling: 1000점   ```<p style="color:red">```
  \- id: 100점 ```#id{color:red}```
  \- class: 10점 ```#.class{color:red}```
  \- tag: 1점 ```div{color:red}```

우선순위가 있는 것이 무슨 뜻일까? 만약 처음 개발자가 **id 선택자**를 통해 글로벌하게 적용해논 요소로 인해 우선순위가 낮은 **class 선택자 ,tag 선택자**로는 원하는 요소를 적용하지 못해 개발중에 **"왜 이게 안먹지?"**를 외칠 것이다. 반대로 우선순위가 낮은 **tag 선택자**부터 전체적인 요소를 적용하고 일부에만 적용할 것들은 그 다음 우선순위의 선택자를 사용하여 작성할 수 있다.

협업과 추후 코드 관리에 편리를 위해서도 **id 선택자**, **inline styling** 보단 낮은 순위부터 사용하는게 좋을 이유이다. \* 그렇다고 너무 가볍게 tag 선택자로 해버리면 ```<div>```같이 자주 쓰이는 경우 다듬기 전 기초틀을 잡을 때부터 애를 먹을 수 있다.  개발자마다 다르겠지만 이런 사소한 것들이 자신의 노하우가 될 것같음. 



### 3. box-sizing 그리고 margin과 padding의 선택

**box-sizing?** box-model부터 다시 보면 ```<div> 컨텐트 </div>```를 통해 공간요소를 만들었는데 **default값**이 컨텐츠 영역만을 나타내는  **content-box**이기 때문에 box-model에서 **border와 margin영역이 밖으로 벗이나 있다는 뜻이다.** 

```
*{box-sizing: border-box;}
```

를 하는 것은 

centent기준이 아닌 border기준으로 하여  개발자가 생각한 사이즈와 실제로 출력되는 사이즈가 같아 조금 더 개발환경에 있어 편리할 수 있다.  \* 뭐 굳이 설정하지 않고, "나는 어쨌든 일괄적으로 조절할꺼야"라고 생각할 수도 있겠지만 개발은 혼자만 하고 끝이라는게 아니니까..



### 4. 레이아웃을 잡는 것

나는 건축설계를 하듯이 하려고 한다. 큰 덩어리(mass)을 잡고, 메스의 모양을 얼추 잡은 뒤 그 메스 안에 공간을 생성한다. 이 공간은 휴식을 위한 공간, 생활하는 공간 등등, 그리고 그 안에는 룸을 통해 실제로 어떤 행위가 일어날 수 있도록 한다.



### 5. margin과 padding을 쓰는 기준?
**없다. 정답은. 그러나 자신 나름대로의 기준이 있는 것이 좋겠다.**

레이아웃 구성하는데 nav와 header는 padding으로 레이아웃은 구분해놓고 footer부분은 margin으로 구분한다면 이것은 코드관리에 불편할 수 있지않을까?



### 6. 속성값(attribute value) 갯수가 4개, 3개, 2개?

4개) padding: 10px 20px 30px 40px;(위에서부터 시계방향)

padding-top: 10px;

padding-right: 20px;

padding-bottom: 30px;

padding-left: 40px;



3개) padding: 10px 20px 30px;(위 오른쪽 왼쪽 아래)

padding-top: 10px;

padding-right: 20px;

padding-bottom: 30px;

padding-left: 20px;



2개) padding: 10px 20px;(위 아래 오른쪽 왼쪽)

padding-top: 10px;

padding-right: 20px;

padding-bottom: 10px;

padding-left: 20px;

 

1개) padding: 10px;(전체)

padding-top: 10px;

padding-right: 10px;

padding-bottom: 10px;

padding-left: 10px;



### 7. distplay : flex

기본: flex는 부모요소에 설정해줘야 자식요소들이 적용된다

flex은 기본적으로 가로정렬을 할 수 있고 **float**나  **inline-block**에서 부족했던 점을 보완코자 나온 뷰포트나 요소의 **크기가 불명확**하거나 **동적으로 변할 때**에도 효율적으로 요소를 배치, 정렬, 분산할 수 있는 방법을 제공하는 CSS3의 새로운 레이아웃 방식이다. 

\* flex에 관해서는 많은 내용이 있다. 추가적으로  https://heropy.blog/2018/11/24/css-flexible-box/ 에서 공부해야겠다.

많이 쓰는 2가지만 우선 메모
```
justify-contents:center
align-items:center
```



### 8. position에서 부모와 자식관계

default값인 **position: static;**과 
뷰포트(쉽게 브라우저)를 기준(브라우저 화면의 왼쪽위 픽셀)으로 고정되는   **position: fixed;**는 제외하고,

- **position: relative;**
- **position: absolute;**

에서

**position: relative;** 자체로는 어느 위치로 이동하지는 않는다.  위치를 이동시켜주는 top, right, bottom, left 프로퍼티가 있어야 원래의 위치에서 원하는 위치로 이동할 수 있다.

\* 이동하고 싶은 요소부터 relative와  top, right, bottom, left 프로퍼티를 사용하면 된다. 그 부모 요소의 position이 어떤 것이든... 부모 position이 명시되어 있지않아도 default값(static)으로 되어있어 작동됨으로. 



**position: absolute;** 부모 중에 position이 **relative, fixed, absolute** 하나라도 있으면 그 부모에 대해 절대적으로 움직이며 만약 지정되지않으면 맨 위인 ```<body>```까지 타고 간다..

\* 일반적으로 absolute를 쓸 경우, 부모에게 position: relative; 를 부여해서 사용한다. static으로는 사용할 수가 없고 그렇다고 부모를 fixed나 absolute를 쓰면 부모요소를 원하는데로 작성할 수 없을테니...
