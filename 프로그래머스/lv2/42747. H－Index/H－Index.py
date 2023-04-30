def solution(citations):
    answer = 0

    citations.sort(reverse=True)
    n = len(citations)
    cnt = 0

    for num in citations:
        cnt += 1
        if num >= cnt:
            pass

        else:
            if len(citations) - cnt > cnt:
                pass
            answer = cnt- 1
            break
    if citations[0] != 0 and answer == 0:
        answer = cnt
    return answer
