with cars as (
    select car_id
    from car_rental_company_rental_history
    where date_format(start_date, '%Y-%m') between '2022-08' and '2022-10'
    group by car_id
    having count(history_id) >= 5
)

select 
    month(start_date) month, car_id, count(history_id) records
from 
    car_rental_company_rental_history h 
where 
    date_format(start_date, '%Y-%m') between '2022-08' and '2022-10' and car_id in (select car_id from cars)
group by 
    month(start_date), car_id
having 
    count(history_id) > 0
order by 
    month, car_id desc