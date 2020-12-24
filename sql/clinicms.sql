-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 24, 2020 at 05:28 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clinicms`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctorr`
--

CREATE TABLE `doctorr` (
  `id` int(10) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `age` int(2) NOT NULL,
  `gender` char(10) NOT NULL,
  `department` varchar(10) NOT NULL,
  `wardno` int(2) NOT NULL,
  `pnum` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctorr`
--

INSERT INTO `doctorr` (`id`, `fname`, `lname`, `age`, `gender`, `department`, `wardno`, `pnum`) VALUES
(4, 'fhnfgh', 'fghf', 55, 'Female', 'Dental', 45, 5457),
(8, 'bnv', 'vm', 20, 'Male', 'Dental', 52, 20508);

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

CREATE TABLE `notice` (
  `id` int(50) NOT NULL,
  `message` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`id`, `message`) VALUES
(1, 'fjjyjf'),
(2, 'fjtyktyikyuotuolyll; fyktoyoo68y ulyuolyu'),
(3, 'fgbfyjfjyg,b,h,j.shsystymhguhl');

-- --------------------------------------------------------

--
-- Table structure for table `pationt`
--

CREATE TABLE `pationt` (
  `id` int(100) NOT NULL,
  `fname` varchar(20) NOT NULL,
  `lname` varchar(20) NOT NULL,
  `age` int(3) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `address` varchar(100) NOT NULL,
  `maritial` varchar(15) NOT NULL,
  `phonenumber` int(15) NOT NULL,
  `disease` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pationt`
--

INSERT INTO `pationt` (`id`, `fname`, `lname`, `age`, `gender`, `address`, `maritial`, `phonenumber`, `disease`) VALUES
(2, 'Mahesh', 'abeykoon', 20, 'Male', 'Colombo, Sri Lanka', 'Married', 75782, 'asdfghjk'),
(4, 'tugjgj', 'utftjyj', 20, 'Male', 'hftutyu, fgjyty,gugyu', 'Divorced', 205252, 'asdfgh'),
(6, 'asdf', 'sdf', 20, 'Female', 'fhtffk,dhtut,fjyy', 'Married', 7567683, 'zsghfjj'),
(8, 'gh', 'bf', 20, 'Male', 'rtdry', 'Select Item', 252, '525'),
(9, 'mahesh', 'sfaf', 20, 'Male', 'dyydy', 'Select Item', 75861286, 'szfhshs');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctorr`
--
ALTER TABLE `doctorr`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notice`
--
ALTER TABLE `notice`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pationt`
--
ALTER TABLE `pationt`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctorr`
--
ALTER TABLE `doctorr`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `notice`
--
ALTER TABLE `notice`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `pationt`
--
ALTER TABLE `pationt`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
