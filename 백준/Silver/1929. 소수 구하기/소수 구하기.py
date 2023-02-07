import sys
m,n = tuple(map(int,sys.stdin.readline().strip().split()))

check_arr = [False,False] + [True] * (n -1) # -1 번째까지가 자신을 포함한 범위이다.
primes=[]


for i in range(2,n+1):
    if check_arr[i]:
        if i >= m:
            primes.append(i)
        for j in range(i,n+1,i):
            check_arr[j] = False
for num in primes:
    print(num)