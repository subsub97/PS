import sys
n = sys.stdin.readline().strip()
num_list = list(map(int,sys.stdin.readline().split()))

total_cnt = 0
for num in num_list:
    cnt = 0
    for i in range(1,num+1):
        if num % i == 0:
            cnt += 1
    if cnt == 2:
        total_cnt += 1
print(total_cnt)
