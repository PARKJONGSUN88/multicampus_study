from django.contrib import admin

from .models import Board, Comment
# Register your models here.

class CommentAdmin(admin.ModelAdmin):
    list_display = ['comment']

admin.site.register(Board)
admin.site.register(Comment, CommentAdmin)