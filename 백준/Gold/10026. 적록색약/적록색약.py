# 적록색약
import sys
from collections import deque
n = int(sys.stdin.readline())

grid = [ sys.stdin.readline().strip() for _ in range(n)]

visited =[ [False] * n  for _ in range(n)]

q = deque()
def in_range(x,y):
    return 0<= x and x < n and 0 <= y and y < n

def check_zone(x,y,color):
    if not in_range(x,y):
        return False
    if color != grid[x][y] or visited[x][y] == True:
        return False
    return True

def w_check_zone(x,y,color):
    if not in_range(x,y):
        return False
    if color == 'B':
        if color != grid[x][y] or visited[x][y] == True:
            return False
    else:
        if grid[x][y] == 'B' or visited[x][y] == True:
            return False
    return True


def look_bfs(condition):
    dxs,dys = [1,-1,0,0],[0,0,1,-1]
    if condition == 'nomal':
        while q:
            x,y = q.popleft()
            cur_color = grid[x][y]
            for dx,dy in zip(dxs,dys):
                next_x,next_y = x + dx , y + dy
                if check_zone(next_x,next_y,cur_color):
                    visited[next_x][next_y] = True
                    q.append((next_x,next_y))
    else:
        while q:
            x,y = q.popleft()
            cur_color = grid[x][y]
            for dx,dy in zip(dxs,dys):
                next_x,next_y = x + dx , y + dy
                if w_check_zone(next_x,next_y,cur_color):
                    visited[next_x][next_y] = True
                    q.append((next_x,next_y))

cnt = 0
for i in range(n):
    for j in range(n):
        if visited[i][j] == False:
            visited[i][j] = True
            q.append((i,j))
            look_bfs('nomal')
            cnt += 1
print(cnt)

visited =[ [False] * n  for _ in range(n)]

cnt = 0
for i in range(n):
    for j in range(n):
        if visited[i][j] == False:
            visited[i][j] = True
            q.append((i,j))
            look_bfs('weakness')
            cnt += 1
print(cnt)