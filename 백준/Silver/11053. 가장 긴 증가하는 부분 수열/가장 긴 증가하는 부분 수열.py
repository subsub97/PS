# 가장 긴 증가하는 부분 수열 DP try2
'''
try1 틀렸습니다.
try2 current_num을 바꾸는 조건을 바꾸었다.
     이전에는 j가 증가할떄 마다 바꾸었는데 이러한 경우에
     중복된 값을 count하는 경우가 발생한다.
try 3 try2 까지의 방식은 DP알고리즘이 아니여서 새로
      코드를 만들어 보았다.

'''
import sys
n = int(input())

num_arr = list(map(int,sys.stdin.readline().split()))

# 가장 긴 증가하는 수열을 찾아보자

memo = [
    0 for _ in range(n)
]

max_cnt = 1

for i in range(n):
    for j in range(i):
        if num_arr[i] > num_arr[j] and memo[i] < memo[j]:
            memo[i] = memo[j]
    memo[i] += 1
    if memo[i] > max_cnt:
        max_cnt = memo[i]

print(max_cnt)
