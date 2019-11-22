from django.shortcuts import render, redirect
from .forms import BookForm
from .models import Book
from IPython import embed

# Create your views here.
def index(request):
    books = Book.objects.all()
    context = {
        'books' : books
    }
    return render(request, 'prac_form/index.html', context)

def new(request):
    if request.method == "POST":
        form = BookForm(request.POST)

        if form.is_valid():
            book = form.save() #modelform사용시
            # book = Book()
            # book.name = form.cleaned_data.get('name')
            # # book.name = form.cleaned_data.get[]'name']
            # book.preface = form.cleaned_data.get('preface')
            # book.save()
            return redirect('prac:index')
    else:            
        form = BookForm()

    context = {
        'form' : form,
    }
    return render(request, 'prac_form/new.html', context)

def detail(request, b_id):
    book = Book.objects.get(id=b_id)
    context = {
        'book' : book
    }
    return render(request, 'prac_form/detail.html', context)