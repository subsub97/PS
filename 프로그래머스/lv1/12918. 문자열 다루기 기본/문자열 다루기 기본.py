import re

def solution(s):
    answer = True
    pattern = re.compile('^[0-9]*$')
    check = re.match(pattern,s)
    if len(s) == 4 or len(s) == 6:
        if check == None:
            answer = False
        else:
            answer = True
    else:
        answer = False
    return answer

