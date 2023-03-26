def solution(brown, yellow):
    answer = []
    cnt = 0
    for b_cnt in range(brown,-1,-2):
        cnt += 1
        cur_row = (b_cnt - 2)//2
        y_cnt = cnt * (cur_row-2)
        if y_cnt == yellow:
            answer = [cur_row,cnt+2]
            break
    return answer