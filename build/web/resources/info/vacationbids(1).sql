-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 13, 2011 at 08:42 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

--
-- Database: 'vacation'
--
Drop database if exists vacation;
create database vacation;
use vacation;
-- --------------------------------------------------------

--
-- Table structure for table 'bid'
--

CREATE TABLE IF NOT EXISTS bid (
  bidID int(11) NOT NULL AUTO_INCREMENT,
  userID varchar(5) NOT NULL,
  destination char(1) NOT NULL,
  deptdate date NOT NULL,
  bidAmt decimal(6,2) NOT NULL,
  PRIMARY KEY (bidID)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=23 ;

--
-- Dumping data for table 'bid'
--

INSERT INTO bid (bidID, userID, destination, deptdate, bidAmt) VALUES
(1, 'A6576', 'A', '2012-08-10', 2300.00),
(2, 'B4533', 'F', '2012-08-14', 700.00),
(3, 'A6576', 'A', '2012-08-10', 2300.00),
(4, 'B4533', 'F', '2012-08-14', 700.00),
(5, 'C111', 'S', '2012-08-03', 1200.00),
(6, 'D4534', 'S', '2012-08-21', 1430.00),
(7, 'A1212', 'A', '2012-08-19', 2250.00),
(8, 'B7687', 'F', '2012-08-14', 650.00),
(9, 'A4333', 'F', '2012-08-11', 745.00),
(10, 'B8987', 'F', '2012-08-20', 699.00),
(11, 'E888', 'A', '2012-08-10', 1900.00),
(12, 'G1211', 'A', '2012-08-12', 700.00),
(13, 'Y999', 'S', '2012-08-07', 1250.00),
(14, 'Q985', 'S', '2012-08-08', 1650.00),
(15, 'H111', 'S', '2012-08-10', 1550.00),
(16, 'J9080', 'F', '2012-08-20', 530.00),
(17, 'D877', 'A', '2012-08-15', 2175.00),
(18, 'F3433', 'A', '2012-08-14', 2315.00),
(19, 'K111', 'F', '2012-08-03', 685.00),
(20, 'B4533', 'S', '2012-08-16', 1325.00),
(21, 'A6576', 'S', '2012-08-17', 1200.00),
(22, 'Z566', 'S', '2012-08-14', 1150.00);


