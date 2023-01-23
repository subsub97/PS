import math
while True:
    side_list = list(map(int,input().split()))

    if side_list[0] == 0 and side_list[1] == 0 and side_list[2] == 0:
        break

    side_list.sort()
    hypotenuse = side_list[-1] ** 2
    a = side_list[0] ** 2
    b = side_list[1] ** 2

    if int(a + b) == int(hypotenuse):
         print('right')
    else:
         print('wrong')