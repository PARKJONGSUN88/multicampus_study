from django import forms
from .models import Article, Author

class ArticleForm(forms.Form):
    title = forms.CharField()
    content = forms.CharField()

class AuthorForm(forms.ModelForm):
    class Meta:
        model = Author
        fields = ['name', 'company']