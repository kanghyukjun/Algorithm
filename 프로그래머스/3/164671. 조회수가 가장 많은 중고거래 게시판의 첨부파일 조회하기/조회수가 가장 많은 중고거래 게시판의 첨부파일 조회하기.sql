-- 코드를 입력하세요

# 조회수가 가장 높은 중고 거래 게시물에 대해서
# 첨부파일의 경로를 조회하세요
# 파일 아이디를 기준으로 내림차순 정렬

# 파일 경로는 /home/grep/src/(게시글ID)/(파일ID)+(파일이름)+(확장자)

# 1. 가장 높은 조회수를 가진 보드의 아이디를 가져온다
# 2. 해당 아이디를 이용해서 files 테이블을 where절로 처리
# 3. concat을 이용해서 출력
# 4. 정렬은 file_id로

SELECT
    CONCAT("/home/grep/src/",board_id,"/",file_id,file_name,file_ext) AS "FILE_PATH"
FROM used_goods_file
WHERE board_id = (
    SELECT board_id
    FROM used_goods_board
    ORDER BY views desc
    LIMIT 1
)
ORDER BY file_id DESC
