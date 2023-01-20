
a,b = map(int,input().split())

#유클리드 호제법 이용

large_num = max(a,b)
small_num = min(a,b)
r = 1
while True:
    if r == 0:
        break
    r = large_num % small_num
    large_num = small_num
    small_num = r
# mod와 b의 최대 공약수아 같다.
print(large_num)
print(a*b // large_num)