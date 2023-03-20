import sys
sys.setrecursionlimit(10**6)

def solution(k, room_number):
    answer =[]
    reserved_room = {}
    for num in room_number:
        check_in(num,reserved_room,answer)
    return answer

def check_in(num,reserved,answer):
    if not reserved.get(num): # None인 경우
        reserved[num] = num + 1
        answer.append(num)
        return num + 1
    else: #이미 사용하고 있는 경우
        empty = check_in(reserved[num],reserved,answer)
        reserved[num] = empty
        return empty
