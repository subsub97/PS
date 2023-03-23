def solution(answers):
    answer = []
    cnt_list = [0,0,0]
    f_ans = [1,2,3,4,5]
    s_ans = [2,1,2,3,2,4,2,5]
    t_ans = [3,3,1,1,2,2,4,4,5,5]
    
    for i in range(len(answers)):
        if answers[i] == f_ans[i%5]:
            cnt_list[0]+= 1
        if answers[i] == s_ans[i%8]:
            cnt_list[1] += 1
        if answers[i] == t_ans[i%10]:
            cnt_list[2] += 1
        
    max_cnt = max(cnt_list)
    for j in range(3):
        if max_cnt == cnt_list[j]:
            answer.append(j+1)

    return answer