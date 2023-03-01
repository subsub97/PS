import sys
input = sys.stdin.readline
find_num = int(input())
wrong_cnt = int(input())
pos_key_list = []
if wrong_cnt != 0:
    imp_key_list = list(map(int,input().split()))
else:
    imp_key_list = []

for num in range(10):
    if num not in imp_key_list:
        pos_key_list.append(num)

min_cnt = abs(find_num - 100)

for number in range(1000000):
    number = str(number)

    for i in range(len(number)):
        if int(number[i]) in imp_key_list:
            break

        if i == len(number) -1: #현재 번호중 고장난 버튼이 없는경우
            min_cnt = (min(min_cnt,abs(find_num - int(number)) + len(number)))


print(min_cnt)
