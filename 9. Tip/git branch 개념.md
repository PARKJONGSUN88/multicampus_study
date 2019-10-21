**우선 git master repository 다시 가져오자.**

1.  git pull 
2. 이클립스에서 내 컴퓨터상 있는 local workspace가 아니라 repository를 그대로 import 하자.



**git feature를 만들어 보자.**

1.  git마스터를 clone한 repository에서 bash열고

   $ git branch feature/js_visual  //js_visual은 내가 생성한 피쳐이름



2. 생성한 git feature로 들어가보자.

   $ git checkout feature/js_visual
   
   ​	// 이때 이클립스를 보면 head가 master였던게 바뀌어 있다.
   
   
   
3.  바뀐 feature에서 작업을 하자. 작업중 확인하려면

   $ git status

   ​	// 그러면 bash에서 바뀐내역이 나와있는데 feature/js_visual에서 작업한거 추가하기 위해

   $ git add .    //모든 내역 더하는 add .

   $ git commit -m "test"

   $ git push origin feature/js_visual

   ​	// 이렇게 하면 feature/js_visual 상에는 올라가고 마스터상에는 따로니까 반영되는건 없음

   

4.  내 branch에서 작업하던것이 다 되서 master에도 반영하고 싶다면

   $ git checkout master // 마스터로 다시 돌아와서

   $ git merge feature/js_visual //로 마스터에 반영하기



**commit과 push의 차이?**

commit은 변경내역만 남기면서 **local repository**까지만 올라간다.

push를 해야 **remote repository**까지 올라간다.

원격저장소(**remote repository**)는 마스터 상태에서 git web repository라고 생각하면 된다.

만약 checkout해서 브런치로 갔다면 그 브런치 최상위가 원격저장소라고 보면 됨.



**브런치와 브런치명**

git branch feature/js_visual 에서

branch는 명령어이고 "feature/js_visual"가 통으로 이름임.

다만 브런치명을 쓰임새에 따라 feature, hotfix 등으로 나눈 것으로 생각하면 됨.