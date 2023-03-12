def solution(s):
    answer = []
    sum_zero = 0
    loop_cnt = 0
    while len(s) != 1:
        new_s = []
        for i in range(len(s)):
            if s[i] != '0':
                new_s.append(s[i])
            else:
                sum_zero += 1
        loop_cnt += 1
        temp_n = len(new_s)
        bin_list = []
        while temp_n >= 1:
            bin_list.append(str(temp_n % 2))
            temp_n //= 2

        s = bin_list[::-1]

    answer.append(loop_cnt)
    answer.append(sum_zero)
    return answer
