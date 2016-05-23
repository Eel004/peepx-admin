-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2016 at 06:14 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `league`
--

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE IF NOT EXISTS `player` (
  `PLAYER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEAM_ID` int(11) NOT NULL,
  `FIRST_NAME` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `LAST_NAME` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `POSITION` varchar(3) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `ADDRESS` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `PHONE_NO` varchar(12) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `EMAIL` varchar(50) COLLATE utf8mb4_vietnamese_ci DEFAULT NULL,
  `BIRTHDAY` date DEFAULT NULL,
  PRIMARY KEY (`PLAYER_ID`),
  KEY `FKC53E9AE1CFAC35F7` (`TEAM_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`PLAYER_ID`, `TEAM_ID`, `FIRST_NAME`, `LAST_NAME`, `POSITION`, `ADDRESS`, `PHONE_NO`, `EMAIL`, `BIRTHDAY`) VALUES
(1, 2, 'Jammie', 'Vardy', 'CF', 'Leicester', '', 'luonguc93@gmail.com', '2016-05-09'),
(3, 2, 'Wes', 'Morgan', 'CB', 'Leicester', '', 'wes.morgan@gmail.com', '1984-05-16'),
(5, 1, 'Mesut', 'Ozil', 'AFM', 'Berlin', '01232338123', 'me.ozil@gmail.com', '1984-05-16'),
(8, 3, 'Eden', 'Hazard', 'RW', 'Chelsea', '', '', '1993-05-05');

-- --------------------------------------------------------

--
-- Table structure for table `position`
--

CREATE TABLE IF NOT EXISTS `position` (
  `pid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `description` varchar(256) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci AUTO_INCREMENT=19 ;

--
-- Dumping data for table `position`
--

INSERT INTO `position` (`pid`, `pname`, `description`) VALUES
(1, 'CF', ''),
(2, 'LW', ''),
(3, 'SS', ''),
(4, 'RW', ''),
(5, 'AM', ''),
(6, 'LM', ''),
(7, 'CM', ''),
(8, 'LFM', ''),
(9, 'AFM', ''),
(10, 'RFM', ''),
(11, 'RM', ''),
(12, 'DM', ''),
(13, 'LWB', ''),
(14, 'RWB', ''),
(15, 'LB', ''),
(16, 'CB', ''),
(17, 'SW', ''),
(18, 'GK', '');

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE IF NOT EXISTS `team` (
  `TEAM_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TEAM_NAME` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `LEAGUE_1` varchar(2) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `LEAGUE_2` varchar(2) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`TEAM_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci AUTO_INCREMENT=21 ;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`TEAM_ID`, `TEAM_NAME`, `LEAGUE_1`, `LEAGUE_2`) VALUES
(1, 'Arsenal', 'Y', 'N'),
(2, 'Leicester City', 'Y', 'N'),
(3, 'Chelsea', 'Y', 'N'),
(4, 'Manchester United', 'Y', 'N'),
(5, 'Manchester City', 'Y', 'N'),
(6, 'Liverpool', 'Y', 'N'),
(7, 'Westham United', 'Y', 'N'),
(8, 'Everton', 'Y', 'N'),
(9, 'Norwich city', 'Y', 'N'),
(10, 'Sunderland', 'Y', 'N'),
(11, 'Stoke city', 'Y', 'N'),
(12, 'Aston villa', 'Y', 'N'),
(13, 'Newcastle', 'Y', 'N'),
(14, 'Crytal palace', 'Y', 'N'),
(15, 'Southampton', 'Y', 'N'),
(16, 'Swansea city', 'Y', 'N'),
(17, 'Watlford', 'Y', 'N'),
(18, 'West Bromwich Albion', 'Y', 'N'),
(19, 'Tottenham Hotspur', 'Y', 'N'),
(20, 'AFC Bournemouth', 'Y', 'N');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(45) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`) VALUES
('alex', '123456', 1),
('mkyong', '123456', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE IF NOT EXISTS `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `role` varchar(45) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`role`,`username`),
  KEY `fk_username_idx` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`user_role_id`, `username`, `role`) VALUES
(2, 'mkyong', 'ROLE_ADMIN'),
(3, 'alex', 'ROLE_USER'),
(1, 'mkyong', 'ROLE_USER');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `player`
--
ALTER TABLE `player`
  ADD CONSTRAINT `FKC53E9AE1CFAC35F7` FOREIGN KEY (`TEAM_ID`) REFERENCES `team` (`TEAM_ID`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
