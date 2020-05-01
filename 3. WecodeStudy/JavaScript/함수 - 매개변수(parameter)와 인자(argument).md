##  함수 -  매개변수(parameter)와 인자(argument)

인자 : 전달인자. 함수에서 받는 값중 실제로 값을 가지고 오는 input의 값

매개변수 : 함수정의에서 함수안에서 사용되는 매개'변수'임.



```
function abc("매개변수") {
	매개변수;
}

abc("인자", "인자")
```

```
function bbc(name) {   
  let name = "wecode"; //이 경우 name은 함수 정의의 매개변수가 먼저 선언됬으므로
  					   //다시 변수명으로 사용할 수 없다.  
}

function bbc(name) {   
  let wecode = name; //name이라는 명의 매개변수를 이용하여 wecode명의 변수에
  					 //값을 넣는다. 
}

bbc("종선") // bbc함수를 실행시키라는 명령에 실제로 값이 있는 '종선'인자를 넣었다.
```
