from django.shortcuts import render, redirect
from .models import Movie
import csv, datetime

# Create your views here.
def index(request):
    movies = Movie.objects.order_by('-id')
    context = {
        'movies' : movies,
    }
    return render(request, 'MovieSite/index.html', context)

def new(request):
    if request.method == 'POST':
        m = Movie(
            title = request.POST.get('title'), 
            title_en = request.POST.get('title_en'),
            audience = request.POST.get('audience'),
            open_date = request.POST.get('open_date'),
            genre = request.POST.get('genre'),
            watch_grade = request.POST.get('watch_grade'),
            score = request.POST.get('score'),
            poster_url = request.POST.get('poster_url'),            
            description = request.POST.get('description')
        )
        m.save()
        return redirect('movie:index')
    else:
        return render(request, 'MovieSite/new.html')

def detail(request, id):
    movie = Movie.objects.get(id=id)
    context = {
        'movie' : movie,
    }
    return render(request, 'MovieSite/detail.html', context)

def edit(request, id):
    movie = Movie.objects.get(id=id)
    if request.method == "POST":    
        movie.title = request.POST.get('title')
        movie.title_en = request.POST.get('title_en')
        movie.audience = request.POST.get('audience')
        movie.open_date = request.POST.get('open_date')
        movie.genre = request.POST.get('genre')
        movie.watch_grade = request.POST.get('watch_grade')
        movie.score = request.POST.get('score')
        movie.poster_url = request.POST.get('poster_url')            
        movie.description = request.POST.get('description')
        movie.save()        
        return redirect('movie:detail', movie.id)
    else:
        context = {
            'movie' : movie,
        }
        return render(request, 'MovieSite/edit.html', context)

def delete(request, id):    
    movie = Movie.objects.get(id=id)
    if request.method == 'POST':
        movie.delete()
        return redirect('movie:index')
    else:
        return redirect('movie:detail', movie.id)

def csv2db(request):
    with open("data.csv", 'r', encoding='utf-8') as fp:
        csvdata = csv.reader(fp)
        for i, line in enumerate(csvdata):
            if i == 0: continue
            movie = Movie()
            movie.title = line[0]
            movie.title_en = line[1]
            movie.audience = int(line[2])
            day = datetime.datetime.strptime(line[3], '%Y%m%d')
            movie.open_date = day
            movie.genre = line[4]
            movie.watch_grade = line[5]
            movie.score = line[6]
            movie.poster_url = line[7]
            movie.description = line[8]
            movie.save()
    return redirect('movie:index')

def deleteall(request):
    movie = Movie.objects.all()
    movie.delete()
    return redirect('movie:index')