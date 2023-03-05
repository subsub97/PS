def solution(line):
    int_p_list = [] # 교점을 모아두는 리스트
    # x y c 값으로 주어짐
    for i in range(len(line)): # 교점찾기
        a = line[i][0]
        b = line[i][1]
        e = line[i][2]
        for j in range(i+1,len(line)):
            c = line[j][0]
            d = line[j][1]
            f = line[j][2]
            # 교점 구하기
            if (a * d - b * c) != 0:
                x = (b * f - e * d) / (a * d - b * c)
                y = (e * c - a * f) / (a * d - b * c)
                # x,y가 정수인지 구분하기
                if x == int(x) and y == int(y): #교점 x,y가 모두 정수인 경우
                    int_p_list.append([int(x),int(y)])
            else:
                continue

    x_sort_list = sorted(int_p_list,key = lambda x:x[0])
    y_sort_list= sorted(int_p_list,key = lambda x:x[1])

    # x축은 col관련, y축은 row관련
    min_col = x_sort_list[0][0]
    min_row = y_sort_list[0][1]
    max_col = x_sort_list[-1][0]
    max_row =  y_sort_list[-1][1]

    n = abs(max_col - min_col)
    m = abs(max_row - min_row)

    grid = [['.'] * (n+1) for _ in range(m+1)]

    for spot in int_p_list:
        row = max_row - spot[1]
        col = spot[0] - min_col
        grid[row][col] = "*"

    answer =[]
    for i in range(len(grid)):
        result =''.join(grid[i][:len(grid[i][::])])
        answer.append(result)

    return answer