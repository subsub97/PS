import heapq

def solution(food_times, k):
    answer = 0
    q = []
    
    if sum(food_times) <= k:
        return -1
    
    for i in range(len(food_times)):
        # index랑 각 음식 소요 시간을 넣는다
        heapq.heappush(q,(food_times[i],i+1))
    # 남은 음식수
    lenght = len(food_times)
    sum_value = 0
    previous = 0
    
    while sum_value + ((q[0][0] - previous) * lenght) <= k:
        now = heapq.heappop(q)[0]
        sum_value += (now - previous) * lenght
        lenght -= 1
        previous = now 
        # 1
    result = sorted(q,key = lambda x :x[1])
    return result[(k - sum_value) % lenght][1]



