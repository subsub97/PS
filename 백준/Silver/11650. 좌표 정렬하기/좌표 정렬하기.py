import sys

n = int(sys.stdin.readline())
x_y_list = []
for i in range(n):
    x,y = map(int,sys.stdin.readline().strip().split())
    x_y_list.append([x,y])

x_y_list.sort(key = lambda x:(int(x[0]),int(x[1])))

for x_y in x_y_list:
    for num in x_y:
        print(num , end=' ')
    print()