# try1
import sys 
sys.setrecursionlimit(10**6)
n = int(input())
k = int(input())

computer = [[] for _ in range(n+1)]

visited = [False for _ in range(n+1)]


for _ in range(k):
    s,e = tuple(map(int,input().split()))
    computer[s].append(e)
    computer[e].append(s)

def dfs(com):
    global virus_cnt
    for cur_com in computer[com]:
        if not visited[cur_com]:
            visited[cur_com] = True
            virus_cnt += 1
            dfs(cur_com)


virus_cnt = 0
visited[1] = True
dfs(1)
print(virus_cnt)