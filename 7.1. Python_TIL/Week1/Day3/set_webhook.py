from decouple import config
import requests
from pprint import pprint

token = config('TOKEN')
base_url = f"https://api.telegram.org/bot{token}"
# url = "6f4306c8.ngrok.io"
url = "PARKJONGSUN.pythonanywhere.com"
setweb_url = f'/setWebhook?url={url}'

req = requests.get(base_url+setweb_url).json()

# pprint(req)