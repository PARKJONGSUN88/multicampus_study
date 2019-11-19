from django.db import models

# Create your models here.
class Board(models.Model):
    title = models.CharField(max_length=10)
    content = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f'{self.title}'


class Subway(models.Model):
    title = models.CharField(max_length=10)    
    size = models.TextField()
    bread = models.TextField()
    source = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return f'주문한 빵사이즈는 {self.size}, 주문한 빵은 {self.bread}, 주문한 소스는 {self.source}'
