#!/usr/bin/python
# -*- coding: utf-8 -*-
#harvesta.py

__all__ = ["harvest"]

_doNaver = True
_doDaum = True
_doGoogle = False
_doTwitter = True

if __name__ != "__main__":
    from .modules import *
import urllib.request
import json
import time
import os
import shutil
from datetime import datetime
import pandas as pd


def harvest(rootPath):
# 시작 시간
    stime = time.time()

    #--------------------------------------------------------------------------
    # 검색어 list 수집
    #--------------------------------------------------------------------------
    naverSearchList = naverfuncs.get_keywords(10)
    daumSearchList = daumfuncs.getKeywords()
    keywordsource_dic = {'NAVER':naverSearchList, 'DAUM':daumSearchList}


    #--------------------------------------------------------------------------
    # 뉴스 URL list 수집
    #--------------------------------------------------------------------------
    # 편의상 데이터 프레임 사용
    colnames = ['ksource', 'keywords', 'knum', 'nsource', 'nnum', 'title', 
          'url']
    df = pd.DataFrame(columns=colnames)
    df_tw = pd.DataFrame(columns=colnames)
    print("Collecting News list. Please wait...  ")
    # 구글 검색은 초기 진입 시 시도하지만 블럭 먹으면 멈춰야 하므로 flag 를 설정한다
    doGoogling = True
    # Twitter 검색을 위한 twitter API 모듈 로드
    twitter = twitterfuncs.get_twitter()
    for keywordSource in keywordsource_dic.keys():
        keywordsList = keywordsource_dic[keywordSource]
        for i, keywords in enumerate(keywordsList):
            if _doNaver:
                print("{} 검색어 {} NAVER 뉴스 수집 시작... ".format(
                    keywordSource, i+1), flush=True)
                naverList = naverfuncs.get_newslist(keywords, 30)
                util.insert_dfrow(
                    df, keywordSource, keywords, i, 'NAVER', naverList)
            if _doDaum:   
                print("{} 검색어 {} DAUM 뉴스 수집 시작... ".format(
                    keywordSource, i+1), flush=True)
                daumList =  daumfuncs.get_newslist(keywords, 30)
                util.insert_dfrow(
                    df, keywordSource, keywords, i, 'DAUM', daumList)

            if _doGoogle:
                # 구글의 경우 일시 블락 걸릴 경우 다시 시도하지 않음 
                if doGoogling :
                    print("{} 검색어 {} Google 뉴스 수집 시작... ".format(
                        keywordSource, i+1), flush=True)
                    googleList = googlefuncs.get_newslist(keywords, 30)
                    if googleList != -1:
                        util.insert_dfrow(df, keywordSource, keywords, i, 
                            'Google', googleList)
                    else:
                        print("!"*10 + " Google blocks us " + "!"*10)
                        doGoogling = False
            if _doTwitter:
                # 트위터의 경우 특이 케이스로 다른 데이터 프레임에 담음
                print("{} 검색어 {} Twitter 트윗 수집 시작... ".format(
                        keywordSource, i+1), flush=True)
                tweets = twitterfuncs.get_tweets(twitter, keywords, 100)
                util.insert_dfrow(
                    df_tw, keywordSource, keywords, i, 'Twitter', tweets)
    print("모든 뉴스 링크 수집 완료")


    #--------------------------------------------------------------------------
    # 약속된 디렉토리 상위 구조 생성
    #--------------------------------------------------------------------------
    now = datetime.now()
    outputRoot = os.path.join(
        rootPath,
        "%d%d%02d" % (now.year % 100, now.month, now.day), 
        # "%02d%02d" % (now.hour, now.minute // 10 * 10)
        "%02d00" % (now.hour)
    )
    # 디렉토리 존재 시 모두 삭제 후 새로 생성
    if os.path.isdir(outputRoot): shutil.rmtree(outputRoot)
    if not(os.path.isdir(outputRoot)): os.makedirs(outputRoot)


    #--------------------------------------------------------------------------
    # 키워드 저장
    #--------------------------------------------------------------------------
    fpKeyword = open(os.path.join(outputRoot, 
        "keywords.txt"), "w", encoding="utf-8")
    for keywordSource in keywordsource_dic.keys():
        keywordsList = keywordsource_dic[keywordSource]
        for i, keywords in enumerate(keywordsList):
            fpKeyword.write(
                "{}\t{}\t{}\n".format(keywordSource, i+1, keywords))
    fpKeyword.close()


    #--------------------------------------------------------------------------
    # 코드 작성 중엔 잦은 뉴스 수집으로 블럭 당할 수 있으니 재사용 용도로 결과를 저장
    # 릴리즈 시 주석처리
    #--------------------------------------------------------------------------
    csvPathName = os.path.join(outputRoot, "output.csv")
    csvTwPathName = os.path.join(outputRoot, "output_tw.csv")
    df.to_csv(csvPathName, mode='w', index=False, encoding="utf-8")
    df_tw.to_csv(csvTwPathName, mode='w', index=False, encoding="utf-8")
    # del(df)
    # del(df_tw)
    # df = pd.read_csv(csvPathName)
    # df_tw = pd.read_csv(csvTwPathName)


    #--------------------------------------------------------------------------
    # html 저장
    #--------------------------------------------------------------------------
    # Suffix Dict.
    initialDic = {'NAVER':'N', 'DAUM':'D', 'Google':'G', 'Twitter':'T'}
    # # 로그 파일
    logfp = open(os.path.join(outputRoot, "log_harvesta.txt"), "w", encoding="utf-8")
    print("저장 시작")
    #-------------------------------------
    # 일반 뉴스 저장
    #-------------------------------------

    #---------------------
    # NAVER와 DAUM을 번갈아 
    # 다운 받도록 설정
    # 최대한 블록 대상이
    # 되지 않게
    #---------------------
    dfShuffle = pd.DataFrame(columns=colnames)
    dfNaver = df[df.nsource == 'NAVER'][:]
    dfDaum = df[df.nsource == 'DAUM'][:]
    toLen = max(len(dfNaver.index), len(dfDaum.index))
    for i in range(toLen):
        if i < len(dfNaver.index):
            dfShuffle.loc[len(dfShuffle.index)] = list(dfNaver.iloc[i])
        if i < len(dfDaum.index):
            dfShuffle.loc[len(dfShuffle.index)] = list(dfDaum.iloc[i])
    df = dfShuffle
    del(dfShuffle)

    #---------------------
    # 실제 다운로드
    #---------------------
    count = len(df.index)
    for i in range(count):
        print("News: {} / {} 저장중".format(i+1, count))
        row = df.iloc[i]
        # keyword 폴더 생성 ex) D_K_01
        dirpath = os.path.join(outputRoot, 
            "%s_K_%02d" % (initialDic[row['ksource']], row['knum']))
        if not(os.path.isdir(dirpath)): os.makedirs(dirpath)
        # 파일 저장 패스 생성 ex) D_01.txt
        filepath = os.path.join(dirpath, 
            "%s_%02d.txt" % (initialDic[row['nsource']], row['nnum']))
            
        # html 가져오기 성공 시 파일 생성
        body = util.getbody(row['url'])
        if body['code'] == 0:
            with open(filepath, "w" , encoding="utf-8") as fp:
                fp.write("{}\n".format(row['title']))
                try:
                    fp.write(body['text'])
                except Exception as e:
                    print(e)
                    logfp.write(str(e))
                    logfp.flush()
        # 실패시 error 로그 추가
        else:
            errortext = "{}\t{}\t{}\n\n".format(i+1, row['url'], body['text'])
            print(errortext)
            logfp.write(errortext)
            logfp.flush()

        # 블럭 방지를 위한 약간의 궁여책.. 좀 쉬기(1.5초)
        # NAVER, DAUM 번갈아 다운로드 하기 때문에 싸이트별로는 3초 쉬는 효과
        time.sleep(1.5)
        
    #-------------------------------------
    # 트위터 저장
    #-------------------------------------
    count = len(df_tw)
    for i in range(count):
        print("Tweets: {} / {} 저장중".format(i+1, count))
        row = df_tw.iloc[i]
        # keyword 폴더 생성 ex) D_K_01
        dirpath = os.path.join(outputRoot, 
            "%s_K_%02d" % (initialDic[row['ksource']], row['knum']))
        if not(os.path.isdir(dirpath)): os.makedirs(dirpath)
        # 파일 저장 패스 생성 ex) D_01.txt
        filepath = os.path.join(dirpath, 
            "%s_%02d.txt" % (initialDic[row['nsource']], row['nnum']))

        # tweets 가져오기 성공 시 파일 생성(타입이 str 일 경우만 저장)
        if type(row['url']) == type(""):
            with open(filepath, "w" , encoding="utf-8") as fp:
                fp.write(row['url'])

    print("저장 끝")

    # 걸린 시간 출력
    etime = time.time() - stime
    scrappedSumm = "수집한 문서 개수: %d개" % (len(df) + len(df_tw))
    elapsedSumm = "걸린 시간: %dm %02ds" % (etime//60, etime%60)
    logfp.write(scrappedSumm + "\n")
    logfp.write(elapsedSumm + "\n")
    logfp.close()
    print(scrappedSumm)
    print(elapsedSumm)

    return outputRoot




#--------------------------------------------------------------------------
# harvesta test code
#--------------------------------------------------------------------------
if __name__ == "__main__":
    from modules import *
    harvest("../../../data/timeline/191029/1400")
