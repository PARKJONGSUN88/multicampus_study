from django.urls import path
from . import views

app_name = 'prac'
urlpatterns = [
    path('', views.index, name='index'),
    path('new/', views.new, name='new'),
    path('<int:b_id>/detail/', views.detail, name='detail'),
]
