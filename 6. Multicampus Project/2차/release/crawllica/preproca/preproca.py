#!/usr/bin/python
# -*- coding: utf-8 -*-
#preproca.py

from .modules import *
from bs4 import BeautifulSoup
import re
import os
import time
import html

def preproc(inputRoot):
    # 시작 시간
    stime = time.time()
    # 로그 파일
    logfp = open(os.path.join(inputRoot, "log_preproca.txt"), "w", encoding="utf-8")

    #------------------------------------------------------------------------------
    # 타겟 파일 리스트 생성
    #------------------------------------------------------------------------------
    # rootpath = "c:\\harvesta_output\\"
    list_target = util.get_filelist(inputRoot)
    # for debugging
    # list_target = list_target[0:12]

    #------------------------------------------------------------------------------
    # 개별 파일 전처리 시작
    #------------------------------------------------------------------------------
    count = len(list_target)
    whitelist = 0
    unknown = 0
    useless = 0
    for i, (prefix, filepath) in enumerate(list_target):

        # 파일 읽고 닫기
        with open(filepath, "r", encoding="utf-8") as fp:
            text = fp.read()
        # 원본 파일 지우기
        os.remove(filepath)
        
        # 문장 단위 처리 편의성을 위해서 개행 추가
        text = re.sub(r"</p>", "</p>\n", text)
        text = re.sub(r"<br/?>", "<br/>\n", text)


        # 뷰티퓰스프로 떠넘기기
        soup = BeautifulSoup(text, "html.parser")
        # 제목 남기기
        textlines = soup.text.split("\n")
        title = textlines[0]
    

        # 제거 룰 적용
        if prefix != "T":
            # 뉴스
            if textlines[1] == "None":
                # body가 없는 문서는 제거 룰 돌리지 않고 건너뜀
                status = "blacklist"
            else :
                for func in rules.get_rulefns():
                    status, soup = func(soup)
                    if status != "unknown": break
                # status, soup = rules.whitelist(soup)
        else:
            status, soup = rules.tweetsweep(soup)

        # 화이트리스트 통과 했으면 본문만 있으므로 타이틀을 따로 넣어줌
        if status == "whitelist": 
            text = "{}\n{}".format(title, soup.text)
            whitelist += 1
        elif status == "twitter": 
            text = soup.text
            whitelist += 1
        elif status == "blacklist":
            text = title
            useless += 1
        else: 
            text = title
            unknown += 1

        # 글로벌 문자열 치환
        text = rules.common_rm_text(text)
        # print(text)

        # 진행사항 출력
        logtxt = "{}/{}\t{}\t{}".format(
            i+1, count, filepath, "unknown" if status == "unknown" else "")
        print(logtxt, flush=True)
        # 스킵된 파일만 로그에 남김
        if status == "unknown":
            logfp.write(logtxt + "\n")
            logfp.flush()
            
        #결과 파일 생성
        path_output = filepath[:-4] + "_DONE.txt"
        with open(path_output, "w", encoding="utf-8") as fp_out:
            fp_out.write(text)

    # 결과 출력 및 로그 닫기
    etime = time.time() - stime
    uselessSumm = "Useless : %d (%.1f%%)" % (useless, useless/count * 100)
    unknownSumm = "Unknown : %d (%.1f%%)" % (unknown, unknown/count * 100)
    hitSumm = "Hit : %d (%.1f%%)" % (whitelist, whitelist/count * 100)
    elapseSumm = "걸린 시간: %dm %02ds" % (etime//60, etime%60)
    logfp.write(uselessSumm + "\n")
    logfp.write(unknownSumm + "\n")
    logfp.write(hitSumm + "\n")
    logfp.write(elapseSumm + "\n")
    logfp.close()
    print(uselessSumm)
    print(unknownSumm)
    print(hitSumm)
    print(elapseSumm )

