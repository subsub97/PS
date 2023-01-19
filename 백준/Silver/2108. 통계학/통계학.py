# sort 2108 통계학
# 1. 산술평균 : n개의 수들의 합을 n으로 나눈 값
# 2. 중앙값 : n개의 수들을 증가하는 순서로 나열 했을 경우 그 중앙에 위치하는 값
# 3. 최빈값 : n개의 수들 중 가장 많이 나타나는 값
# 4. 범위 : n개의 수들 중 최댓값과 최솟값의 차이

import sys,math
n = int(sys.stdin.readline().strip())

num_list = []
cnt_list = [
    [0] *2 for _ in range(8002)
]
for i in range(n):
    num =int(sys.stdin.readline().strip())
    num_list.append(num)
    if num == 0:
        cnt_list[0][0] += 1
        if cnt_list[0][0] == 0:
            cnt_list[0][1] = 0
    else:
        cnt_list[num+4001][0] += 1
        if cnt_list[num+4001][1] == 0 :
            cnt_list[num+4001][1] = num


num_list.sort()
cnt_list.sort(key = lambda x: (x[0] , x[1]))
same_max = []
pre_max = 0
for j in range(8001,-1,-1):
    if j == 8001:
        pre_max = cnt_list[j][0]
        same_max.append(cnt_list[j][1])
    else:
        if pre_max == cnt_list[j][0]:
            same_max.append(cnt_list[j][1])
        else:
            break

print(round(sum(num_list)/n))
print(num_list[n//2])
if len(same_max) >= 2:
    print(same_max[-2])
else:
    print(same_max[0])

print(max(num_list)-min(num_list))
