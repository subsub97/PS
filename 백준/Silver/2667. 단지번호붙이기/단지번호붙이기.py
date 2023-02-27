import sys
sys.setrecursionlimit(10**6)

n = int(sys.stdin.readline())

apt_area = [ sys.stdin.readline().strip() for _ in range(n)]

visited = [ [0] * n for _ in range(n)]
apt_num_list =[]

def in_range(x,y):
    return 0 <= x and x < n and 0 <= y and y < n

def can_go(x,y):
    if not in_range(x,y):
        return False
    if visited[x][y] == True or apt_area[x][y] == '0':
        return False
    return True

def dfs(x,y):
    global cnt
    cnt += 1
    visited[x][y] = True
    dxs,dys = [1,-1,0,0],[0,0,1,-1]
    for dx,dy in zip(dxs,dys):
        next_x = x + dx
        next_y = y + dy
        if can_go(next_x,next_y):
            dfs(next_x,next_y)
    return

many_group = 0

for i in range(n):
    for j in range(n):
        cnt = 0
        if can_go(i,j):
            many_group +=1
            dfs(i,j)
            apt_num_list.append(cnt)

print(many_group)
apt_num_list.sort()
for num in apt_num_list:
    print(num)