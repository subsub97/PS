n = int(input())

for _ in range(n):
    dp = [1, 2, 4]
    k = int(input())
    for i in range(3,k+1):
        dp.append(dp[i-1] + dp[i-2] + dp[i-3])
    print(dp[k-1])