from django.shortcuts import render, redirect
from .models import Article, Comment

def index(request):
    articles = Article.objects.all()

    context = {
        'articles': articles
    }
    return render(request, 'crud/index.html', context)

def new(request):
    # print(f'new : {request.method}')
    # return render(request, 'crud/new.html') # 기존 new 함수
    
    # REST 하게 바꿨을때 폼이 새로 생성되는 부분.
    if request.method == "POST":
        article = Article(title=request.POST.get('title'), content=request.POST.get('content'))
        article.save()
        return redirect('crud:index')
    else:
    # 폼 html 을 불러오는 부분.
        return render(request, 'crud/new.html')

# RESTful 하게 수정 (POST /crud/new)
# def create(request):
#     print(f'create : {request.method}')
#     article = Article(title=request.POST.get('title'), content=request.POST.get('content'))
#     article.save()

#     return redirect('crud:index')

def detail(request, art_id):
    art = Article.objects.get(id=art_id)
    com = art.comment_set.all()
    context = {
        'art' : art,
        'comments' : com,
    }
    return render(request, 'crud/detail.html', context)

def update(request, art_id):
    art = Article.objects.get(id=art_id)
    # print(f'update : {request.method}') # request method 확인
    if request.method == "POST":
        art.title = request.POST.get('title')
        art.content = request.POST.get('content')
        art.save()
        return redirect('crud:detail', art.id)
    else:
        return render(request, 'crud/update.html', {'art':art})

# RESTful 하게 수정 (POST crud/update/id)
# def arti_save(request, id):
#     art = Article.objects.get(id=id)
#     print(f'save : {request.method}')

#     art.title = request.POST.get('title')
#     art.content = request.POST.get('content')

#     art.save()
#     return redirect('crud:detail', art.id)

#---------------------------------------------
# delete 부분은 데이터를 삭제하는 동작이기에 GET으로 동작되어서는 안됨.
# GET으로 동작할 경우 브라우저 URL로도 데이터 삭제가 가능하게됨.
# DELETE method가 장고에서 지원이 안되기에 POST 방식으로 값을 넘겨 받음.
def delete(request, art_id):
    art = Article.objects.get(id=art_id)
    if request.method == "POST":
        art.delete()
        return redirect('crud:index')
    else:
        # GET인경우 상세정보 페이지
        return redirect('crud:detail', art.id)

def comment(request, art_id):
    article = Article.objects.get(id=art_id)

    if request.method == "POST":
        comment = request.POST.get('comment')

        com = Comment()
        com.comment = comment
        com.article = article
        com.save()

    return redirect('crud:detail', art_id)
    # return redirect('crud:detail', article.id)
    # return redirect('crud:detail', com.article_id)

def comment_edit(request, art_id, com_id):
    com = Comment.objects.get(id=com_id)

    if request.method == "POST":
        text = request.POST.get('comment')
        com.comment = text
        com.save()
        return redirect('crud:detail', art_id)
    else:        
        context = {
            'comment' : com,
        }
        return render(request, 'crud/comment_edit.html', context)

def comment_del(request, art_id, com_id):
    com = Comment.objects.get(id=com_id)

    if request.method == "POST":
        com.delete()

    return redirect('crud:detail', art_id)   