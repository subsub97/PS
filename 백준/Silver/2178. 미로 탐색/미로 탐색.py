from collections import deque

q = deque()

n,m = tuple(map(int,input().split()))

maze = [
    [0] * m
    for _ in range(n)
         ]

for i in range(n):
    maze_line = input()
    for j in range(m):
        maze[i][j] = int(maze_line[j])



visited = [
    [False] * m
    for _ in range(n)
         ]

min_dis = [
    [0] *m
    for _ in range(n)
]

def in_range(x,y):
    return 0 <= x and x < n and 0 <= y and y < m

def can_go(x,y):
    if not in_range(x,y):
        return False
    if visited[x][y] == True or maze[x][y] == 0:
        return False
    return True

def bfs():
    while q:
        x,y,cur_dis = q.popleft()
        dxs,dys =[1,-1,0,0],[0,0,1,-1]

        for dx,dy in zip(dxs,dys):
            next_x = x + dx
            next_y = y + dy
            if can_go(next_x,next_y):
                visited[next_x][next_y] = True
                if min_dis[next_x][next_y] == 0:
                    min_dis[next_x][next_y] = cur_dis+1
                q.append((next_x,next_y,cur_dis+1))

q.append((0,0,1))
bfs()
print(min_dis[n-1][m-1])