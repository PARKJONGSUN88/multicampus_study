from django.contrib.auth.forms import UserChangeForm
from django.contrib.auth import get_user_model

class UserCustomChangeForm(UserChangeForm):
    class Meta:
        model = get_user_model()
        fields = ['first_name', 'last_name', 'email']