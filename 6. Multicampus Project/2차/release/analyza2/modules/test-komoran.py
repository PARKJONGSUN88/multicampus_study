#!/usr/bin/python

import util
from konlpy.tag import Komoran
import re


path = "../data/191017/1630/D_K_03"
filelist = util.get_filelist(path)


file = filelist[0]
with open(file, 'r', encoding='utf-8') as fp:
    komoran = Komoran()
    lines = []
    while True:
        try:
            line = fp.readline()
            if not line: 
                break

            line = re.sub("\xa0", " ", line).strip()
            if line == "" : 
                continue

            # tokens = komoran.pos(line)
            tokens = komoran.nouns(line)
            if len(tokens) == 0: 
                continue

            lines.append(tokens)

        except Exception as e:
            print(e)
            continue

for line in lines:
    for token in line:
        # print(token[0], end="\t")
        print(token, end="\t")
print("")
    