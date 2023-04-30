import heapq

def solution(numbers):
    answer = []
    heap_q = []
    for i in range(len(numbers)):
        for j in range(i+1,len(numbers)):
            append_num = numbers[i] + numbers[j]
            heapq.heappush(heap_q,append_num)
    
    while heap_q:
        temp = heapq.heappop(heap_q)
        
        if temp not in answer:
            answer.append(temp)
            
    return answer