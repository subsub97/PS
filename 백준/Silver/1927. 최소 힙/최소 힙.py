import heapq,sys

heap = []
n = int(sys.stdin.readline())

for _ in range(n):
    num = int(sys.stdin.readline())
    if num == 0:
        if 0 == len(heap):
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap,num)
