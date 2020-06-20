from django.urls import path
from . import views

app_name='boards'

urlpatterns =[
    path('', views.index, name="index"),
    path('new/', views.new, name="new"),
    path('<int:b_id>/', views.detail, name="detail"),
    path('edit/<int:b_id>/', views.edit, name="edit"),
    path('delete/<int:b_id>/', views.delete, name="delete"),
]