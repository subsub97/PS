def solution(arr1, arr2):
    answer = [[]]
    for i in range(len(arr1)):
        for j in range(len(arr2[0])):
            mat_val = 0
            for k in range(len(arr2)):
                mat_val += (arr1[i][k] * arr2[k][j])
            answer[i].append(mat_val)
        if i < len(arr1)-1:
            answer.append([])
    return answer