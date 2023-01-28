# 1780 분할구현  try1 (해당문제는 풀이를 참고해서 풀었다.)
import sys

n = int(sys.stdin.readline())

arr_2d = [
    list(map(int,sys.stdin.readline().strip().split()))
    for _ in range(n)
]
minus_cnt = 0
zero_cnt = 0
plus_cnt = 0

def dfs(x,y,n):
    global minus_cnt,zero_cnt,plus_cnt
    num_check = arr_2d[x][y]
    for i in range(x,x+n):
        for j in range(y,y+n):
            s = arr_2d[x][y]
            if num_check != arr_2d[i][j]:
                for k in range(3):
                    for l in range(3):
                        dfs(x + k * n // 3,y + l * n // 3,n//3)
                return

    if num_check == -1:
        minus_cnt += 1
    elif num_check == 0:
        zero_cnt += 1
    else:
        plus_cnt += 1

dfs(0,0,n)

print(minus_cnt)
print(zero_cnt)
print(plus_cnt)