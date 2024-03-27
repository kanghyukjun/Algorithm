-- 코드를 작성해주세요
select round(avg(A.length), 2) as AVERAGE_LENGTH
from (select ifnull(length, 10) as length
     from fish_info) A;