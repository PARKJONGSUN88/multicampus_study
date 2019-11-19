from django.shortcuts import render
from django.http import HttpResponse
import random
from faker import Faker
from datetime import datetime

# Create your views here.
def index(request):
    return render(request, 'index.html')

def age(request, age):
    context = {'age' : age}
    return render(request, 'age.html', context)

def squ(request, num):
    context = { 'res' : num**2 }    
    return render(request, 'squ.html', context)

def plus(request, num1, num2):
    context = {
        'num1' : num1,
        'num2' : num2,
    }
    hap = context["num1"] + context["num2"]
    return render(request, 'cal.html', hap)

def profile(request, name, age):
       
    yearlist = [ '시끄러운', '말 많은', '푸른', '어두운', '적색', '조용한', '웅크린', '백색', '지혜로운', '용감한', '날카로운', '욕심 많은' ]
    monthlist = [ '늑대', '태양', '양', '매', '황소', '불꽃', '나무', '달빛', '말', '돼지', '하늘', '바람' ]
    daylist = [ '와(과) 함께 춤을', '의 기상', '은(는) 그림자 속에', '의 환생', '의 죽음', '아래에서', '을(를) 보라.',
            '이(가) 노래하다.', '의 그늘', '의 일격', '에게 쫒기는 남자', '의 행진', '의 왕', '의 유령', '을 죽인 자.',
            '은(는) 맨날 잠잔다.', '처럼..', '의 고향', '의 전사', '은(는) 나의 친구', '의 노래', '의 정령', '의 파수꾼', '의 악마', '와(과) 같은 사나이', '심판자을(를) 쓰러뜨린 자', '의 혼',
            '은(는) 말이 없다.']        
    year = random.choice(yearlist)
    month = random.choice(monthlist)
    day = random.choice(daylist)
    hap = year+" "+month+day

    lottonum = range(1, 47)    
    lotto = random.sample(lottonum, 6)
    lotto.sort()

    #I_num=[str(l) for l un lotto]

    context = {
        'name' : name,
        'age' : age,
        'hap' : hap,
        'lotto' : lotto,
        #'lotto' : ", ".join(I_num)            
    }
    return render(request, 'profile.html', context)


def before(request, name):
    fake = Faker('ko_KR')    
    job = fake.job()
    context = {
        'name' : name,
        'job' : job,
    }
    return render(request, 'before.html', context)

def image(request):
    num = random.choice(range(1, 1000))
    url = f'https://picsum.photos/id/{num}/200/300'
    context = {
        'url' : url,
    }
    return render(request, 'image.html', context)

def dtl(request):
    foods = ["짜장면", "탕수육", "짬뽕", "양장피", "군만두", "고추잡채", "볶음밥"]
    my_sentence = "Life is short, you need python"
    messages = ['apple', 'banana', "cucumber", "mango"]
    datetimenow = datetime.now() #현재 시간
    empty_list = []
    context = {
        "foods" : foods,
        "my_sentence" : my_sentence,
        "messages" : messages,
        "timenow" : datetimenow,
        "empty_list" : empty_list,
    }
    return render(request, "dtl.html", context)

# def isitbirthday(request):
#     datetimenow = datetime.now()
#     context = {
#         "timenow" : datetimenow,
#     }
#     return render(request, "isitbirthday.html", context)

def isitbirthday(request):
    today = datetime.now()

    if today.month == 7 and today.date == 22:
        res = True
    else:
        res = False

    birth = datetime(2020, 7, 22)
    d_day = (birth-today).days

    context = {
        'result' : res,
        "d_day" : d_day,
    }
    return render(request, "isitbirthday.html", context)