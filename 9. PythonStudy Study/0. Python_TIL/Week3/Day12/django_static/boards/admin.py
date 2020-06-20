from django.contrib import admin
from .models import Board

class BoardAdmin(admin.ModelAdmin):
    list_display = ['title', 'image' ]

admin.site.register(Board, BoardAdmin)