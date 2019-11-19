from django.contrib import admin
from .models import Board, Subway

# Register your models here.

class BoardAdmin(admin.ModelAdmin):
    fields = ['content', 'title']
    list_display = ['title', 'updated_at', 'created_at']
    list_filter = ['updated_at']
    search_fields = ['title', 'content']

admin.site.register(Board, BoardAdmin)
admin.site.register(Subway)
