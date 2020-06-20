from django.db import models

class Person(models.Model):
    name = models.CharField(max_length=20)

    def __str__(self):
        return f'{self.id}번 술꾼 {self.name}'

class Alcohol(models.Model):
    name = models.CharField(max_length=20)
    # people = models.ManyToManyField(Person, through='Sales', related_name="alcohols") # 중개필드 사용시
    people = models.ManyToManyField(Person, related_name="alcohols")

    def __str__(self):
        return f'주류 No.{self.id} : {self.name}'

# class Sales(models.Model):
#     person = models.ForeignKey(Person, on_delete=models.CASCADE)
#     alcohol = models.ForeignKey(Alcohol, on_delete=models.CASCADE)

#     def __str__(self):
#         return f'{self.person}이 마시는 {self.alcohol}'



