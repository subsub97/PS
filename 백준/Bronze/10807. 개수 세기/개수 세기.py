n = int(input())
list = list(map(int,input().split()))
find_num = int(input())
cnt = 0
for num in list:
    if num == find_num:
        cnt += 1

print(cnt)