def solution(record):
    answer = []
    info_dict = {'Enter':"들어왔습니다.",'Leave':"나갔습니다."}
    for infos in record:
        info = infos.split()
        if len(info) == 2:
            continue
        #info[1] 은 항상 uid, info[2]은 nick name이  있다.
        info_dict[info[1]] = info[2]

    for infos in record:
        info = infos.split()
        if info[0] == 'Enter':
            answer.append(f"{info_dict[info[1]]}님이 {info_dict[info[0]]}")
        elif info[0] == 'Leave':
            answer.append(f"{info_dict[info[1]]}님이 {info_dict[info[0]]}")
    return answer