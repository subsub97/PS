#  sort 10814 try2 
#  나이 순으로 정렬 나이가 같다면 먼저 가입한 순으로 정렬
# lambda 에서 int x[0]으로 안함
import sys
n = int(sys.stdin.readline().strip())

people_info = [
    sys.stdin.readline().strip().split()
    for _ in range(n)
]
people_info.sort(key = lambda x:int(x[0]))

for arr in people_info:
    for info in arr:
        print(info,end=' ')
    print()