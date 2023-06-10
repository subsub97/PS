from itertools import combinations,permutations

num = input()
num_list = []
sum_val = 0

#입력 받은 숫자중 가장큰 30의 배수는 무엇인가
for i in range(len(num)):
    num_list.append(num[i])
    sum_val += int(num[i])

if "0" not in num_list or len(num) < 2: #0이 없거나 2자리 미만이면 절대 30의 배수를 만들수없음
    print(-1)

else:
    if sum_val % 3 == 0:
        num_list.sort(reverse=True)
        print(int("".join(num_list)))
    else:
        print(-1)



