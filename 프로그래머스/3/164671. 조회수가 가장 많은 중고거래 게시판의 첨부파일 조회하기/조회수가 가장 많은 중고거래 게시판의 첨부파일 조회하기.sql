SELECT concat('/home/grep/src/',f.board_id,'/',f.file_id, f.file_name, f.file_ext) as file_path
from used_goods_file f 
join used_goods_board b
on f.board_id = b.board_id
where b.views = (select max(b1.views) from used_goods_board b1 )
order by f.file_id desc