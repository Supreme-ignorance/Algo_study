-- 코드를 입력하세요

SELECT a.user_id, a.nickname, b.total_sales
    FROM used_goods_user a
    JOIN (SELECT writer_id, SUM(price) as total_sales 
            FROM USED_GOODS_BOARD
            WHERE status = 'DONE'
            GROUP BY writer_id) b
    ON a.user_id = b.writer_id
    WHERE b.total_sales >= 700000
    ORDER BY b.total_sales;

