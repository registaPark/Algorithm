select order_id , product_id , left(out_date,10) as out_date , 
if (left(out_date,10)<='2022-05-01' , '출고완료', if(out_date is null,'출고미정','출고대기')) as 출고여부
from food_order
order by order_id