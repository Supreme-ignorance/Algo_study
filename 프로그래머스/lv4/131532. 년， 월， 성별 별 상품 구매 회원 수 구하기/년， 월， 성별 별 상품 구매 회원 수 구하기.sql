-- 코드를 입력하세요
# select * from online_sale;
SELECT year(o.sales_date) as year, month(o.sales_date) as month, u.gender, count(distinct u.user_id) as users
from user_info u, online_sale o
where not u.gender is null
    and u.user_id = o.user_id
group by year, month, u.gender
order by year, month, u.gender