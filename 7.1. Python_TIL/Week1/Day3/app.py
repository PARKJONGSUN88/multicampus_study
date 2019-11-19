from flask import Flask, render_template, request
import requests
from decouple import config # .env파일에 저장된 Token받아오기
from pprint import pprint
import random

app = Flask(__name__)

# token값 받아오기
token = config('TOKEN')
# telegram bot API 문서에 request url
# https://api.telegram.org/bot<token>/METHOD_NAME
base_url = f"https://api.telegram.org/bot{token}"


@app.route('/telegram')
def telegram():   

    # telegram 서버에 data요청
    # .json() 이 없으면 응답코드만 받음
    res = requests.get(f'{base_url}/getUpdates').json()

    # chat id 추출(sendMessage할 때 필요하기 때문)
    chat_id = res['result'][0]["message"]['chat']['id']

    # pprint(chat_id)

    def lotto():
        lottonum = range(1, 47)
        order = random.sample(lottonum, 6)
        return str(order)

    lotto_num = lotto()
    lottogo = requests.get(f'{base_url}/sendMessage?chat_id={chat_id}&text={lotto_num}').json()

    # pprint(lottogo)
    return ''

def lotto():
    lottonum = range(1, 47)
    order = random.sample(lottonum, 6)
    return str(order)

@app.route('/lotto')
def lotto_go():   
    res = requests.get(f'{base_url}/getUpdates').json()    
    chat_id = res['result'][0]["message"]['chat']['id']
    lotto_num = lotto()
    lottogo = requests.get(f'{base_url}/sendMessage?chat_id={chat_id}&text={lotto_num}').json()    
    return ''

@app.route("/chat")
def chat():
    return render_template("chat.html")

@app.route("/send_msg")
def send_message():
    req = request.args.get("chat")

    res = requests.get(f'{base_url}/getUpdates').json()
    chat_id = res['result'][0]["message"]['chat']['id']

    send_url = f'/sendMessage?chat_id={chat_id}&text={req}'

    response = requests.get(base_url+send_url)
    
    return "보내기 완료"

# @app.route("/", methods=['POST'])
# def tel_web():
#     req = request.get_json().get('message')

#     # pprint(req)

#     if req is not None:
#         chat_id = req.get('chat').get('id')
#         text = req.get('text')
#     print(chat_id, text)

#     # neyoung = req["text"], req['chat']['id']
#     # pprint(neyoung)

#     return '', 200

def indian():
    yearlist = [ '시끄러운', '말 많은', '푸른', '어두운', '적색', '조용한', '웅크린', '백색', '지혜로운', '용감한', '날카로운', '욕심 많은' ]
    monthlist = [ '늑대', '태양', '양', '매', '황소', '불꽃', '나무', '달빛', '말', '돼지', '하늘', '바람' ]
    daylist = [ '와(과) 함께 춤을', '의 기상', '은(는) 그림자 속에', '의 환생', '의 죽음', '아래에서', '을(를) 보라.',
            '이(가) 노래하다.', '의 그늘', '의 일격', '에게 쫒기는 남자', '의 행진', '의 왕', '의 유령', '을 죽인 자.',
            '은(는) 맨날 잠잔다.', '처럼..', '의 고향', '의 전사', '은(는) 나의 친구', '의 노래', '의 정령', '의 파수꾼', '의 악마', '와(과) 같은 사나이', '심판자을(를) 쓰러뜨린 자', '의 혼',
            '은(는) 말이 없다.']        
    year = random.choice(yearlist)
    month = random.choice(monthlist)
    day = random.choice(daylist)
    return f'{year+" "+month+day}'

@app.route("/", methods=['POST'])
def tel_web():
    C_ID = config('C_ID')
    C_SC = config('C_SC')
    url = "https://openapi.naver.com/v1/papago/n2mt"

    headers = {
        "Content-Type" : "application/x-www-form-urlencoded; charset=UTF-8",
        "X-Naver-Client-Id" : C_ID,
        "X-Naver-Client-Secret" : C_SC
    }
    
    req = request.get_json().get('message')
    # pprint(req)

    if req is not None:
        chat_id = req.get('chat').get('id')
        text = req.get('text')
    
        # pprint(text)                
        # if text == "로또":
        #     msg = lotto()

    if "로또" in text:
        msg = lotto()
    elif "인디언" in text:
        msg = indian()
    elif "/번역" in text:
        re_txt = text.replace("/번역", "")  
        data = {
            'source' : "ko",
            "target" : "en",
            "text" : re_txt
        }        
        res = requests.post(url, headers=headers, data=data).json()
        msg = res.get('message').get('result').get("translatedText") 


    else:
        msg = "뭐라는거여~~ 다시 확인하란 말이야~"

    print(msg)

    send_url = f'/sendMessage?chat_id={chat_id}&text={msg}'

    response = requests.get(base_url+send_url)

    return '', 200    


@app.route("/papago")
def papago():
    C_ID = config('C_ID')
    C_SC = config('C_SC')
    url = "https://openapi.naver.com/v1/papago/n2mt"

    headers = {
        "Content-Type" : "application/x-www-form-urlencoded; charset=UTF-8",
        "X-Naver-Client-Id" : C_ID,
        "X-Naver-Client-Secret" : C_SC
    }

    data = {
        'source' : "ko",
        "target" : "en",
        "text" : "안녕하세요"
    }

    

    res = requests.post(url, headers=headers, data=data).json()
    msg = res.get('message').get('result').get("translatedText")
    
    return "Finish"



if __name__ == "__main__":
    app.run(debug=True)