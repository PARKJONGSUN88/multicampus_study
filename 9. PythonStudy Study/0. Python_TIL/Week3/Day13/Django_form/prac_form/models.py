from django.db import models

# Create your models here.
class Book(models.Model):
    name = models.CharField(max_length=50)
    preface = models.CharField(max_length=100)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.name

        
