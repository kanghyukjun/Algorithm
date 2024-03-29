-- 코드를 입력하세요
# 가격이 가장 비싼 식품의
# id, 이름, 코드, 분류, 가격을 조회하라

SELECT
    product_id,
    product_name,
    product_cd,
    category,
    price
FROM
    food_product
WHERE
    price = (
        SELECT
            max(price)
        FROM
            food_product
    )