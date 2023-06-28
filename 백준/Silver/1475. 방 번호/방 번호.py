dic = {}
str_num = input()
dic['6'] = 0
for i in  str_num:
    if i == '9':
        i = '6'
    try:
        dic[i] += 1
    except:
        dic[i] = 1

if dic['6'] >= 2:
    if dic['6'] % 2 == 0:
        dic['6'] = dic['6'] // 2
    else:
        dic['6'] = (dic['6'] // 2) + 1

print(max(dic.values()))
