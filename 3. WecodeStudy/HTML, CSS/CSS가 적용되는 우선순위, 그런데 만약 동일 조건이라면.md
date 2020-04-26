## CSS가 적용되는 우선순위, 그리고 만약 동일 조건이라면?

### 1. CSS를 적용하는 3가지가 방법

1. 태그안에 직접 작성하는 inline styling   ```<p style="color:red">```

2. ```<style></style>``` 안에 작성

3. 스타일 시트를 따로 작성 ```<link href="index.css" rel="stylesheet" type="text/css" />```

   

###  2. CSS selector와 우선순위

  \- inline styling: 1000점   ```<p style="color:red">```
  \- id: 100점 ```#id{color:red}```
  \- class: 10점 ```#.class{color:red}```
  \- tag: 1점 ```div{color:red}```

우선순위가 있는 것이 무슨 뜻일까? 만약 처음 개발자가 **id 선택자**를 통해 글로벌하게 적용해논 요소로 인해 우선순위가 낮은 **class 선택자 ,tag 선택자**로는 원하는 요소를 적용하지 못해 개발중에 **"왜 이게 안먹지?"**를 외칠 것이다. 반대로 우선순위가 낮은 **tag 선택자**부터 전체적인 요소를 적용하고 일부에만 적용할 것들은 그 다음 우선순위의 선택자를 사용하여 작성할 수 있다.

협업과 추후 코드 관리에 편리를 위해서도 **id 선택자**, **inline styling** 보단 낮은 순위부터 사용하는게 좋을 이유이다. \* 그렇다고 너무 가볍게 tag 선택자로 해버리면 ```<div>```같이 자주 쓰이는 경우 다듬기 전 기초틀을 잡을 때부터 애를 먹을 수 있다.  개발자마다 다르겠지만 이런 사소한 것들이 자신의 노하우가 될 것같음. 



### 3. 동일조건일 경우

### 3-1.  style tag안에서 작성되었을 경우

```
<style>
.ex {
 color:red;
}

.ex {
 color:black;
}
</style>
```

만약 위와 같은 상황이라면 위의 코드는 무시가 되고 아래의 코드가 적용되어 black이 적용될 것이다.

브라우저에서 코드를 위에서부터 읽고 적용을 하니 위와 같은 경우 최종적으로 아래 있는 것이 반영될것이다.



### 3-2. link를 통해 stylesheet로 css를 적용

main.html

```
<link href="/static/css/style1.css" rel="stylesheet">

<link href="/static/css/style2.css" rel="stylesheet">
```


style1.css

```
.ex {
 color:red;
}
```
style2.css

```
.ex {
 color:black;
}
```

만약 위와 같은 상황이라면 메인.html 에서는 링크가 아래된 것에 우선순위를 줄 것이다.