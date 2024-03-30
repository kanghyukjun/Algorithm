# INS에는 있고 OUTS에는 없는 동물들 중
# 가장 오래 보호소에 있었던 동물 3마리의
# 이름과 보호 시작일을 조회하라
# 보호 시작일 순으로 정렬

# left join 후 outs가 null

SELECT
    ins.name,
    ins.datetime
FROM
    animal_ins AS ins
    LEFT JOIN
    animal_outs AS outs
    USING(animal_id)
WHERE outs.datetime IS NULL
ORDER BY ins.datetime
LIMIT 3
