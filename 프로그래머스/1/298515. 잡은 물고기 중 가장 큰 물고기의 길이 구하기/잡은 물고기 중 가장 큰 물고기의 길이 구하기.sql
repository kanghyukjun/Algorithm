-- 코드를 작성해주세요
SELECT CONCAT(LENGTH, 'cm') as MAX_LENGTH
from fish_info
where length = (select max(length)
            from fish_info
            );