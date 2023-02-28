# 다리놓기 복습

t_n = int(input())

for _ in range(t_n):
    n,m = tuple(map(int,input().split()))
    memo = [[0 for _ in range(m+1)] for _ in range(n+1)]
    for i in range(1,n+1):
        for j in range(i,m+1):
            if i == 1:
                memo[i][j] = j
            elif i == j:
                memo[i][j] = 1
            else:
                memo[i][j] = memo[i][j-1] + memo[i-1][j-1]
    print(memo[n][m])