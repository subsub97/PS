#DP try1

import sys

n = int(sys.stdin.readline().strip())

memo = [1,2]

for i in range(2,n+1):
    memo.append((memo[i-1] + memo [i-2]) % 10007)

print(memo[n-1])
