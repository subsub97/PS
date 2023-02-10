# try1
# x 축 이동 가능 순간이동은 2 * x

# 아이디어  BFS 를 이용하여 인접한 곳 으로 이동하면서 체크!

from collections import deque

subin,bro = tuple(map(int,input().split()))

q = deque()
visited = [False for _ in range(100001)]
dist_arr = [ 0 for _ in range(100001)]


def in_range(x):
    return 0 <= x and x < 100001

def can_go(x):
    if not in_range(x):
        return False
    if visited[x] == True:
        return False
    return True

def push(x,distance):
    q.append(x)
    visited[x] = True
    dist_arr[x] = distance


def bfs():
    while q:
        x = q.popleft()
        walk_x = [1,-1]
        for w_x in walk_x:
            next_x = x + w_x
            if can_go(next_x):
                push(next_x,dist_arr[x] + 1)
                if next_x == bro:
                    return
        warp_x = x * 2
        if can_go(warp_x):
            push(warp_x, dist_arr[x] + 1)
            if next_x == bro:
                return


push(subin,0)
bfs()
print(dist_arr[bro])