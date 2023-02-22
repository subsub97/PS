# 톱니바퀴

'''
1. k번 회전 (회전은 시계방향과 반시계 방향이 있다.)
2.방향 결정 방법
 1 ,2 ,3 ,4 번의 각 4개의 톱니바퀴가 서로 영향을 준다.
 1번 톱니와 맞닿는 부분이 서로 다른 극이라면 2번 톱니는 1번이 회전한 방향과 반대방향으로
 회전하게 된다.

 3. k 가 주어짐
 4. N번 톱니와 돌릴 방향이 주어짐
 1 시계 -1 반시계방향
'''
import sys

def turn_gear(n,dir):
    temp = [2,2]
    cnt = 0 # temp를 두개 관리 하기위한 변수
    if dir == 1:
        for cur_i in range(8):
            next_i = cur_i + 1
            if next_i > 7:
                next_i = 0
            temp[cnt] = gear_list[n][next_i]
            cnt += 1
            if cnt > 1:
                cnt = 0
            if temp[cnt] == 2:
                gear_list[n][next_i] = gear_list[n][cur_i]
            else:
                gear_list[n][next_i] = temp[cnt]
    else:
        for cur_i in range(7,-1,-1):
            pre_i = cur_i + 1
            if pre_i > 7:
                pre_i = 0
            temp[cnt] = gear_list[n][cur_i]
            cnt += 1
            if cnt > 1:
                cnt = 0
            if temp[cnt] == 2:
                gear_list[n][cur_i] = gear_list[n][pre_i]
            else:
                gear_list[n][cur_i] = temp[cnt]

def check_gear(n,dir):
    if n == 0:
        if gear_list[n][2] == gear_list[n+1][6]: # 1번과 2번 톱니중 1번만 돌아가는경우
            turn_gear(n,dir)
        else: # 1,2번이 돌아가는경우
            turn_gear(n,dir)  #1번 돌리기
            if gear_list[n+1][2] == gear_list[n+2][6]: #2번과 3번을 확인해서 2번만 돌아가는경우
                turn_gear(n+1,dir * -1) # 2번 돌리기
            else: #2,3번이 둘다 돌아가는경우
                turn_gear(n+1,dir * -1) # 2번 돌리기
                if gear_list[n+2][2] == gear_list[n+3][6]: #3번만 돌아가는경우
                    turn_gear(n+2,dir) # 3번 돌리기
                else:# 3,4번 돌아가는경우
                    turn_gear(n+2,dir) # 3번 돌리기
                    turn_gear(n+3,dir * -1) # 4번 돌리기
    elif n == 3: # 4번 톱니인경우
        if gear_list[n][6] == gear_list[n-1][2]: #4번만 돌아가는 경우
            turn_gear(n,dir)
        else: #3,4번 돌아가는 경우
            turn_gear(n,dir) #  4번 돌리기
            if gear_list[n-1][6] == gear_list[n-2][2]: # 2,3번 확인
                turn_gear(n-1,dir * -1)  #3번 돌리기
            else: # 2,3번 돌아가는경우
                turn_gear(n-1,dir * -1) # 3번돌리기
                if gear_list[n-2][6] == gear_list[n-3][2]: # 2번만 돌아가는 경우
                    turn_gear(n-2,dir) # 2번 돌리기
                else:
                    turn_gear(n-2,dir)
                    turn_gear(n-3,dir * -1)

    else:  # 2번과,3번 톱니라면 2번째와 6번째를 확인한다.
        if n == 1: #2번 톱니
            if gear_list[n][6] == gear_list[n-1][2] and gear_list[n][2] == gear_list[n+1][6]: #1,2번 확인
                turn_gear(n,dir)
            elif gear_list[n][6] == gear_list[n-1][2] and gear_list[n][2] != gear_list[n+1][6]: #1,2번은 같고 2,3번은 다른경우
                turn_gear(n,dir)
                if gear_list[n+1][2] == gear_list[n+2][6]: #3,4번이같은경우
                    turn_gear(n+1,dir * -1)
                else:
                    turn_gear(n+1,dir * -1)
                    turn_gear(n + 2, dir)
            elif gear_list[n][6] != gear_list[n-1][2] and gear_list[n][2] == gear_list[n+1][6]: # 1,2번은 다르고 2,3번은 같은경우
                turn_gear(n,dir)
                turn_gear(n-1,dir * -1)
            else: #1,2,3번이 다 돌아가야하는경우
                turn_gear(n-1,dir * -1)
                turn_gear(n, dir)
                if gear_list[n+1][2] == gear_list[n+2][6]: #3,4번이같은경우
                    turn_gear(n+1,dir * -1)
                else:
                    turn_gear(n+1,dir * -1)
                    turn_gear(n + 2, dir)

        else: # 3번일때
            if gear_list[n][6] == gear_list[n-1][2] and gear_list[n][2] == gear_list[n+1][6]: #2,4번 확인
                turn_gear(n,dir)
            elif gear_list[n][6] == gear_list[n-1][2] and gear_list[n][2] != gear_list[n+1][6]: #2,3번은 같고 3,4번은 다른경우
                turn_gear(n,dir) # 3 번돌리기
                turn_gear(n+1,dir * -1)
            elif gear_list[n][6] != gear_list[n-1][2] and gear_list[n][2] == gear_list[n+1][6]: # 2,3번은 다르고 3,4번은 같은경우
                turn_gear(n,dir) # 3번 돌리기
                if gear_list[n-2][2] == gear_list[n-1][6]: #1,2번이같은경우
                    turn_gear(n-1,dir * -1) #2번만 돌리기
                else:
                    turn_gear(n-1,dir * -1)
                    turn_gear(n-2, dir)

            else: #2,3,4번이 다 돌아가야하는경우
                turn_gear(n+1,dir * -1) # 4번돌리기
                turn_gear(n, dir) # 3번돌리기
                if gear_list[n-2][2] == gear_list[n-1][6]: #1,2번이같은경우
                    turn_gear(n-1,dir * -1) # 2번 돌리기
                else:
                    turn_gear(n-1,dir * -1)
                    turn_gear(n-2, dir)


gear_list = [[],[],[],[]]
for i in range(4): # 톱니바퀴 구성이 주어진진다
    gear = sys.stdin.readline().strip()
    for j in range(8):
        gear_list[i].append(int(gear[j]))

k = int(sys.stdin.readline())
for _ in range(k): # 톱니 돌리기
    n,dir = tuple(map(int,sys.stdin.readline().strip().split()))
    n -= 1 # 오차 상쇄
    check_gear(n,dir)

score_list=[1,2,4,8]
sum_score = 0
for i in range(4):
    sum_score += (gear_list[i][0] * score_list[i])


print(sum_score)