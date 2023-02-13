import math
a,b,n = map(int,input().split())
day = (n -b) / (a-b)
print(math.ceil(day))

