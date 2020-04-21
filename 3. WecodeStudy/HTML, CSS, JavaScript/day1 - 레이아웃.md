

### 1. position 속성 - relative, absolute, fixed

#### position 속성

HTML 요소가 위치를 결정하는 방식

1. 정적 위치(static position) 지정 방식

2. 상대 위치(relative position) 지정 방식
3. 고정 위치(fixed position) 지정 방식

4. 절대 위치(absolute position) 지정 방식



#### static position

HTML요소의 위치를 결정하는 가장 기본적인 방식

static으로 설정된 요소는 top, right, bottom, left 속성값에 영향을 받지 않는다

단순히 웹 페이지의 흐름에 따라 차례대로 요소들을 위치시키는 방식



#### relative position

해당 HTML 요소의 기본 위치를 기준으로 위치를 설정하는 방식

HTML 요소의 기본 위치란 해당 요소가 static position일 때 결정되는 위치를 의미한다



#### fixed position

뷰포트(viewport)를 기준으로 위치를 설정하는 방식

즉, 웹 페이지가 스크롤 되어도 고정 위치로 지정된 요소는 항상 같은 곳에 위치하게 된다



#### absolute position

뷰포트(viewport)를 기준으로 위치를 결정하는 것과 비슷하게 동작한다

그러나 뷰포트(viewport)를 기준으로 하는 것이 아닌 위치가 설정된 조상(ancestor) 요소를 기준으로 위치를 설정하게 된다

하지만 위치가 설정된 조상(ancestor) 요소를 가지지 않는다면, HTML 문서의 body 요소를 기준으로 위치를 설정하게 된다



#### static position과 다른 방식들과의 차이점

정적 위치(static position) 지정 방식을 제외한 나머지 다른 방식(relative, fixed, absolute)들은 전부 어떤 기준에 대해 해당 요소의 상대적인 위치를 설정하는 방식

\- 상대 위치(relative position) : 해당 요소가 정적 위치 지정 방식일 때의 위치에 상대적으로 위치함

\- 고정 위치(fixed position) : 뷰포트(viewport)에 상대적으로 위치함

\- 절대 위치(absolute position) : 위치가 설정된 바로 상위의 조상(ancestor) 요소에 상대적으로 위치함



#### z-index 속성

HTML 요소의 위치를 설정하게 되면 어떤 요소들은 설정된 위치 및 방식에 따라 서로 겹칠 수도 있다

z-index 속성은 이렇게 겹쳐지는 요소들이 쌓이는 스택(stack)의 순서를 설정한다

스택(stack)의 순서는 양수나 음수 모두 설정할 수 있으며, 크기가 클수록 앞쪽에 위치하고 작을수록 뒤쪽에 위치하게 된다



### 2. inline, inline-block, block 에 대해서

#### display

CSS에서 레이아웃을 제어하기 위한 프로퍼티. 

 ![Display](https://dongqui.github.io/assets/postimages/display-1137478495ade3a8b6951573fff2cfed4fc243cb00b46b619d72af140202063e.png) 

#### block

화면상에서 기본적으로 한줄을 차지하며 다음 태그는 줄바꿈이 적용된다. 



#### inline

텍스트가 차지한 만큼의 공간을 가지고 있으며 줄바꿈이 적용되지 않는다. 



#### inline-block

**inline**과 **block**의 속성을 둘다 가지고 있는 것으로 줄바꿈이 적용되지 않으나  **inline**속성에서 할 수 없었던 width/height 변경 및 line-height등을 바꿀 수  있다. 



#### none

요소를 렌더링하지 않도록 설정한다. 

`visibility` 속성을 `hidden`으로 설정한 것과 달리, 영역도 차지하지 않는다. 

```html
<style>
.display-none{ display: none }
.invisible{ visibility: hidden }
</style>

<div class="display-none">1</div>
<div>2</div>

<div class="invisible">3</div>
<div>4</div>
```

```html
2

4
```



### 3. float에 대해서

웹 페이지의 레이아웃(layout)을 작성할 때 자주 사용된다

 `float` 라는 단어는 원래 ‘뜨다’ 라는 의미이며, 원래 웹페이지에서 **이미지**를 어떻게 띄워서 텍스트와 함께 배치할 것인가에 대한 속성.

 ![float](https://ofcourse.kr/images/attach/float.gif) 

`inherit`: 부모 요소에서 상속

`left`: 왼쪽에 부유하는 블록 박스를 생성. 페이지 내용은 박스 오른쪽에 위치하며 위에서 아래로 흐름

`right`: 오른쪽에 부유하는 블록 박스를 생성. 페이지 내용은 박스 왼쪽에 위치하며 위에서 아래로 흐름.

​			이후 요소에 clear 속성이 있으면 페이지 흐름이 달라짐

​			none 이 아니라면 display 속성은 무시된다

`none` : 요소를 부유시키지 않음

`left`와 `right`를 통해 부유속성을 지정시 `display`는 무시된다 (`none`은 제외)
또한 이후 요소에 [`clear`](https://ofcourse.kr/css-course/clear-속성) 속성이 있으면 페이지 흐름이 달라진다



#### clear

`float` 속성을 통해 태그를 부유시킨 이후 문서의 흐름을 제거하기 위해 쓰인다
방향에 따라 3가지 속성을 사용할 수 있다

`left`: 좌측 부유 제거

`right`: 우측 부유 제거

`both`: 양쪽 모두 제거

```html
<html>
<head>
<style>
	.float-container{ width: 320px; border: 2px solid #09c; }
	.float-container img{ float: left; margin: 5px; padding: 5px; border: 2px solid #90C; }
</style>
</head>
<body>
	<div class="float-container">
		<img src="/images/attach/earth.jpg">
		<p>This is first line with floating image.</p>
		<p style="clear: both">This is second line with cleared property.</p>
	</div>
</body>
</html>
```

![image-20200421115609243](https://user-images.githubusercontent.com/50945715/79825240-786d7980-83d3-11ea-9b93-6c83cb3d8b65.png)



#### 레이아웃에서의 clear

`float` 속성이 레이아웃에서 많이 [사용](https://ofcourse.kr/css-course/float-속성#레이아웃에서의-float)한다고 하였는데, `clear`속성도 `float`를 레이아웃에서 사용하며 발생되는 문제를 해결하기 위해 많이 사용된다.

`float` 속성을 적용한 태그는 붕 뜨며 정상적인 요소로 처리가 안되기 때문에
아래에 나타나야 하는 내용이 부유된 태그의 중간에 나타나는 문제 및 상위 태그의 높이가 없어지는 문제 등이 발생하게 된다.

```html
<style>
	.box-container{
		width: 350px;
		border: 2px solid #09c;
		background-color: #d7f5ff;
	}
	.box-container .box{
		width: 80px;
		height: 40px;
		border: 2px solid red;
		background-color: #ffe7d5;
	}
</style>
<div class="box-container">
	<div class="box" style="float: left">박스1</div>
	<div class="box" style="float: right">박스2</div>
</div>
<div>박스 아래에 나타나야 하는 내용</div>
```

![image-20200421120008686](https://user-images.githubusercontent.com/50945715/79825241-799ea680-83d3-11ea-9710-cae844b03642.png)



```html
<div class="box-container">
	<div class="box" style="float: left">박스1</div>
	<div class="box" style="float: right">박스2</div>
	<div style="clear: both"></div>
</div>
<div>박스 아래에 나타나야 하는 내용</div>
```

![image-20200421120117325](https://user-images.githubusercontent.com/50945715/79825244-7a373d00-83d3-11ea-8b95-ced73a042ac8.png)
