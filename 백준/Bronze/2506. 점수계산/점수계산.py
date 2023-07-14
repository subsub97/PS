
n = int(input())
O_X = list(map(int,input().split()))

score = 0
pre = 0
for i in range(n-1,-1,-1):
    if O_X[i] == 0:
        pre = 0
    else:
        pre += 1
        score += pre

print(score)