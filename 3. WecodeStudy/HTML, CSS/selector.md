### selector를 고르고 제어하자



#### 1. selector들의 우선순위

- inline styling(13줄에 style 요소로 직접): 1000점
- id: 100점
- class: 10점
- tag: 1점

```
<p class="p-tag">나는 p태그, class가 있다</p>
```

p태그에 적용된 30px은 1점
p-tag클래스에 적용된 15px는 10점이므로 15px이 적용된다.

```
p.p-tag {
  font-size: 100px;
}
```

1점(p) + 10점(.p-tag) = 11점 이기 때문에 해당 요소는 100px이 적용될 것.

 tag <<<<< class <<<< id <<<<<< inline css



#### 2. selector들의 결합

**class나 id가 selector일때 태그와 결합이 가능하다.**

```
p.p-tag {
  color: gray;
}
p#third-line {
  text-decoration: underline;
}
```
첫 번째는 p태그이면서 p-tag 클래스이다.
두 번째는 p태그이면서 third-line 아이디이다. 



```
*p#third-line.p-tag*
```
이런 조합도 가능하긴 하지만, third-line라는 아이디는 한 개이므로 위와 같이 tag+id+class의 조합은 과한 표현이다.



#### 3. selector가 서로 붙어있지 않고 스페이스로 띄워있을 경우.

예1)

```
.pre span {
  background-color: yellow;
}
```

```.pre``` ```span```의 두가지 selector 같이 선택된 경우를 말한다.


```
<div class="pre">
  <span>이건 노란색 배경이고</span>
</div>
<div class="main">
  <span>이건 아님!</span>
</div>
<span class="pre">이것도 아님</span>
<div>
  <p class="pre">
    <span>이건 적용됩니다! 노란색배경!</span>
  </p>
</div>
```
최종적으로 적용되는 selector는 span이다.
**모든 span이 아니라 "pre" 클래스 내부에 있는 span이라는 뜻.**



예2)

```
.a div .b .pre span {
  background-color: yellow;
}
```
a클래스 밑에, div밑에, b클래스 밑에, pre클래스 밑에 span태그에 적용이 된다.
```
<div class="a">
  <div>
    <header class="b">
      <h1 class="pre">
        <span>제목! 노란색 배경 나옴!</span>
        <span class="title">이것도 나옴!</span>
      </h1>
      <span>이건 적용안 됨</span>
    </header>
  </div>
  <span>이건 적용안 됨</span>
</div>
```
<br>



#### 4. 이미 정의된 여러 class들(id들)을 띄어쓰기 하여 동시에 적용

```
<div class="wecode-box last-box">
	<p>이게 젤 낫네</p>
</div>
```
현재의 div명이 "wecode-box last-box"인데 이렇게 띄어쓰기로 되어있다. 

"wecode-box"와 "last-box" 라는  이름의 class를 동시에 div에 적용하라는 것이다. 