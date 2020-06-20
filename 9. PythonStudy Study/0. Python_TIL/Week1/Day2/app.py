from flask import Flask, render_template, request
import random
from pprint import pprint
import requests

app = Flask(__name__)

@app.route('/')
def hello():
        name = "월드!"
        return f"안녕 {name}!"

@app.route('/mulcam')
def mulcam():
        return "멀캠"

@app.route('/greeting/<string:name>')
def greeting(name):
        return f"{name}님 안녕"

@app.route('/lunch/<int:num>')
def lunch(num):
        menu = ["짜장", "짜장2", "짜장3", "짜장4", "짜장5"]
        order = random.sample(menu, num)
        return str(order)

@app.route('/lotto')
def lotto():
        lottonum = range(1, 47)
        order = random.sample(lottonum, 6)
        return str(order)

@app.route('/html')
def html():
        mutiline = '''
        <h1> This is H1 Tag </h1>
        '''
        return mutiline

@app.route('/hi/<string:id>')
def hi(id):
        return render_template('hi.html', id=id)

@app.route('/lunch2/<int:num>')
def lunch2(num):
        menu = ["짜장", "짜장2", "짜장3", "짜장4", "짜장5"]
        order = random.sample(menu, num)
        return render_template('lunch.html', menu=order)

@app.route('/fake_naver')
def fake_naver():
        return render_template('fake_naver.html')

@app.route('/fake_google')
def fake_google():
        return render_template('fake_google.html')

@app.route('/send')
def send():
        return render_template('send.html')

@app.route('/receive')
def receive():
        name = request.args.get('name')
        message = request.args.get('message')
        return render_template('receive.html', name=name, msg=message)

@app.route('/send2')
def send2():
        return render_template('send2.html')

@app.route('/receive2')
def receive2():
        name = request.args.get('name')
  
        yearlist = [ '시끄러운', '말 많은', '푸른', '어두운', '적색', '조용한', '웅크린', '백색', '지혜로운', '용감한', '날카로운', '욕심 많은' ]
        monthlist = [ '늑대', '태양', '양', '매', '황소', '불꽃', '나무', '달빛', '말', '돼지', '하늘', '바람' ]
        daylist = [ '와(과) 함께 춤을', '의 기상', '은(는) 그림자 속에', '의 환생', '의 죽음', '아래에서', '을(를) 보라.',
                '이(가) 노래하다.', '의 그늘', '의 일격', '에게 쫒기는 남자', '의 행진', '의 왕', '의 유령', '을 죽인 자.',
                '은(는) 맨날 잠잔다.', '처럼..', '의 고향', '의 전사', '은(는) 나의 친구', '의 노래', '의 정령', '의 파수꾼', '의 악마', '와(과) 같은 사나이', '심판자을(를) 쓰러뜨린 자', '의 혼',
                '은(는) 말이 없다.']

        # year = random.sample(yearlist, 1)
        year = random.choice(yearlist)
        month = random.sample(monthlist, 1)
        day = random.sample(daylist, 1)

        res = f'{name}님은{year+month+day}'
        # return render_template('receive2.html', name=name, year=year[0], month=month[0], day=day[0])
        return render_template('receive2.html', res=res)

@app.route('/lotto_get')
def lotto_get():
        return render_template('lotto_get.html')
        

@app.route('/lotto_num')
def lotto_num():
        num = request.args.get("num")
        url = f"https://dhlottery.co.kr/common.do?method=getLottoNumber&drwNo={num}"
        res = requests.get(url).json()
        # pprint(res)
        # List comprehension
        # [ 받는변수 for 받는변수 in 범위로된 데이터 ]
        wnum = [ res[f'drwtNo{i}'] for i in range(1, 7) ]
        lotto = random.sample(range(1,47), 6)
        
        # 교집합만 리스트에 넣어라
        match = list(set(wnum) & set(lotto))
        
        count = len(match)
        msg = ""
        if count == 6:
                msg = "1등"
        elif count == 5:
                msg = "2등"
        elif count == 4:
                msg = "3등"
        elif count == 3:
                msg = "4등"
        else :
                msg = "꽝"

        return render_template('lotto_result.html', wnum=wnum, lotto=lotto, match=match, count=count, num=num, msg=msg)

        
        print(lotto)
        print(match)        
        print(wnum)


        #return f'{res}'













if __name__ == "__main__":
        app.run(debug=True, port=8000)