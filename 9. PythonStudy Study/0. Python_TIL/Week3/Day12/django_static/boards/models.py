from django.db import models
from imagekit.models import ProcessedImageField, ImageSpecField
from imagekit.processors import ResizeToFill, Thumbnail

# Board를 새로 생성할때(views.py 에서 new 동작) save() 가 호출되어야 pk가 생성이 됨.
# 그래서 새로 생성될때는 instance.pk에 None 값이 들어가게됨.
# def board_img_path(instance, filename):
#     return f'boards/{instance.pk}번글/{filename}'

class Board(models.Model):
    title = models.CharField(max_length=20)
    content = models.TextField()
    updated = models.DateTimeField(auto_now=True)
    created = models.DateTimeField(auto_now_add=True)
    
    # # ResizeToFill Ver.1
    # image = ProcessedImageField(
    #     upload_to = "boards/images_rtf",
    #     processors = [ResizeToFill(600,500)],
    #     format = "JPEG",
    #     options = {
    #         "quality": 85
    #     }
    # )

    # Thumbnail Ver.1 (원본 X, 썸네일 O)
    # Thumbnail size 도 바꿔가면서 실습해보기
    # image = ProcessedImageField(
    #     upload_to = "boards/thumbnail",
    #     processors = [Thumbnail(700, 700)],
    #     format = "JPEG",
    #     options = {
    #         "quality": 90
    #     }
    # )

    # thumbnail 원본 저장하고 썸네일은 캐쉬형태로 Ver.2
    # 원본 저장 됨 / thumbnail은 CACHE로 필요할때 만들어서 저장.
    image = models.ImageField(blank=True, upload_to="boards/%Y/%m/%d")
    image_thumbnail = ImageSpecField(
        source = 'image',
        processors = [Thumbnail(550,550)],
        format= "JPEG",
        options = {
            "quality": 90
        }
    )
   
    # upload 할때 저장되는 파일 경로를 가변적으로 변경하는 방법
    # upload_to = "%Y/%m/%d"  : 날짜로 관리
    # upload_to=board_img_path : 함수를 호출해서 경로 설정.
    # 함수 설명은 상단에 있음.
    #
    # image = models.ImageField(blank=True, upload_to=board_img_path)
    # image_thumbnail = ImageSpecField(
    #     source = 'image',
    #     processors = [Thumbnail(550,550)],
    #     format= "JPEG",
    #     options = {
    #         "quality": 90
    #     }
    # )