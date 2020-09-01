

create table products (id bigserial, title varchar(255), description varchar(5000), price numeric(8, 2), primary key(id));

insert into products (title, description, price) values
('Cheese', 'Fresh cheese', 320.0),
('Milk', 'Fresh milk', 80.0),
('Apples', 'Fresh apples', 70.0),
('Bread', 'Fresh bread', 30.0);
