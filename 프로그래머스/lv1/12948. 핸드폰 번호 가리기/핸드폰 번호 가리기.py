import re
#긍정형 전방 탐색 : 정규표현식의 앞/뒤에 붙여 사용하면 주어진 조건대로 검색
# 조건과 일치하는 문자는 결과에서 제외.
def solution(phone_number):
    answer =  re.sub('\d(?=\d{4})','*',phone_number)
    return answer