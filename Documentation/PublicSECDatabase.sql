-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: publicsec
-- ------------------------------------------------------
-- Server version	5.7.21-log

DROP DATABASE IF EXISTS publicsec;
CREATE DATABASE publicsec;
use publicsec;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client_contracts`
--


DROP TABLE IF EXISTS `client_contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_contracts` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdCompany` int(11) NOT NULL,
  `IdClient` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Company_Foreign_Key_idx` (`IdCompany`),
  KEY `Client_Foreign_Key_idx` (`IdClient`),
  CONSTRAINT `Client_Foreign_Key` FOREIGN KEY (`IdClient`) REFERENCES `clients` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Company_Foreign_Key` FOREIGN KEY (`IdCompany`) REFERENCES `companies` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_contracts`
--

LOCK TABLES `client_contracts` WRITE;
/*!40000 ALTER TABLE `client_contracts` DISABLE KEYS */;
INSERT INTO `client_contracts` VALUES (1,1,1,'2011-02-02','2012-02-02'),(2,1,2,'2012-02-03','2014-02-02');
/*!40000 ALTER TABLE `client_contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clients` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Username` varchar(225) DEFAULT NULL,
  `Password` varchar(225) DEFAULT NULL,
  `Address` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'NumeClient1','PrenumeClient1','client1','parolaclient1','Strada Clientului Nr.7','0711223344','client@hotmail.com'),(2,'NumeClient1','PrenumeClient2','client2','parolaclient2','Strada Clientului nr 2','07112234','client2@hotmail.com'),(3,'NumeClient3','PrenumeClient3','client3','parolaclient3','Strada Clientului nr 3','04112341','client3@hotmail.com'),(19,'1','1','1','1','1','1','1');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companies`
--

DROP TABLE IF EXISTS `companies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `companies` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `ContractStartDate` date NOT NULL,
  `ContractEndDate` date NOT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `Username` varchar(225) DEFAULT NULL,
  `Password` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companies`
--

LOCK TABLES `companies` WRITE;
/*!40000 ALTER TABLE `companies` DISABLE KEYS */;
INSERT INTO `companies` VALUES (1,'Firma1','2011-04-02','2012-04-02','asd','firma1','parola1'),(2,'Firma2','2012-04-05','2014-05-12','asd1','firma2','parola2');
/*!40000 ALTER TABLE `companies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_contracts`
--

DROP TABLE IF EXISTS `employee_contracts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_contracts` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdCompany` int(11) NOT NULL,
  `IdEmployee` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `Foreign_Key_Company_idx` (`IdCompany`),
  KEY `Foreign_Key_Employee_idx` (`IdEmployee`),
  CONSTRAINT `Foreign_Key_Company` FOREIGN KEY (`IdCompany`) REFERENCES `companies` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Foreign_Key_Employee` FOREIGN KEY (`IdEmployee`) REFERENCES `employees` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_contracts`
--

LOCK TABLES `employee_contracts` WRITE;
/*!40000 ALTER TABLE `employee_contracts` DISABLE KEYS */;
INSERT INTO `employee_contracts` VALUES (1,1,1,'2010-02-02','2012-02-02'),(2,2,2,'2011-02-02','2011-02-01');
/*!40000 ALTER TABLE `employee_contracts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS `employees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employees` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(225) DEFAULT NULL,
  `Password` varchar(225) DEFAULT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Rating` double(4,3) NOT NULL DEFAULT '0.000',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employees`
--

LOCK TABLES `employees` WRITE;
/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` VALUES (1,'employee1','employee1','employee1','employee1','0123012312','employee1@hotmail.com',0.000),(2,'employee','passemployee2','employee2','employee2','012312313','employee2@hotmail.com',0.000);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetings`
--

DROP TABLE IF EXISTS `meetings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meetings` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdClient` int(11) NOT NULL,
  `IdCompany` int(11) NOT NULL,
  `IdEmployee` int(11) DEFAULT NULL,
  `Date` date NOT NULL,
  `Feedback` double(4,2) DEFAULT NULL,
  `Description` mediumtext,
  `IsOpen` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`Id`),
  KEY `Foreign_Key_Client_idx` (`IdClient`),
  KEY `Foreign_Key_Employee_idx` (`IdEmployee`),
  CONSTRAINT `Foreign_Key_Client1` FOREIGN KEY (`IdClient`) REFERENCES `clients` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Foreign_Key_Employee1` FOREIGN KEY (`IdEmployee`) REFERENCES `employees` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetings`
--

LOCK TABLES `meetings` WRITE;
/*!40000 ALTER TABLE `meetings` DISABLE KEYS */;
INSERT INTO `meetings` VALUES (1,1,1,1,'2010-01-01',5.00,'da',1),(2,1,2,2,'2010-04-02',3.00,'nu',1);
/*!40000 ALTER TABLE `meetings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notifications` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ClientId` int(11) DEFAULT NULL,
  `EmployeeId` int(11) DEFAULT NULL,
  `MeetingId` int(11) NOT NULL,
  `NotifyClient` tinyint(1) DEFAULT NULL,
  `NotifyEmployee` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `meetingsforeignkey_idx` (`MeetingId`),
  KEY `employeesforeignkey_idx` (`EmployeeId`),
  KEY `clientsforeignkey_idx` (`ClientId`),
  CONSTRAINT `clientsforeignkey` FOREIGN KEY (`ClientId`) REFERENCES `clients` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `employeesforeignkey` FOREIGN KEY (`EmployeeId`) REFERENCES `employees` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `meetingsforeignkey` FOREIGN KEY (`MeetingId`) REFERENCES `meetings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,1,1,1,1,1);
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reports` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdMeeting` int(11) NOT NULL,
  `Description` text,
  PRIMARY KEY (`Id`),
  KEY `Foreign_Key_Meeting_idx` (`IdMeeting`),
  CONSTRAINT `Foreign_Key_Meeting` FOREIGN KEY (`IdMeeting`) REFERENCES `meetings` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reports`
--

LOCK TABLES `reports` WRITE;
/*!40000 ALTER TABLE `reports` DISABLE KEYS */;
INSERT INTO `reports` VALUES (1,1,'solved'),(2,1,'solv3d');
/*!40000 ALTER TABLE `reports` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-03  1:16:17
