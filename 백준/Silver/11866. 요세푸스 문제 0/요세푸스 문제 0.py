# queue try 3

n , k = map(int,input().split())

list = [
    i for i in range(1,n+1)
]

idx = k - 1
for i in range(n):
    if i == 0:
        if len(list) == 1:
            print(f"<{list[0]}>")
        else:
            print('<',end='')
            print(list.pop(idx), end=', ')
            idx += k - 1
            idx = idx % len(list)
    elif i==n-1:
        print(list.pop(idx),end='>')
        idx += k - 1

    else:
        print(list.pop(idx),end=', ')
        idx += k - 1
        idx = idx % len(list)