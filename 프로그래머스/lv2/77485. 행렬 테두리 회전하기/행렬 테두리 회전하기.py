def solution(rows, columns, queries):
    answer = []
    grid = [[]]
    num = 1

    # grid = [[i*columns+j for j in range(1,columns+1)] for i in range(rows)] 리스트 컴프리헨션
    for i in range(rows):
        grid.append([])
        for j in range(columns):
            grid[i].append(num)
            num += 1

    for info in queries:
        r1, c1, r2, c2 = info[0] - 1, info[1] - 1, info[2] - 1, info[3] - 1
        visited = [[False] * columns for _ in range(rows)]
        cur_min,grid = find_min_val(c1,c2,r1,r2,visited,grid)  # x1: 1 x2: 4 y1:1 y2:3
        answer.append((cur_min))

    return answer


def in_range(cur_c, cur_r,x1,x2,y1,y2):
    return x1 <= cur_c and cur_c <= x2 and y1 <= cur_r and cur_r <= y2


def find_min_val(s_c, e_c,s_r,e_r,visited,grid):
    temp = [0, 0]
    cnt = 0  # temp 조정하는 idx
    min_val = grid[s_r][s_c]
    dir_commend = 0
    cur_r = s_r
    cur_c = s_c

    while True:
        temp[cnt] = grid[cur_r][cur_c]
        cnt = (cnt + 1) % 2

        if temp[cnt] != 0:
            grid[cur_r][cur_c] = temp[cnt]  # 회전을 위한 값 넣기

        dxs, dys = [1, 0, -1, 0], [0, 1, 0, -1]
        next_r, next_c = cur_r + dys[dir_commend], cur_c + dxs[dir_commend]
        if in_range(next_c,next_r,s_c,e_c,s_r,e_r) and visited[cur_r][cur_c] == False:
            visited[cur_r][cur_c] = True
            cur_r = next_r
            cur_c = next_c
            if min_val > grid[cur_r][cur_c]:
                min_val = grid[cur_r][cur_c]
        else:
            dir_commend += 1
            if dir_commend == 4:
                break
            next_r, next_c = cur_r + dys[dir_commend], cur_c + dxs[dir_commend]
            if in_range(next_c, next_r,s_c,e_c,s_r,e_r) and visited[cur_r][cur_c] == False:
                visited[cur_r][cur_c] = True
                cur_r = next_r
                cur_c = next_c
                if min_val > grid[cur_r][cur_c]:
                    min_val = grid[cur_r][cur_c]
            else:
                break
    return min_val,grid