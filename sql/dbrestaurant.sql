use dbrestaurant;

insert into category(name_category) values ('Pizza');
insert into category(name_category) values ('Pasta');
insert into category(name_category) values ('Wine');
insert into category(name_category) values ('Dessert');
insert into category(name_category) values ('Coffee');

insert into item(name,price,category_id) values ('Margarita pizza',650,1);
insert into item(name,price,category_id) values ('Bolognese',650,2);
insert into item(name,price,category_id) values ('White wine',650,3);
insert into item(name,price,category_id) values ('Baklava',650,4);
insert into item(name,price,category_id) values ('Cappucino',650,5);

insert into user(password,username)values("petar123","Petar");
insert into user(password,username)values("dragan123","Dragan");
insert into user(password,username)values("milan123","Milan");