-- 코드를 작성해주세요
# ROOT 아이템을 찾아 출력
# ROOT 아이템이란 parent아이템 id가 null인 것

SELECT
    F.item_id,
    F.item_name
FROM
    item_info F INNER JOIN item_tree T USING(item_id)
WHERE
    T.parent_item_id IS NULL
ORDER BY
    F.item_id