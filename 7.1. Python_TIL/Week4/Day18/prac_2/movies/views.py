from django.shortcuts import render, get_object_or_404, redirect
from .models import Movie, Rating
from .forms import MovieForm, RatingForm
from django.contrib.auth.decorators import login_required
from django.views.decorators.http import require_POST
from django.forms.models import model_to_dict

# Create your views here.
def index(request):
    
    movies = []

    # 평균 평점을 구하기 위한 로직
    for m in Movie.objects.all():
        # 평점이 하나라도 있는지 확인.
        if m.rating_set.all().exists():
            # score 라는 필드의 값만 추출
            score = m.rating_set.values('score')
            # [s['score'] for s in score] : dictionary 형식으로 반환된 값에서 value만 배열로 만듬
            # sum( [s['score'] for s in score] ) 배열의 모든 값을 더함.
            avg = sum( [s['score'] for s in score] ) / len(score)
        else:
            avg = 0
        # 현재 model class 인 m 을 dictionary로 변환
        # score 라는 키를 설정한 후 평균 값을 저장하기 위해 변환 시킴.
        movie = model_to_dict(m)
        # movie 모델에는 score라는 항목이 없어서 추가. 
        # dictionary 형태라 가능.
        movie['score'] = avg
        # movies 라는 리스트에 하나씩 담음.
        movies.append(movie)

    context = {
        'movies': movies
    }

    return render(request, 'movies/index.html', context)

@login_required
def new(request):
    
    if request.method == "POST":
        form = MovieForm(request.POST, request.FILES)
        
        if form.is_valid():
            movie = form.save(commit=False)
            movie.user = request.user
            movie.save()
            return redirect(movie)
    else:
        form = MovieForm()

    context = {
        'form': form,
        'button_label': "등록하기"
    }
    return render(request, 'movies/base_form.html', context)


def detail(request, m_id):
    movie = get_object_or_404(Movie, id=m_id)
    ratings = movie.rating_set.all()
    form = RatingForm()

    context = {
        'movie': movie,
        'form' : form,
        'ratings': ratings
    }

    return render(request, 'movies/detail.html', context)

@login_required
def edit(request, m_id):
    movie = get_object_or_404(Movie, id=m_id)
    
    if request.user != movie.user:
        return redirect(movie)

    if request.method == "POST":
        form = MovieForm(request.POST, request.FILES, instance=movie)
        print(form.data)
        if form.is_valid():
            movie = form.save()
            return redirect(movie)
    else:
        form = MovieForm(instance=movie)
    context = {
        'form':form,
        'button_label': "수정하기"
    }
    return render(request, 'movies/base_form.html', context)

@login_required
@require_POST
def delete(request, m_id):
    movie = get_object_or_404(Movie, id=m_id)
    
    if request.user != movie.user:
        return redirect(movie)
    movie.delete()

    return redirect('movies:index')

@login_required
@require_POST
def rating_new(request, m_id):
    movie = get_object_or_404(Movie, id=m_id)
    form = RatingForm(request.POST)
    if form.is_valid():
        rating = form.save(commit=False)
        rating.user = request.user
        rating.movie = movie
        rating.save()
        return redirect(movie)

    ratings = Rating.objects.all()
    context = {
        'movie': movie,
        'form': form,
        'ratings':ratings
    }
    return render(request, 'movies/detail.html', context)

@login_required
@require_POST
def rating_del(request, m_id, r_id):
    rating = get_object_or_404(Rating, id=r_id)
    
    movie = get_object_or_404(Movie, id=m_id)
    
    if request.user == rating.user:
        rating.delete()

    return redirect(movie)