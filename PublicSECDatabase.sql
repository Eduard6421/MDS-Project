CREATE TABLE `Clients` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`First_Name` varchar NOT NULL AUTO_INCREMENT,
	`Last_Name` varchar NOT NULL AUTO_INCREMENT,
	`User_Name` varchar NOT NULL AUTO_INCREMENT,
	`User_Password` varchar NOT NULL AUTO_INCREMENT,
	`Address` varchar NOT NULL AUTO_INCREMENT,
	`Phone` varchar NOT NULL AUTO_INCREMENT,
	`Email` varchar AUTO_INCREMENT,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Company` (
	`ID` int NOT NULL AUTO_INCREMENT,
	`Name` varchar NOT NULL AUTO_INCREMENT,
	`Contract_Start_Date` DATE NOT NULL AUTO_INCREMENT,
	`Contract_End_Date` DATE NOT NULL AUTO_INCREMENT,
	`Description` varchar AUTO_INCREMENT,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Employee` (
	`ID` int NOT NULL AUTO_INCREMENT,
	`Username` varchar NOT NULL AUTO_INCREMENT,
	`Password` varchar NOT NULL AUTO_INCREMENT,
	`First_Name` varchar NOT NULL AUTO_INCREMENT,
	`Last_Name` varchar NOT NULL AUTO_INCREMENT,
	`Phone` varchar NOT NULL AUTO_INCREMENT,
	`Email` varchar NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Client_Contract` (
	`ID` int NOT NULL AUTO_INCREMENT,
	`ID_Client` int NOT NULL AUTO_INCREMENT,
	`ID_Company` int NOT NULL AUTO_INCREMENT,
	`Start_Date` DATE NOT NULL,
	`End_Date` DATE NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Employee_Contract` (
	`ID` int NOT NULL AUTO_INCREMENT,
	`ID_Company` int NOT NULL AUTO_INCREMENT,
	`ID_Employee` int NOT NULL AUTO_INCREMENT,
	`Start_Date` DATE NOT NULL,
	`End_Date` DATE NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Logs` (
	`ID` bigint NOT NULL AUTO_INCREMENT,
	`ID_Client` int NOT NULL,
	`ID_Employee` int NOT NULL,
	`Date` DATE NOT NULL,
	`Feedback` int,
	`Description` mediumtext,
	PRIMARY KEY (`ID`)
);

ALTER TABLE `Client_Contract` ADD CONSTRAINT `Client_Contract_fk0` FOREIGN KEY (`ID_Client`) REFERENCES `Clients`(`ID`);

ALTER TABLE `Client_Contract` ADD CONSTRAINT `Client_Contract_fk1` FOREIGN KEY (`ID_Company`) REFERENCES `Company`(`ID`);

ALTER TABLE `Employee_Contract` ADD CONSTRAINT `Employee_Contract_fk0` FOREIGN KEY (`ID_Company`) REFERENCES `Company`(`ID`);

ALTER TABLE `Employee_Contract` ADD CONSTRAINT `Employee_Contract_fk1` FOREIGN KEY (`ID_Employee`) REFERENCES `Employee`(`ID`);

ALTER TABLE `Logs` ADD CONSTRAINT `Logs_fk0` FOREIGN KEY (`ID_Client`) REFERENCES `Clients`(`ID`);

ALTER TABLE `Logs` ADD CONSTRAINT `Logs_fk1` FOREIGN KEY (`ID_Employee`) REFERENCES `Employee`(`ID`);

