## CSS가 적용되는 우선순위, 그런데 만약 동일 조건이라면?

선택자에 의한 우선순위나 상속관계에 의한 css우선순위는 충분히 이해되었다는 전제하에.

만약 동일 조건일 경우, 여러번 작성되어 충돌이 일어나면 어떻게 적용될 것인가?



### 1.  style tag안에서 작성되었을 경우

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



### 2. link를 통해 stylesheet로 css를 적용

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