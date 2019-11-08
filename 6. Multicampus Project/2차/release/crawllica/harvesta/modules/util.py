# -*- coding: utf-8 -*-
#util.py

import urllib.request
import requests
from bs4 import BeautifulSoup
import re

#------------------------------------------------------------------------------
# 데이터 프레임에 담는 헬퍼 함수
#------------------------------------------------------------------------------
def insert_dfrow(df, keyword_source, keywords, i, news_source, news_list):
    if news_source != 'Twitter':
        for j, news in enumerate(news_list):
            title = BeautifulSoup(news['title'], 'html.parser').text
            df.loc[len(df.index)] = [
                keyword_source, keywords, i+1, news_source, j+1, 
                title, news['link']]
    else:
        for j, tweets in enumerate(news_list):
            df.loc[len(df.index)] = [
                keyword_source, keywords, i+1, news_source, j+1, 
                "", tweets]


#------------------------------------------------------------------------------
# URL의 <body>만 추출해오는 함수
#------------------------------------------------------------------------------
def getbody(url):
    # Browser fake
    headers = {'User-Agent' : "".join([
        'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 ',
        '(KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36'])}
    try:
        res = requests.get(url, headers=headers, timeout=10)
        soup = BeautifulSoup(res.content, 'html.parser')
        code = 0; text = str(soup.html.body)
    except Exception as e:
        print(e)
        code = 1; text = str(e)
    finally:
        return {'code' : code , 'text' : text}


#------------------------------------------------------------------------------
# module test code
#------------------------------------------------------------------------------
if __name__ == "__main__":
    body = getbody("".join(["http://www.kookje.co.kr/news2011/asp/", 
        "newsbody.asp?code=0700&key=20191010.99099004655"]))
 
    print(body)