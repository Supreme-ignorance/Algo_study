-- 코드를 입력하세요
SELECT book_id, sum(sales) from book_sales where YEAR(sales_date) = 2022 and Month(sales_date) = 1 group by book_id;

select book.category, sum(temp.sales) as total_sales from book inner join (SELECT book_id, sum(sales) as sales from book_sales where YEAR(sales_date) = 2022 and Month(sales_date) = 1 group by book_id) as temp on temp.book_id = book.book_id group by category order by category;