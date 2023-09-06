n,m = map(int,input().split())

num_list =[]
used =[False for _ in range(n+1)]
def printNum(num):
    for elem in num:
        print(elem,end=' ')
    print()
    return

def choose(cnt):
    if cnt == m+1:
        printNum(num_list)
        return

    for i in range(1,n+1):
        if used[i] == False:
            used[i] = True
            num_list.append(i)
            choose(cnt+1)
            num_list.pop()
            used[i] = False
    return

choose(1)

