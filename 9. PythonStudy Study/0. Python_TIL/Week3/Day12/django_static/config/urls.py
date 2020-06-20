"""config URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/2.2/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include

# static으로 media 경로를 설정해 주기 위해 import
from django.conf import settings
from django.conf.urls.static import static

urlpatterns = [
    path('', include('boards.urls')),
    path('admin/', admin.site.urls),
]

urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
# 첫번째 인자 : 어떤 URL을 정적으로 추가할건지
# 두번째 인자 : 실제 미디어파일은 어디에 있는지
#               document_root에 미디어 파일 경로를 전달해주면됨.