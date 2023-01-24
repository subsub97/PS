#1676 try2

n = int(input())

cnt = 0
fac_num = 1
for i in range(1,n+1):
    fac_num *= i
    while str(fac_num)[-1] == '0':
        cnt += 1
        fac_num //= 10
print(cnt)