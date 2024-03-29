-- 코드를 입력하세요
# outdate가
#     2022-05-01면 출고 완료
#     이후 날짜는 출고 대기
#     NULL이면 출고 미정
# id 기준 오름차순

SELECT
    order_id,
    product_id,
    DATE_FORMAT(out_date, "%Y-%m-%d") AS "out_date",
    CASE
        WHEN DATE_FORMAT(out_date, "%m-%d") <= "05-01" THEN "출고완료"
        WHEN out_date IS NULL THEN "출고미정"
        ELSE "출고대기"
    END AS "출고여부"
FROM
    food_order
ORDER BY
    order_id