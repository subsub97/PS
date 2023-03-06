from collections import deque

# 사람이 앉은 경우 P, 테이블 O, 파티션 X
def solution(places):
    answer = []

    for room in places:
        flag = 0
        for i in range(5):
            for j in range(5):
                if room[i][j] == 'P':
                    q = deque()
                    visited =[[False] * 5 for _ in range(5)]
                    q.append((i,j,0))
                    visited[i][j] = True
                    val = bfs(q,room,visited) # 1을 리턴하면 정상 거리유지
                    if val != 1:
                        flag = 1
        if flag == 1:
            answer.append(0)
        else:
            answer.append(1)


    return answer

def in_range(x,y):
    return 0 <= x and x < 5 and 0 <= y and y < 5

def need_check(x,y,cur_room,visited,level):
    if 3 <= level:
        return False
    if not in_range(x,y):
        return False
    if cur_room[x][y] == 'X' or visited[x][y] == True:
        return False
    return True

def bfs(q,room,visited):
    dxs,dys = [1,-1,0,0],[0,0,1,-1]
    while q:
        row,col,cur_level = q.popleft()
        if cur_level != 0 and room[row][col] == 'P':
            return 0
        for dx,dy in zip(dxs,dys):
            next_r,next_c = row + dy, col +dx
            if need_check(next_r,next_c,room,visited,cur_level+1):
                visited[next_r][next_c] = True
                q.append((next_r,next_c,cur_level + 1))
    return 1




