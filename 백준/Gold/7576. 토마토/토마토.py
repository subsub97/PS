from collections import deque
import sys


col,row = tuple(map(int,sys.stdin.readline().strip().split()))


t_container = [
    list(map(int,sys.stdin.readline().strip().split()))
                for _ in range(row)
              ]
visited = [ [False] * col
            for _ in range(row)
            ]

q = deque()
min_path = 0
def in_range(x,y):
    return 0 <= x and x < row and 0 <= y and y < col

def can_go(x,y):
    if not in_range(x,y):
        return False

    if visited[x][y] == True or t_container[x][y] != 0:
        return False
    return True


def bfs():
    global min_path
    dxs,dys = [1,-1,0,0],[0,0,1,-1]
    while q:
        x,y,step = q.popleft()
        if min_path < step:
            min_path = step
        for dx,dy in zip(dxs,dys):
            next_x,next_y = x + dx,  y + dy
            if can_go(next_x,next_y):
                visited[next_x][next_y] = True
                t_container[next_x][next_y] = 1
                q.append((next_x,next_y,step + 1))

for r in range(row):
    for c in range(col):
        if t_container[r][c] == 1:
            q.append((r,c,0))
bfs()
flag = 0
for r in range(row):
    for c in range(col):
        if t_container[r][c] == 0:
            flag = 1
            break
if flag == 1:
    print(-1)
else:
    print(min_path)