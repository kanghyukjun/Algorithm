-- 코드를 입력하세요
# 종, 이름, 성별 중성화 여부
# 아이디 순으로 정렬
# 이름이 없는 동물은 No name으로 표기

SELECT
    animal_type,
    IFNULL(name, "No name") AS "name",
    sex_upon_intake
FROM
    animal_ins
ORDER BY
    animal_id