from django.urls import path
from . import views


app_name = 'movies'
urlpatterns = [
    path('', views.index, name='index'),
    path('new/', views.new, name='new'),
    path('<int:m_id>/', views.detail, name="detail"),
    path('<int:m_id>/edit/', views.edit, name='edit'),
    path('<int:m_id>/delete/', views.delete, name='delete'),
    path('<int:m_id>/ratings/new/', views.rating_new, name='rating_new'),
    path('<int:m_id>/ratings/<int:r_id>/delete/', views.rating_del, name="rating_del"),
]

