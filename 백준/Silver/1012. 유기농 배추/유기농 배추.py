import sys
sys.setrecursionlimit(10**6)
n = int(sys.stdin.readline())


def in_range(x,y):
    global row,col
    return 0 <= x and x < row and 0 <= y and y < col

def can_go(x,y):
    if not in_range(x,y):
        return False
    if farm[x][y] == 0 or visited[x][y] == True:
        return False
    return True

def dfs(x,y):
    visited[x][y] = True
    dxs,dys = [1,-1,0,0],[0,0,-1,1]
    for dx,dy in zip(dxs,dys):
        next_x,next_y = x + dx, y + dy
        if can_go(next_x,next_y):
            dfs(next_x,next_y)




for _ in range(n):
    row,col,cab = tuple(map(int,sys.stdin.readline().strip().split()))
    bug = 0
    farm = [
        [0] * col
        for _ in range(row)
    ]

    visited = [
        [False] * col
        for _ in range(row)
    ]

    for i in range(cab):
        r,c = tuple(map(int,sys.stdin.readline().strip().split()))
        farm[r][c] = 1

    for r in range(row):
        for c in range(col):
            if farm[r][c] == 1 and visited[r][c] == False:
                bug +=1
                dfs(r,c)

    print(bug)