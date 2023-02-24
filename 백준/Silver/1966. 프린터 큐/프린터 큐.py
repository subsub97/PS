n = int(input())

for _ in range(n):
    d_n,select = tuple(map(int,input().split()))
    imp_list = list(map(int,input().split()))
    idx_list = [0 for _ in range(d_n)]
    idx_list[select] ='print'
    order = 0
    while True:
        if imp_list[0] == max(imp_list): # 출력가능한 상태
            order += 1 #출력순서 변수를 증가시킨다.
            if idx_list[0] == 'print':
                print(order)
                break
            else: # 문제에서 알고자하는 순서가 아닌 경우 버린다.
                imp_list.pop(0)
                idx_list.pop(0)
        else: # 현재 출력가능한 우선순위가 아닌경우
            temp1 = imp_list.pop(0)
            temp2 = idx_list.pop(0)
            imp_list.append(temp1)
            idx_list.append(temp2)