-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2020 at 03:57 PM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chat_k32`
--

-- --------------------------------------------------------

--
-- Table structure for table `chat`
--

CREATE TABLE `chat` (
  `id` int(11) NOT NULL,
  `username` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `message` text COLLATE utf8_unicode_ci NOT NULL,
  `pub_date` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chat`
--

INSERT INTO `chat` (`id`, `username`, `message`, `pub_date`) VALUES
(1, 'bacnv1', 'Hello', '2929/SepSep/20202020 1414:0909'),
(2, 'bacnv1', 'Hello', '29/Sep/20 14:09'),
(3, 'bacnv1', 'Hello', '29/SepSepSep/2020 14:09'),
(4, 'asd', 'Hi', '05/Oct/2020 15:10'),
(5, 'asd', 'Test message', '05/Oct/2020 15:10'),
(6, 'bacnv1', 'xin chao', '05/Oct/2020 15:10'),
(7, 'asd', 'Kiem tra lai di', '05/Oct/2020 15:10'),
(8, 'trung', 'dhuhdasdsa', '05/Oct/2020 15:10'),
(9, 'trung', 'Ã¡dsadad', '05/Oct/2020 15:10'),
(10, 'trung', 'gdhgasudÃ¡', '05/Oct/2020 15:10'),
(11, 'trung', 'sadasdasd', '05/Oct/2020 15:10'),
(12, 'asd', 'dc chua?', '05/Oct/2020 15:10'),
(13, 'trung', 'ddasdÃ¡', '05/Oct/2020 15:10'),
(14, 'trung', 'fdgdfgdfg', '05/Oct/2020 15:10'),
(15, 'asd', 'asdhgahsd', '05/Oct/2020 15:10'),
(16, 'asd', 'nhay tuy hung a?', '05/Oct/2020 15:10');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_name` char(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` text COLLATE utf8_unicode_ci NOT NULL,
  `name` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_name`, `password`, `name`) VALUES
('asd', '123', 'Lam'),
('bacnv1', '123456', 'BacNV'),
('long', '123', 'Longleo'),
('na', 'na', 'na'),
('PhamHuuLuan', '123123', 'luan'),
('Sun', '123', 'Sun'),
('trung', '1', 'trung');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chat`
--
ALTER TABLE `chat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chat`
--
ALTER TABLE `chat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
