from django.shortcuts import render, redirect
from .models import Question

# Create your views here.
def index(request):
    lists = Question.objects.order_by('-id')
    context = {
        'lists' : lists,
    }
    return render(request, 'qc10/index.html', context)

def new(request):
    if request.method == "POST":
        question = Question(content=request.POST.get('content'))
        question.save()
        return redirect('qc10:index')
    else:
        return render(request, 'qc10/new.html')

def detail(request, qc_id):
    qc = Question.objects.get(id=qc_id)
    context = {
        'qc' : qc,
    }
    return render(request, 'qc10/detail.html', context)

def update(request, qc_id):
    qc = Question.objects.get(id=qc_id)
    if request.method == "POST":
        qc.content = request.POST.get('content')
        qc.save()
        return redirect('qc10:detail', qc.id)
    else:
        return render(request, 'qc10/update.html', { 'qc' : qc })
