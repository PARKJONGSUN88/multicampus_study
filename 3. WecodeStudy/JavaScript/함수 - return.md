##  함수 - return

함수를 정의할 때 return이 있다. 생략도 가능하다.

**return은 단순히 함수의 틀을 잡는 것이 아니라 return을 만나면 그 함수는 종료 된다는 것** 

조건을 만날때까지 돌다가 만나면 끝이라는것이다.

switch-case문의 break같은..


단순 함수의 틀이 아니라는걸 놓치고 있었음. 또한 리턴이 꼭 있어야 할 경우, 생략되도 될 경우 등이 있고 이는 추후 화살표함수에서도 그에 따라 중괄호 생략이 가능해진다.
```
function meetAt(year, month, day) {
  if (day) return year + "년" + month + "월" + day + "일"  
  if (month) return year + "년" + month + "월"
  return year + "년"
}
```
만약 day가 true(존재한다면) 리턴  year + "년" + month + "월" + day + "일"  하고 함수 끝.

만약 month가 true(존재한다면 !!이경우 day도 존재) 리턴 year + "년" + month + "월" 하고 끝.