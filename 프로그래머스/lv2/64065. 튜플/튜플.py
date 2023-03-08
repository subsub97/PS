def solution(s):
    answer = []
    temp_list =[[]]
    idx = 0
    temp_num =' '
    for i in range(len(s)):
        if s[i] == "{" or s[i] ==",":
            continue
        elif s[i] == "}":
            if i < len(s)-2: # }} 가 마지막에 두개 연속 나오기때문
                temp_list.append([])
                idx += 1
        else:
            temp_num += s[i]
            if s[i+1] == '}' or s[i+1] == ",":
                if temp_num:
                    temp_list[idx].append(int(temp_num))
                    temp_num = ''
                
    temp_list.sort(key = lambda x:len(x)) # 2차원 배열인 경우 내부의 1차원 배열의 길이들로 정렬

    for cur_list in temp_list:
        for num in cur_list:
            if num not in answer:
                answer.append(num)
    print(answer)
    return answer

# s가 각 배열의 사이즈 별로 정렬이 되어있다면 좋겠다.
