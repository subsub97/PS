# 1259 try1

while True:
    num = input()
    check = 0
    if num == '0':
        break
    center_point = len(num) // 2
    for i in range(center_point):
        if num[i] != num[-i-1]:
            print('no')
            check = 1
            break
    if check == 0:
        print('yes')




