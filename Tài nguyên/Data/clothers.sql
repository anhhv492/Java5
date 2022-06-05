-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th5 27, 2022 lúc 08:51 PM
-- Phiên bản máy phục vụ: 10.4.20-MariaDB
-- Phiên bản PHP: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `clothers`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`, `user_id`) VALUES
(0, 'Áo', 1),
(1, 'Quần', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `img` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `color`, `count`, `created_date`, `img`, `name`, `price`, `size`, `category_id`) VALUES
(1, '1231', 1212, '2022-05-27 19:50:43', NULL, 'Áo chống nắng', 13222, '12321321', 0),
(3, 'Màu trắng xám', 123, '2022-05-27 15:00:31', NULL, 'Áo chống nắng 2', 2000000, 'L, M, XL', 1),
(5, 'Màu trắng xám', 123, '2022-05-27 15:21:38', NULL, 'Áo chống nắng32', 20, 'L, M', 0),
(8, 'Màu trắng xám', 123, '2022-05-27 15:47:14', NULL, 'Áo chống nắng new', 32132, 'L, M', 0),
(11, '1231', 1, '2022-05-28 00:01:21', NULL, '123', 10, '123', 0),
(12, 'Màu trắng xám', 1, '2022-05-28 01:36:54', NULL, 'Quần guchi', 10, 'L, M', 1),
(13, 'Màu trắng xám', 1, '2022-05-28 01:37:02', NULL, 'Quần guchi', 10, 'L, M', 1),
(14, 'Màu trắng xám', 1, '2022-05-28 01:37:04', NULL, 'Quần guchi', 10, 'L, M', 1),
(15, '312123', 32132, '2022-05-28 01:37:16', NULL, '123231', 312312, '1231233', 1),
(23, 'Màu trắng', 222, '2022-05-28 01:39:00', NULL, 'Áo dài', 2000000, 'L, M', 0),
(24, 'Đen', 2000, '2022-05-28 01:48:38', NULL, 'Quần vải', 1500000, '31-50 size', 1),
(25, 'Đen, Trắng', 500, '2022-05-28 01:48:53', NULL, 'Quần âu', 2500000, '31-50 size', 1),
(26, 'Đen, Trắng', 500, '2022-05-28 01:49:06', NULL, 'Quần bò', 2500000, '31-50 size', 1),
(27, 'Đen, Trắng', 500, '2022-05-28 01:49:12', NULL, 'Quần s', 2500000, '31-50 size', 1),
(28, 'Đen, Trắng', 500, '2022-05-28 01:49:14', NULL, 'Quần s2', 2500000, '31-50 size', 1),
(29, 'Đen, Trắng', 500, '2022-05-28 01:49:17', NULL, 'Quần s3', 2500000, '31-50 size', 1),
(30, '32123123', 123, '2022-05-28 01:49:42', NULL, 'Hạ Việt Anh', 231321, '231', 0),
(31, 'Đen, Trắng', 500, '2022-05-28 01:49:22', NULL, 'Quần s455', 2500000, '31-50 size', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(11) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `avatar`, `email`, `gender`, `location`, `name`, `password`, `phone`, `role`) VALUES
(1, '', 'anhhv492@gmail.com', 0, 'Vĩnh Phúc', 'Việt Anh', '492002', '0984297473', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpfk8djhv5natgshmxiav6xkpu` (`user_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `category`
--
ALTER TABLE `category`
  ADD CONSTRAINT `FKpfk8djhv5natgshmxiav6xkpu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
