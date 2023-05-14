def solution(participant, completion):
    answer = ''
    c_dict = {}
    for name in participant:
        if c_dict.get(name) == None:
            c_dict[name] = 1
        else:
            c_dict[name] += 1
    for name in completion:
        if c_dict[name] == 1:
            del c_dict[name]
        else:
            c_dict[name] -= 1
    for name in c_dict:
        answer = name
    return answer