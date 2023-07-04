n = int(input())
q = []
max_size = n

for _ in range(n):
    num_list = list(map(int,input().split()))
    for num in num_list:
        q.append(num)
    q.sort(reverse=True)
    temp = len(q) - max_size
    if temp > 0 :
        for _ in range(temp):
            q.pop()
print(q[-1])