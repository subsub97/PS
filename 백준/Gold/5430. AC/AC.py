import sys
from collections import deque

t_n = int(sys.stdin.readline().strip())

for _ in range(t_n):
    q = deque()
    command = sys.stdin.readline().strip()
    n = int(sys.stdin.readline().strip())
    arr = sys.stdin.readline().strip()[1:-1].split(",")
    flag = 0
    error_point = 0
    if n == 0:
        q = []
    else:
        q = deque(arr)

    for i in range(len(command)):
        if error_point ==0:
            if command[i] == 'R':
                flag = (flag + 1) % 2

            else:
                if len(q) == 0:
                    error_point = 1
                    break
                else:
                    if flag == 0:
                        q.popleft()
                    else:
                        q.pop()
        else:
            break
    if error_point == 0:
        if flag == 0:
            print("[" + ",".join(q) + "]")
        else:
            q.reverse()
            print("[" + ",".join(q) + "]")
    else:
        print('error')