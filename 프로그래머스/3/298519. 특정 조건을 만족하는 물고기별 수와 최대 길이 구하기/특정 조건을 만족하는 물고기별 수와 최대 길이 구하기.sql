-- 코드를 작성해주세요

-- 평균 길이가 33cm 이상인 물고기 그룹을 만든다
-- 그 그룹별로 물고기의 갯수와 최대 길이와 타입을 출력한다

-- 평균 길이가 33cm 이상인 물고기 그룹에 포함되는 값들을 갖고온다
# select count(*), max(length), fish_type
# from ()
# group by fish_type
# where fish_type in ()
# order by fish_type

select count(*) as FISH_COUNT, max(length) as MAX_LENGTH, fish_type AS FISH_TYPE
from fish_info
where fish_type in (select fish_type
                    from fish_info
                    group by fish_type
                    having avg(ifnull(length, 10)) >= 33)
group by fish_type
order by fish_type