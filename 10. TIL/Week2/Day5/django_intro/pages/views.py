from django.shortcuts import render
import random
import requests

# Create your views here.
def throw(request):
    return render(request, 'pages/throw.html')

def catch(request):
    # print(request)
    # print(request.path)
    # print(request.method)   
    # print(request.META)
    # print(request.GET)
    message = request.GET.get('message')
    message2 = request.GET.get('message2')
    context = {
        'msg' : message,
        'msg2' : message2,
    }
    return render(request, 'pages/catch.html', context)

def lotto(request):
    return render(request, 'pages/lotto.html')

def lotto_result(request):
    count = int(request.GET.get('count')) #형변환 안하면 str타입으로 받아짐
    # print(type(count))
    lotto_num = []
    for i in range(count):
        lotto_num.append(random.sample(range(1,47),6))        
    context = {
        'count' : count,
        'lotto_num' : lotto_num,
    }
    return render(request, 'pages/lotto_result.html', context)

def artii(request):
    return render(request, 'pages/artii.html')

def artii_result(request):
    neyong = request.GET.get('neyong')
    url = 'http://artii.herokuapp.com/make?text='
    # 폰트리스트 받아오기
    f_url = 'http://artii.herokuapp.com/fonts_list'
    fonts = requests.get(f_url).text
    fonts = fonts.split('\n')
    # 폰트 랜덤 고르기
    font = random.choice(fonts)
        
    hap = url+neyong+"&font="+font

    res = requests.get(hap).text  # 텍스트값이니까 .text를 해서 json받듯이 
    # print(res)
    context = {
        'res' : res
    }
    return render(request, 'pages/artii_result.html', context)

# def artii_result(request):
#     neyong = request.GET.get('neyong')
#     url = 'http://artii.herokuapp.com/make?text='
#     hap = url+neyong
#     res = requests.get(hap).text 
#     context = {
#         'res' : res
#     }
#     return render(request, 'artii_result.html', context) 

def user_new(request) :
    return render(request, 'pages/user_new.html')

def user_create(request) :
    username = request.POST.get('name')
    pw = request.POST.get('pw')
    context = {
        'username' : username,
        'pw' : pw,
    }
    return render(request, 'pages/user_create.html', context)

def subway(request) :
    return render(request, 'pages/subway.html')

def subway_pick(request) :
    size = request.POST.get('size')
    bread = request.POST.get('bread')
    source = request.POST.get('source')
    context = {
        'size' : size,
        'bread' : bread,
        'source' : source,
    }
    return render(request, 'pages/subway_pick.html', context)

def static_example(request) :
    return render(request, 'pages/static.html')

def index(request) :
    return render(request, 'pages/index.html')