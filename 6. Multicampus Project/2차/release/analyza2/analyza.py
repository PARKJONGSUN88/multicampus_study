#!/usr/bin/python
#analyza.py


import sys
import os
import json
import time
import cx_Oracle
import itertools
from modules import *


#------------------------------------------------------------------------------
#  MAIN driver code
#------------------------------------------------------------------------------
if __name__ == "__main__":

    if len(sys.argv) < 2:
        print("Woops... Somthing went wrong...")
        print("[Usage]: analyza.py [source-dir path]")
        exit(1)
    path = sys.argv[1]
    path = path[:len(path)-1] if path[len(path)-1] == "/" else path
    # path = "../../data/timeline/191029/1800"
    dirlist = util.get_dirlist(path)

    searchWords = []
    # visual_data = []
    hugeDocs = ""
    sigwordsList = []
    # idx = 0
    for dir_ in dirlist:
        try:
            # 그룹 정보 생성(검색어 디렉토리 명 ex: D_K_01)
            group = dir_[dir_.rfind("/")+1:]

            # 검색어 추출하기
            searchword = util.get_searchword(dir_)
            
            # 로그
            print("분석 시작: {}\t{}".format(dir_, searchword))

            # 대표 키워드 리스트 생성
            (docs, sigwords) = tfidf.get_sigwords_by_tf(dir_, searchword, group)
            
            #단위 작업 메인 저장변수에 합치기
            hugeDocs += docs + "\n"
            searchWords.append({'key' : group, 'searchword' : searchword})
            sigwordsList.append(sigwords)

        except Exception as e:
            print(e)
    
    # 모든 그룹당 같은 지분으로 중요 키워드를 넣어줌
    sigwords = []
    zipped = itertools.zip_longest(*sigwordsList)
    for li in zipped:
        for elem in li :
            if elem:
                sigwords.append(elem)
    del(zipped)

    # 중복 제거
    dict_ = {}
    sigwords2 = []
    for sigword in sigwords:
        if sigword['word'] not in dict_:
            sigwords2.append(sigword)
            dict_[sigword['word']] = 1
    sigwords = sigwords2
    del(sigwords2)
    del(dict_)

    # 테스트 확인
    for i in sigwords[:100]:
        print(i)

    # 미친 테스트 시작:
    stime = time.time()
    print("한꺼번에 하기 테스트 시작")
     # 디스턴스 매트릭스 생성
    distDF = word2veca.create_distance_df(hugeDocs, sigwords, 300)
    # 테스트 저장
    distDF.to_csv(os.path.join(path, "hugeVec.csv"), encoding="ms949")
    etime = time.time() - stime
    elapsedSumm = "걸린 시간: %dm %02ds" % (etime//60, etime%60)

    nodes = []
    colnames = list(distDF.columns)
    for i, colname in enumerate(colnames):
        for sigword in sigwords:
            if colname == sigword['word']:
                nodes.append({
                    'group' : sigword['group'],
                    'id' : "_"+("%02d"%(i+1)),
                    'word' : colname,
                    'val' : sigword['TF_score']
                })
    visual_data = {
        'nodes' : nodes,
        'dmatrix' : distDF.to_csv()
    }

    #--------------------------------------------------------------------------
    # DATABASE 컬럼 데이터 생성
    #--------------------------------------------------------------------------
    divIdx = path.rfind("/")
    yymmdd = int(path[divIdx-6:divIdx])
    hhmm = int(path[divIdx+1:])
    searchword =  json.dumps(searchWords, ensure_ascii=False)
    visdata = json.dumps(visual_data, ensure_ascii=False)
    # # 테스트 저장
    with open(os.path.join(path, "visdata.txt"), "w", encoding="utf-8-sig") \
    as fp:
        fp.write(visdata)

    #--------------------------------------------------------------------------
    #  Oracle Database에 Insert
    #--------------------------------------------------------------------------
    os.putenv('NLS_LANG', '.UTF8')
    con = cx_Oracle.connect(config.oracle_connection)
    cur = con.cursor()
    statement = "".join([
            "insert into latte_timeline(yymmdd, hhmm, searchword, visdata) ",
            "values (:1, :2, :3, :4)"])
    cur.execute(statement, (yymmdd, hhmm, searchword, visdata))
    cur.close()
    con.commit()
    con.close()

    # 입력 확인 테스트 코드
    
    con = cx_Oracle.connect(config.oracle_connection)
    cur = con.cursor()
    statement = "".join([
            "select * from latte_timeline where yymmdd = :1 and hhmm = :2"    
    ])
    cur.execute(statement, (yymmdd, hhmm))
    for row in cur:
        print(row)
    cur.close()
    con.close()


    # #----------------------------------------
    # # 개별 키워드 테스트 루틴 - 디버깅시 필요!
    # #----------------------------------------
    # path = "../../data/timeline/191017/1630/D_K_01/"
    # path = path[:len(path)-1] if path[len(path)-1] == "/" else path

    # # 검색어 추출하기
    # searchword = util.get_searchword(path)
    # print(searchword)

    # # 대표 키워드 리스트 생성
    # (docs, sigwords) = tfidf.get_sigwords_by_tf(path, searchword)

    # # 디스턴스 매트릭스 생성
    # distDF = word2veca.create_distance_df(docs, sigwords, 20)
    # print(distDF)
    # #----------------------------------------
