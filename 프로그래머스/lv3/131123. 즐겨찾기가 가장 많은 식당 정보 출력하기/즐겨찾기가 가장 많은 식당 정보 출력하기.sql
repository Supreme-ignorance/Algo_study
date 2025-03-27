-- 코드를 입력하세요
SELECT a.food_type, a.rest_id, a.rest_name, a.favorites 
    FROM rest_info a
    JOIN (SELECT food_type, MAX(favorites) AS max_fav
            FROM rest_info
             GROUP BY food_type) b
    ON a.food_type = b.food_type
    AND a.favorites = b.max_fav
    ORDER BY food_type DESC;

