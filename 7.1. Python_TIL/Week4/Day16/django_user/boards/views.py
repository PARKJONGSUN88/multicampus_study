from django.shortcuts import render, redirect, get_object_or_404
from .forms import BoardForm, CommentForm
from .models import Board, Comment
from django.contrib.auth.decorators import login_required
from django.views.decorators.http import require_POST

def index(request):
    boards = Board.objects.all()

    context = {
        'boards':boards
    }
    return render(request, 'boards/index.html', context)

@login_required
def new(request):
    if request.method == "POST":
        form = BoardForm(request.POST)
        
        if form.is_valid():
            # DB에 바로 적용하지 않고 form이 참고하는 모델로 인스턴스를 만들어줌.
            board = form.save(commit=False)
            # 게시글의 유저 정보를 저장
            board.user = request.user
            # 게시글을 DB에 저장
            board.save()

            return redirect('boards:index')

    else:
        form = BoardForm()

    context = {
        'form':form
    }
    return render(request, 'boards/new.html', context)

def detail(request, b_id):
    board = get_object_or_404(Board, id=b_id)
    
    # 댓글 달기 폼 생성
    comment_form = CommentForm()
    # 게시글이 가진 모든 댓글을 가져옴
    comments = board.comment_set.all()

    context = {
        'board':board,
        'comment_form': comment_form,
        'comments': comments
    }
    return render(request, 'boards/detail.html', context)

@login_required
def edit(request, b_id):
    # Board 모델 안에 해당 값이 있으면 가져오고 없으면 404 에러 발생
    board = get_object_or_404(Board, id=b_id)

    # 현재 로그인 유저와 게시글 작성 유저 비교
    if request.user != board.user:
        return redirect('boards:index')

    if request.method == "POST":
        # instance에 위에서 찾은 board 값을 지정.
        # 그렇게 하면 db에 저장된 내용이 Form에 적용됨.
        # 첫번째 인자로 request.POST가 있으면
        # POST 로 받은 데이터 내용이 폼에 씌여짐.
        # board의 내용으로 적용된 Form에 새롭게 POST로 받은 데이터까 씌여짐.
        # 즉 수정되게됨.
        form = BoardForm(request.POST, instance=board)
        if form.is_valid():
            board = form.save()
            return redirect('boards:detail', board.id)
    else:
        # 폼을 이미 저장된 내용으로 채우기 위해 instance=board 사용
        form = BoardForm(instance=board)

    context = {
        'form': form
    }
    return render(request, 'boards/edit.html', context)

@login_required
def delete(request, b_id):
    board = get_object_or_404(Board, id=b_id)

    if request.user != board.user:
        return redirect('boards:index')
        
    if request.method == "POST":
        board.delete()
        return redirect('boards:index')

    return redirect('boards:detail', board.id)

@login_required
@require_POST
def new_comment(request, b_id):
    form = CommentForm(request.POST)

    if form.is_valid():
        # 댓글 모델은 게시글과 유저 정보가 필요해서 바로저장을 시키지 않음.
        comment = form.save(commit=False)
        comment.board_id = b_id # 게시글 정보 저장
        comment.user = request.user # 유저 정보 저장
        comment.save() # 최종 db에 저장
        return redirect('boards:detail', b_id)
    else: # 유효성 검사에 실패했을때.
        board = Board.objects.get(id=b_id)
        comments = board.comment_set.all()

        context = {
            'board':board,
            'comment_form':form,
            'comments':comments
        }
        return render(request, 'boards/detail.html', context)

@login_required
@require_POST
def del_comment(request, c_id):
    comment = get_object_or_404(Comment, id=c_id)
    # 게시글의 정보가 필요해서 삭제되기 전에 저장.
    board_id = comment.board_id
    if request.user == comment.user:
        comment.delete()

    return redirect('boards:detail', board_id)

@login_required
def like(request, b_id):
    board = get_object_or_404(Board, pk=b_id)

    # 좋아요를 저장해두는 곳에 유저가 있는지 확인
    # if board.like_users.filter(id=request.user.id).exists()
    if request.user in board.like_users.all():
        # 있으면 목록에서 제거
        board.like_users.remove(request.user)
    else:
        # 없으면 목록에 등록
        board.like_users.add(request.user)

    return redirect('boards:index')
