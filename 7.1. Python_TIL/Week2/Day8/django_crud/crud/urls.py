from django.urls import path
from . import views

urlpatterns = [    
    path('', views.index),   # crud/
    path('new/', views.new), # crud/new/
    path('created/', views.create),  # crud/create/
    path('<int:num>/article/', views.detail), #crud/pk/article/detail page
    path('<int:upnum>/update/', views.update), # crud/pk/update/ 수정 폼페이지    
    path('<int:pk>/revise/', views.revise), #crud/pk/revise/ 최종 업데이트
    path('<int:pk>/delete/', views.delete), #crud/pk/delete/ 삭제하기
]