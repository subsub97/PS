num_arr = list(map(str,input().split()))
r_arr =[]

for num in num_arr:
    for i in range(2,-1,-1):
        r_arr.append(num[i])

r_a = int(r_arr[0] + r_arr[1] + r_arr[2])
r_b = int(r_arr[3] + r_arr[4] + r_arr[5])

print(max(r_a,r_b))