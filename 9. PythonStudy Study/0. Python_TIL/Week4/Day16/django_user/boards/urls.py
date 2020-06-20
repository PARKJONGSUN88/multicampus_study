from django.urls import path
from . import views

app_name='boards'

urlpatterns =[
    path('', views.index, name="index"),
    path('new/', views.new, name="new"),
    path('<int:b_id>/', views.detail, name="detail"),
    path('edit/<int:b_id>/', views.edit, name="edit"),
    path('delete/<int:b_id>/', views.delete, name="delete"),
    path('new_comment/<int:b_id>/', views.new_comment, name="new_comment"),
    path('del_comment/<int:c_id>/', views.del_comment, name="del_comment"),
    path('like/<int:b_id>/', views.like, name="like"),

]