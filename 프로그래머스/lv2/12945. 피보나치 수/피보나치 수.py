    
def solution(n):
    memo = [0 for _ in range(n+1)]
    memo[1] = 1
    answer = 0
    
    for i in range(2,n+1):
        memo[i] = (memo[i-1] + memo[i-2]) % 1234567
        
    answer = memo[n] 
    return answer



    