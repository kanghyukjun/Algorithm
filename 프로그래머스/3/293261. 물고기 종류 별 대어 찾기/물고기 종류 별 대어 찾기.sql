-- 코드를 작성해주세요
-- fish_type 별 최대 길이를 갖고 온다
-- type과 length를 이용해서 fish_info의 id와 매치시킨다
-- type을 이용해서 fish_name_info의 name과 매치시킨다

select b.id as ID, c.fish_name as FISH_NAME, a.length as LENGTH
from (
        select fish_type as type, max(length) as length
        from fish_info
        group by fish_type
    ) a, fish_info b, fish_name_info c
where a.type = b.fish_type and a.length = b.length and a.type = c.fish_type;