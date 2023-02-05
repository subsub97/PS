# m을 넘지 않으면서 m 과 가깝게 3장의 카드를 고르기
import sys
n,m = tuple(map(int,sys.stdin.readline().strip().split()))
card_list = tuple(map(int,sys.stdin.readline().strip().split()))
close_sum = 0
for i in range(n):
    for j in range(1+i,n):
        for k in range(1+j,n):
            if m >= card_list[i] + card_list[j] + card_list[k] and close_sum < card_list[i] + card_list[j] + card_list[k]:
                close_sum = card_list[i] + card_list[j] + card_list[k]


print(close_sum)