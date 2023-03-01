n = int(input())
switch_list = list(map(int,input().split()))
students = int(input())

def swap_switch(idx):
    if switch_list[idx] == 0:
        switch_list[idx] = 1
    else:
        switch_list[idx] = 0

def check_symmertry(down,up):
    if down < 0 or up >= n:
        return False

    if switch_list[down] == switch_list[up]:
        return True
    else:
        return False

for _ in range(students):
    sex,num = map(int,input().split( ))
    temp_num = num - 1
    if sex ==1:
        for i in range(temp_num,n,num):
            swap_switch(i)

    else:

        temp_d = temp_num  - 1
        temp_up = temp_num +1

        while check_symmertry(temp_d,temp_up):
            swap_switch(temp_d)
            swap_switch(temp_up)
            temp_d -=1
            temp_up +=1
        swap_switch(temp_num)
cnt = 0
for num in switch_list:
    cnt +=1
    if cnt == 20:
        print(num)
        cnt = 0
    else:
        print(num,end=' ')