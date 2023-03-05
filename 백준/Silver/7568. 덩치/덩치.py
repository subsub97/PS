#어떤 사람의 몸무게가 xkg 이고 y cm 임

import sys
input = sys.stdin.readline
size_list = []
rank_list = []

n = int(input())

for _ in range(n):
    size_list.append(tuple(map(int,input().split())))

# 자신보다 큰 사람들이 몇명이 있는가 체크 하고 자기 등수를 먹인다.
for i in range(n):
    cur_rank = 1
    cur_x = size_list[i][0]
    cur_y = size_list[i][1]
    for j in range(n):
        target_x = size_list[j][0]
        target_y = size_list[j][1]
        if cur_x < target_x and cur_y < target_y:
            cur_rank += 1
    rank_list.append(cur_rank)

for ranking in rank_list:
    print(ranking,end=' ')