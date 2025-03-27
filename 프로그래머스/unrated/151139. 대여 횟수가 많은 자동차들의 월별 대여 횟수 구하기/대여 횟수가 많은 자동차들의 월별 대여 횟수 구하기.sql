-- 코드를 입력하세요

# SELECT a.month, a.car_id, a.record FROM (
#         SELECT DATE_FORMAT(start_date, '%c') as month, car_id, COUNT(car_id) as record
#         FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#         GROUP BY month, car_id
#     ) a
#     WHERE a.record >= 5
#     ORDER BY CAST(a.month AS signed), a.car_id


# SELECT car_id, COUNT(car_id) as all_count
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#     WHERE start_date BETWEEN '2022-08-01' AND '2022-10-31'
#     GROUP BY car_id;
    
# SELECT DATE_FORMAT(a.start_date, '%c') as month, a.car_id, COUNT(a.car_id) as record
#     FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY a
#     JOIN (SELECT car_id, COUNT(car_id) as all_count
#             FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
#             WHERE start_date BETWEEN '2022-08-01' AND '2022-11-01'
#             GROUP BY car_id) b
#     ON a.car_id = b.car_id
#     WHERE b.all_count >= 5 AND a.start_date BETWEEN '2022-08-01' AND '2022-11-01'
#     GROUP BY month, car_id
#     ORDER BY CAST(month as signed), car_id


# SELECT car_id, COUNT(car_id) AS record
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
# WHERE DATE_FORMAT(start_date, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
# GROUP BY car_id
# HAVING record >= 5

SELECT MONTH(a.start_date) AS month, a.car_id, COUNT(a.car_id)
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY a
JOIN (SELECT car_id, COUNT(car_id) AS record
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE DATE_FORMAT(start_date, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
        GROUP BY car_id
        HAVING record >= 5) b
ON a.car_id = b.car_id
WHERE DATE_FORMAT(a.start_date, '%Y-%m') BETWEEN '2022-08' AND '2022-10'
GROUP BY MONTH(a.start_date), a.car_id
ORDER BY month ASC, car_id DESC


    