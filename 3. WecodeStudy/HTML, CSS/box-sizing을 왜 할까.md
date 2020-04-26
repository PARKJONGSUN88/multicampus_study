### box-sizing을 왜 할까?

**box-sizing?** box-model부터 다시 보면 ```<div> 컨텐트 </div>```를 통해 공간요소를 만들었는데 **default값**이 컨텐츠 영역만을 나타내는  **content-box**이기 때문에 box-model에서 **border와 margin영역이 밖으로 벗이나 있다는 뜻이다.** 

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

첫 번째는 가로가 300px이 맞는데, 두 번째 박스는 확인해보면 가로가 300px가 아니다. 

이유는 양쪽으로 테두리 10px이 추가되었고, padding이 50px씩 추가되어서 가로가 420px이 된다.



그렇기에 아래와 같이 초기화를 하기 한다.

```html
* {
  box-sizing: border-box;
}
```

\* 눈으로 보이는 그 너비가, 개발자가 코딩하는 그 값이여야 코딩과 머리속으로 생각하는 로직이 같아진다. 이러한 특성이 불편하다는 것을 깨닫고 새로운 CSS 프로퍼티를 만들었다.

\* centent기준이 아닌 border기준으로 하여  개발자가 생각한 사이즈와 실제로 출력되는 사이즈가 같아 조금 더 개발환경에 있어 편리할 수 있다. 

 \* 뭐 굳이 설정하지 않고, "나는 어쨌든 일괄적으로 조절할꺼야"라고 생각할 수도 있겠지만 개발은 혼자만 하고 끝이라는게 아니니까..