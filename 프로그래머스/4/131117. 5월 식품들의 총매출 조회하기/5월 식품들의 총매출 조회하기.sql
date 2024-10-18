-- 코드를 입력하세요
# SELECT p.PRODUCT_ID, p.PRODUCT_NAME, SUM(p.price * o.amount) as TOTAL_SALES FROM FOOD_PRODUCT p
#     JOIN FOOD_ORDER o
#     ON p.product_id = o.product_id
#     WHERE YEAR(o.produce_date) = '2022'
#         AND MONTH(o.produce_date) = '5'
#     GROUP BY p.product_id, p.product_name;

SELECT product_id, SUM(AMOUNT)
               FROM FOOD_ORDER
                WHERE YEAR(PRODUCE_DATE) = '2022'
               AND MONTH(PRODUCE_DATE) = '5'
               GROUP BY product_id;

SELECT p.PRODUCT_ID, p.PRODUCT_NAME, p.price * tmp.total_mount as total_sales FROM
    FOOD_PRODUCT p
    INNER JOIN (SELECT product_id, SUM(AMOUNT) as total_mount
               FROM FOOD_ORDER
                WHERE YEAR(PRODUCE_DATE) = '2022'
               AND MONTH(PRODUCE_DATE) = '5'
               GROUP BY product_id) tmp
   on p.product_id = tmp.product_id
   ORDER BY total_sales desc, product_id


# SELECT p.PRODUCT_ID, SUM(o.amount)
# FROM FOOD_PRODUCT p
#     JOIN FOOD_ORDER o
#     ON p.product_id = o.product_id
#     WHERE YEAR(o.produce_date) = '2022'
#         AND MONTH(o.produce_date) = '5'
#     GROUP BY p.product_id