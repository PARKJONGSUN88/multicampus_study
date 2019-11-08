#morpheus.py

from konlpy.tag import Komoran
from konlpy.tag import Twitter
from khaiii import KhaiiiApi
import re


#------------------------------------------------------------------------------
#  komoran 형태소 분석기로 토크나이즈드 된 문장 반환
#------------------------------------------------------------------------------
def sentences_komoran(filelist):
    komoran = Komoran()
    sentences = []
    for i, file in enumerate(filelist):
        with open(file, 'r', encoding='utf-8') as fp:
            while True:
                try:
                    line = fp.readline()
                    if not line: 
                        break

                    line = re.sub("\xa0", " ", line).strip()
                    if line == "" : 
                        continue

                    tokens = komoran.nouns(line)
                    if len(tokens) == 0: 
                        continue

                    sentences.append(tokens)

                except Exception as e:
                    print(e)
                    continue
    return sentences


#------------------------------------------------------------------------------
#  twitter 형태소 분석기로 토크나이즈드 된 문장 반환
#------------------------------------------------------------------------------
def sentences_twitter(filelist):
    twitter = Twitter()
    sentences = []
    for i, file in enumerate(filelist):
        with open(file, 'r', encoding='utf-8') as fp:
            while True:
                try:
                    line = fp.readline()
                    if not line: 
                        break

                    # 전처리 누락으로 잘못된 텍스트 변환를 처리. 추후 제거해도 무관
                    line = re.sub("\xa0", " ", line).strip()
                    if line == "" : 
                        continue

                    words = twitter.pos(line, norm=True) 
                    tokens = []
                    for word in words: 
                        # if word[1] not in ['Punctuation', 'Eomi', 'Josa']:
                        if word[1] in ['Noun']:
                            tokens.append(word[0])

                    if len(tokens) == 0: 
                        continue

                    sentences.append(tokens)

                except Exception as e:
                    print(e)
                    continue
    return sentences


_khaiii = KhaiiiApi()
#------------------------------------------------------------------------------
#  khaiii 형태소 분석기로 토크나이즈드 된 문장 반환
#------------------------------------------------------------------------------
def sentences_khaiii(filelist):
    sentences = []
    for filepath in filelist:
        try:
            unitList = sentence_khaiii(filepath)
            sentences.append(unitList)

        except Exception as e:
            print(e)
            continue

    return sentences
#---------------------------------------
#  khaiii 토크나이징 서브 함수
#---------------------------------------
def sentence_khaiii(filepath):
    strList = []
    with open(filepath, 'r', encoding='utf-8-sig') as fp:
        while True:
            line = fp.readline()

            if not line: 
                break

            if line == "\n": 
                continue

            # 전처리 잘못 된 부분이 있어서 임시로 넣음. 추후 빼도 무관.
            line = re.sub("\xa0", " ", line).strip()
            if line == "" : 
                    continue

            #--------------------------------
            # 나중에 고도화 및 모듈화 해야할 곳
            #--------------------------------
            # 형태소 분석 전 전처리 작업 
            # (형태소 분석에 악영향을 주는 기호 삭제)
            line = line.replace("'", "").replace('"', "")\
                .replace("‘", "").replace("’", "").replace("“", "")\
                .replace('”', "").replace('·', " ")
            
            # khaiii 형태소 분석
            try :  
                words = _khaiii.analyze(line)
            except Exception as e:
                print(e)
                continue

            for word in words:
                # print(word)
                strList.append("{0}".format(word))

    #--------------------------------
    # 나중에 고도화 및 모듈화 해야할 곳
    #--------------------------------
    # unit(의미 있는 어절 단위; 자체정의)
    # unit 을 담을 unitList 생성 및 unit parsing 작업 시작
    unitList = []
    for i, line in enumerate(strList):
        morpParcelList = line.split("\t")[1].replace(
        '"', '').replace("'", "").split(" + ")
        try:
            morpMetaList = []
            for elem in morpParcelList:
                divIdx = elem.rfind("/")
                splited = [elem[:divIdx], elem[divIdx+1:]]
                
                if \
                    splited[0] != "" and \
                    splited[1] != "NP" and \
                    splited[1] != "NR" and \
                    ( 
                        splited[1][0] == "N" or \
                        splited[1][0] == "S" or \
                        splited[1] == "XSN"
                    ):
                    morpMetaList.append(splited)

            # 1글자인 경우 일반명사, 고유명사, 외래어만 셋 중 하나가
            # 아닐 경우 스킵
            if len(morpMetaList) == 1 and len(morpMetaList[0][0]) == 1 :
                type = morpMetaList[0][1]
                if type != "NNG" and type != "NNP" and type != "SL" :
                        continue

            # 기타 일반적인 상황인 경우 계속 수행
            unit = ""
            for elem in morpMetaList:
                unit += elem[0].upper()

            # 결과에서 의미없는 특문 제거
            unit = re.sub('([,.]$)|(^[,.])', '', unit)

            # 최종적으로 () [] 등으로 구분하여 나눈 후 각각 추가
            unitSplit = re.split("[\(\)\[\]\{\} ]", unit)
            for i, elem in enumerate(unitSplit) :
                unitSplit[i] = elem.strip()
            
            if len(unitSplit) > 1 :
                for elem in unitSplit :
                    if len(elem) > 0 : unitList.append(elem) 
            else :
                # 두 글자 이상만 추가
                if len(unitSplit[0]) > 1 : 
                    unitList.append(unitSplit[0])
            
            # 마지막으로 놓친 부분을 한 번 더 검증
            for unit in unitList :
                if re.match(r"[!@#$%^&*():;\[\]\{\}]", unit) != None :
                    unitList.remove(unit)

        except Exception as e:
            print(line, e, sep="\n")

    return unitList
    

#------------------------------------------------------------------------------
#  단순 띄어쓰기 분리로 토크나이즈드 된 문장 리스트 반환
#------------------------------------------------------------------------------
def sentences_split(filelist):
    sentences = []
    for i, file in enumerate(filelist):
        with open(file, 'r', encoding='utf-8') as fp:
            while True:
                try:
                    line = fp.readline()
                    if not line: 
                        break

                    line = re.sub("\xa0", " ", line).strip()
                    if line == "" : 
                        continue

                    tokens = line.split(" ")
                    tokens = list(map(lambda token: token.strip(), tokens))
                    tokens = list(filter(lambda token: line != "", tokens))
                    if len(tokens) == 0: 
                        continue

                    sentences.append(tokens)

                except Exception as e:
                    print(e)
                    continue
    return sentences
