def solution(clothes):
    answer = 0
    clothes_dict = {}
    for clothe in clothes:
        if clothes_dict.get(clothe[1]) == None:
            clothes_dict[clothe[1]] = 1
        else:
            clothes_dict[clothe[1]]+=1
    total_clothe = 1
    for value in clothes_dict:
        total_clothe *= clothes_dict[value]+1
    answer = total_clothe -1
    return answer