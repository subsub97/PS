n = int(input())

word_list = [
    input() for _ in range(n)
]

set_list = list(set(word_list))

set_list.sort()
set_list.sort(key = len)


for word in set_list:
    print(word)