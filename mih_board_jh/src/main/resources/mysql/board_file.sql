-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: board
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `file` (
  `FILE_NO` int(255) NOT NULL AUTO_INCREMENT,
  `ORIGINAL_FILE_NM` varchar(1000) DEFAULT NULL,
  `FILE_SIZE` int(255) DEFAULT NULL,
  `BOARD_NO` int(255) DEFAULT NULL,
  `SAVED_FILE_NM` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`FILE_NO`),
  KEY `BOARD_NO` (`BOARD_NO`),
  CONSTRAINT `file_ibfk_1` FOREIGN KEY (`BOARD_NO`) REFERENCES `board` (`board_no`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
INSERT INTO `file` VALUES (9,'CI.txt',1244,71,'6ca86295-ecb3-4128-936b-1390527d5b67_2018818_CI.txt'),(10,'cicd-01.png',46807,71,'05e603ef-6aaa-4a08-8ac3-6c4cd4c8e888_2018818_cicd-01.png'),(11,'CI.txt',1244,72,'704e797c-0a4a-44fe-a851-7c178dbcbd6b_2018818_CI.txt'),(12,'cicd-01.png',46807,72,'adfed894-cd4f-4301-9a8d-1fbb8c5a8f6d_2018818_cicd-01.png'),(13,'jenkins_port_change.png',95349,73,'588039e3-8f26-4668-bc95-fdc475968b24_2018818_jenkins_port_change.png'),(14,'junit.png',1917,73,'1397e642-15ba-43ce-acb7-db2c55db232a_2018818_junit.png'),(15,'Findbugs.jpg',10256,74,'f27c3f66-a971-4125-9e7e-04de8c87e514_2018818_Findbugs.jpg'),(16,'jenkins.png',6078,74,'6b47c41c-0e4c-4627-a555-62827a5dd72d_2018818_jenkins.png'),(18,'새 폴더.zip',1969563,76,'d5fc07fb-2572-4ce5-8146-cc95b0012cbf_2018819_새 폴더.zip'),(19,'sample.xlsx',9056,78,'7953a0d3-c4b1-46cc-8346-bdda8d6db7ae_2018820_sample.xlsx'),(20,'sample.xlsx',9079,79,'2e200138-1555-4351-b4df-f645729e1a17_2018820_sample.xlsx'),(21,'sample.xlsx',9079,80,'6656c37a-6f92-4b69-aca6-0685d334a524_2018820_sample.xlsx'),(22,'sample.xlsx',9079,82,'2ab6811a-f923-4a15-82db-cd80abfc32df_2018820_sample.xlsx'),(23,'sample.xlsx',9079,83,'67797697-5f6b-4453-82bc-5deff941c255_2018820_sample.xlsx'),(24,'sample.xlsx',9079,84,'ac0769af-cfec-4940-8743-cf5330320e3c_2018820_sample.xlsx'),(25,'sample.xlsx',9079,85,'dde0f80a-a623-49e0-8370-08993e7b9685_2018820_sample.xlsx'),(26,'Sample - Superstore.xls',3364352,88,'887f5865-ffe6-4acb-b84a-6c6ef17caa6c_2018820_Sample - Superstore.xls'),(28,'Sample - Superstore.xls',3364352,98,'63b9e776-6490-473d-b28a-8ad5683d99e1_2018820_Sample - Superstore.xls'),(29,'Sample - Superstore.xls',3364352,122,'9226372c-b14a-4e3c-baec-cf736a137d0c_2018821_Sample - Superstore.xls'),(30,'Sample - Superstore.xls',3364352,126,'c7987eee-01b6-4e3e-a255-ead6e2e6d50e_2018821_Sample - Superstore.xls');
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-21 14:29:31
