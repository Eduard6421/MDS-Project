CREATE TABLE `Clients` (
	`ID` bigint NOT NULL,
	`First_Name` varchar NOT NULL,
	`Last_Name` varchar NOT NULL,
	`User_Name` varchar NOT NULL,
	`User_Password` varchar NOT NULL,
	`Address` varchar NOT NULL,
	`Phone` varchar NOT NULL,
	`Email` varchar,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Company` (
	`ID` int NOT NULL,
	`Name` varchar NOT NULL,
	`Contract_Start_Date` DATE NOT NULL,
	`Contract_End_Date` DATE NOT NULL,
	`Description` varchar,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Employee` (
	`ID` int NOT NULL,
	`Username` varchar NOT NULL,
	`Password` varchar NOT NULL,
	`First_Name` varchar NOT NULL,
	`Last_Name` varchar NOT NULL,
	`Phone` varchar NOT NULL,
	`Email` varchar NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Client_Contract` (
	`ID` int NOT NULL,
	`ID_Company`  NOT NULL,
	`ID_Client`  NOT NULL,
	`Start_Date` DATE NOT NULL,
	`End_Date` DATE NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Employee_Contract` (
	`ID` int NOT NULL,
	`ID_Company`  NOT NULL,
	`ID_Employee`  NOT NULL,
	`Start_Date` DATE NOT NULL,
	`End_Date` DATE NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Meetings` (
	`ID` bigint NOT NULL,
	`ID_Client`  NOT NULL,
	`ID_Employee`  NOT NULL,
	`Date` DATE NOT NULL,
	`Feedback` int,
	`Description` mediumtext,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Reports` (
	`ID` bigint NOT NULL,
	`ID_Meeting`  NOT NULL,
	`Description` TEXT,
	PRIMARY KEY (`ID`)
);

ALTER TABLE `Client_Contract` ADD CONSTRAINT `Client_Contract_fk0` FOREIGN KEY (`ID_Company`) REFERENCES `Company`(`ID`);

ALTER TABLE `Client_Contract` ADD CONSTRAINT `Client_Contract_fk1` FOREIGN KEY (`ID_Client`) REFERENCES `Clients`(`ID`);

ALTER TABLE `Employee_Contract` ADD CONSTRAINT `Employee_Contract_fk0` FOREIGN KEY (`ID_Company`) REFERENCES `Company`(`ID`);

ALTER TABLE `Employee_Contract` ADD CONSTRAINT `Employee_Contract_fk1` FOREIGN KEY (`ID_Employee`) REFERENCES `Employee`(`ID`);

ALTER TABLE `Meetings` ADD CONSTRAINT `Meetings_fk0` FOREIGN KEY (`ID_Client`) REFERENCES `Clients`(`ID`);

ALTER TABLE `Meetings` ADD CONSTRAINT `Meetings_fk1` FOREIGN KEY (`ID_Employee`) REFERENCES `Employee`(`ID`);

ALTER TABLE `Reports` ADD CONSTRAINT `Reports_fk0` FOREIGN KEY (`ID_Meeting`) REFERENCES `Meetings`(`ID`);

