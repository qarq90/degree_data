-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Oct 29, 2024 at 04:59 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbms`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE `bank` (
  `custID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  `type` varchar(255) NOT NULL,
  `amount` double NOT NULL,
  `balance` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`custID`, `name`, `address`, `date`, `type`, `amount`, `balance`) VALUES
(1, 'John Doe', '', '2024-10-01', 'Deposit', 500, 500),
(2, 'Alice Johnson', '', '2024-10-02', 'Withdrawal', 200, 300),
(3, 'Bob Smith', '', '2024-10-03', 'Deposit', 1000, 1300),
(4, 'Carol Davis', '', '2024-10-04', 'Transfer', 150, 1150),
(5, 'David Wilson', '', '2024-10-05', 'Withdrawal', 400, 750),
(10, 'Narendra Modi ', ' Gujarat', '1956-02-05', 'Widdraw', 1000000, 0),
(45, 'dasda', 'sda', '2024-12-26', 'Deposit', 10000, 200),
(57, 'asdas', 'dasda', '2024-04-02', 'Current', 681, 16),
(66, 'qarq90', 'bombay central', '2005-01-17', 'Deposit', 750000, 7500000),
(1233, 'asdasd', 'adasd', '2024-07-03', 'Savings', 681, 651),
(1234, 'qarq90', 'asdkjasbdkjnaslj', '2024-10-23', 'Savings', 25555, 16815);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bank`
--
ALTER TABLE `bank`
  ADD PRIMARY KEY (`custID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bank`
--
ALTER TABLE `bank`
  MODIFY `custID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1235;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
