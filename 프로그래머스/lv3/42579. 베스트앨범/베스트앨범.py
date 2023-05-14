def solution(genres, plays):
    answer = []
    '''
    1. 속한 노래가 많이 재생된 장르
    2. 장르 내에서 많이 재생된 노래
    3. 재생수가 같다면 고유번호가 낮은 거 
    '''
    orgin_num = 0 
    genres_cnt_dict = {} #장르별 총 몇번 재생되었는지를 관리하기 위함
    each_dict = {}
    
    for genre,cnt in zip(genres,plays):
        
        if genres_cnt_dict.get(genre) == None:
            genres_cnt_dict[genre] =  cnt
            each_dict[genre] = [tuple([cnt,orgin_num])]
        else:
            genres_cnt_dict[genre] += cnt
            each_dict[genre].append(tuple([cnt,orgin_num]))
        orgin_num += 1
             
    genres_cnt_dict.items()
    #속한 노래가 많이 재생된 장르 순으로 정렬
    sorted_list  = sorted(genres_cnt_dict, key =lambda x: genres_cnt_dict[x],reverse = True)
    for genre in sorted_list: # genre는 가장 많이 들려진 장르부터 내림차순으로 불려짐
        each_dict[genre].sort(key = lambda x:x[0] ,reverse = True) # 장르별 가장 많이 들은 노래부터 정렬
        if len(each_dict[genre]) > 1:
            answer.append(each_dict[genre][0][1])
            answer.append(each_dict[genre][1][1])
        else:
            answer.append(each_dict[genre][0][1])
    
    return answer