# DP try1
n = int(input())

memo = [1,3]

for i in range(2,n+1):
    memo.append(memo[i-1] + 2*(memo[i-2]))

print(memo[n-1] % 10007)

