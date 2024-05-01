create table if not exists group_tb
(
	id serial primary key,
	name varchar(255)

	
);

create table if not exists user_tb
(
	id serial primary key,
	name varchar(255),
	surename varchar(255),
	patronymic varchar(255),
	email varchar(255),
	role varchar(255),
	group_tb_id integer references group_tb(id)
);

create table if not exists tasks
(
	id serial primary key,
	name varchar(255),
	description text,
	files varchar(255),
	status integer,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	date_start date,
	date_end date,
	time_start time,
	time_end time,
	user_tb_id integer references user_tb(id)
	
)