from collections import deque

n , m = tuple(map(int,input().split()))

q = deque()



friend_list = [[] for _ in range(n)]

for i in range(m):
    s,e = tuple(map(int,input().split()))
    friend_list[s-1].append(e-1)
    friend_list[e-1].append(s-1)

def can_push(num):
    if visited[num] == True:
        return False
    return True

def bfs():
    global bacon_val
    while q:
        num, distance = q.popleft()
        for next_num in friend_list[num]:
            if can_push(next_num):
                q.append((next_num,distance + 1))
                visited[next_num] = True
        bacon_val += distance

    return bacon_val
min_val = 101
for i in range(n):
    bacon_val = 0
    visited = [False for _ in range(n)]
    visited[i] =True
    q.append((i,0))
    val = bfs()
    if min_val > val:
        min_val = val
        famous_person = i
print(famous_person + 1)