# 1. 점수 합을 구한다
# 2. 그 중 최대 점수를 구한다

select MS.score, MS.emp_no, EMP.emp_name, EMP.position, EMP.email
from hr_employees EMP inner join (
                            select emp_no, sum(score) as score
                            from hr_grade
                            group by emp_no
                            order by score desc
                            limit 1
                        ) MS
                        using(emp_no)