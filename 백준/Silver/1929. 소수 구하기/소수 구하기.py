import sys
m,n = tuple(map(int,sys.stdin.readline().strip().split()))

for i in range(m,n+1):
    num = int(i ** 0.5)
    cnt = 0
    for j in range(1,num+1):
        if i % j == 0:
            cnt += 1
        if cnt > 1:
            break
    if cnt == 1 and i != 1:
        print(i)