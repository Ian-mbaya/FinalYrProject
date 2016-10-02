-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2016 at 05:29 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `myproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `doctors`
--

CREATE TABLE IF NOT EXISTS `doctors` (
  `Doc_No` varchar(10) NOT NULL,
  `Fname` char(50) NOT NULL,
  `Lname` char(50) NOT NULL,
  `ID_No` int(8) NOT NULL,
  `Date_Employed` text NOT NULL,
  `Gender` enum('Male','Female') NOT NULL,
  `Specialization` enum('diabetes','body fitness','asthma','allergies') NOT NULL,
  `Phone_Number` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctors`
--

INSERT INTO `doctors` (`Doc_No`, `Fname`, `Lname`, `ID_No`, `Date_Employed`, `Gender`, `Specialization`, `Phone_Number`) VALUES
('DOC100', 'Pius', 'Muriithi', 31878566, ' 2016/09/27', 'Male', 'allergies', '0721886636');

-- --------------------------------------------------------

--
-- Table structure for table `doc_msgs`
--

CREATE TABLE IF NOT EXISTS `doc_msgs` (
  `Msg_id` varchar(100) NOT NULL,
  `Phone_Number` varchar(14) NOT NULL,
  `Msg` varchar(1000) NOT NULL,
  `Cost` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `patients`
--

CREATE TABLE IF NOT EXISTS `patients` (
  `Patient_No` varchar(10) NOT NULL,
  `Fname` char(50) NOT NULL,
  `Lname` char(50) NOT NULL,
  `DOB` date NOT NULL,
  `Gender` enum('Male','Female') NOT NULL,
  `Phone_Number` varchar(14) NOT NULL,
  `Area_of_Residence` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patients`
--

INSERT INTO `patients` (`Patient_No`, `Fname`, `Lname`, `DOB`, `Gender`, `Phone_Number`, `Area_of_Residence`) VALUES
('PN098', 'Mark', 'Zuckerburg', '2016-09-01', 'Male', '0732564234', 'CA');

-- --------------------------------------------------------

--
-- Table structure for table `p_messages`
--

CREATE TABLE IF NOT EXISTS `p_messages` (
  `Msg_id` varchar(100) NOT NULL,
  `Phone_No` varchar(14) NOT NULL,
  `Msg` varchar(1000) NOT NULL,
  `Cost` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `treatment`
--

CREATE TABLE IF NOT EXISTS `treatment` (
  `Doc_No` varchar(10) NOT NULL,
  `Patient_No` varchar(10) NOT NULL,
  `Disease` enum('diabetes','body fitness','asthma','allergies') NOT NULL,
  `Description` text NOT NULL,
  `Recommendation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `treatment`
--

INSERT INTO `treatment` (`Doc_No`, `Patient_No`, `Disease`, `Description`, `Recommendation`) VALUES
('DOC100', 'PN098', 'allergies', 'Body allergy', 'Stop using body lortions');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `Emp_No` varchar(10) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Emp_No`, `Email`, `Password`) VALUES
('DOC100', 'piuswanjiru1@gmail.com', 'Sheldon254#}');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `doctors`
--
ALTER TABLE `doctors`
 ADD PRIMARY KEY (`Doc_No`), ADD UNIQUE KEY `Phone_Number` (`Phone_Number`), ADD UNIQUE KEY `ID_No` (`ID_No`);

--
-- Indexes for table `doc_msgs`
--
ALTER TABLE `doc_msgs`
 ADD PRIMARY KEY (`Msg_id`,`Phone_Number`), ADD KEY `Phone_Number` (`Phone_Number`);

--
-- Indexes for table `patients`
--
ALTER TABLE `patients`
 ADD PRIMARY KEY (`Patient_No`);

--
-- Indexes for table `p_messages`
--
ALTER TABLE `p_messages`
 ADD PRIMARY KEY (`Msg_id`,`Phone_No`);

--
-- Indexes for table `treatment`
--
ALTER TABLE `treatment`
 ADD PRIMARY KEY (`Doc_No`,`Patient_No`), ADD KEY `Patient_No` (`Patient_No`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`Emp_No`), ADD UNIQUE KEY `Email` (`Email`,`Password`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `doc_msgs`
--
ALTER TABLE `doc_msgs`
ADD CONSTRAINT `doc_msgs_ibfk_1` FOREIGN KEY (`Phone_Number`) REFERENCES `doctors` (`Phone_Number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `treatment`
--
ALTER TABLE `treatment`
ADD CONSTRAINT `treatment_ibfk_1` FOREIGN KEY (`Doc_No`) REFERENCES `doctors` (`Doc_No`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `treatment_ibfk_2` FOREIGN KEY (`Patient_No`) REFERENCES `patients` (`Patient_No`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`Emp_No`) REFERENCES `doctors` (`Doc_No`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
