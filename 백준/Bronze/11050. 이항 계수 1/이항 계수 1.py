n,k = map(int,input().split())

child = 1
parent = 1
if k < 0:
    print(0)
elif k > n:
    print(0)
else:
    for i in range(n,0,-1):
        child *= i
    for j in range(k,0,-1):
        parent *= j
    for l in range(n-k,0,-1):
        parent *= l

    print(child // parent)