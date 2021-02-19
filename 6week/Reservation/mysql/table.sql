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
select id, product_id, display_info_id, user_id, reservation_date, create_date, modify_date from reservation_info;
select id, reservation_info_id, product_price_id, count from reservation_info_price;
select id, product_id, reservation_info_id, user_id, score, comment, create_date, modify_date from reservation_user_comment;
select id, reservation_info_id, reservation_user_comment_id, file_id from reservation_user_comment_image;

-- select categories
select c.id, c.name, (select count(*) from display_info d, product p where p.id = d.product_id and p.category_id = c.id) as count
from category as c;

-- select promotions by product_image_type
select pm.id, pd.id product_id, c.id category_id, c.name category_name, pd.description, pi.file_id
from promotion as pm, product as pd, category as c, product_image as pi
where pm.product_id = pd.id and pd.category_id = c.id and pd.id = pi.product_id and pi.type = 'ma';

-- count category by id
select count(*)
from product as p, display_info as di
where p.id = di.product_id and p.category_id = 3;

-- select display_info by product_image_type
select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id
from product as p, display_info as di , category as c, product_image as pi
where p.id = di.product_id and p.id = pi.product_id and pi.type = 'ma' and p.category_id = c.id;

-- select display_info by product_image_type and category_id
select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id
from product as p, display_info as di , category as c, product_image as pi
where p.id = di.product_id and p.id = pi.product_id and pi.type = 'ma' and p.category_id = c.id and c.id = 3;

-- select display_info by product_image_type and category_id and page
select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id
from product as p, display_info as di , category as c, product_image as pi
where p.id = di.product_id and p.id = pi.product_id and pi.type = 'ma' and p.category_id = c.id and c.id = 3
limit 4 offset 0;

-- select display_info by product_image_type and display_id
select p.id, p.category_id, di.id as display_info_id, c.name, p.description, p.content, p.event, di.opening_hours, di.place_name, di.place_lot, di.place_street, di.tel, di.homepage, di.email, di.create_date, di.modify_date, pi.file_id
from product as p, display_info as di, category as c, product_image as pi
where p.id = di.product_id and p.id = pi.product_id and pi.type = 'ma' and p.category_id = c.id and di.id = 3;

-- select product_image by product id and product_image_type
select p.id as product_id, pi.id as product_image_id, pi.type, pi.file_id as file_info_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date
from product as p, product_image as pi, file_info as fi
where p.id = pi.product_id and pi.file_id = fi.id and p.id = 1 and pi.type = 'ma';

-- select display_info_image by product_id
select dii.id, dii.display_info_id, dii.file_id, fi.file_name, fi.save_file_name, fi.content_type, fi.delete_flag, fi.create_date, fi.modify_date
from display_info as di, display_info_image as dii, file_info as fi
where di.id = dii.display_info_id and dii.file_id = fi.id and di.product_id= 1;

-- select product_price by product id
select id, product_id, price_type_name, price, discount_rate, create_date, modify_date
from product_price
where product_id = 1
order by id desc;

-- count reservation_user_comment by product_id
select count(*)
from reservation_user_comment as ruc, user as u
where ruc.user_id = u.id and ruc.product_id = 1;

-- avg reservation_user_comment score by product id
select avg(ruc.score)
from reservation_user_comment as ruc, product as p
where p.id = ruc.product_id and p.id = 1;

-- select reservation_user_comment
select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date
from reservation_user_comment as ruc, user as u
where ruc.user_id = u.id
order by ruc.id desc;

-- select reservation_user_comment by product_id
select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date
from reservation_user_comment as ruc, user as u
where ruc.user_id = u.id and ruc.product_id = 1
order by ruc.id desc;

-- select reservation_user_comment by product_id and page
select ruc.id, ruc.product_id, ruc.reservation_info_id, ruc.score, u.email reservation_email, ruc.comment, ruc.create_date, ruc.modify_date
from reservation_user_comment as ruc, user as u
where ruc.user_id = u.id and ruc.product_id = 1
order by ruc.id desc
limit 5 offset 0;