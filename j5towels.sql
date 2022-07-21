use j5towels
go
CREATE TABLE users (
  [id] int NOT NULL identity primary key,
  [avatar] varchar(255) DEFAULT NULL,
  [email] varchar(255) DEFAULT NULL,
  [gender] int DEFAULT NULL,
  [location] varchar(255) DEFAULT NULL,
  [name] nvarchar(255) DEFAULT NULL,
  [password] varchar(255) DEFAULT NULL,
  [phone] varchar(255) DEFAULT NULL,
  [role] int DEFAULT 0 NULL
) 
go

CREATE TABLE category (
  [id] int NOT NULL identity primary key,
  [name] nvarchar(255) DEFAULT NULL,
  [user_id] int NULL
	foreign key(user_id) references users(id)
) 
go

CREATE TABLE towel (
  [id] int NOT NULL identity primary key,
  [color] nvarchar(255) DEFAULT NULL,
  [matter] nvarchar(100) DEFAULT NULL,
  [count] int DEFAULT NULL,
  [created_date] datetime2(0) DEFAULT NULL,
  [img] nvarchar(255) DEFAULT NULL,
  [name] nvarchar(255) DEFAULT NULL,
  [price] int DEFAULT NULL,
  [size] nvarchar(255) DEFAULT NULL,
  [brand] nvarchar(255) DEFAULT NULL,
  [category_id] int DEFAULT NULL
	foreign key(category_id) references category(id)
) 
go
CREATE TABLE orders (
  [id] int NOT NULL identity primary key,
  [date] nvarchar(255) DEFAULT NULL,
  [address] nvarchar(100) DEFAULT NULL,
  [status] int DEFAULT NULL,
  [created_date] datetime2(0) DEFAULT NULL,
  [user_id] int NOT NULL,
	foreign key(user_id) references users(id)
)
go
CREATE TABLE order_detail (
  [id] int NOT NULL identity primary key,
  [price] decimal(10,2) DEFAULT NULL,
  [quantity] int DEFAULT NULL,
  [status] int DEFAULT NULL,
  [order_id] int NOT NULL,
  [towel_id] int NOT NULL,
	foreign key(user_id) references users(id),
	foreign key(towel_id) references towel(id)
)
go
INSERT INTO users ( [avatar], [email], [gender], [location], [name], [password], [phone], [role]) VALUES
( '', 'admin@gmail.com', 0, '', N'admin', 'admin', '0984297473', 1),
( '', 'anhhv492@gmail.com', 1, N'Vĩnh Phúc', N'Việt Anh', '492002', '0984297473', 0)
go

INSERT INTO category ( [name], [user_id]) 
VALUES(N'Khăn rửa mặt', 1),
(N'Khăn tắm', 1),
(N'Khăn lau', 1);
go

INSERT INTO towel ( [color], [matter], [count], [created_date], [img], [name], [price], [size], [category_id]) VALUES
( N'Đen', N'Vải cotton', 1212, '2022-05-27 19:50:43', NULL, N'Khăn mặt siêu mềm', 13222, '35x60cm', 1),
( N'Trắng, xanh lam', N'Vải Sợi Tre', 70, '2022-05-30 10:43:15', NULL, N'Khăn mặt thẩm hút', 50000, '65x25cm', 1),
( N'Đen', N'Vải Microfiber', 2000, '2022-05-28 01:48:38', NULL, N'Khăn mặt kháng khuẩn', 1500000, '31-50 size', 1),
( N'Đen, Trắng', N'Vải Sợi Tre', 500, '2022-05-28 01:49:06', NULL, N'Khăn rửa mặt Trung Quốc', 2500000, '31-50 size', 2),
( N'Đen, Trắng', N'Vải cotton', 500, '2022-05-28 01:49:12', NULL, N'Khăn rửa mặt Việt Nam', 2500000, '31-50 size', 2),
( N'Trắng xám', N'Vải Microfiber', 150, '2022-05-28 17:32:58', NULL, N'Khắm tắm trẻ em', 150000, '300cm-700cm', 2),
( N'Trắng, xanh', N'Vải cotton', 100, '2022-05-28 15:21:35', NULL, N'Khăn lau sàn', 20000, '50cm', 3),
( N'Trắng', N' Vải xô', 20, '2022-05-28 17:31:43', NULL, N'Khắm tắm người lớn', 200000, '1m-2m', 2),
( N'Màu trắng xám', N'Vải Sợi Tre', 200, '2022-05-31 15:47:10', NULL, N'Khăn lau cửa', 120000, '50x80cm', 3),
( N'Trắng, vàng, trắng đen', N'Vài siêu mềm', 200, '2022-05-30 10:25:59', NULL, N'Khắm lau máy tính', 50000, '30x30cm', 3);

go
