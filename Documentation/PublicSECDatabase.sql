-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 17, 2018 at 06:27 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `publicsec`
--

-- --------------------------------------------------------

--
-- Table structure for table `clients`
--

CREATE TABLE `clients` (
  `Id` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Username` varchar(225) DEFAULT NULL,
  `Password` varchar(225) DEFAULT NULL,
  `Address` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `clients`
--

INSERT INTO `clients` (`Id`, `FirstName`, `LastName`, `Username`, `Password`, `Address`, `Phone`, `Email`) VALUES
(1, 'NumeClient1', 'PrenumeClient1', 'client1', 'parolaclient1', 'Strada Clientului Nr.7', '0711223344', 'client@hotmail.com'),
(2, 'NumeClient1', 'PrenumeClient2', 'client2', 'parolaclient2', 'Strada Clientului nr 2', '07112234', 'client2@hotmail.com'),
(3, 'NumeClient3', 'PrenumeClient3', 'client3', 'parolaclient3', 'Strada Clientului nr 3', '04112341', 'client3@hotmail.com'),
(19, '1', '1', '1', '1', '1', '1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `client_contracts`
--

CREATE TABLE `client_contracts` (
  `Id` int(11) NOT NULL,
  `IdCompany` int(11) NOT NULL,
  `IdClient` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client_contracts`
--

INSERT INTO `client_contracts` (`Id`, `IdCompany`, `IdClient`, `StartDate`, `EndDate`) VALUES
(1, 1, 1, '2011-02-02', '2012-02-02'),
(2, 1, 2, '2012-02-03', '2014-02-02');

-- --------------------------------------------------------

--
-- Table structure for table `companies`
--

CREATE TABLE `companies` (
  `Id` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `ContractStartDate` date NOT NULL,
  `ContractEndDate` date NOT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `Username` varchar(225) DEFAULT NULL,
  `Password` varchar(225) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `companies`
--

INSERT INTO `companies` (`Id`, `Name`, `ContractStartDate`, `ContractEndDate`, `Description`, `Username`, `Password`) VALUES
(1, 'Firma1', '2011-04-02', '2012-04-02', 'asd', 'firma1', 'parola1'),
(2, 'Firma2', '2012-04-05', '2014-05-12', 'asd1', 'firma2', 'parola2');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `Id` int(11) NOT NULL,
  `Username` varchar(225) DEFAULT NULL,
  `Password` varchar(225) DEFAULT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Rating` double(4,3) NOT NULL DEFAULT '0.000'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`Id`, `Username`, `Password`, `FirstName`, `LastName`, `Phone`, `Email`, `Rating`) VALUES
(1, 'employee1', 'employee1', 'employee1', 'employee1', '0123012312', 'employee1@hotmail.com', 0.000),
(2, 'employee', 'passemployee2', 'employee2', 'employee2', '012312313', 'employee2@hotmail.com', 0.000);

-- --------------------------------------------------------

--
-- Table structure for table `employee_contracts`
--

CREATE TABLE `employee_contracts` (
  `Id` int(11) NOT NULL,
  `IdCompany` int(11) NOT NULL,
  `IdEmployee` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee_contracts`
--

INSERT INTO `employee_contracts` (`Id`, `IdCompany`, `IdEmployee`, `StartDate`, `EndDate`) VALUES
(1, 1, 1, '2010-02-02', '2012-02-02'),
(2, 2, 2, '2011-02-02', '2011-02-01');

-- --------------------------------------------------------

--
-- Table structure for table `meetings`
--

CREATE TABLE `meetings` (
  `Id` int(11) NOT NULL,
  `IdClient` int(11) NOT NULL,
  `IdEmployee` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Feedback` int(11) DEFAULT NULL,
  `Description` mediumtext,
  `IsOpen` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `meetings`
--

INSERT INTO `meetings` (`Id`, `IdClient`, `IdEmployee`, `Date`, `Feedback`, `Description`, `IsOpen`) VALUES
(1, 1, 1, '2010-01-01', 5, 'da', 1),
(2, 1, 2, '2010-04-02', 3, 'nu', 1);

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `Id` int(11) NOT NULL,
  `IdMeeting` int(11) NOT NULL,
  `Description` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reports`
--

INSERT INTO `reports` (`Id`, `IdMeeting`, `Description`) VALUES
(1, 1, 'solved'),
(2, 1, 'solv3d');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `client_contracts`
--
ALTER TABLE `client_contracts`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Company_Foreign_Key_idx` (`IdCompany`),
  ADD KEY `Client_Foreign_Key_idx` (`IdClient`);

--
-- Indexes for table `companies`
--
ALTER TABLE `companies`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`Id`);

--
-- Indexes for table `employee_contracts`
--
ALTER TABLE `employee_contracts`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Foreign_Key_Company_idx` (`IdCompany`),
  ADD KEY `Foreign_Key_Employee_idx` (`IdEmployee`);

--
-- Indexes for table `meetings`
--
ALTER TABLE `meetings`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Foreign_Key_Client_idx` (`IdClient`),
  ADD KEY `Foreign_Key_Employee_idx` (`IdEmployee`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `Foreign_Key_Meeting_idx` (`IdMeeting`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `clients`
--
ALTER TABLE `clients`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `client_contracts`
--
ALTER TABLE `client_contracts`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `companies`
--
ALTER TABLE `companies`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employee_contracts`
--
ALTER TABLE `employee_contracts`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `meetings`
--
ALTER TABLE `meetings`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `client_contracts`
--
ALTER TABLE `client_contracts`
  ADD CONSTRAINT `Client_Foreign_Key` FOREIGN KEY (`IdClient`) REFERENCES `clients` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Company_Foreign_Key` FOREIGN KEY (`IdCompany`) REFERENCES `companies` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `employee_contracts`
--
ALTER TABLE `employee_contracts`
  ADD CONSTRAINT `Foreign_Key_Company` FOREIGN KEY (`IdCompany`) REFERENCES `companies` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Foreign_Key_Employee` FOREIGN KEY (`IdEmployee`) REFERENCES `employees` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `meetings`
--
ALTER TABLE `meetings`
  ADD CONSTRAINT `Foreign_Key_Client1` FOREIGN KEY (`IdClient`) REFERENCES `clients` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Foreign_Key_Employee1` FOREIGN KEY (`IdEmployee`) REFERENCES `companies` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `reports`
--
ALTER TABLE `reports`
  ADD CONSTRAINT `Foreign_Key_Meeting` FOREIGN KEY (`IdMeeting`) REFERENCES `meetings` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
