safe_cnt = 0


def in_range(x, y, board):
    return 0 <= x and x < len(board[0]) and 0 <= y and y < len(board[0])


def check_safe_area(x, y, board):
    global safe_cnt

    if board[x][y] == 1:
        return safe_cnt
    # 하,상,우,좌,우상,우하,좌상,좌하
    dxs, dys = [1, -1, 0, 0, -1, 1, -1, 1], [0, 0, 1, -1, 1, 1, -1, -1]
    flag = 0
    for dx, dy in zip(dxs, dys):
        next_x, next_y = x + dx, y + dy

        if in_range(next_x, next_y, board):
            if board[next_x][next_y] == 1:
                flag = 1
                break

    if flag == 0:
        safe_cnt += 1

    return safe_cnt


def solution(board):
    for i in range(len(board[0])):
        for j in range(len(board[0])):
            answer = check_safe_area(i, j, board)
    return answer

