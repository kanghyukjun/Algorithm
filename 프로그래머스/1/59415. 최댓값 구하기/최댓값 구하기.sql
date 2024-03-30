-- 코드를 입력하세요
SELECT datetime
from animal_ins
where datetime = (
    SELECT max(datetime)
    from animal_ins
    where datetime
)