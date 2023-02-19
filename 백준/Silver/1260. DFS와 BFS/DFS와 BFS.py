# DFS, BFS 구현하기

import sys
from collections import deque

n,m,v = tuple(map(int,sys.stdin.readline().strip().split()))

v -= 1
v_list = [ [] for _ in range(n) ]
visited = [ False for _ in range(n) ]
q = deque()
for _ in range(m): #간선 연결하기
    s,e = tuple(map(int,sys.stdin.readline().strip().split()))
    s -= 1
    e -= 1
    v_list[s].append(e)
    v_list[e].append(s)

# 작은것부터 방문하기 위한 정렬
for i in range(n):
    v_list[i].sort()
    
def can_go(x):
    if visited[x] == True:
        return False
    return True

def dfs(v):
    visited[v] = True
    print(v + 1,end=' ')
    for next_v in v_list[v]:
        if can_go(next_v):
            dfs(next_v)

def bfs():
    while q:
        x = q.popleft()
        print(x + 1,end=' ')
        for next_v in v_list[x]:
            if can_go(next_v):
                visited[next_v] = True
                q.append(next_v)

# dfs부터 실행
dfs(v)
visited = [ False for _ in range(n) ]
print()
q.append(v)
visited[v] = True
bfs()