-- 코드를 입력하세요
SELECT
    animal_id,
    name,
    date_format(datetime, "%Y-%m-%d") AS "날짜"
FROM animal_ins