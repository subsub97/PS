import sys
sys.setrecursionlimit(10**6)

n = int(input())
tree = list(map(int,input().split()))
k = int(input())

def dfs(k):
    tree[k] = -2
    for i in range(n):
        if tree[i] == k:
            dfs(i)

dfs(k)
cnt = 0
for i in range(n):
    if tree[i] != -2 and i not in tree:
        cnt +=1

print(cnt)