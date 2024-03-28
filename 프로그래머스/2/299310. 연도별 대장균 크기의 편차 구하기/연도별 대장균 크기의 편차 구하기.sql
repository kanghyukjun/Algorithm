-- 코드를 작성해주세요

# 연도별로 최대 대장균의 크기를 구해야 한다
# 그렇게 구한 테이블과 원래 테이블을 date를 이용해 join을 한다

select year(a.differentiation_date) as year,
        (b.max_size - a.size_of_colony) as year_dev,
        id
from
    ecoli_data a inner join
    (select year(differentiation_date) as year, max(size_of_colony) as max_size
                        from ecoli_data
                        group by year) b
    on year(a.differentiation_date) = b.year
order by year, year_dev

