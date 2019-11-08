#util.py

import os
import re


#------------------------------------------------------------------------------
#  분석의 목표가 될 파일 리스트 들을 반환
#------------------------------------------------------------------------------
def get_dirlist(path):
    filelist = list(map(
            lambda file: os.path.join(path, file), os.listdir(path)))
    dirlist = list(filter(lambda file : os.path.isdir(file), filelist))
    return dirlist


#------------------------------------------------------------------------------
#  분석의 목표가 될 파일 리스트 들을 반환
#------------------------------------------------------------------------------
def get_filelist(path):
    filelist = list(filter(lambda file :  
            re.compile(r"DONE\.txt").search(file), os.listdir(path)))
    filelist = list(map(lambda file : os.path.join(path, file), filelist))
    return filelist
    

#------------------------------------------------------------------------------
#  해당 뉴스들을 검색케 한 검색어 반환
#------------------------------------------------------------------------------
def get_searchword(path):
    divIndex = path.rfind("/", 1)+1
    keyinfos = path[divIndex:].split("_")
    siteInit = keyinfos[0]
    swNum = int(keyinfos[2])

    keyFilepath = path[:divIndex] + "keywords.txt"
    with open(keyFilepath, "r", encoding="utf-8") as fp:
        lines = [line.split("\t") for line in fp.readlines()]
        lines = list(filter(lambda line : line[0][0] == siteInit, lines))
        searchword = re.sub("\n", "", lines[swNum-1][2])
    return searchword


if __name__ == "__main__":
    get_searchword("data/1630/D_K_01")