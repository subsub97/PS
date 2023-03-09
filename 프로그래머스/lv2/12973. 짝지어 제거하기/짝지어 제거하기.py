def solution(s):
    answer = 0
    s = list(s)
    stack = []
    for i in range(len(s)):
        if len(stack) == 0 or stack[-1] != s[i]:
            stack.append(s[i])
        else:
            stack.pop()
    if len(stack) == 0:
        answer = 1
    return answer