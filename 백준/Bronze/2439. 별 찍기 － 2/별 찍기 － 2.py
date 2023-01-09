n = int(input())

for i in range(n-1,-1,-1):
    for k in range(i):
        print(" ",end='')
    for j in range(n-i):
        print("*",end='')
    print()
