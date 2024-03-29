-- 코드를 입력하세요
# 입양을 간 기록(INS)은 있는데, 보호소에 들어온 기록(OUTS)이 없는
# 동물의 ID와 이름을 ID 순으로 조회해라

# OUTS에 있는 동물 중 INS에 있는 동물을 제외한 동물을 출력
# 조인 후 in으로 빼기?

SELECT
    animal_id,
    name
FROM
    animal_outs
WHERE
    animal_id NOT IN (
        SELECT
            O.animal_id
        FROM
            animal_ins I INNER JOIN animal_outs O USING(animal_id)
    )
ORDER BY animal_id
;

