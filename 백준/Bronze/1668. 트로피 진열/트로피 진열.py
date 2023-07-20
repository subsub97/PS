n = int(input())

h_list = []
for _ in range(n):
    h = int(input())
    h_list.append(h)


for i in range(2):
    max_h = 0
    cnt = 0
    if i == 1 :
        h_list = h_list[::-1]
    for h in h_list:
        if max_h < h:
           cnt += 1
           max_h = h
    print(cnt)