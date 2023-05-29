import sys
sys.setrecursionlimit(10**6)

def in_range(x,y):
    global w,h
    return 0 <= x and x < h and 0 <= y and y < w

def can_go(x,y):
    if not in_range(x,y):
        return False

    if grid[x][y] == 0 or visited[x][y] == True:
        return False
    return True

def dfs(x,y):
    visited[x][y] = True
    dxs,dys = [1,-1,0,0,1,-1,1,-1],[0,0,1,-1,1,-1,-1,1]
    for dx,dy in zip(dxs,dys):
        next_x,next_y = x + dx , y + dy
        if can_go(next_x,next_y):
            dfs(next_x,next_y)


while True:
    w,h = tuple(map(int,input().split()))

    if w == 0 and h == 0:
        break

    island = 0

    grid = [ list(map(int,input().split())) for _ in range(h)]
    visited = [ [False] * w for _ in range(h)]
    for i in range(h):
        for j in range(w):
            if can_go(i,j):
                dfs(i,j)
                island += 1

    print(island)