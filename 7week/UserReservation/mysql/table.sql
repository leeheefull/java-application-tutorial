-- select All
select id, name, password, email, phone, create_date, modify_date from user;
select id, user_id, role_name from user_role;
select id, name from category;
select id, file_name, save_file_name, content_type, delete_flag, create_date, modify_date from file_info;
select id, description, content, event, category_id, create_date, modify_date from product;
select id, product_id, opening_hours, place_name, place_lot, place_street, tel, homepage, email, create_date, modify_date from display_info;
select id, product_id, type, file_id from product_image;
select id, display_info_id, file_id from display_info_image;
select id, product_id, price_type_name , price, discount_rate, create_date, modify_date from product_price;
select id, product_id from promotion;
select id, product_id, display_info_id, user_id, reservation_date, cancel_flag, create_date, modify_date from reservation_info;
select id, reservation_info_id, product_price_id, count from reservation_info_price;
select id, product_id, reservation_info_id, user_id, score, comment, create_date, modify_date from reservation_user_comment;
select id, reservation_info_id, reservation_user_comment_id, file_id from reservation_user_comment_image;

-- select user by email
select id, name, password, email, phone, create_date, modify_date 
from user 
where email = 'carami@connect.co.kr';

-- select user_role by user_email
select ur.id, ur.user_id, ur.role_name 
from user as u, user_role as ur
where u.id = ur.user_id and u.email = 'carami@connect.co.kr';

-- select reservation by user_email
select ri.id, p.id as product_id, ri.display_info_id, ri.cancel_flag, p.description as product_description, p.content as product_content,
u.id as user_id, sum(pp.price*rip.count) as sum_price, ri.reservation_date, p.create_date, p.modify_date
from reservation_info as ri
join user as u on ri.user_id = u.id
join product as p on ri.product_id = p.id
join reservation_info_price as rip on ri.id = rip.reservation_info_id
join product_price as pp on rip.product_price_id = pp.id
where u.email = 'carami@connect.co.kr'
group by reservation_info_id;

-- update reservation_info cancel_flag by id
update reservation_info 
set cancel_flag = 1 
where id = 1;

-- select reservation_info by id
select ri.id, ri.product_id, ri.cancel_flag, ri.display_info_id, ri.user_id, ri.reservation_date, ri.create_date, ri.modify_date
from reservation_info as ri
where ri.id = 16;

-- select reservation_info_prices by reservation_info id
select rip.id, rip.reservation_info_id, rip.product_price_id, rip.count
from reservation_info_price as rip
where rip.reservation_info_id = 16;
