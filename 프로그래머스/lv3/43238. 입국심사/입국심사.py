from bisect import bisect_left
import sys
import sys

def binary_search(times, n):
    min_val = sys.maxsize
    start = 0
    end = max(times) * n

    while start <= end:
        mid = (start + end) // 2
        share_num = 0
        for time in times:
            share_num += mid // time

        if share_num >= n: 
            if min_val > mid:
                min_val = mid
            end = mid - 1
        else:
            start = mid + 1
    return min_val

def solution(n, times):
    answer = binary_search(times, n)
    return answer

        
    
    return answer