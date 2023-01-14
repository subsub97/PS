max_num = 0
for i in range(9):
    a = int(input())
    if a > max_num:
        num_info = []
        num_info.append(a)
        num_info.append(i)
        max_num = a
print(num_info[0],num_info[1]+1)