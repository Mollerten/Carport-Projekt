CREATE DATABASE  IF NOT EXISTS `carport` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carport`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 188.166.163.22    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `city` varchar(45) NOT NULL,
  `postal_code` varchar(45) NOT NULL,
  PRIMARY KEY (`city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('Rønne','3700');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `request_id` int NOT NULL AUTO_INCREMENT,
  `length_cp` int NOT NULL,
  `width_cp` int NOT NULL,
  `length_rr` int NOT NULL,
  `width_rr` int NOT NULL,
  `roof_mat` varchar(255) NOT NULL,
  `wood_cladding_mat` varchar(255) NOT NULL,
  `total_price` double DEFAULT NULL,
  `customer_id` int NOT NULL,
  `admin_id` int DEFAULT NULL,
  PRIMARY KEY (`request_id`),
  KEY `fk_design_roof1_idx` (`roof_mat`),
  KEY `fk_design_bekledning1_idx` (`wood_cladding_mat`),
  KEY `fk_request_user2_idx` (`admin_id`),
  KEY `fk_request_user1_idx` (`customer_id`),
  CONSTRAINT `fk_design_roof1` FOREIGN KEY (`roof_mat`) REFERENCES `roof` (`roof_mat`),
  CONSTRAINT `fk_design_wood_cladding1` FOREIGN KEY (`wood_cladding_mat`) REFERENCES `wood_cladding` (`wood_cladding_mat`),
  CONSTRAINT `fk_request_user1` FOREIGN KEY (`customer_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `fk_request_user2` FOREIGN KEY (`admin_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (4,780,600,0,0,'not_yet_implemented','not_yet_implemented',NULL,8,NULL),(5,600,570,0,0,'not_yet_implemented','not_yet_implemented',NULL,9,NULL),(6,570,510,0,0,'not_yet_implemented','not_yet_implemented',NULL,11,NULL),(7,720,360,0,0,'not_yet_implemented','not_yet_implemented',NULL,12,NULL);
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roof`
--

DROP TABLE IF EXISTS `roof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roof` (
  `roof_mat` varchar(255) NOT NULL,
  `stock_id` bigint NOT NULL,
  PRIMARY KEY (`roof_mat`),
  KEY `fk_roof_stock1_idx` (`stock_id`),
  CONSTRAINT `fk_roof_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roof`
--

LOCK TABLES `roof` WRITE;
/*!40000 ALTER TABLE `roof` DISABLE KEYS */;
INSERT INTO `roof` VALUES ('not_yet_implemented',404);
/*!40000 ALTER TABLE `roof` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `stock_id` bigint NOT NULL,
  `description` varchar(255) NOT NULL,
  `length` int DEFAULT NULL,
  `unit` varchar(45) NOT NULL,
  `price_per_unit` double NOT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (404,'not_yet_implemented',0,'0',0),(1284952,'bræddebolt 10 x 120 mm.',0,'pak',359),(1376727,'4,5 x 60 mm. skruer 200 stk.',0,'pak',199),(1456929,'4,0 x 50 mm. beslagskruer 250 stk.',0,'pak',359),(1648781,'STALDDØRSGREB 50x75',0,'stk',259),(1721336,'4,5 x 50 mm. SKRUER 300stk.	',0,'pak',109),(1761618,'universal 190 mm.',0,'stk',34.95),(1913883,'T HÆNGSEL390mm',0,'stk',89.95),(2108358,'4,5 x 70mm. SKRUER 400stk.',0,'pak',199),(2777803,'firkantskiver 40x40x11mm',0,'stk',7.5),(3739893,'hulbånd 1x20 mm. 10 mtr.',10,'rulle',289),(5191091,'Plastmo Ecolite blåtonet',240,'stk',125),(5191092,'Plastmo Ecolite blåtonet',300,'stk',165),(5191094,'Plastmo Ecolite blåtonet',360,'stk',185),(5191095,'Plastmo Ecolite blåtonet',420,'stk',225),(5191096,'Plastmo Ecolite blåtonet',480,'stk',250),(5233176,'Plastmo Ecolite blåtonet',600,'stk',315),(5669996,'plastmo bundskruer 200 stk.',0,'pak',394.95),(10850251250300,'25x125mm. trykimp. Brædt',300,'stk',146.85),(10850251250360,'25x125mm. trykimp. Brædt',360,'stk',176.23),(10850251250420,'25x125mm. trykimp. Brædt',420,'stk',205.59),(10850251250480,'25x125mm. trykimp. Brædt',480,'stk',234.96),(10850251250540,'25x125mm. trykimp. Brædt',540,'stk',264.33),(10850251250600,'25x125mm. trykimp. Brædt',600,'stk',239.7),(10850252000300,'25x200 mm. trykimp. Brædt',300,'stk',230.85),(10850252000360,'25x200 mm. trykimp. Brædt',360,'stk',277.03),(10850252000420,'25x200 mm. trykimp. Brædt',420,'stk',323.19),(10850252000480,'25x200 mm. trykimp. Brædt',480,'stk',369.36),(10850252000540,'25x200 mm. trykimp. Brædt',540,'stk',415.53),(10850252000600,'25x200 mm. trykimp. Brædt',600,'stk',509.7),(10860191000180,'19x100 mm. trykimp. Brædt',180,'stk',19.71),(10860191000210,'19x100 mm. trykimp. Brædt',210,'stk',23),(10860191000240,'19x100 mm. trykimp. Brædt',240,'stk',26.28),(10860191000270,'19x100 mm. trykimp. Brædt',270,'stk',29.56),(10860191000300,'19x100 mm. trykimp. Brædt',300,'stk',32.85),(10860191000360,'19x100 mm. trykimp. Brædt',360,'stk',39.43),(10860191000420,'19x100 mm. trykimp. Brædt',420,'stk',45.99),(13850970970180,'97x97 mm. trykimp. Stolpe',180,'stk',136.71),(13850970970240,'97x97 mm. trykimp. Stolpe',240,'stk',182.28),(13850970970270,'97x97 mm. trykimp. Stolpe',270,'stk',205.06),(13850970970300,'97x97 mm. trykimp. Stolpe',300,'stk',227.85),(13850970970360,'97x97 mm. trykimp. Stolpe',360,'stk',273.43),(13850970970420,'97x97 mm. trykimp. Stolpe',420,'stk',318.99),(13850970970480,'97x97 mm. trykimp. Stolpe',480,'stk',364.56),(14370471000240,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 240 CM',240,'stk',83.88),(14370471000270,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 270 CM',270,'stk',94.36),(14370471000300,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 300 CM',300,'stk',104.85),(14370471000330,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 330 CM',330,'stk',115.34),(14370471000360,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 360 CM',360,'stk',125.83),(14370471000390,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 390 CM',390,'stk',136.3),(14370471000420,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 420 CM ',420,'stk',146.79),(14370471000450,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 450 CM ',450,'stk',157.28),(14370471000480,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 480 CM ',480,'stk',167.76),(14370471000510,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 510 CM',510,'stk',178.25),(14370471000540,'47X100 MM REGLAR HØVLET 4S TIL 45X95 MM 540 CM ',540,'stk',188.73),(14380472000300,'45x195 mm. spærtræ ubh.',300,'stk',284.85),(14380472000360,'45x195 mm. spærtræ ubh.',360,'stk',341.83),(14380472000420,'45x195 mm. spærtræ ubh.',420,'stk',398.79),(14380472000480,'45x195 mm. spærtræ ubh.',480,'stk',455.76),(14380472000540,'45x195 mm. spærtræ ubh.',540,'stk',512.73),(14380472000600,'45x195 mm. spærtræ ubh.',600,'stk',774),(14380472000660,'45x195 mm. spærtræ ubh.',660,'stk',851.4),(14380472000720,'45x195 mm. spærtræ ubh.',720,'stk',928.8),(16380380730360,'38X73MM LÆGTER TRYKIMPRÆGNERET NTR/AB 360 CM',360,'stk',179.83),(16380380730420,'38X73MM LÆGTER TRYKIMPRÆGNERET NTR/AB 420 CM',420,'stk',209.79),(16380380730480,'38X73MM LÆGTER TRYKIMPRÆGNERET NTR/AB 480 CM',480,'stk',239.76);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `tlfnr` varchar(20) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `isAdmin` tinyint NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_customer_city_idx` (`city`),
  CONSTRAINT `fk_customer_city` FOREIGN KEY (`city`) REFERENCES `city` (`city`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (8,'BennyBussemand','BennysBusser@hotmail.com','1234','23758432','Østergade 13','Rønne',0),(9,'user','usermail@mail.com','1234','11223344','Userstreet 1337','Rønne',0),(10,'admin','adminmail@mail.com','1234','12345678','Adminstreet 666','Rønne',1),(11,'FedePede','PedesFedePik@hotmail.com','1234','76298412','Fartgade 21','Rønne',0),(12,'XxPussySlayerxX','ThomasPS@gmail.com','1234','97534600','Storegade 19','Rønne',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wood_cladding`
--

DROP TABLE IF EXISTS `wood_cladding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wood_cladding` (
  `wood_cladding_mat` varchar(255) NOT NULL,
  `stock_id` bigint NOT NULL,
  PRIMARY KEY (`wood_cladding_mat`),
  KEY `fk_bekledning_stock1_idx` (`stock_id`),
  CONSTRAINT `fk_wood_cladding_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wood_cladding`
--

LOCK TABLES `wood_cladding` WRITE;
/*!40000 ALTER TABLE `wood_cladding` DISABLE KEYS */;
INSERT INTO `wood_cladding` VALUES ('not_yet_implemented',404);
/*!40000 ALTER TABLE `wood_cladding` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-25  9:01:07
