cnt = 0
def solution(n):
    answer = []
    answer = find_min_path(n,1,3,2,answer)
    return answer

def find_min_path(n,start,to,via,paths):
    if n == 1:
        paths.append([])
        move(1,start,to,paths)
    else:
        find_min_path(n-1,start,via,to,paths)
        paths.append([])
        move(n,start,to,paths)
        find_min_path(n-1,via,to,start,paths)
    return paths
def move(n,start,to,paths):
    global cnt
    paths[cnt].append(start)
    paths[cnt].append(to)
    cnt +=1

