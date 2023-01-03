#DP try1

n = int(input())

# 각 계단마다의 점수를 알고있는 리스트 생성
step = [
    int(input()) for _ in range(n)
]

memo = [ 0 for _ in range(n)]
# 연속으로 한칸을 올라가는지 체크하기위한 변수 cnt
memo[0] = step[0]
if n > 1:
    memo[1] = memo[0] + step[1]
for i in range(2,n):
    if i == 2:
        memo[i] = max(step[i - 1], step[i - 2]) + step[i]
    else:
        memo[i] = max(memo[i-3] + step[i-1] , memo[i-2] )  + step[i]
print(memo[n-1])