import sys
n = int(sys.stdin.readline())
num_set = set()

for i in range(n):
    temp = sys.stdin.readline().strip().split()
    if len(temp) > 1:
        num = int(temp[1])

        if temp[0] == 'add':
            num_set.add(num)
        elif temp[0] == 'check':
            if num in num_set:
                print(1)
            else:
                print(0)
        elif temp[0] == 'remove':
            if num in num_set:
                num_set.remove(num)
        else:
            if num in num_set:
                num_set.remove(num)
            else:
                num_set.add(num)
    else:
        if temp[0] == 'all':
         for i in range(1, 21):
             num_set.add(i)
        else:
            num_set = set()