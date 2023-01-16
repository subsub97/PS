# 수찾기 1920 try 1

'''아이디어 N가지 여러가지 수가 주어지면 주어진 수들을 정렬하여 추가적으로 주어지는 M가지 수중
N가지의 수중 어떠한 숫자라도 매칭이 가능한 수가있는지 분할탐색을한다.
 '''

n = int(input())
n_list = list(map(int,input().split()))
m = int(input())
m_list = list(map(int,input().split()))

n_list.sort() # 정렬


for check_num in m_list: #찾아보고 싶은 숫자 집합에서 하나씩 꺼내기
    start = 0
    end = n - 1
    while start <= end:
        mid = (start + end) // 2
        if check_num == n_list[mid]:
            print('1')
            break
        else:
            if n_list[mid] > check_num:
                end = mid - 1
            else:
                start = mid + 1
    if start > end:
        print(0)