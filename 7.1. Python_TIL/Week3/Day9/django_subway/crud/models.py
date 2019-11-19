from django.db import models

# Create your models here.
class Article(models.Model):
    title = models.CharField(max_length=20)
    content = models.TextField()
    created = models.DateTimeField(auto_now_add=True)
    updated = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f'{self.id} > {self.title}'


class Comment(models.Model):
    comment = models.CharField(max_length=200)
    # ForeignKey(어떤테이블을 참조, 그 테이블이 삭제될때 어떻게 할지)
    # models.CASCADE : 부모테이블이 삭제시 같이 삭제하는 옵션
    # models.PROTECT : 부모테이블이 삭제 될때 오류 발생.
    # models.SET_NULL: 삭제 되었을때 부모 참고 값에 NULL값으로 채움. 단 NOT NULL 불가능.
    # models.SET_DEFAULT: 삭제 되었을때 설정된 default 값으로 설정. default 옵션 설정 필요!
    # models.SET() : 특정 함수를 호출. ()안에 함수명을 넣어주면 됨.
    # models.DO_NOTHING : 암것도 안함.
    article = models.ForeignKey(Article, on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)