-- 코드를 입력하세요
SELECT P.product_code, O.sales_sum * P.price AS sales
FROM product P
    INNER JOIN (
        SELECT product_id, SUM(sales_amount) AS sales_sum
        FROM offline_sale
        GROUP BY product_id
    ) O
    USING(product_id)
ORDER BY 2 DESC, 1;