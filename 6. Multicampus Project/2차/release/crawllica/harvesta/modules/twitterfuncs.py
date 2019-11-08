# -*- coding: utf-8 -*-
#twitterfuncs.py

from twitter import Twitter, OAuth
import yweather
import requests
from operator import itemgetter
import re
from bs4 import BeautifulSoup
if __name__ != "__main__":
    from . import config


#--------------------------------------------------------------------------
# twitter Module 반환
#--------------------------------------------------------------------------
def get_twitter():
    return Twitter(auth = OAuth(
        config.access_key,
        config.access_secret,
        config.consumer_key,
        config.consumer_secret))


#--------------------------------------------------------------------------
# 지역명에 해당하는 WOEID 반환
#--------------------------------------------------------------------------
def get_woeid(location):
    return yweather.Client().fetch_woeid(location)


#--------------------------------------------------------------------------
# Twitter API를 이용한 실시간 트렌드 10개
#--------------------------------------------------------------------------
def get_api_trends(twitter, woeid):
    try:
        places = twitter.trends.place(_id = woeid) 
        compactList = []
        for location in places:
            for trend in location["trends"]:
                name = re.sub('#', '', trend["name"])
                name = re.sub('_', ' ', name)
                volume = trend["tweet_volume"]
                volume = 0 if volume == None else volume
                compactList.append({"name" : name, "volume" : volume, "len" : len(name)})
        sortedList = sorted(compactList, key=itemgetter("volume", "len"), reverse=True)

        finalList = []
        for trend in sortedList[:10]:
            finalList.append(trend["name"])

        # #메타 정보 확인을 위한 테스트 코드
        # for location in results:
        #     for trend in location["trends"]:
        #         #print(" - %s" % trend["name"])
        #         print(trend)
    except Exception as e:
        print(e)

    return finalList


#--------------------------------------------------------------------------
# 비로그인 GET 방식을 이용한 수동 수집 꼼수 트렌드 10개
#--------------------------------------------------------------------------
def get_web_trends(woeid):
    try:
        trendsHtml = requests.get(
            "https://twitter.com/i/trends?id=" + "23424868").json()['module_html']
        soup = BeautifulSoup(trendsHtml, 'html.parser')
        tagList = soup.select('.trend-name')

        trendList = []
        for tag in tagList:
            trend = re.sub(r"^[#]", "", tag.text)
            trend = re.sub(r"_", " ", trend)
            trendList.append(trend)
    except Exception as e:
        print(e)
    
    return trendList


#--------------------------------------------------------------------------
# 키워드를 받아 검색하여 cnt개의 tweet 내용을 list로 반환하는 함수
#--------------------------------------------------------------------------
def get_tweets(twitter, keyword, cnt):
    tweetList = []
    try:
        query = twitter.search.tweets(q = keyword, count = cnt)
        # 트위터의 경우 매우 짧은 문장이기때문에 리스트로 만들지 않고 한 문자열로 합친 후
        # 일관성 있는 처리를 위해 1개짜리 리스트를 만들어 리턴한다
        tweets = ""
        for result in query["statuses"]:
            tweets = tweets + result["text"] + "\n"
        tweetList += [tweets]
    except Exception as e:
        print(e)

    return tweetList


#--------------------------------------------------------------------------
# module test conde
#--------------------------------------------------------------------------
if __name__ == "__main__":
    import config
    woeid = get_woeid("Korea"); print(woeid)
    trends = get_web_trends(woeid); print(trends)
    twitter = get_twitter()
    tweets = get_tweets(twitter, trends[1], 100)
    for tweet in tweets:
        print(tweet)


#--------------------------------------------------------------------------
# module test code - getWebTrends()
#--------------------------------------------------------------------------
# if __name__ == "__main__":
#     trends_html = requests.get(
#         "https://twitter.com/i/trends?id=" + "23424868").json()['module_html']
#     soup = BeautifulSoup(trends_html, 'html.parser')
#     tag_list = soup.select('.trend-name')

#     for tag in tag_list:
#         trend = re.sub(r"^[#]", "", tag.text)
#         trend = re.sub(r"_", " ", trend)
#         print(trend)
