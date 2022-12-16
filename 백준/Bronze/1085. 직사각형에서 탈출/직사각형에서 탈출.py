x,y,w,h = map(int,input().split())

min_len = 1001

if h - y < min_len :
    min_len = h- y
if y < min_len:
    min_len = y
if x <min_len:
    min_len = x
if w -x < min_len:
    min_len = w- x
print(min_len)