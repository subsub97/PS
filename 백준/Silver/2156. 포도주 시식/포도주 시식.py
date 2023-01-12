#DP 포도주시식 try2

n = int(input())

g_quantitys = [
    int(input())
    for _ in range(n)
]

memo = [
    0 for _ in range(n+1)
]

for i in range(1,n+1):
    if i == 1:
        memo[i] = g_quantitys[0]
    elif i == 2:
        memo[i] = memo[i-1] + g_quantitys[i-1]
    elif i == 3 :
        memo[i] = max(memo[i-2]+g_quantitys[i-1],memo[i-3]+g_quantitys[i-2]+g_quantitys[i-1])
    else:
        memo[i] = max(memo[i - 2] + g_quantitys[i - 1], memo[i - 3] + g_quantitys[i - 2] + g_quantitys[i - 1],memo[i-4]+g_quantitys[i-2]+g_quantitys[i-1])
print(max(memo))