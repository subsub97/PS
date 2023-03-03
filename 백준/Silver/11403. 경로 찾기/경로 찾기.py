# 가중치가 없는 경로에서 i -> j 경로가 있는지 없는지 구하는 프로그램

import sys
input = sys.stdin.readline
n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
can_go_list = [[0]*n for _ in range(n)]


def can_go(cur_idx,find_idx):
    for idx in range(n):
        if graph[find_idx][idx] == 1 and visited[idx] == False:
            visited[idx] = True
            can_go_list[cur_idx][idx] = 1
            can_go(cur_idx,idx)

for i in range(n):
    visited = [False for _ in range(n)]
    can_go(i,i)

for row in can_go_list:
    for num in row:
        print(num,end=' ')
    print()