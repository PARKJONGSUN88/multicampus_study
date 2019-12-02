from django.shortcuts import render, redirect
from django.contrib.auth.forms import UserCreationForm, AuthenticationForm, PasswordChangeForm
from django.contrib.auth import login as auth_login
from django.contrib.auth import logout as auth_logout
from django.contrib.auth.decorators import login_required
from .forms import UserCustomChangeForm
from django.contrib.auth import update_session_auth_hash

def signup(request):

    if request.user.is_authenticated:
        return redirect('movies:index')

    if request.method == "POST":
        form = UserCreationForm(request.POST)
        if form.is_valid():
            user = form.save()
            auth_login(request, user)
            return redirect('movies:index')
    else:
        form = UserCreationForm()

    context = {
        'form':form
    }
    return render(request, 'accounts/auth_form.html', context)

def login(request):
    if request.user.is_authenticated:
        return redirect('movies:index')
    
    if request.method == "POST":
        form = AuthenticationForm(request, request.POST)
        if form.is_valid():
            auth_login(request, form.get_user())
            return redirect('movies:index')
    else:
        form = AuthenticationForm()

    context = {
        'form': form
    }
    return render(request, 'accounts/auth_form.html', context)

@login_required
def logout(request):
    if request.method == "POST":
        auth_logout(request)
        
    return redirect('movies:index')


@login_required
def edit(request):
    print(request.user)
    if request.method == "POST":
        form = UserCustomChangeForm(request.POST, instance=request.user)
        if form.is_valid():
            form.save()
            return redirect('movies:index')
    else:
        form = UserCustomChangeForm(instance=request.user)

    context = {
        'form':form,
        'button_label': "Edit"
    }
    return render(request, 'accounts/auth_form.html', context)
    

@login_required
def password(request):

    if request.method == "POST":
        form = PasswordChangeForm(request.user, request.POST)
        if form.is_valid():
            user = form.save()
            update_session_auth_hash(request, user)
            return redirect('accounts:edit')
    else:
        form = PasswordChangeForm(request.user)

    context = {
        'form':form,
        'button_label': "Edit"
    }
    return render(request, 'accounts/auth_form.html', context)
