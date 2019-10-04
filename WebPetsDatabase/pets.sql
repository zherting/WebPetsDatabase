-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: pets
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `billinfo`
--

DROP TABLE IF EXISTS `billinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `billinfo` (
  `BILL_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BILL` int(11) DEFAULT NULL,
  `ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`BILL_ID`),
  KEY `ID` (`ID`),
  CONSTRAINT `billinfo_ibfk_1` FOREIGN KEY (`ID`) REFERENCES `ownerinfo` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `billinfo`
--

LOCK TABLES `billinfo` WRITE;
/*!40000 ALTER TABLE `billinfo` DISABLE KEYS */;
INSERT INTO `billinfo` VALUES (1,154,11),(2,154,13),(3,154,15),(4,154,17),(5,154,19);
/*!40000 ALTER TABLE `billinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ownerinfo`
--

DROP TABLE IF EXISTS `ownerinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ownerinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE` varchar(10) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `OWNER` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ownerinfo`
--

LOCK TABLES `ownerinfo` WRITE;
/*!40000 ALTER TABLE `ownerinfo` DISABLE KEYS */;
INSERT INTO `ownerinfo` VALUES (1,'Cat','Jasper','Dan'),(3,'Fish','Goldy','Peppa'),(4,'Dog','Carly','Mike'),(7,'Turtle','Mr. slow','Greger'),(11,'Bird','Taylor','Cameron'),(12,'Bird','Taylor','Cameron'),(13,'Bird','Taylor','Cameron'),(14,'Bird','Taylor','Cameron'),(15,'Bird','Taylor','Cameron'),(16,'Bird','Taylor','Cameron'),(17,'Bird','Taylor','Cameron'),(18,'Bird','Taylor','Cameron'),(19,'Bird','Taylor','Cameron');
/*!40000 ALTER TABLE `ownerinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-03 22:39:57
