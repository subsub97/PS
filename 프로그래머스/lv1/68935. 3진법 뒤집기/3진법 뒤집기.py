def solution(n):
    answer = 0
    num_list =[]
    while n >= 1:
        num_list.append(n%3)
        n //= 3
    
    
    mult_num = 0
    for i in range(len(num_list)-1,-1,-1):
        answer += num_list[i] * (3 ** mult_num)
        mult_num += 1
        
    
    return answer