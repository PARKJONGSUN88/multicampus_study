from django.shortcuts import render, redirect, get_object_or_404
from .models import Article, Author
from .forms import ArticleForm, AuthorForm
from IPython import embed

# Create your views here.
def index(request):
    # embed()
    article = Article.objects.order_by('-id')
    context = {
        'article': article
    }
    return render(request, 'article/index.html', context)


def new(request):
    if request.method == "POST":
        # title = request.POST.get('title')
        # content = request.POST.get('content')
        # article = Article()
        # article.title = title
        # article.content = content
        # article.save()
        # return redirect('article:index')
        form = ArticleForm(request.POST)
        # embed()
        # 유효성 검사 이상없으면 True가
        if form.is_valid():
            # title = form.cleaned_data.get('title')
            # content = form.cleaned_data.get('content')
            # article = Article.objects.create(title=title, content=content)
            author = form.save()
            return redirect('article:index')
            # return redirect('article:detail', article.id)
        
    else:
        # form = ArticleForm()
        form = AuthorForm()

    context = {
        "form" : form,
    }
    return render(request, 'article/new.html', context)


def detail(request, a_id):
    article = Article.objects.get(id=a_id)
    context = {
        'article' : article
    }
    return render(request, 'article/detail.html', context)


def edit(request, a_id):
    # article = Article.objects.get(id=a_id)
    article = get_object_or_404(Article, id=a_id)
    
    if request.method == 'POST':
        form = ArticleForm(request.POST)
        if form.is_valid():
            article.title = form.cleaned_data.get('title')
            article.content = form.cleaned_data.get('content')
            article.save()
            return redirect(article)
            # return redirect('article:detail', article.id)
    else:
        form = ArticleForm(initial=article.__dict__)

    context = {
        'form' : form,
    }
    return render(request, 'article/new.html', context)


def delete(request, a_id):
    article = Article.objects.get(id=a_id)
    if request.method == 'POST':
        article.delete()

    return redirect('article:index')