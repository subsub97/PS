def in_range(x,y):
    return 0 <= x and 0 <= y

n = int(input())

grid = [ [0] * 1000 for _ in range(1000)]

dxs,dys = [0,1,1,-1] , [1,-1,0,1] # 우, 좌하, 하, 우상

cnt = 0
cur_x , cur_y = 0 ,0
cur_dir = 0
while True:
    cnt += 1
    if cnt == n:
        print(f"{cur_x + 1}/{cur_y + 1}")
        break

    if in_range(cur_x,cur_y):
        cur_x = cur_x + dxs[cur_dir]
        cur_y = cur_y + dys[cur_dir]
        if cur_x == 0:
            cur_dir = (cur_dir + 1) % 4
        elif cur_y == 0:
            cur_dir = (cur_dir + 1) % 4