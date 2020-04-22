## HTML, CSS 참조
<br>

### box-sizing
```html
.first {
  width: 300px;
  margin-bottom: 20px;
}

.second {
  width: 300px;
  margin-bottom: 20px;
  padding: 50px;
  border-width: 10px;
}
```

첫 번째는 가로가 300px이 맞는데, 두 번째 박스는 확인해보면 가로가 300px가 아니다. 이유는 양쪽으로 테두리 10px이 추가되었고, padding이 50px씩 추가되어서 가로가 420px이 된다.
```html
* {
  box-sizing: border-box;
}
```
눈으로 보이는 그 너비가, 개발자가 코딩하는 그 값이여야 코딩과 머리속으로 생각하는 로직이 같아진다. 이러한 특성이 불편하다는 것을 깨닫고 새로운 CSS 프로퍼티를 만들었다.
<br>
### CSS selector

**class나 id가 selector일때 태그와 결합할 수 있습니다.**
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

여러 selector를 사용할 수도 있다.
<br>

selector가 서로 붙어있지 않고 스페이스로 띄워있을 경우.
```
.pre span {
  background-color: yellow;
}
```
아래 css에서 최종적으로 적용되는 selector는 span이다.
**모든 span이 아니라 "pre" 클래스 내부에 있는 span이라는 뜻.**
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
```
.a div .b .pre span {
  background-color: yellow;
}
```
span 태그에 적용되는 css이다.

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
<br>
### img관련

**background-image로 이미지 넣기** 
```
img {
  width: 150px;
  background-size: 100%;
}
```
img태그로 이미지를 넣을 경우와 css의 background-image로 이미지를 넣을 경우 그 차이가 없다.
<br>

### 여러 class 적용하기
**class명을 띄어쓰기 하며 이미 정의된 class들을 넣어줄 수 있음**
```
<div class="wecode-box last-box">
	<p>이게 젤 낫네</p>
</div>
```
현재의 div명이 "wecode-box last-box"인데 이렇게 띄어쓰기로 되어있고 "wecode-box"와 "last-box" 라는  이름의 class가 있을시 두개의 속성을 div에 속성을 줄 수 있다. 