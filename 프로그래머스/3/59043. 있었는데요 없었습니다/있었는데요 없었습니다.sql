-- 코드를 입력하세요
# 보호 시작일(INS)보다 입양일(OUTS)이 더 빠른 동물의
# 아이디와 이름을 조회하라
# 보호 시작일 기준 오름차순

# ID를 기준으로 조인했을 때
# 보호 시작일 > 입양일인 동물 출력

SELECT
    O.animal_id,
    O.name
FROM
    animal_outs O INNER JOIN animal_ins I USING(animal_id)
WHERE 1=1
    AND I.datetime > O.datetime
ORDER BY
    I.datetime
;