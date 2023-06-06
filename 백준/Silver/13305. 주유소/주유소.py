import sys
n = int(input())

distances = tuple(map(int,input().split()))
cost = tuple(map(int,input().split()))

dist = 0
total_cost = 0
min_cost = sys.maxsize
for i in range(1,len(cost)):
    if cost[i-1] < min_cost:
        min_cost = cost[i-1]
    total_cost += distances[i-1] * min_cost

print(total_cost)