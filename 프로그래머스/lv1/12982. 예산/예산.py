def solution(d, budget):
    answer = 0
    d.sort()
    
    for cur_b in d:
        if budget - cur_b >= 0:
            budget -= cur_b
            answer += 1
        else:
            break
    
        
    return answer