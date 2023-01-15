#분해합 2231 try 1

n = int(input())
num = 0
flag = 0
while num <= n:
    num += 1
    str_num = str(num)
    sum_num = 0
    for i in range(1,len(str_num)+1):
        sum_num += int(str_num[i-1:i])
    sum_num += num
    if sum_num == n:
        print(num)
        flag = 1
        break

if flag == 0:
    print('0')