-- 코드를 입력하세요
SELECT b.book_id, a.author_name, DATE_FORMAT(b.PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
from book b
join author a
on a.author_id = b.author_id
where b.category = '경제'
order by b.published_date