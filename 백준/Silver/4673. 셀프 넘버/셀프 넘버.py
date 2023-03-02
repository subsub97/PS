# 10,000보다 작거나 같은 셀프 넘버를 출력
# 생성자가 없는 경우 셀프 넘버이다.
self_num_list =[num for num in range(11000)]


for num in range(10001):
    cur_num = 0
    cur_num += num
    char_num = str(num)
    for p_num in range(len(char_num)):
        cur_num += int(char_num[p_num])

    self_num_list[cur_num] = False

for i in range(10001):
    if self_num_list[i] != False:
        print(self_num_list[i])