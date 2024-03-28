
# 1. 점수 합을 구한다
# 2. 그 중 최대 점수를 구한다

select MS.score, MS.emp_no, EMP.emp_name, EMP.position, EMP.email
from hr_employees EMP inner join (
                            select sum(score) as score, emp_no
                            from hr_grade
                            group by emp_no
                            having sum(score) = (
                                select max(A.score)
                                from (
                                    select emp_no, sum(score) as score
                                    from hr_grade
                                    group by emp_no
                                ) A
                            )
                        ) MS
                        on EMP.emp_no = MS.emp_no

