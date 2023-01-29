# 2630 try1

import sys

n = int(sys.stdin.readline().strip())

color_paper = [
    list(map(int,sys.stdin.readline().strip().split()))
    for _ in range(n)
]
white = 0
blue = 0
def dfs(x,y,n):
    global white,blue
    check_num = color_paper[x][y]
    for i in range(x,x+n): # 행을 확인한다
        for j in range(y,y+n): #열을 확인한다
            if check_num != color_paper[i][j]: # 같은 색의 색종이가 아닌경우
                for k in range(2):
                    for l in range(2):
                        dfs(x + k * n//2,y + l * n// 2,n//2)
                return
    if check_num == 1:
        blue += 1
    else:
        white += 1

dfs(0,0,n)

print(white)
print(blue)