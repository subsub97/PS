'''
아기상어는 자신의 크기보다 작은 물고기만 먹을수 있고
처음 시작 크기는 2이다.
상하좌우로 움직일수 있다.
크기가 같은 물고리를 먹지는 못하지만 지나갈수있다.
자신의 크기와 같은 만큼은 물고기를 먹어야 커짐
'''
import sys
from collections import deque

n = int(sys.stdin.readline().strip())
grid = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(n)]
max_exp = 2 #상어 진화를 관리할 변수
shark_exp = 0  #상어의 지금 경험치를 관리하는 변수
q = deque()
visited =[]

def init_visited():
    global visited
    visited = [[False] *n for _ in range(n)]

def in_range(x,y):
    return 0 <= x and x < n and 0 <= y and y <n

def can_go(x,y,cur_size):
    if not in_range(x,y) or visited[x][y]== True:
        return False
    if grid[x][y] > cur_size: #현재 상어 크기보다 물고기가 크면 이동 못함
        return False
    return True

def bfs():
    global shark_exp,max_exp
    dxs,dys = [-1,0,0,1] , [0,-1,1,0]  # 상,좌,우,하  순서로 본다.
    max_time = 0
    while q:
        x,y,cur_size,cur_time = q.popleft()

        if grid[x][y] != 0 and grid[x][y] < cur_size: #먹을수있는 물고기를 만난경우
            shark_exp += 1
            max_time = cur_time
            temp_lst =[(x,y,cur_time)]
            while q: #최단 거리에 같은 최단거리에 우선순위가 높은 곳이 있는지 확인
                check_x,check_y,cur_size,check_cur_time = q.popleft()
                if grid[check_x][check_y] != 0 and grid[check_x][check_y] < cur_size: #먹을수 있는경우
                    temp_lst.append((check_x,check_y,check_cur_time))
            temp_lst.sort(key = lambda x:(-x[2],-x[0],-x[1])) # x가 높은것부터 내림차순 정렬후 y가 높은것부터 내림차순 정렬
            x,y,c = temp_lst.pop()
            
            if shark_exp == max_exp: #상어가 진화하는 조건을 만족한 경우
                cur_size += 1
                max_exp = cur_size
                shark_exp = 0
            grid[x][y] = 0
            init_visited()

        for dx,dy in zip(dxs,dys):
            next_x , next_y = x + dx , y + dy
            if can_go(next_x,next_y,cur_size):
                visited[next_x][next_y] = True
                q.append((next_x,next_y,cur_size,cur_time+1))
    return max_time

init_visited()

for i in range(n):
    for j in range(n):
        if grid[i][j] == 9:
            grid[i][j] = 0
            visited[i][j] = True
            q.append((i,j,2,0))
            time = bfs()
print(time)




