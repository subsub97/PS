-- 코드를 입력하세요
# /테이블에서 2022년 10월에 작성된 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회하는 SQL문
SELECT b.TITLE,b.BOARD_ID,r.REPLY_ID,r.WRITER_ID,r.CONTENTS,DATE_FORMAT(r.CREATED_DATE,"20%y-%m-%d") as CREATED_DATE
from USED_GOODS_BOARD as b JOIN USED_GOODS_REPLY as r ON b.BOARD_ID = R.BOARD_ID
where EXTRACT(YEAR FROM b.CREATED_DATE) = 2022
    AND EXTRACT(MONTH FROM b.CREATED_DATE) = 10
order by r.CREATED_DATE asc, b.TITLE ASC