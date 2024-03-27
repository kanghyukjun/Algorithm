-- 코드를 작성해주세요
select count(*) as FISH_COUNT, c.FISH_NAME as FISH_NAME
from (select b.fish_name
     from fish_info a, fish_name_info b
     where a.fish_type = b.fish_type) c
group by c.fish_name
order by fish_count desc;