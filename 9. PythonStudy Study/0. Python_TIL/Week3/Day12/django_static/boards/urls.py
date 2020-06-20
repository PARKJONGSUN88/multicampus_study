from django.urls import path
from . import views

app_name = 'boards'
urlpatterns = [
    path('', views.index, name="index"),
    path('new/', views.new, name="new"),
    path('<int:b_id>/', views.detail, name="detail"),
    path('<int:b_id>/edit/', views.edit, name="edit"),
]