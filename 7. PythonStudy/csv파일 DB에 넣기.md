1. 장고 프로젝트 폴더 밑에 data.csv 넣기

2. movie/urls.py

path('csv2db/', views.csv2db, name='csv2db'),


3. movie/views.py
# -----------------------------------------------------------------------------
# 추가 임포트
# -----------------------------------------------------------------------------
import csv, datetime


# -----------------------------------------------------------------------------
# csv2db
# -----------------------------------------------------------------------------
def csv2db(request):
    with open("data.csv", 'r', encoding='utf-8') as fp:
        csvdata = csv.reader(fp)
        for i, line in enumerate(csvdata):
            print(i, line)
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


4. 127.0.0.1/movie/csv2db 접속