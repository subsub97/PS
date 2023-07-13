import sys


words = []

while True:
    word = sys.stdin.readline().rstrip()
    word_dict = {}
    if word == "-":
        break
    else:
        if len(word) >= 4 and len(word) < 10:
            for a in word:
                try:
                    word_dict[a] += 1
                except:
                    word_dict[a] = 1
            words.append(word_dict)
while True:
    alpas = sys.stdin.readline().rstrip()
    cnt = 0
    if alpas == "#":
        break

    alpa_dict = {}
    for a in alpas:
        try:
            alpa_dict[a] += 1
        except:
            alpa_dict[a] = 1
    max_cnt = 0
    min_cnt = 30000000
    max_list = set()
    min_list = set()
    for i in range(len(alpas)):# 무조건 포함되어야하는 알파벳
        cnt = 0
        for w_dict in words:
            flag = 0
            if w_dict.get(alpas[i]): #현재 선택된 단어에 선택된 alpabet이 포함된경우
                if alpa_dict[alpas[i]] < w_dict[alpas[i]]: # 포함은했지만 개수가 다른경우 패스
                    continue
                for w_alpa in w_dict: #알파벳 하나하나 확인해보기
                    if not alpa_dict.get(w_alpa):
                        flag = 1
                        break
                    else:
                        if alpa_dict[w_alpa] < w_dict[w_alpa]:
                            flag = 1
                            break
                if flag == 0:
                    cnt += 1
            else:
                continue

        if max_cnt <= cnt:
            if max_cnt < cnt:
                max_list = set()
            max_list.add(alpas[i])
            max_cnt = cnt

        if min_cnt >= cnt:
            if min_cnt > cnt:
                min_list = set()
            min_list.add(alpas[i])
            min_cnt = cnt


    max_list = list(max_list)
    min_list = list(min_list)
    max_list.sort()
    min_list.sort()


    print("".join(min_list),end=' ')
    print(min_cnt,end =' ')
    print("".join(max_list),end=' ')
    print(max_cnt)