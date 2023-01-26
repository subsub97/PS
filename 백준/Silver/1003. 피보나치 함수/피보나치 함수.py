# dp try 1
import sys
n = int(sys.stdin.readline().strip())

for i in range(n):
    # k번쨰 수는 0과 1이 몇번 호출 될까?
    k = int(sys.stdin.readline().strip())


    dp = [
        [0,0] for _ in range(k+1)
    ]
    if k > 1:
        dp[0][0] =1; dp[0][1] =0;
        dp[1][0] =0; dp[1][1] = 1;
    else:
        dp = [[1, 0], [0, 1]]

    for i in range(2,k+1):
        dp[i][0] = dp[i-2][0] + dp[i-1][0]
        dp[i][1] = dp[i-2][1] + dp[i-1][1]
    print(dp[k][0],dp[k][1])