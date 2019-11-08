#tfidf.py

#------------------------------------------------------------------------------
#  reference
#------------------------------------------------------------------------------
"""
https://towardsdatascience.com/tfidf-for-piece-of-text-in-python-43feccaa74f8
"""

import re
import math
from . import morpheus
from . import util


#------------------------------------------------------------------------------
#  개별 doc을 모두 읽어 docs로 합쳐 반환하는 함수 doc은 개행으로 구분
#------------------------------------------------------------------------------
def get_docs(filelist):
    sents = []
    for filepath in filelist:
        words = morpheus.sentence_khaiii(filepath)
        sent = " ".join(words)
        sents.append(sent)
    docs = "\n".join(sents)
    return docs


#------------------------------------------------------------------------------
#  각각의 doc의 info를 합쳐 리스트로 반환하는 함수
#------------------------------------------------------------------------------
def get_infos(docs):
    docList = docs.split("\n")
    docInfos = []
    for i, doc in enumerate(docList):
        count = len(doc.split(" "))
        info = {'doc_id' : i+1, 'doc_length' : count}
        docInfos.append(info)
    return docInfos
    

#------------------------------------------------------------------------------
#  각각의 doc에 대한 freq dictionary를 생성하여 리스트로 반환하는 함수
#------------------------------------------------------------------------------
def create_freq_dict(docs):
    freqDictList = []
    docList = docs.split("\n")
    for i, doc in enumerate(docList):
        freq_dict = {}
        words = doc.split(" ")
        for word in words:
            word = word.upper()
            if word in freq_dict:
                freq_dict[word] += 1
            else:
                freq_dict[word] = 1
            temp = {'doc_id' : i+1, 'freq_dict' : freq_dict}
        freqDictList.append(temp)
    return freqDictList


#------------------------------------------------------------------------------
#  각각의 문서 각각의 word에 대하여 TF 값을 계산하여 리스트로 반환하는 함수
#------------------------------------------------------------------------------
def compute_tf(docInfo, freqDictList):
    tfScores = []
    for tempDict in freqDictList:
        id_ = tempDict['doc_id']
        for k in tempDict['freq_dict']:
            temp = {
                'doc_id' : id_,
                'TF_score' : 
                    tempDict['freq_dict'][k]/docInfo[id_-1]['doc_length'],
                'key' : k
            }
            tfScores.append(temp)
    return tfScores
    


#------------------------------------------------------------------------------
#  각각의 문서 각각의 word에 대하여 IDF 값을 계산하여 리스트로 반환하는 함수
#------------------------------------------------------------------------------
def compute_idf(docInfos, freqDictList):
    idfScores = []
    counter = 0
    for dict_ in freqDictList:
        counter += 1
        for k in dict_['freq_dict'].keys():
            count = sum(
                [k in tempDict['freq_dict'] for tempDict in freqDictList]
            )
            temp = {
                'doc_id' : counter,
                'IDF_score' : math.log(len(docInfos)/count), 
                'key' : k
            }
            idfScores.append(temp)
    return idfScores


#------------------------------------------------------------------------------
#  각각의 문서 각각의 word에 대하여 TF-IDF 값을 계산하여 리스트로 반환하는 함수
#------------------------------------------------------------------------------
def compute_tfidf(tfScores, idfScores):
    tfidfScores = []
    for j in idfScores:
        for i in tfScores:
            if j['key'] == i['key'] and j['doc_id'] == i['doc_id']:
                temp = {
                    'doc_id' : j['doc_id'],
                    'TFIDF_score' : j['IDF_score']*i['TF_score'],
                    'key' : i['key']
                }
        tfidfScores.append(temp)
    return tfidfScores


#------------------------------------------------------------------------------
#  IssueWhatShow 용도에 맞게 합산 값을 계산해주는 함수
#  "Reduced Term Frequency Score!!!" - R-TF
#------------------------------------------------------------------------------
def compute_merged_score(scores, whatscore, verySigWords, group):
    dict_ = {}
    for score in scores:
        key = score['key']
        if key in dict_:
            dict_[key] += score[whatscore]
        else:
            dict_[key] = score[whatscore]

    mergeScores = []
    maxScore = 0
    for key in dict_:
        score = dict_[key]
        maxScore = round(max([maxScore, score]), 6)
        mergeScores.append({
            'word' : key, 
            whatscore : round(score, 6),
            'group' : group
        })
    
    # 검색어에 해당하는 키워드의 점수는 최대 점수값을 더해줌
    for word in verySigWords:
        for i, score in enumerate(mergeScores):
            if score['word'] == word:
                mergeScores[i][whatscore] += maxScore
                break

    mergeScores.sort(key=lambda x: x[whatscore], reverse=True)
    return mergeScores


#------------------------------------------------------------------------------
#  TF-IDF 의 Term Frequency 를 이용하여 중요 키워드를 내림차순으로 반환
#------------------------------------------------------------------------------
def get_sigwords_by_tf(path, searchword, group):
    # 검색어를 중요 단어로 인식
    verySigWords = searchword.split(" ")

    # 문서 파일 리스트 생성
    filelist = util.get_filelist(path)

    # 형태소 분석하여 전체 문서 합치기 (개행으로 개별 doc 구분)
    docs = get_docs(filelist)

    # 개별 doc 정보 가져오기 [{doc_id: , doc_length: }, ...]
    docInfos = get_infos(docs)

    # 빈도수사전 dict list 생성
    freqDictList = create_freq_dict(docs)

    # TF 계산
    tfScores = compute_tf(docInfos, freqDictList)

    # word를 unique key로 만들어 TF 값을 합산
    #-----------------------------------------
    # "Reduced Term Frequency Score!!!" - R-TF
    #-----------------------------------------
    mergScores = compute_merged_score(tfScores, 'TF_score', verySigWords, group)
    return (docs, mergScores)
