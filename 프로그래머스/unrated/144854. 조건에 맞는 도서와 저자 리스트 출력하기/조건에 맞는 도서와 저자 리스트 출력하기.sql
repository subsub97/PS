-- 코드를 입력하세요
SELECT BOOK_ID, AUTHOR_NAME, date_format(published_date,'%Y-%m-%d') as published_date
from Book, Author
where Book.category = '경제'
and book.author_id = author.author_id 
order by published_date