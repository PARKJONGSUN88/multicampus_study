from django.shortcuts import render

# Create your views here.
def static_example(request) :
    return render(request, 'pages/static.html')