### NLP(natural language processing)

#### 자연어 처리 프로세싱

우선 자연어란 사람이 쓰는 언어임.  컴퓨터가 쓰는 언어는 0과 1뿐이니까.

사람이 쓰는 언어를 컴퓨터가 알 수 있게 프로세싱하는걸 의미함.



### Word Embedding

자연어를 컴퓨터가 이해할 수 있도록 자연어를 처리해야되는데

그때 텍스트를 컴퓨터가 처리할 수 있는 적절한 것으로 바꾸는 것 .



### Word2vec

워드를 벡터화한다는 뜻인데 어떤 단어가 있으면 그 주변 단어를 가지고 

맥락에 맞는지를 알게 해준다.

word2vec은 어떤 샘플 데이터들를 학습하고 그를 바탕으로 추론한다.

word2vec은 두가지 방식이 있는데

1. 맥락으로 단어를 예측하는 CBOW와
2. 단어로 맥락을 예측하는 skip-gram 모델이 있음.



기존에는 그냥 단어를 컴퓨터가 이해할 수 있게만 표현했다면 word2vec은 단어를 그냥 수치가 아닌 벡터로 표현하여 어떠한 단어들끼리 서로 연관성을 알고자 함



펌/

모든 Word Embedding 관련 학습들은 기본적으로 언어학의 ‘[Distributional Hypothesis](https://en.wikipedia.org/wiki/Distributional_semantics#Distributional_Hypothesis)‘ 라는 가정에 입각하여 이루어진다.  이는, ‘비슷한 분포를 가진 단어들은 비슷한 의미를 가진다’ 라는 의미이다. 여기서 비슷한 분포를 가졌다는 것은 기본적으로 단어들이 같은 문맥에서 등장한다는 것을 의미한다. 





