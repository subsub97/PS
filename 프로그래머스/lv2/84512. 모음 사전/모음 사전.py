import sys
sys.setrecursionlimit(10**6)
cnt =0
def solution(word):
    answer = 0
    word_list = []
    answer = find_vowel_order(word,word_list,answer)
    return answer

def find_vowel_order(word,word_list,answer):
    global cnt
    vowel_list = ['A','E','I','O','U']
    cur_word = ''
    if len(word) == len(word_list):
        for w_alpa in word_list:
            cur_word += w_alpa
        if cur_word == word:
            return cnt

    if len(word_list) == 5:
        return

    for alpa in vowel_list:
        word_list.append(alpa)
        cnt += 1
        answer = find_vowel_order(word,word_list,answer)
        if answer:
            break
        word_list.pop()
    return answer



