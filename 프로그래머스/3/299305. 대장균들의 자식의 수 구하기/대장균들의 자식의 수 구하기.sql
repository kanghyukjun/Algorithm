-- 코드를 작성해주세요
select id, (select count(*)
           from ecoli_data b
           where a.id = b.parent_id) as child_count
from ecoli_data a
order by id;