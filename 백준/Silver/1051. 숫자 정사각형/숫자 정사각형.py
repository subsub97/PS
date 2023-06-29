n,m = list(map(int,input().split()))

grid1 = []
for i in range(n):
    grid1.append(input())

grid = []
for i in range(n):
    grid.append([])
    for j in range(m):
        grid[i].append(grid1[i][j])

max_len = min(n,m)
max_width =0
flag =1
while flag:
    for i in range(n-max_len + 1):
        for j in range(m-max_len + 1):
            cur_num = grid[i][j]
            if cur_num == grid[i][j+max_len -1] and cur_num == grid[i+max_len -1][j] and cur_num == grid[i +max_len -1][j++max_len -1]:
                max_width = max_len * max_len
                break
        if max_width > 0:
            flag = 0
            break
    max_len = max_len-1
print(max_width)