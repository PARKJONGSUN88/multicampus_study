# -*- coding: utf-8 -*-
#naverFuncs.py

import requests
import urllib.request
from bs4 import BeautifulSoup
import re
import json
if __name__ != '__main__':
    from . import config


#--------------------------------------------------------------------------
# 실시간 인기 검색어 cnt개 반환
#--------------------------------------------------------------------------
def get_keywords(cnt):
    naverUrl = "https://www.naver.com"
    try:
        html = requests.get(naverUrl, timeout=10).content
        soup = BeautifulSoup(html, 'html.parser')
        tagList = soup.select('.ah_roll_area .ah_k')
        naver_keywords = []
        for keyword in tagList:
            naver_keywords.append(keyword.get_text())
    except Exception as e:
        print(e)
        return naver_keywords
    else:
        #cnt 개의 결과만을 반환
        return naver_keywords[:min([len(naver_keywords), cnt])]


#--------------------------------------------------------------------------
# 검색어로 뉴스를 검색하여 cnt개 반환
#--------------------------------------------------------------------------
def get_newslist(search_words, cnt):
    encText = urllib.parse.quote(search_words)
    url = "".join(["https://openapi.naver.com/v1/search/news.json?",
            "query={0}&display={1}&sort={2}"]).format(encText, cnt, "date") 

    # NAVER API를 이용하여 검색
    request = urllib.request.Request(url)
    request.add_header("X-Naver-Client-Id", config.clientID)
    request.add_header("X-Naver-Client-Secret", config.clientSecret)
    try:
        response = urllib.request.urlopen(request)
    except Exception as e:
        print(e)
    else:
        rescode = response.getcode()
        if(rescode == 200):
            response_body = response.read()
            newsList = json.loads(response_body.decode('utf-8'))['items']

            # title과 link만 추출하여 담기
            resultList = []
            for news in newsList:
                resultList.append({ 
                    'title' : re.sub("<[^>]*>", '', news['title']),
                    # 'link' : news['originallink'] != 
                    #     '' and news['originallink'] or news['link']})
                    'link' : news['link']})
        else:
            print("Error Code:" + rescode)
   
    #결과 반환 (없으면 없는대로)
    return resultList


#--------------------------------------------------------------------------
# module test code
#--------------------------------------------------------------------------
if __name__ == "__main__":
    naverKeywords = get_keywords(120)
    print(naverKeywords)
    import config
    newsList = get_newslist("미대륙 횡단열차", 30) #1 키워드 1 뉴스 테스트
    for news in newsList: print(news)