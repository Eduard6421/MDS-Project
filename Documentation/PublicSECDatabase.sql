-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: publicsec
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `User_Name` varchar(225) DEFAULT NULL,
  `User_Password` varchar(225) DEFAULT NULL,
  `Address` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'NumeClient1','PrenumeClient1','client1','parolaclient1','Strada Clientului Nr.7','0711223344','client@hotmail.com'),(2,'NumeClient1','PrenumeClient2','client2','parolaclient2','Strada Clientului nr 2','07112234','client2@hotmail.com'),(3,'NumeClient3','PrenumeClient3','client3','parolaclient3','Strada Clientului nr 3','04112341','client3@hotmail.com'),(19,'1','1','1','1','1','1','1');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_contract`
--

DROP TABLE IF EXISTS `client_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client_contract` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Company` int(11) NOT NULL,
  `ID_Client` int(11) NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Company_Foreign_Key_idx` (`ID_Company`),
  KEY `Client_Foreign_Key_idx` (`ID_Client`),
  CONSTRAINT `Client_Foreign_Key` FOREIGN KEY (`ID_Client`) REFERENCES `client` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Company_Foreign_Key` FOREIGN KEY (`ID_Company`) REFERENCES `company` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_contract`
--

LOCK TABLES `client_contract` WRITE;
/*!40000 ALTER TABLE `client_contract` DISABLE KEYS */;
INSERT INTO `client_contract` VALUES (1,1,1,'2011-02-02','2012-02-02'),(2,1,2,'2012-02-03','2014-02-02');
/*!40000 ALTER TABLE `client_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  `Contract_Start_Date` date NOT NULL,
  `Contract_End_Date` date NOT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `User_Name` varchar(225) DEFAULT NULL,
  `User_Password` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (1,'Firma1','2011-04-02','2012-04-02','asd','firma1','parola1'),(2,'Firma2','2012-04-05','2014-05-12','asd1','firma2','parola2');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `User_Name` varchar(225) DEFAULT NULL,
  `User_Password` varchar(225) DEFAULT NULL,
  `First_Name` varchar(50) NOT NULL,
  `Last_Name` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Rating` double(4,3) NOT NULL DEFAULT '0.000',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'employee','passemployee1','employee1','employee1','0123012312','employee1@hotmail.com',0.000),(2,'employee','passemployee2','employee2','employee2','012312313','employee2@hotmail.com',0.000);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_contract`
--

DROP TABLE IF EXISTS `employee_contract`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee_contract` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Company` int(11) NOT NULL,
  `ID_Employee` int(11) NOT NULL,
  `Start_Date` date NOT NULL,
  `End_Date` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `Foreign_Key_Company_idx` (`ID_Company`),
  KEY `Foreign_Key_Employee_idx` (`ID_Employee`),
  CONSTRAINT `Foreign_Key_Company` FOREIGN KEY (`ID_Company`) REFERENCES `company` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Foreign_Key_Employee` FOREIGN KEY (`ID_Employee`) REFERENCES `employee` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_contract`
--

LOCK TABLES `employee_contract` WRITE;
/*!40000 ALTER TABLE `employee_contract` DISABLE KEYS */;
INSERT INTO `employee_contract` VALUES (1,1,1,'2010-02-02','2012-02-02'),(2,2,2,'2011-02-02','2011-02-01');
/*!40000 ALTER TABLE `employee_contract` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetings`
--

DROP TABLE IF EXISTS `meetings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meetings` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Client` int(11) NOT NULL,
  `ID_Employee` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Feedback` int(11) DEFAULT NULL,
  `Description` mediumtext,
  PRIMARY KEY (`ID`),
  KEY `Foreign_Key_Client_idx` (`ID_Client`),
  KEY `Foreign_Key_Employee_idx` (`ID_Employee`),
  CONSTRAINT `Foreign_Key_Client1` FOREIGN KEY (`ID_Client`) REFERENCES `client` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Foreign_Key_Employee1` FOREIGN KEY (`ID_Employee`) REFERENCES `company` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetings`
--

LOCK TABLES `meetings` WRITE;
/*!40000 ALTER TABLE `meetings` DISABLE KEYS */;
INSERT INTO `meetings` VALUES (1,1,1,'2010-01-01',5,'da'),(2,1,2,'2010-04-02',3,'nu');
/*!40000 ALTER TABLE `meetings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reports`
--

DROP TABLE IF EXISTS `reports`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reports` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Meeting` int(11) NOT NULL,
  `Description` text,
  PRIMARY KEY (`ID`),
  KEY `Foreign_Key_Meeting_idx` (`ID_Meeting`),
  CONSTRAINT `Foreign_Key_Meeting` FOREIGN KEY (`ID_Meeting`) REFERENCES `meetings` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
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

-- Dump completed on 2018-05-10  0:51:01
