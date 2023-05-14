def solution(phone_book):
    answer = True
    phone_book.sort(key=lambda x: len(x))
    p_dict = {}
    len_set = set([])
    for num in phone_book:
        len_set.add(len(num))
        for cur_len in len_set:
            if p_dict.get(num[0:cur_len]) == None:
                if len(num) == cur_len:
                    p_dict[num[0:cur_len]] = 1
            else:
                answer = False
                return answer

    return answer