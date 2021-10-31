-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 29, 2021 at 10:01 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `coffeeparadise`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `bill_id` int(11) NOT NULL,
  `bill_product_id` int(11) NOT NULL,
  `bill_product_image` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `bill_product_name` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `bill_product_price` double NOT NULL,
  `bill_product_promotion` double NOT NULL,
  `bill_product_amount` int(11) NOT NULL,
  `bill_product_money` double NOT NULL,
  `user_fullname` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `staff_id` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`bill_id`, `bill_product_id`, `bill_product_image`, `bill_product_name`, `bill_product_price`, `bill_product_promotion`, `bill_product_amount`, `bill_product_money`, `user_fullname`, `user_id`, `date`, `staff_id`, `status`) VALUES
(132, 7, 'mochahot.jpg,', 'Mocha nóng(1 cốc),', 0, 0, 1, 7.656, 'Gia Hưng', 1, '2021-02-26', 1, -1),
(133, 6, 'espresso-5063148_1920.jpg,', 'Capuchino đậm(1 cốc),', 0, 0, 1, 7, 'Gia Hưng', 1, '2021-02-27', 1, 2),
(135, 8, 'mochaice.jpg,', 'Mocha lạnh(1 cốc),', 0, 0, 1, 8, 'Gia Hưng', 1, '2021-02-27', 1, 1),
(136, 6, 'espresso-5063148_1920.jpg,', 'Capuchino đậm(1 cốc),', 0, 0, 1, 7, 'Gia Hưng', 1, '2021-02-27', 1, 1),
(137, 6, 'espresso-5063148_1920.jpg,', 'Capuchino đậm(1 cốc),', 0, 0, 1, 7, 'Gia Hưng', 1, '2021-02-27', 1, 6),
(138, 6, 'espresso-5063148_1920.jpg,', 'Capuchino đậm(1 cốc),', 0, 0, 1, 7, 'Gia Hưng', 1, '2021-02-27', 1, 1),
(139, 6, 'coffee-1790576_1920.jpg,menu-5.jpg,', 'Ristretto Espresso(2 cốc),Latte Macchiato(3 cốc),', 0, 0, 5, 25.6, 'Gia Hưng', 1, '2021-02-27', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE `categories` (
  `categories_id` int(11) NOT NULL,
  `categories_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`categories_id`, `categories_name`) VALUES
(1, 'Espresso'),
(2, 'Latte Macchiato'),
(3, 'Cappuccino'),
(4, 'Mocha'),
(5, 'Trà sữa'),
(26, 'Rượu vang'),
(28, 'Bia'),
(30, 'Sữa');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `comment_id` int(11) NOT NULL,
  `comment_user` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `comment_detail` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `product_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `comment_time` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `product_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`comment_id`, `comment_user`, `comment_detail`, `product_name`, `comment_time`, `product_id`) VALUES
(20, 'Tuấn', 'Cà phê ngon tuyệt vời, đúng gu của mình', 'Normale Espresso', '2021/01/16', 1),
(21, 'Quốc', 'Ngon, không có chỗ nào để chê', 'Normale Espresso', '2021/01/16', 1),
(23, 'Hưng', 'Cà phê ngon vcc', 'Ristretto Espresso', '2021/01/20', 2),
(24, 'hưng', 'Cà phê ngon quá ae', 'Capuchino đậm', '2021/01/20', 6),
(25, 'Bình', 'Loại này uống ngon ghê', 'Normale Espresso', '2021/02/05', 1);

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `contact_id` int(11) NOT NULL,
  `contact_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `contact_phone` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `contact_title` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `contact_content` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `contact_email` text COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`contact_id`, `contact_name`, `contact_phone`, `contact_title`, `contact_content`, `contact_email`) VALUES
(1, 'hưng', '12345678', 'Về cà phê', 'Ngon vcc luôn', 'giahungnguyenhuu99@gmail.com'),
(2, 'Hưng', '123456', 'Capuchino', 'Quá ngon luôn shop ơi', 'giahungnguyenhuu99@gmail.com'),
(3, 'Trần Chân', '123123213', 'Latte', 'Cần thêm 1 chút sữa nữa sẽ ngon hơn', 'tranchan@gmail.com'),
(4, 'Chân Tử Đan', '456789', 'Mocha', 'Không đắng cho lắm hơi ngọt ^^', 'tranchan@gmail.com'),
(5, 'Minh', '123321', 'Epresso', 'Cần đắng thêm 1 chút nữa mới tuyệt hảo', 'giahungnguyenhuu99@gmail.com'),
(6, 'Võ Duy Nam', '123123123', 'Về mocha', 'Dở nực bán cho chó uống', 'giahungnguyenhuu99@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `favourite`
--

CREATE TABLE `favourite` (
  `favourite_id` int(11) NOT NULL,
  `favourite_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `favourite_price` double NOT NULL,
  `favourite_promotion` double NOT NULL,
  `favourite_image` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `product_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `favourite`
--

INSERT INTO `favourite` (`favourite_id`, `favourite_name`, `favourite_price`, `favourite_promotion`, `favourite_image`, `product_id`, `user_id`) VALUES
(62, 'Normale Espresso', 5, 12, 'coffee-2407662_1920.jpg', 1, 1),
(63, 'Mocha lạnh', 8, 0, 'mochaice.jpg', 8, 1),
(64, 'Ristretto Espresso', 4, 5, 'coffee-1790576_1920.jpg', 2, 1),
(65, 'Mocha lạnh', 8, 0, 'mochaice.jpg', 8, 2);

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `message_id` int(11) NOT NULL,
  `message_sent` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `message_time_sent` text COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT current_timestamp(),
  `name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `message`
--

INSERT INTO `message` (`message_id`, `message_sent`, `message_time_sent`, `name`, `id_user`) VALUES
(982, 'Cho tôi hỏi quán còn trà sữa không?', '2021/02/05 11:29:38 AM', 'Gia Hưng', 1),
(983, 'Còn chứ bạn', '2021/02/05 11:32:11 AM', 'Admin', 1),
(984, 'Ship cho tôi loại 50k nhé', '2021/02/05 11:32:28 AM', 'Gia Hưng', 1),
(985, 'ok', '2021/02/05 11:32:37 AM', 'Admin', 1),
(986, 'bạn cho mình thông tin địa chỉ với ạ?', '2021/02/05 11:32:46 AM', 'Admin', 1),
(987, 'dũng sĩ, thanh khê ,đà nẵng', '2021/02/05 11:33:18 AM', 'Gia Hưng', 1),
(988, 'ok', '2021/02/05 11:33:22 AM', 'Admin', 1),
(989, 'q', '2021/02/05 12:53:05 PM', 'Gia Hưng', 1),
(990, '1', '2021/02/05 12:56:46 PM', 'Gia Hưng', 1),
(991, '2', '2021/02/05 12:56:49 PM', 'Administrator', 1),
(992, '3', '2021/02/05 12:57:00 PM', 'Gia Hưng', 1),
(993, '4', '2021/02/05 12:57:04 PM', 'Administrator', 1),
(994, '5', '2021/02/05 01:00:45 PM', 'Gia Hưng', 1),
(995, '6', '2021/02/05 01:00:48 PM', 'Administrator', 1),
(996, '2', '2021/02/05 01:00:54 PM', 'Gia Hưng', 1),
(997, '7', '2021/02/05 01:02:49 PM', 'Admin', 1),
(998, '8', '2021/02/05 01:02:54 PM', 'Gia Hưng', 1),
(999, '9', '2021/02/05 03:26:16 PM', 'Administrator', 1),
(1000, '10', '2021/02/05 03:26:39 PM', 'Gia Hưng', 1),
(1001, 'z', '2021/02/05 03:44:44 PM', 'Trần Chân', 2),
(1002, '11', '2021/02/05 06:06:30 PM', 'Gia Hưng', 1),
(1003, '12', '2021/02/05 06:06:34 PM', 'Administrator', 1),
(1004, '13', '2021/02/05 06:24:05 PM', 'Gia Hưng', 1),
(1005, '14', '2021/02/05 06:24:09 PM', 'Administrator', 2),
(1006, 'a', '2021/02/05 06:26:49 PM', 'Gia Hưng', 2),
(1007, 'b', '2021/02/05 06:26:50 PM', 'Administrator', 1),
(1008, 'c', '2021/02/05 06:28:01 PM', 'Administrator', 1),
(1009, 'd', '2021/02/05 06:28:03 PM', 'Gia Hưng', 1),
(1010, 'c', '2021/02/05 06:31:18 PM', 'Administrator', 2),
(1011, 'k', '2021/02/05 06:31:21 PM', 'Gia Hưng', 1),
(1012, 'z', '2021/02/05 06:32:15 PM', 'Administrator', 1),
(1013, 'e', '2021/02/05 06:32:17 PM', 'Gia Hưng', 1),
(1014, 'q', '2021/02/05 07:48:21 PM', 'Gia Hưng', 1),
(1015, 'q', '2021/02/05 07:48:25 PM', 'Administrator', 1),
(1016, 'd', '2021/02/05 07:57:20 PM', 'Gia Hưng', 1),
(1017, 'q', '2021/02/05 07:57:21 PM', 'Administrator', 1),
(1018, 'z', '2021/02/05 08:16:26 PM', 'Gia Hưng', 1),
(1019, 'a', '2021/02/05 08:16:28 PM', 'Administrator', 1),
(1020, 'q', '2021/02/05 09:57:10 PM', 'Trần Chân', 2),
(1021, 'b', '2021/02/05 10:02:40 PM', 'Gia Hưng', 1),
(1022, 'c', '2021/02/05 10:02:42 PM', 'Administrator', 1),
(1023, 'd', '2021/02/05 10:08:24 PM', 'Gia Hưng', 1),
(1024, 'e', '2021/02/05 10:08:27 PM', 'Administrator', 1),
(1025, '', '2021/02/05 10:08:48 PM', 'Gia Hưng', 1),
(1026, '', '2021/02/05 10:08:51 PM', 'Administrator', 1),
(1027, 'z', '2021/02/05 10:11:26 PM', 'Gia Hưng', 1),
(1028, 'x', '2021/02/05 10:11:28 PM', 'Administrator', 1),
(1029, 'v', '2021/02/05 10:21:22 PM', 'Gia Hưng', 1),
(1030, 'b', '2021/02/05 10:21:24 PM', 'Administrator', 1),
(1031, 'z', '2021/02/05 10:25:53 PM', 'Gia Hưng', 1),
(1032, 'v', '2021/02/05 10:25:55 PM', 'Administrator', 1),
(1033, 'b', '2021/02/05 11:49:45 PM', 'Gia Hưng', 1),
(1034, 'c', '2021/02/06 12:41:21 AM', 'Gia Hưng', 1),
(1035, 'd', '2021/02/06 12:41:25 AM', 'Administrator', 1),
(1036, 'z', '2021/02/06 12:43:27 AM', 'Administrator', 1),
(1037, 'y', '2021/02/06 12:51:49 AM', 'Gia Hưng', 1),
(1038, 'z', '2021/02/06 12:52:27 AM', 'Gia Hưng', 1),
(1039, 'a', '2021/02/06 01:11:04 AM', 'Dương Văn Vũ', 4),
(1040, 'n', '2021/02/06 01:11:25 AM', 'Dương Văn Vũ', 4),
(1041, 'a', '2021/02/08 09:00:03 PM', 'Gia Hưng', 1),
(1042, 'a', '2021/02/08 09:00:59 PM', 'Trần Chân', 2),
(1043, 'b', '2021/02/08 09:05:41 PM', 'Gia Hưng', 1),
(1044, 'c', '2021/02/08 09:06:58 PM', 'Gia Hưng', 1),
(1045, 'd', '2021/02/08 09:07:05 PM', 'Administrator', 1),
(1046, 'e', '2021/02/08 09:07:33 PM', 'Gia Hưng', 1),
(1047, 'z', '2021/02/08 09:14:37 PM', 'Administrator', 1),
(1048, 'x', '2021/02/08 09:14:40 PM', 'Gia Hưng', 1),
(1049, 'b', '2021/02/08 09:15:24 PM', 'Trần Chân', 2),
(1050, 'z', '2021/02/08 09:15:43 PM', 'Administrator', 1),
(1051, 'r', '2021/02/08 09:15:55 PM', 'Trần Chân', 2),
(1052, 'hi', '2021/02/08 09:16:16 PM', 'Administrator', 1),
(1053, 'hello', '2021/02/08 09:16:24 PM', 'Administrator', 1),
(1054, 'cc', '2021/02/08 09:16:35 PM', 'Gia Hưng', 1),
(1055, 'làm gì đó', '2021/02/08 09:22:26 PM', 'Gia Hưng', 1),
(1056, 'chi có', '2021/02/08 09:22:40 PM', 'Administrator', 1),
(1057, 'ok', '2021/02/08 09:22:50 PM', 'Gia Hưng', 1),
(1058, 'hihi', '2021/02/08 09:22:57 PM', 'Administrator', 1),
(1059, 'chào admin', '2021/02/08 09:44:18 PM', 'Gia Hưng', 1),
(1060, 'chào bạn', '2021/02/08 09:44:30 PM', 'Administrator', 1),
(1061, 'alo', '2021/02/08 09:44:41 PM', 'Administrator', 1),
(1062, 'z', '2021/02/08 09:47:33 PM', 'Gia Hưng', 1),
(1063, 'x', '2021/02/08 09:47:44 PM', 'Gia Hưng', 1),
(1064, 'c', '2021/02/08 09:47:51 PM', 'Administrator', 1),
(1065, 'z', '2021/02/08 09:56:12 PM', 'Gia Hưng', 1),
(1066, 'c', '2021/02/08 09:56:15 PM', 'Administrator', 1),
(1067, 'v', '2021/02/08 09:56:17 PM', 'Administrator', 1),
(1068, 'q', '2021/02/08 09:56:20 PM', 'Gia Hưng', 1),
(1069, 't', '2021/02/08 09:59:16 PM', 'Gia Hưng', 1),
(1070, 'd', '2021/02/08 10:00:09 PM', 'Administrator', 1),
(1071, 'e', '2021/02/08 10:00:11 PM', 'Gia Hưng', 1),
(1072, 'r', '2021/02/08 10:00:32 PM', 'Administrator', 1),
(1073, 't', '2021/02/08 10:00:35 PM', 'Gia Hưng', 1),
(1074, 'a', '2021/02/08 10:22:22 PM', 'Gia Hưng', 1),
(1075, 'b', '2021/02/08 10:22:29 PM', 'Administrator', 1),
(1076, 'c', '2021/02/08 10:22:51 PM', 'Gia Hưng', 1),
(1077, 'z', '2021/02/08 10:26:20 PM', 'Gia Hưng', 1),
(1078, 'd', '2021/02/08 10:26:32 PM', 'Administrator', 1),
(1079, 'f', '2021/02/08 10:26:36 PM', 'Gia Hưng', 1),
(1080, 'z', '2021/02/08 10:38:12 PM', 'Gia Hưng', 1),
(1081, 'x', '2021/02/08 10:38:22 PM', 'Administrator', 1),
(1082, 'v', '2021/02/08 10:38:52 PM', 'Gia Hưng', 1),
(1083, 'z', '2021/02/08 10:39:03 PM', 'Administrator', 1),
(1084, 'n', '2021/02/08 10:39:29 PM', 'Gia Hưng', 1),
(1085, 'q', '2021/02/08 10:50:58 PM', 'Administrator', 1),
(1086, 'p', '2021/02/08 10:51:02 PM', 'Gia Hưng', 1),
(1087, 't', '2021/02/08 11:23:13 PM', 'Gia Hưng', 1),
(1088, 'z', '2021/02/09 12:04:43 AM', 'Gia Hưng', 1),
(1089, 'i', '2021/02/09 12:06:03 AM', 'Gia Hưng', 1),
(1090, 'o', '2021/02/09 12:06:17 AM', 'Gia Hưng', 1),
(1091, 'z', '2021/02/09 12:07:31 AM', 'Administrator', 1),
(1092, 'v', '2021/02/09 12:08:52 AM', 'Gia Hưng', 1),
(1093, 'q', '2021/02/09 12:20:48 AM', 'Administrator', 1),
(1094, 'r', '2021/02/09 12:20:52 AM', 'Gia Hưng', 1),
(1095, 'o', '2021/02/09 12:21:47 AM', 'Administrator', 1),
(1096, 'o', '2021/02/09 12:21:50 AM', 'Trần Chân', 2),
(1097, 'q', '2021/02/09 01:06:53 AM', 'Administrator', 1),
(1098, 'z', '2021/02/09 01:09:26 AM', 'Administrator', 1),
(1099, 'p', '2021/02/09 01:09:29 AM', 'Gia Hưng', 1),
(1100, 'u', '2021/02/09 01:10:02 AM', 'Trần Chân', 2),
(1101, 'q', '2021/02/09 01:13:13 AM', 'Gia Hưng', 1),
(1102, 'o', '2021/02/09 01:13:22 AM', 'Administrator', 1),
(1103, 'z', '2021/02/09 01:18:03 AM', 'Gia Hưng', 1),
(1104, 'a', '2021/02/09 01:18:05 AM', 'Administrator', 1),
(1105, 'x', '2021/02/09 01:27:09 AM', 'Administrator', 1),
(1106, 'y', '2021/02/09 01:27:14 AM', 'Gia Hưng', 1),
(1107, 'i', '2021/02/09 01:28:03 AM', 'Gia Hưng', 1),
(1108, 'q', '2021/02/09 01:30:01 AM', 'Gia Hưng', 1),
(1109, 'u', '2021/02/09 01:30:54 AM', 'Administrator', 1),
(1110, 'l', '2021/02/09 01:30:58 AM', 'Gia Hưng', 1),
(1111, 'g', '2021/02/09 01:33:31 AM', 'Gia Hưng', 1),
(1112, 'a', '2021/02/09 01:34:06 AM', 'Administrator', 1),
(1113, 'b', '2021/02/09 01:34:09 AM', 'Gia Hưng', 1),
(1114, 't', '2021/02/09 09:02:50 AM', 'Gia Hưng', 1),
(1115, 'a', '2021/02/09 09:02:54 AM', 'Administrator', 1),
(1116, 'z', '2021/02/09 09:10:03 AM', 'Gia Hưng', 1),
(1117, 'q', '2021/02/09 09:11:56 AM', 'Administrator', 1),
(1118, 'q', '2021/02/09 09:12:05 AM', 'Administrator', 1),
(1119, 'b', '2021/02/09 09:18:30 AM', 'Trần Chân', 2),
(1120, 'p', '2021/02/09 09:19:47 AM', 'Administrator', 1),
(1121, 'u', '2021/02/09 09:19:56 AM', 'Trần Chân', 2),
(1122, 'z', '2021/02/09 09:22:37 AM', 'Trần Chân', 2),
(1123, 'e', '2021/02/09 09:22:54 AM', 'Administrator', 1),
(1124, 'r', '2021/02/09 09:22:57 AM', 'Gia Hưng', 1),
(1125, 'k', '2021/02/09 09:23:18 AM', 'Gia Hưng', 1),
(1126, 'q', '2021/02/09 09:23:22 AM', 'Administrator', 1),
(1127, 'c', '2021/02/09 09:24:14 AM', 'Administrator', 1),
(1128, 'v', '2021/02/09 09:24:17 AM', 'Gia Hưng', 1),
(1129, 'q', '2021/02/09 09:24:41 AM', 'Administrator', 1),
(1130, 'r', '2021/02/09 09:24:44 AM', 'Gia Hưng', 1),
(1131, 'q', '2021/02/09 09:25:28 AM', 'Gia Hưng', 1),
(1132, 'r', '2021/02/09 09:25:33 AM', 'Administrator', 1),
(1133, 'z', '2021/02/09 09:26:43 AM', 'Gia Hưng', 1),
(1134, 'x', '2021/02/09 09:26:45 AM', 'Administrator', 1),
(1135, 't', '2021/02/09 09:30:23 AM', 'Administrator', 1),
(1136, 'u', '2021/02/09 09:30:27 AM', 'Gia Hưng', 1),
(1137, 'z', '2021/02/09 09:32:45 AM', 'Gia Hưng', 1),
(1138, 'v', '2021/02/09 09:32:49 AM', 'Administrator', 1),
(1139, 'n', '2021/02/09 09:34:17 AM', 'Gia Hưng', 1),
(1140, 'q', '2021/02/09 09:34:26 AM', 'Administrator', 1),
(1141, 'u', '2021/02/09 09:38:24 AM', 'Administrator', 1),
(1142, 'p', '2021/02/09 09:38:29 AM', 'Gia Hưng', 1),
(1143, 'y', '2021/02/09 09:39:07 AM', 'Administrator', 1),
(1144, 'u', '2021/02/09 09:39:10 AM', 'Gia Hưng', 1),
(1145, 'a', '2021/02/09 09:39:22 AM', 'Administrator', 1),
(1146, 'b', '2021/02/09 09:43:10 AM', 'Administrator', 1),
(1147, 'c', '2021/02/09 09:43:12 AM', 'Gia Hưng', 1),
(1148, 'b', '2021/02/09 09:43:41 AM', 'Administrator', 1),
(1149, 'c', '2021/02/09 09:44:35 AM', 'Gia Hưng', 1),
(1150, 'd', '2021/02/09 09:44:41 AM', 'Administrator', 1),
(1151, 'e', '2021/02/09 09:44:44 AM', 'Administrator', 2),
(1152, 'q', '2021/02/09 09:44:52 AM', 'Trần Chân', 2),
(1153, 'e', '2021/02/09 09:47:38 AM', 'Administrator', 1),
(1154, 'f', '2021/02/09 09:47:41 AM', 'Gia Hưng', 1),
(1155, 't', '2021/02/09 09:47:51 AM', 'Trần Chân', 2),
(1156, 'y', '2021/02/09 09:47:55 AM', 'Administrator', 2),
(1157, 'chào bạn?', '2021/02/09 09:48:07 AM', 'Administrator', 1),
(1158, 'chào admin?', '2021/02/09 09:48:18 AM', 'Gia Hưng', 1),
(1159, 'làm gì đó?', '2021/02/09 09:48:26 AM', 'Administrator', 2),
(1160, 'ỉa', '2021/02/09 09:48:30 AM', 'Trần Chân', 2),
(1161, 'hello', '2021/02/09 09:49:23 AM', 'Gia Hưng', 1),
(1162, 'hi', '2021/02/09 09:49:33 AM', 'Administrator', 1),
(1163, 'chào admin', '2021/02/09 02:52:10 PM', 'Trần Chân', 2),
(1164, 'chào bạn', '2021/02/09 02:52:25 PM', 'Administrator', 2),
(1165, 'bạn cần mình tư vấn gì không ạ', '2021/02/09 02:52:34 PM', 'Administrator', 2),
(1166, 'cà phê loại nào ngon nhất nhỉ?', '2021/02/09 02:52:46 PM', 'Trần Chân', 2),
(1167, 'thích thì mua k thích thì mua hỏi như cc', '2021/02/09 02:52:58 PM', 'Administrator', 2),
(1168, 'có ship rượu k shop?', '2021/02/09 02:53:23 PM', 'Gia Hưng', 1),
(1169, 'có nha ^^', '2021/02/09 02:53:37 PM', 'Administrator', 1),
(1170, 'Chào admin?', '2021/02/09 03:07:07 PM', 'Phạm Thị Như Ý', 5),
(1171, 'Chào bạn', '2021/02/09 03:07:18 PM', 'Administrator', 5),
(1172, 'bạn cần tư vấn về vấn đề gì ạ?', '2021/02/09 03:07:28 PM', 'Administrator', 5),
(1173, 'đm mày thích ăn cứt không?', '2021/02/09 03:07:42 PM', 'Phạm Thị Như Ý', 5),
(1174, 'a', '2021/02/09 04:41:02 PM', 'Trần Chân', 2),
(1175, 'c', '2021/02/09 04:41:11 PM', 'Administrator', 2),
(1176, 'a', '2021/02/09 04:41:44 PM', 'Trần Chân', 2),
(1177, 'e', '2021/02/09 04:41:46 PM', 'Administrator', 2),
(1178, 'chào admin', '2021/02/09 08:50:00 PM', 'Gia Hưng', 1),
(1179, 'chào bạn', '2021/02/09 08:50:05 PM', 'Administrator', 1),
(1180, 'bú đít k?', '2021/02/09 08:50:11 PM', 'Gia Hưng', 1),
(1181, 'có :v', '2021/02/09 08:50:14 PM', 'Administrator', 1),
(1182, 'hế lô', '2021/02/09 08:51:03 PM', 'Trần Chân', 2),
(1183, 'sao cưng', '2021/02/09 08:51:07 PM', 'Administrator', 2),
(1184, 'làm nháy', '2021/02/09 08:51:12 PM', 'Trần Chân', 2),
(1185, 'ok', '2021/02/09 08:51:14 PM', 'Administrator', 2),
(1186, 'cc', '2021/02/09 08:51:22 PM', 'Administrator', 1),
(1187, 'ăn cức k :))', '2021/02/09 08:51:32 PM', 'Gia Hưng', 1),
(1188, 'z', '2021/02/09 08:57:27 PM', 'Administrator', 1),
(1189, 'x', '2021/02/09 08:57:38 PM', 'Gia Hưng', 1),
(1190, 'c', '2021/02/09 09:57:04 PM', 'Gia Hưng', 1),
(1191, 'd', '2021/02/09 09:57:07 PM', 'Administrator', 1),
(1192, 'f', '2021/02/09 09:57:10 PM', 'Gia Hưng', 1);

-- --------------------------------------------------------

--
-- Table structure for table `permision`
--

CREATE TABLE `permision` (
  `per_id` int(11) NOT NULL,
  `per_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `permision`
--

INSERT INTO `permision` (`per_id`, `per_name`) VALUES
(1, 'Administrator'),
(2, 'Admin'),
(3, 'Moderator'),
(4, 'Staff');

-- --------------------------------------------------------

--
-- Table structure for table `permisiondetail`
--

CREATE TABLE `permisiondetail` (
  `detail_id` int(11) NOT NULL,
  `per_id` int(11) NOT NULL,
  `action` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `check` int(11) NOT NULL,
  `staff_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `permisiondetail`
--

INSERT INTO `permisiondetail` (`detail_id`, `per_id`, `action`, `check`, `staff_id`) VALUES
(1, 1, 'ADD', 1, 1),
(2, 1, 'EDIT', 1, 1),
(3, 1, 'DEL', 1, 1),
(4, 2, 'ADD', 0, 2),
(5, 2, 'EDIT', 1, 2),
(6, 2, 'DEL', 1, 2),
(7, 3, 'ADD', 0, 3),
(8, 3, 'EDIT', 0, 3),
(9, 3, 'DEL', 1, 3),
(10, 4, 'ADD', 0, 4),
(11, 4, 'EDIT', 0, 4),
(12, 4, 'DEL', 0, 4);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `product_description` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `product_image` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `product_price` double NOT NULL,
  `categories_id` int(11) NOT NULL,
  `categories_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `views` int(11) DEFAULT NULL,
  `product_description_detail` text COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `promotion` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_description`, `product_image`, `product_price`, `categories_id`, `categories_name`, `views`, `product_description_detail`, `promotion`) VALUES
(1, 'Normale Espresso', 'Espresso là café được pha bằng máy, sử dụng nước nóng nén bởi áp suất cao qua lớp bột cà phê được xay mịn. Nước dùng để pha chế Espresso là nước tinh khiết, còn café dùng để pha chế theo phương pháp này cũng phải là café rang mộc, không tẩm ướp bất kỳ tạp chất nào.', 'coffee-2407662_1920.jpg', 5, 1, 'Espresso', 394, 'Normale Espresso (truyền thống), có tỷ lệ từ 1: 2 đến 1: 3. (tức là cứ 18 gram cà phê sẽ chiết ra khoảng từ 36 gram Espresso).Khi làn sóng cà phê thứ ba được dẫn đầu bởi các loại Specialty coffee, chúng cần được rang nhẹ hơn (để thể hiện được đặc tính hương vị riêng) – không ai muốn một Shot cà phê Sumatra cay đắng và cháy khét như mọi cốc Blend roast từng có trước đây. Những loại cà phê này đòi hỏi việc chiết xuất khó khăn hơn nhiều. Vì vậy, các cửa hàng cà phê đặc sản trên khắp thế giới đã bắt đầu tập trung xu hướng về một cốc “Espresso bình thường”. Và Normale với tỷ lệ 1: 2 đang khuynh đảo mọi thế trận từng có trong mặt trận tỷ lệ của Espresso.Về lý thuyết, tỷ lệ pha dao động trong khoảng 1:2 sẽ giúp giúp tỷ lệ chiết xuất (Extraction yield – tức tỷ lệ giữa các chất hòa tan/tổng khối lượng cà phê) ở mức tối đa (tiêu chuẩn là 18-20%). Nói cách khác, điều này có nghĩa là bạn đã hoà tan nhiều nhất có thể các chất rắn trong cà phê vào cốc của mình, nên gần như chúng ta không bỏ lỡ hương vị nào với Normale. Và với xu hướng càng ngày có càng nhiều cà phê bản địa – Single origin coffee được dùng làm Espresso thì việc thử nghiệm các tỷ lệ pha cà phê cao hơn là điều cần thiết.', 12),
(2, 'Ristretto Espresso', 'Ristretto là một biến thể của Espresso hay một phương pháp pha chế khác bằng máy pha để cho ra tách cafe “cô đặc” hơn. Trong tiếng Ý,  Ristretto có nghĩa là rút ngắn – restricted. “Rút ngắn” ở đây hàm ý chỉ việc các barista chỉ thực hiện chiết xuất vào giai đoạn đầu của một quá trình pha cafe mà bỏ đi giai đoạn chiết xuất cuối.', 'coffee-1790576_1920.jpg', 4, 1, 'Espresso', 212, 'Ristretto là một biến thể của Espresso hay một phương pháp pha chế khác bằng máy pha để cho ra tách cafe “cô đặc” hơn. Trong tiếng Ý,  Ristretto có nghĩa là rút ngắn – restricted. “Rút ngắn” ở đây hàm ý chỉ việc các barista chỉ thực hiện chiết xuất vào giai đoạn đầu của một quá trình pha cafe mà bỏ đi giai đoạn chiết xuất cuối.\r\n\r\nTùy thuộc vào công thức của quán cafe mà Ristretto sẽ dao động trong khoảng 15 – 20ml cà phê. Nhưng đa số đều được phục vụ double shot do thể tích quá ít.', 5),
(3, 'Espresso Macchiato', 'Espresso Macchiato có thành phần chủ yếu là café (1 shot hoặc 2 shot), chỉ có 1 chút sữa tươi đánh nóng và điểm thêm “đốm” bọt sữa nhỏ. Loại này dành cho những người yêu thích hương vị mạnh, đậm đắng của café.', 'menu-5.jpg', 6, 2, 'Latte', 19, NULL, NULL),
(4, 'Latte Macchiato', 'Latte Macchiato thành phần chính là sữa tươi đánh nóng và bọt sữa rất dày, còn café đóng vai trò “vệt lốm đốm”. Latte Macchiato khác với café thông thường ở lớp bọt sữa, dành cho những người ưa vị ngọt, béo ngậy nhưng vẫn phảng phất 1 chút café.', 'menu-5.jpg', 6, 2, 'Latte', 11, NULL, NULL),
(5, 'Capuchino nhạt', 'Capuchino là một thức uống sang trọng và cầu kỳ, bao gồm ba phần chính: cà phê espresso, sữa nóng và sữa sủi bọt', 'menu-5.jpg', 7, 3, 'Capuchino', 21, NULL, NULL),
(6, 'Capuchino đậm', 'Với thành phần giống hệt Capuchino nhạt nhưng được rắc lên trên cốc cà phê Capuchino một ít bột ca cao hay bột quế để cafe Capuchino sẽ đậm đà hơn.', 'espresso-5063148_1920.jpg', 7, 3, 'Capuchino', 197, 'Capuchino có vị cà phê trầm và nhẹ, cùng hương thơm của kem hòa lẫn vị béo của sữa. Chỉ cần nhấp môi một ngụm nóng, bạn sẽ có ngay cảm giác thích thú khi thưởng thức một món ngon cùng với tâm trạng sảng khoái, đầu óc tỉnh táo, minh mẫn.', NULL),
(7, 'Mocha nóng', 'Cafe Mocha nóng là loại được hòa trộn giữa espresso với sữa nóng, kèm mùi sô cô la tạp ra sự hòa quyện hoàn toàn của hương vị cafe với vị thơm ngọt béo của sữa và chocolate.', 'mochahot.jpg', 8, 4, 'Mocha', 169, 'Mocha (đọc là mo-ka), tiếng Ý còn gọi là Mocaccino, là một trong những sản phẩm cà phê Ý điển hình, gần giống như cà phê Latte nhưng có thêm sauce chocolate. Vị đắng ngọt ngào của chocolate hòa quyện với vị đắng của cà phê và béo ngậy hơn nhờ sữa tươi đánh nóng cùng lớp bọt sữa mịn màng, đã khiến cho Mocha trở thành thức uống ưa thích của phụ nữ và giới trẻ.', 4.3),
(8, 'Mocha lạnh', 'Nếu những cốc cafe mocha nóng hổi làm bạn say mê bởi hương vị nồng nàn quyến rũ thì cốc mocha đá hòa chung cafe đậm đà, hương vị mát lạnh, ngọt tan nơi đầu lưỡi cũng khiến bạn mê mẩn không hề kém đâu.', 'mochaice.jpg', 8, 4, 'Mocha', 214, 'Hiện nay, trên thị trường có rất nhiều loại cafe khác nhau. Mỗi người có những sở thích chọn lựa vị cafe khác nhau. Mocha chính là thức uống được nhiều người lựa chọn. Cafe mocha có vị đắng của chocolate và espresso, thêm chút béo ngậy từ sữa tươi. Lớp bọt mịn béo càng khiến ly mocha thêm lôi cuốn, hấp dẫn. Tuy vậy, cà phê mocha vẫn giữ được hương vị đặc trưng của loại cafe nói chung.', NULL),
(20, 'Rượu vang nho', 'Thơm ngon tuyệt hảo', 'wine-3384057_1920-519033529800.jpg', 15, 26, 'Rượu vang', 53, 'Được nhập khẩu từ Mỹ có tem bảo hànhh', 8),
(28, 'Sữa bò', 'Thơm ngon', 'bannervungtau-1375091240300.jpg', 20, 30, 'Sữa', 7, 'Thơm ngon hảo hạng', 3);

-- --------------------------------------------------------

--
-- Table structure for table `revenue`
--

CREATE TABLE `revenue` (
  `revenue_id` int(11) NOT NULL,
  `revenue_day` int(11) NOT NULL,
  `revenue_week` int(11) NOT NULL,
  `revenue_month` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL,
  `staff_image` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `staff_name` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `staff_email` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `staff_pass` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `staff_phone` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `staff_salary` double NOT NULL,
  `staff_calendar` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `per_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staff_id`, `staff_image`, `staff_name`, `staff_email`, `staff_pass`, `staff_phone`, `staff_salary`, `staff_calendar`, `per_id`) VALUES
(1, 'bg-01.jpg', 'Administrator', 'administrator@gmail.com', '25d55ad283aa400af464c76d713c07ad', '18001090', 1000, 'Freedom', 1),
(2, 'kontum.jpg', 'Admin', 'admin@gmail.com', '25d55ad283aa400af464c76d713c07ad', '123123123', 500, 'Thứ 2 - Thứ 4 - Thứ 6 (6h - 12h)', 2),
(3, 'kinhthanhhue.jpg', 'Moderator', 'moderator@gmail.com', '25d55ad283aa400af464c76d713c07ad', '45656456', 300, 'Thứ 3 - Thứ 5 - Thứ 7 (12h - 6h)', 3),
(5, 'hangma-7861264516400.jpg', 'Lê Thị Cẩm Tú', 'camtule@gmail.com', '25d55ad283aa400af464c76d713c07ad', '456789321', 100, 'Thứ 3 - Thứ 5 - Thứ 7 (18h - 24h)', 4),
(6, 'f-8311297087700.jpg', 'Lý Tiểu Long', 'dragon@gmail.com', '25d55ad283aa400af464c76d713c07ad', '123123456', 100, 'Thứ 2 - Thứ 4 - Thứ 6 (18h - 24h)', 4),
(8, 'chuahuong-939113794100.jpg', 'a', 'abc@gmail.com', '1a1dc91c907325c69271ddf0c944bc72', '45656456', 300, 'Thứ 3 - Thứ 5 - Thứ 7 (12h - 6h)', 4),
(9, '', 'a', 'a', '1a1dc91c907325c69271ddf0c944bc72', '1', 100, 'a', 3);

-- --------------------------------------------------------

--
-- Table structure for table `stars`
--

CREATE TABLE `stars` (
  `star_id` int(11) NOT NULL,
  `star_average` float NOT NULL,
  `star_temporary` float NOT NULL,
  `count` int(11) NOT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `stars`
--

INSERT INTO `stars` (`star_id`, `star_average`, `star_temporary`, `count`, `product_id`) VALUES
(106, 5, 5, 2, 1),
(107, 3, 6, 3, 1),
(108, 0.5, 0.5, 2, 2),
(109, 1.25, 2.5, 3, 2),
(110, 2.5, 7.5, 4, 2),
(111, 5, 5, 2, 8),
(112, 4, 8, 3, 8),
(113, 5, 5, 2, 5),
(114, 3, 6, 3, 5),
(115, 3, 3, 2, 20),
(116, 3.66667, 11, 4, 1),
(117, 2, 4, 3, 20),
(118, 3, 9, 4, 20),
(119, 3.5, 14, 5, 20),
(120, 3.125, 12.5, 5, 2),
(121, 5, 5, 2, 6),
(122, 3, 6, 3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_fullname` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_email` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_pass` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_fullname`, `user_email`, `user_pass`, `status`) VALUES
(1, 'Gia Hưng', 'giahungnguyenhuu99@gmail.com', '25d55ad283aa400af464c76d713c07ad', 1),
(2, 'Trần Chân', 'tranchan@gmail.com', '25d55ad283aa400af464c76d713c07ad', 0),
(3, 'Lê Thị Khánh Linh', 'linhlethi@gmail.com', '25d55ad283aa400af464c76d713c07ad', 0),
(4, 'Dương Văn Vũ', 'vanvu1212@gmail.com', '25d55ad283aa400af464c76d713c07ad', 0),
(5, 'Phạm Thị Như Ý', 'nhuy1991@gmail.com', '25d55ad283aa400af464c76d713c07ad', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_id`);

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`categories_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`comment_id`);

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`contact_id`);

--
-- Indexes for table `favourite`
--
ALTER TABLE `favourite`
  ADD PRIMARY KEY (`favourite_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`message_id`);

--
-- Indexes for table `permision`
--
ALTER TABLE `permision`
  ADD PRIMARY KEY (`per_id`);

--
-- Indexes for table `permisiondetail`
--
ALTER TABLE `permisiondetail`
  ADD PRIMARY KEY (`detail_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`);

--
-- Indexes for table `stars`
--
ALTER TABLE `stars`
  ADD PRIMARY KEY (`star_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `bill_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=140;

--
-- AUTO_INCREMENT for table `categories`
--
ALTER TABLE `categories`
  MODIFY `categories_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `comments`
--
ALTER TABLE `comments`
  MODIFY `comment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `contact_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `favourite`
--
ALTER TABLE `favourite`
  MODIFY `favourite_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=66;

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `message_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1193;

--
-- AUTO_INCREMENT for table `permision`
--
ALTER TABLE `permision`
  MODIFY `per_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `permisiondetail`
--
ALTER TABLE `permisiondetail`
  MODIFY `detail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `staff_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `stars`
--
ALTER TABLE `stars`
  MODIFY `star_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
