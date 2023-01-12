import sys
n = int(input())

score_arr = list(map(int,sys.stdin.readline().split()))
# 최고점수 M을 찾는다.
max_score = max(score_arr)


#평균 점수 구하기
total_score = 0
for num in score_arr:
    total_score += num/max_score * 100
print(f"{total_score/n}")