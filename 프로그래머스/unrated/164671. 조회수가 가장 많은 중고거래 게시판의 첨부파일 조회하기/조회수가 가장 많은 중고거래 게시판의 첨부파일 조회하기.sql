SELECT concat('/home/grep/src/',board_id,'/',file_id,file_name,file_ext) as FILE_PATH
from used_goods_file
where board_id = (select board_id from used_goods_board order by views desc limit 1)
order by file_id desc

# select board_id from used_goods_board order by views asc 

# select * from used_goods_board order by views desc 

# select * from used_goods_file

# SELECT  
#     #   A.BOARD_ID
#     # , A.VIEWS
#     # , B.*
#      CONCAT('/home/grep/src/',A.BOARD_ID,'/',B.FILE_ID,B.FILE_NAME,B.FILE_EXT) AS FILE_PATH
# FROM(SELECT *
#     FROM USED_GOODS_BOARD
#     ORDER BY VIEWS DESC
#     LIMIT 1) A
# LEFT JOIN USED_GOODS_FILE B ON A.BOARD_ID = B.BOARD_ID
# ORDER BY B.FILE_ID DESC