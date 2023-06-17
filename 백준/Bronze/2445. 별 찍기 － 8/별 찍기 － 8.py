n = int(input())
for i in range(1,(n*2)+1):
    if i <= n:
        print("*" * i,end='')
        print(" " * ((n*2)-(i*2)),end='')
        print("*" * i)

    else:
        print("*" * ((n*2) - i),end='')
        print(" " * ((n*2) - ((n*2) -i) * 2),end='')
        print("*" * ((n*2) - i))

