import sys
input = sys.stdin.readline
k = int(input())

account = []
for _ in range(k):
    num = int(input())
    if num == 0:
        account.pop()
    else:
        account.append(num)

print(sum(account))