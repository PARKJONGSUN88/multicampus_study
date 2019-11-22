from django.urls import path
from . import views

app_name = "article"
urlpatterns = [
    path('', views.index, name="index"),    
    path('new/', views.new, name="new"),
    path('<int:a_id>/', views.detail, name="detail"),
    path('<int:a_id>/edit/', views.edit, name="edit"),
    path('<int:a_id>/delete/', views.delete, name="delete"),
]
