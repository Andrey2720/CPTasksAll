create table if not exists users
(
	id serial primary key,
	name varchar(255),
	email varchar(255),
	phone varchar(255),
	role varchar(255),
	password varchar(255)
);


create table if not exists category
(
	id serial primary key,
	name varchar(255)
	
);

create table if not exists masters
(
	id serial primary key,
	name varchar(255),
	email varchar(255),
	phone varchar(255),
	role varchar(255),
	password varchar(255),
	category_id integer references category(id),
	city varchar(255),
	description text,
	rating integer
	
);

create table if not exists form
(
	id serial primary key,
	nameobj varchar(255),
	typeobj varchar(255),
	description text,
	files varchar(255),
	status integer,
	city varchar(255),
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	users_id integer references users(id),
	masters_id integer references masters(id),
	category_id integer references category(id)
	
	
);


