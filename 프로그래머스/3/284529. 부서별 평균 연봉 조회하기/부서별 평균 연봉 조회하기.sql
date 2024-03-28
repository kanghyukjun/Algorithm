-- 코드를 작성해주세요
select c.dept_id, c.dept_name_en, round(avg(c.sal)) as avg_sal
from (select a.dept_id, a.dept_name_en, b.sal
     from hr_department a inner join hr_employees b
        on a.dept_id = b.dept_id) c
group by c.dept_id
order by avg_sal desc;