from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('subway/', views.subway),
    path('subway_pick/', views.subway_pick),
    path('subway_id/<int:id>', views.subway_id),
]