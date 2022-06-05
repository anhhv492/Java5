use clothers
go
create table users(
	id int identity not null primary key,
	avartar varchar(255),
	gender int not null,
	location nvarchar(255) not null,
	name nvarchar(100) not null,
	email varchar(50) not null,
	password varchar(100) not null,
	phone varchar(20) not null,
	role int default 0 not null
)
go
create table category(
	id int identity not null primary key,
	name nvarchar(100) not null,
	user_id int not null,
	foreign key(user_id) references users(id)
)
go
create table product(
	id int identity not null primary key,
	color nvarchar(50) not null,
	count int not null,
	create_date date not null,
	img nvarchar(255) not null,
	name nvarchar(255) not null,
	price int not null,
	size nvarchar(100) not null,
	category_id int not null,
	foreign key(category_id) references category(id)
)	