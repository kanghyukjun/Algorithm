-- 코드를 입력하세요

# 음식 종류별로
# 즐겨찾기 수가 가장 많은 식당의
# 음식 종류, id, 식당 이름, 즐겨찾기 수를 조회
# 음식 종류 기준으로 내림차순

SELECT
    food_type,
    rest_id,
    rest_name,
    favorites
FROM rest_info
WHERE (food_type, favorites) IN (
    SELECT
        food_type,
        max(favorites)
    FROM rest_info
    GROUP BY food_type
)
ORDER BY 1 desc