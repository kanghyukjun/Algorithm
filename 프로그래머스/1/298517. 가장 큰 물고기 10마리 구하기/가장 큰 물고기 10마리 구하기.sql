-- 코드를 작성해주세요

select ID, LENGTH
from FISH_INFO
where LENGTH IS NOT NULL
order by LENGTH desc
limit 10;