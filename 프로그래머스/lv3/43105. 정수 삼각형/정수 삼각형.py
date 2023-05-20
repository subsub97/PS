
def solution(triangle):
    answer = 0
    dp = [ [0 for _ in range(len(triangle[-1]))] for _ in range(len(triangle))]
    for i in range(len(triangle)):
        for j in range(len(triangle[i])):
            if i == 0:
                dp[i][j] = triangle[i][j]
            else:
                if j == 0: #좌측 끝인경우
                    dp[i][j] = triangle[i][j] + dp[i-1][j]
                elif i == j:
                    dp[i][j] = triangle[i][j] + dp[i - 1][j-1]
                else:
                    dp[i][j] = max(dp[i-1][j-1],dp[i-1][j]) + triangle[i][j]
    answer = max(dp[-1])
    return answer


print(solution([[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]))
