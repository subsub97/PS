# 밑변의 길이와 높이가 N인 삼각형
def solution(n):
    answer = []
    triangle_arr = [[0] * i for i in range(1,n+1)]
    num = 1
    dxs,dys = [0,1,-1],[1,0,-1] #아래,오른쪽, 왼쪽 대각위로 움직이게 도와준다.
    cur_x,cur_y = 0,0
    _dir = 0 #dx,dy의 방향을 결정해줄 변수

    while True:
        triangle_arr[cur_y][cur_x] = num
        num += 1
        next_c,next_r = cur_x + dxs[_dir], cur_y + dys[_dir]
        if in_range(next_c,next_r,n) and triangle_arr[next_r][next_c] == 0:
            cur_x,cur_y = next_c,next_r
        else:
            _dir = (_dir + 1) % 3
            next_c, next_r = cur_x + dxs[_dir], cur_y + dys[_dir]
            if in_range(next_c, next_r,n) and triangle_arr[next_r][next_c] == 0:
                cur_x, cur_y = next_c, next_r
            else:
                break
    answer = sum(triangle_arr,[])
    return answer

def in_range(x,y,n):
    return 0 <= x and x < n and 0 <= y and y< n

print(solution(6))