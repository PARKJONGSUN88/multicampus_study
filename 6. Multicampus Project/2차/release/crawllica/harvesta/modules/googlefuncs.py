# -*- coding: utf-8 -*-
#googlefuncs.py

import urllib.request
import requests
import re
from bs4 import BeautifulSoup
import time
import random


#--------------------------------------------------------------------------
# cnt개의 뉴스 제목과 링크 반환
#--------------------------------------------------------------------------
def get_newslist(search_words, cnt):
    encText = urllib.parse.quote(search_words)
    baseUrl = 'https://www.google.co.kr/search?q='
    suffix1 = "&tbm=nws&start="
    suffix2 = "&sa=N"
    # header = {'User-Agent' : 'Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 \
    #     (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36'}
    p = re.compile(r"\?q=.*&sa")

    newsList = []
    start = 0
    while len(newsList) < cnt:
        try:
            res = requests.get(
                baseUrl + encText + suffix1 + str(start) + suffix2)

            #블럭 당하면 caller 에게 -1로 알림
            if re.compile(r"Our systems have detected").search(res.text):
                return -1 

            soup =  BeautifulSoup(res.content, 'html.parser')
            candList = soup.select('#ires ol div table h3 a')
            if len(candList) == 0: break   # 뉴스가 모자라면 그만둠
            for cand in candList:
                if len(newsList) >= cnt: break # 다 채웠으면 그만둠
                m = p.search(cand.get('href'))
                if m:
                    link = m.group()[3:-3]
                    newsList.append({
                        'title' : cand.text,
                        'link' : urllib.parse.unquote(link).strip() })
                else:
                    print("skipped: " + cand.get('href'))
        except Exception as e:
            print(e)
        finally:
            start += 10 # 다음 페이지
            wait = round(random.uniform(0, 2.5), 1)
            print("random sleep {} sec...".format(wait))
            time.sleep(wait)

    return newsList


#--------------------------------------------------------------------------
# module test code - getNewsList()
#--------------------------------------------------------------------------
if __name__ == "__main__":
    newsList = get_newslist("검찰 개혁", 3) # 뉴스 11개 테스트
    print(newsList)
