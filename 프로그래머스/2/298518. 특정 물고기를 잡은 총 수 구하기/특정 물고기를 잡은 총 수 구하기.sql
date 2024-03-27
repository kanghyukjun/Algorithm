-- 코드를 작성해주세요
select COUNT(*) AS FISH_COUNT
from (select FISH_NAME
      from FISH_INFO A, FISH_NAME_INFO B
      where A.FISH_TYPE = B.FISH_TYPE) C
where C.FISH_NAME = "BASS" OR C.FISH_NAME = "SNAPPER"
;
