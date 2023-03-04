#절대 값이 가장 작은 값이 여러개일 경우 가장 작은 수를 출력

import heapq,sys

input = sys.stdin.readline

n = int(input())
heap = []
for _ in range(n):
    num = int(input())
    if num != 0:
        heapq.heappush(heap,(abs(num),num))
    else:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap)[1])