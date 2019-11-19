from django.urls import path
from . import views

app_name = "subway"

urlpatterns = [
    # name 을 설정하면 url 관리가 수월하다.
    # python 파일에서는 'app_name:설정name'
    # template 에서는 {% url 'app_name:설정name' %} 
    # url이 바뀌어도 일일히 찾아서 바꿀 필요가 없다.
    path('', views.index, name='index'),
    path('new/', views.new, name='new'),
    # REST 이용으로 update부분 필요 없음. POST new/ 이용.
    # path('create/', views.create, name='create'),
    # redirect('app_name:설정name', 넘길 id)
    # {% url 'app_name:설정name' 넘길id %}
    path('detail/<int:id>/', views.detail, name='detail'),
    path('edit/<int:id>/', views.edit, name='edit'),
    # REST 이용으로 update부분 필요 없음. POST edit/id 이용.
    # path('update/<int:id>/', views.update, name='update'),
    path('delete/<int:id>/', views.delete, name='delete'),
]