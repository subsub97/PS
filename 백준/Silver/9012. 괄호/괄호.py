# 9012 try2
# yes no의 출력 값이 대문자임

import sys

n = int(sys.stdin.readline())

for _ in range(n):
    ps = sys.stdin.readline().strip()
    check_stack = []
    trash_cnt = 0
    for i in range(len(ps)):
        if 0 == len(check_stack) and ps[i] != ')': # ) 닫는 괄호가 먼저 들어가면 VPS 를 만족하지 못하기에 애초에 넣지 않는다 그럼 짝이 안맞을 테니까
            check_stack.append(ps[i])
        else:
            if 0 != len(check_stack) and check_stack[-1] != ps[i]: # len이 0 일떄 ps[i]가 )라면 else 문으로 넘어오기에 pop할수있는 데이터가 없어서 오류 방지
                check_stack.pop()
            else:
                if ps[i] != ')':
                    check_stack.append(ps[i])
                else:
                    trash_cnt += 1
    if len(check_stack) > 0 or trash_cnt > 0:
        print('NO')
    else:
        print('YES')