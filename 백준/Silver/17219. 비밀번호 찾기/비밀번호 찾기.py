# 17219 try1
import sys

n,m = map(int,sys.stdin.readline().strip().split())
add_dict ={}
for _ in range(n):
    address,password = sys.stdin.readline().strip().split()
    add_dict[address] = password
for _ in range(m):
    address = sys.stdin.readline().strip()
    print(add_dict.get(address))