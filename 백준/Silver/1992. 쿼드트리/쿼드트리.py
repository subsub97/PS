import sys

n = int(sys.stdin.readline().strip())

grid = [
    sys.stdin.readline()
    for _ in range(n)
]


def dfs(x,y,n):
    num_check = grid[x][y]
    for i in range(x,x+n):
        for j in range(y,y+n):
            if num_check != grid[i][j]:
                print('(', end='')
                for k in range(2):
                    for l in range(2):

                        dfs(x+k * n//2,y+l * n//2 , n//2)
                print(')', end='')
                return
    print(num_check,end='')

dfs(0,0,n)
