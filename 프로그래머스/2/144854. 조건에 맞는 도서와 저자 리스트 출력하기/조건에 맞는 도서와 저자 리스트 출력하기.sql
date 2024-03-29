-- 코드를 입력하세요
# 경제 카테고리에 속하는 도서들의 id, 저자명, 출판일 출력
# 출판일 기준 오름차순 정렬

SELECT
    B.book_id,
    A.author_name,
    date_format(B.published_date, "%Y-%m-%d") AS published_date
FROM
    book AS B INNER JOIN author AS A
    ON B.author_id = A.author_id
WHERE
    B.category = "경제"
ORDER BY
    B.published_date
;