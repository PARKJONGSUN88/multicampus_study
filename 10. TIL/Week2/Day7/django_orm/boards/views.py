from django.shortcuts import render
from .models import Subway

# Create your views here.
def index(request):
    return render(request, 'boards/index.html')

def subway(request) :
    return render(request, 'boards/subway.html')

def subway_pick(request) :
    size = request.POST.get('size')
    bread = request.POST.get('bread')
    source = request.POST.get('source')

    # Subway.objects.create(title="주문", size=size, bread=bread, source=source)
    subway = Subway()    
    subway.size = size
    subway.bread = bread
    subway.source = source
    subway.save()

    result = Subway.objects.all()

    context = { 
        'result' : result,
    }
    return render(request, 'boards/subway_pick.html', context)

def subway_id(request, id):
    sub = Subway.objects.get(pk=id)
    context = { 
        'result' : sub,
    }
    return render(request, 'boards/subway_id.html', context)

    