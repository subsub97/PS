
def solution(num):
    answer = 0
    answer = find_collatz_num(num,0)
    return answer

def find_collatz_num(cur_num,cnt):
    if cur_num == 1:
        return cnt
    elif cnt == 500:
        return -1
    else:
        if cur_num % 2 == 0: #짝수인 경우
            return find_collatz_num(cur_num // 2,cnt + 1)
        else:
            return find_collatz_num((cur_num * 3) + 1, cnt + 1)
    