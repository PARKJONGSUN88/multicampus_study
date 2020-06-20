from django.urls import path
from . import views

app_name = "movie"
urlpatterns = [    
    path('', views.index, name='index'),
    path('new/', views.new, name='new'),
    path('<int:id>', views.detail, name='detail'),
    path('<int:id>/edit/', views.edit, name='edit'),
    path('<int:id>/delete/', views.delete, name="delete"),
    path('csv2db/', views.csv2db, name='csv2db'),
    path('deleteall/', views.deleteall, name='deleteall'),
]