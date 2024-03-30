-- 코드를 입력하세요
# car 테이블과 history 테이블에서
# 자동차 종류가 세단인 자동차들 중
# 10월에 대여를 시작한 기록이 있는 자동차의
# ID 리스트를 출력하여라
# 중복이 없어야하며 ID 기준 내림차순 정렬

SELECT DISTINCT CAR.car_id
FROM
    car_rental_company_car AS CAR
    INNER JOIN
    car_rental_company_rental_history AS HIS
    ON CAR.car_id = HIS.car_id
WHERE 1=1 
    AND CAR.car_type = "세단"
    AND HIS.start_date >= "2022-10-01"
ORDER BY 1 DESC