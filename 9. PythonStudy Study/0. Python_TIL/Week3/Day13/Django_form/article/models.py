from django.db import models
from django.urls import reverse

# Create your models here.
class Article(models.Model):
    title = models.CharField(max_length=30)
    content = models.CharField(max_length=200)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.title

    def get_absolute_url(self):
        return reverse('article:detail', args=[self.id])
        # return reverse('article:detail', kargs={'a_id' : self.id})

class Author(models.Model):
    name = models.CharField(max_length=20)
    company = models.CharField(max_length=200)

    def __str__(self):
        return self.name

    
    # def get_absolute_url(self):
    #     return reverse('author:detail', args=[self.id])