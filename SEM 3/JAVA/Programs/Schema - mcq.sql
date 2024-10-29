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
-- Table structure for table `mcq`
--

CREATE TABLE `mcq` (
  `id` int(11) NOT NULL,
  `question` varchar(255) NOT NULL,
  `option1` varchar(255) NOT NULL,
  `option2` varchar(255) NOT NULL,
  `option3` varchar(255) NOT NULL,
  `option4` varchar(255) NOT NULL,
  `correct_answer` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mcq`
--

INSERT INTO `mcq` (`id`, `question`, `option1`, `option2`, `option3`, `option4`, `correct_answer`) VALUES
(1, 'Which of these is a fundamental data type in Java?', 'String', 'int', 'Class', 'Interface', 2),
(2, 'What is the size of an int variable in Java?', '2 bytes', '4 bytes', '8 bytes', '16 bytes', 2),
(3, 'Which keyword is used to prevent a method from being overridden in Java?', 'private', 'final', 'static', 'volatile', 2),
(4, 'What is the default value of a boolean variable in Java?', 'true', 'false', '0', 'null', 2),
(5, 'Which of the following is not an access modifier in Java?', 'public', 'protected', 'void', 'private', 3),
(6, 'Which method is called when an object is garbage collected?', 'finalize()', 'dispose()', 'destroy()', 'delete()', 1),
(7, 'What is the default package imported in every Java program?', 'java.util', 'java.io', 'java.lang', 'java.net', 3),
(8, 'Which of these operators is used for string concatenation?', '+', '*', '++', '&', 1),
(9, 'Which method must be implemented by a class implementing the Runnable interface?', 'run()', 'start()', 'execute()', 'begin()', 1),
(10, 'Which of the following is not a feature of Java?', 'Object-Oriented', 'Platform-Independent', 'Pointer-based', 'Robust', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mcq`
--
ALTER TABLE `mcq`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mcq`
--
ALTER TABLE `mcq`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
