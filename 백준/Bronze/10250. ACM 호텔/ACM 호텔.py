# 10250 try1
import sys
# test case 의 개수
t = int(sys.stdin.readline())

for i in range(t):
    floor, room, n = map(int, sys.stdin.readline().strip().split())
    h_blueprint = [
        [0] * room for _ in range(floor)
    ]
    cnt = 0
    for i in range(room):
        for j in range(floor):
            h_blueprint[j][i] = 1
            cnt += 1
            if cnt == n:
                floor = str(j + 1)
                if i < 9:
                    room = '0' + str(i + 1)
                else:
                    room = str(i+1)
                break
        if cnt == n:
            break
    print(floor + room)
