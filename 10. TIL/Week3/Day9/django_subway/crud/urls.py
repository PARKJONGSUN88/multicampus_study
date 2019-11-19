from django.urls import path
from . import views

app_name = "crud"
urlpatterns = [
    path('', views.index, name="index"),
    path('new/', views.new, name="new"),
    # path('create/', views.create, name="create"),
    path('<int:art_id>', views.detail, name="detail"),
    path('<int:art_id>/update/', views.update, name="update"),
    # path('<int:id>/save/', views.arti_save, name="save"),
    path('<int:art_id>/delete/', views.delete, name="delete"),
    path('<int:art_id/comment/', views.comment, name='comment')
]