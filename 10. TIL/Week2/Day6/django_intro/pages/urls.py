from django.urls import path
from . import views

urlpatterns = [
    path('static_example/', views.static_example),
]
