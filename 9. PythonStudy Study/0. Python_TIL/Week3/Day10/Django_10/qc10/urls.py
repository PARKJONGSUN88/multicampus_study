from django.urls import path
from . import views

app_name = 'qc10'
urlpatterns = [
    path('', views.index, name='index'),
    path('new/', views.new, name='new'),
    path('<int:qc_id>', views.detail, name='detail'),
    path('<int:qc_id>/update/', views.update, name="update"),
]