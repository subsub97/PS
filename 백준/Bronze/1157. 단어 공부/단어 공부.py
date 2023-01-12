word = input().upper()

alpa_cnt = 0
max_cnt = 0
flag = 0
max_alpa = ""
check_arr =[]

for i in range(len(word)):
    alpa_cnt = 0
    condition =True
    for alpa in check_arr:
        if alpa == word[i]:
            condition = False
            break
    if condition:
        for j in range(i,len(word)):
            if word[i] == word[j]:
                alpa_cnt += 1

        if max_cnt < alpa_cnt:
            max_cnt = alpa_cnt
            flag = 0
            max_alpa = word[i]

        elif max_cnt == alpa_cnt:
            flag = 1
        check_arr.append(word[i])

if flag == 1:
    print("?")
else:
    print(max_alpa)