github에 등록된 email과 로컬에서 push를 날리는 .git의 email이 동일해야 잔디가 심어진다.

 

> 1. 작업중인 폴더로 가서 아래 명령어를 사용해서 email이 등록되어 있는지 확인
>
>    `git config --list`
>
>    2-1.등록되어 있으면
>
>    `git config user.email "[Your Email]"`로 가서 이메일 수정
>
> 2. global에 email을 등록 (별도로 git config를 고치지 않게 global에 등록)
>
>    `git config --global user.email "[Your Email]"`



https://devkyu.tistory.com/872



### Reference

https://diordna.tistory.com/37