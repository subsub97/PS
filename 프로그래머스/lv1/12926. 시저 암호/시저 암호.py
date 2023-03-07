def solution(s, n):
    answer = ''
    for char in s:
        push_char = ord(char) + n
        if ord(char) >= 97 and ord(char) <= 122:
            if push_char > 122:
                push_char -= 26
        elif ord(char) >=65 and ord(char) <= 90:
            if push_char > 90:
                push_char -= 26
        else:
            answer += " "
            continue
        answer+=(chr(push_char)) 
    return answer