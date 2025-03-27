-- 코드를 입력하세요
SELECT product.product_code, 
        sum(product.price * offline_sale.sales_amount) as sales
    FROM product
    INNER JOIN offline_sale ON product.product_id = offline_sale.product_id
    GROUP BY product.product_code
    ORDER BY sales desc, product.product_code;