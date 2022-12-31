# DP try2

n = int(input())

dp_arr=[1,2,3]
cnt = 0
if n > 3:
    for i in range(3,n+1):
        dp_arr.append((dp_arr[i-1] + dp_arr[i-2]) % 15746)


print(dp_arr[n-1] )