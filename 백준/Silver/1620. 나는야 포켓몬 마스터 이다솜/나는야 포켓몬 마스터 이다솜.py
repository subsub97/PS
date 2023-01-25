# 1620 try1
import sys

'''
아이디어
딕셔너리형태로 모든 포켓몬이름을 받고 value형태로 질문을 받는경우에
대비하여 key : value -> value : key 형태로 뒷 부분에 더 추가를 해주자.
'''
n,m = map(int,input().split())
name_dict = {}
for i in range(1,n+1):
    name = input()
    name_dict[name] = i
    name_dict[str(i)] = name

for j in range(m):
    key = input()
    print(name_dict[key])