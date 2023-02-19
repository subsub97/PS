import sys
n,r,c = tuple(map(int,sys.stdin.readline().strip().split()))

init_n = 2 ** n
visit_path = 0
def dfs(cur_n,row,col):
    global visit_path

    if cur_n // 2 != 1:
        if cur_n // 2 > row: # 1 or 2 사분면
            if cur_n // 2 > col: # 1사분면
                dfs(cur_n // 2, row , col)
            else: # 2 사분면
                n = cur_n // 2
                cur_cnt = n * n
                visit_path += cur_cnt
                dfs(cur_n // 2, row, col - (cur_n // 2))
        else: # 3 or 4 사분면
            if cur_n // 2 > col: # 3사분면
                n = cur_n // 2
                cur_cnt = n * n * 2
                visit_path += cur_cnt
                dfs(cur_n // 2, row - (cur_n // 2), col)
            else: # 4 사분면
                n = cur_n // 2
                cur_cnt = n * n * 3
                visit_path += cur_cnt
                dfs(cur_n // 2, row - (cur_n // 2), col - (cur_n // 2))

    else: # 2 x 2 박스라면 하나하나 cnt 하기
        cnt = 0
        for i in range(2):
            for j in range(2):
                if i == row and j == col:
                    visit_path += cnt
                    return
                cnt += 1

dfs(init_n,r,c)
print(visit_path)