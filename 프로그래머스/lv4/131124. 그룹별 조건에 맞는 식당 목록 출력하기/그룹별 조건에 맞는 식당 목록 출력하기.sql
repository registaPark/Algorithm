select b.member_name , a.review_text , date_format(a.review_date,'%Y-%m-%d') as review_date
from rest_review a left join
(select r.member_id , m.member_name, rank() over(order by cnt desc) as ranking 
from (select * , count(member_id) as cnt from rest_review 
group by member_id) as r left join member_profile m on m.member_id = r.member_id) b on a.member_id = b.member_id
where b.ranking = 1
order by review_date