# 최대힙 만들기
import heapq,sys

heap = []
n = int(sys.stdin.readline())

for _ in range(n):
    num = int(sys.stdin.readline())
    if num == 0:
        if 0 == len(heap):
            print(0)
        else:
            print(heapq.heappop(heap) * -1)
    else:
        heapq.heappush(heap,-1 * num)
