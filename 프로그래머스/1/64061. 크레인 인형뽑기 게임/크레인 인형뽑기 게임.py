item_stack = []
def solution(board, moves):
    answer = 0

    for column in moves:
        column -= 1
        for row in range(len(board[0])):
            if board[row][column] != 0:
                # 인형이 있는 경우
                current_doll = board[row][column]
                board[row][column] = 0
                answer = item_add(current_doll,answer)
                break
    return answer

def item_add(doll,answer):
    if len(item_stack) == 0:
        item_stack.append(doll)
    else:
        if doll == item_stack[-1]:
            item_stack.pop()
            answer += 2
        else:
            item_stack.append(doll)

    return  answer