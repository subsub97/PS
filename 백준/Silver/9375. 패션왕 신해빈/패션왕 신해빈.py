test_case = int(input())
import sys

for _ in range(test_case):
    n = int(input())
    clothes = {} # dict 생성

    for i in range(n):
        name,type = sys.stdin.readline().strip().split()
        if type in clothes:
            clothes[type].append(name)
        else:
            clothes[type] = [name]

    # 가능한 경우의 수 계산하기
    ans = 1
    for type in clothes:
        ans = ans * (len(clothes[type]) + 1)
    print(ans-1)

