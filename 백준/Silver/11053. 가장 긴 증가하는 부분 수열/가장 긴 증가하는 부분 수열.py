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
