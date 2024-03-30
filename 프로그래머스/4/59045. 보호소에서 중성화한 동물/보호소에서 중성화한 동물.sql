-- 코드를 입력하세요

# INS와 OUTS에서
# 합집합에서 교집합을 뺀 값들을 갖고 와야 한다
# 아이디, 종, 이름을 조회
# 아이디 순으로 정렬

SELECT
    ins.animal_id, ins.animal_type, ins.name
FROM
    animal_ins ins
    INNER JOIN
    animal_outs outs
    ON ins.animal_id = outs.animal_id
WHERE ins.SEX_UPON_INTAKE != outs.SEX_UPON_OUTCOME
ORDER BY 1