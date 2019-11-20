from django.db import models

# Create your models here.
class Movie(models.Model):
    title = models.CharField(max_length=50)
    title_en = models.CharField(max_length=50)
    audience = models.IntegerField()
    open_date = models.DateTimeField()
    genre = models.CharField(max_length=50)
    watch_grade = models.CharField(max_length=50)
    score = models.FloatField(max_length=10)
    poster_url = models.TextField()
    description = models.TextField()

    def __str__(self):
        return f'{self.id} {self.title}'