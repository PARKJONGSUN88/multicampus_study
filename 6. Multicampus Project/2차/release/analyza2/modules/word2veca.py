#word2veca.py

from gensim.models import Word2Vec
import pandas
from . import util
from . import morpheus


#------------------------------------------------------------------------------
#  word2vec을 이용하여 sigwords로 구성된 디스턴스 매트릭스를 생성
#------------------------------------------------------------------------------
def create_distance_df(docs, sigwords, length):
    # 문서 파일 리스트 생성
    # filelist = util.get_filelist(path)

    # khaiii로 모든 문서의 토크나이즈드된 문장 리스트 생성
    # sents = morpheus.sentences_khaiii(filelist)
    doclist = docs.split("\n")
    sents = [doc.split(" ") for doc in doclist]

    # word2vec으로 단어 벡터들 생성
    model = Word2Vec(
        sentences=sents, 
        size=300, window = 10, 
        min_count=round(30), 
        workers=10, iter=200, 
        sg=1,
        hs=0,   
        negative=5,
    )

    wv = model.wv
    del(model)

    # 전달받은 sigwords 중 model에 포함된 단어를 우선순위 순서로 추려냄
    sigvocs = []
    missvocs = []
    hit = 0
    miss = 0
    for worddic in sigwords:
        try:
            word = worddic['word']
            if wv.vocab[word]:
                sigvocs.append(word)
                hit += 1
            if hit >= length:
                break
        except:
            missvocs.append(word)
            miss += 1
    # 디버깅용. 추후 삭제.
    print("missed: %d"  % miss)
    for voc in missvocs:
        print(voc)
    

    # 디스턴스 매트릭스를 데이터프레임 형태로 만듦
    distDF =  pandas.DataFrame(columns = sigvocs , index = sigvocs)
    for i in sigvocs:
        dists = []
        for j in sigvocs:
            dist = round(wv.distance(i, j), 6)
            dists.append(0 if dist < 1.0e-2 else dist)
        distDF[i] = dists
    # 분석을 위해 임시 저장
    # distDF.to_csv("d-matrix.csv", encoding="utf-8-sig")

    return distDF