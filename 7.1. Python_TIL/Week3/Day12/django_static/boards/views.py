from django.shortcuts import render, redirect
from .models import Board
# Create your views here.
def index(request):
    boards = Board.objects.all()

    context = {
        "boards":boards
    }
    return render(request, 'boards/index.html', context)

def new(request):
    if request.method == "POST":
        title = request.POST.get('title')
        content = request.POST.get('content')
        # 파일은 request.POST.get 이 아닌 request.FILES.get을 해야함.
        image = request.FILES.get('image')

        board = Board(title=title, content=content, image=image)
        board.save()

        return redirect('boards:index')
    else:
        return render(request, 'boards/new.html')


def detail(request, b_id):
    board = Board.objects.get(id=b_id)

    context = {
        'board': board
    }
    return render(request, 'boards/detail.html', context)

def edit(request, b_id):
    board = Board.objects.get(id=b_id)

    if request.method == "POST":
        board.title = request.POST.get('title')
        board.content = request.POST.get('content')
        img = request.FILES.get('image')
        
        # 이미지에 빈값이 있으면 저장하지 않게 하기위해서
        if img is not None:
            board.image = img

        board.save()
        return redirect('boards:detail', board.id)
    else:
        context = {
            'board': board
        }
        return render(request, 'boards/edit.html', context)