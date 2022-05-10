CREATE DATABASE  IF NOT EXISTS `carport` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `carport`;
-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: carport
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `parts_list`
--

DROP TABLE IF EXISTS `parts_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parts_list` (
  `part_list_id` int NOT NULL AUTO_INCREMENT,
  `request_id` int NOT NULL,
  `stock_id` int NOT NULL,
  `line_price` int NOT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`part_list_id`),
  KEY `fk_parts_list_request1_idx` (`request_id`),
  KEY `fk_parts_list_stock1_idx` (`stock_id`),
  CONSTRAINT `fk_parts_list_request1` FOREIGN KEY (`request_id`) REFERENCES `request` (`request_id`),
  CONSTRAINT `fk_parts_list_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `roof`
--

DROP TABLE IF EXISTS `roof`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roof` (
  `roof_mat` varchar(255) NOT NULL,
  `stock_id` int NOT NULL,
  PRIMARY KEY (`roof_mat`),
  KEY `fk_roof_stock1_idx` (`stock_id`),
  CONSTRAINT `fk_roof_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `stock_id` int NOT NULL,
  `description` varchar(255) NOT NULL,
  `amount` int NOT NULL,
  `unit` varchar(45) NOT NULL,
  `price_per_unit` int NOT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `wood_cladding`
--

DROP TABLE IF EXISTS `wood_cladding`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wood_cladding` (
  `wood_cladding_mat` varchar(255) NOT NULL,
  `stock_id` int NOT NULL,
  PRIMARY KEY (`wood_cladding_mat`),
  KEY `fk_bekledning_stock1_idx` (`stock_id`),
  CONSTRAINT `fk_wood_cladding_stock1` FOREIGN KEY (`stock_id`) REFERENCES `stock` (`stock_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-10  8:43:38
