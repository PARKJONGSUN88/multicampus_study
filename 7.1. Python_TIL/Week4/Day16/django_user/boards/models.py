from django.db import models
from django.conf import settings

class Board(models.Model):
    title = models.CharField(max_length=30)
    content = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    # 좋아요 로직 구현을 위해 추가
    # related_name을 설정하지 않으면 user에서 board_set으로 접근
    # 근데 위에 ForeignKey로 연결된 user도 board_set으로 접근하게됨.
    # 이름이 겹치게됨. 장고는 혼란에 빠지게됨.
    # 그래서 related_name을 설정해주어 장고가 구분할수 있게됨.
    # 최종적으로 FK로 접근을 할땐 board_set / MtM으로 접근할땐 like_boards
    like_users = models.ManyToManyField(settings.AUTH_USER_MODEL, related_name="like_boards", blank=True)

    def __str__(self):
        return self.title
    
class Comment(models.Model):
    comment = models.CharField(max_length=200)
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    board = models.ForeignKey(Board, on_delete=models.CASCADE)

    def __str__(self):
        return self.comment