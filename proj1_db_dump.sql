-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: regen_ins
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.10.1

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
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner` (
  `oid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fname` varchar(50) NOT NULL,
  `lname` varchar(50) NOT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1,'Juliana','Bernhard'),(2,'Jeromy','Douglas'),(3,'Marge','Schamberger'),(4,'Ole','Boyer'),(5,'Matilde','Cormier'),(6,'Mohammad','Spinka'),(7,'Zena','O\'Reilly'),(8,'Forrest','Schmitt'),(9,'Angelita','Parker'),(10,'Newell','Sanford');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle` (
  `vid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `plate` varchar(8) NOT NULL,
  `ins_exp_date` date NOT NULL,
  `oid` int(10) unsigned NOT NULL,
  PRIMARY KEY (`vid`),
  KEY `oid` (`oid`),
  CONSTRAINT `vehicle_ibfk_1` FOREIGN KEY (`oid`) REFERENCES `owner` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES (1,'aaa-1111','2018-11-29',1),(2,'upf-8187','2018-02-05',2),(3,'lhy-7142','2018-09-10',3),(4,'irw-0606','2018-08-20',4),(5,'yye-9358','2018-03-31',5),(6,'agg-2073','2018-01-08',6),(7,'ysu-2015','2018-10-26',7),(8,'joi-0618','2018-08-28',8),(9,'msv-9964','2020-02-08',9),(10,'osw-1512','2018-08-16',10),(11,'ybh-2244','2018-09-28',1),(12,'wnu-3687','2018-08-05',2),(13,'wbg-4028','2018-09-02',3),(14,'nnb-8018','2018-06-23',4),(15,'abh-9333','2018-03-11',5),(16,'gof-7245','2019-10-16',6),(17,'ubw-8972','2019-10-13',7),(18,'zco-0730','2019-01-17',8),(19,'kfk-6535','2019-12-13',9),(20,'mqe-9214','2019-04-30',10),(21,'cqa-1893','2019-07-20',1),(22,'kzl-0805','2019-10-22',2),(23,'lll-4917','2019-08-24',3),(24,'bvx-5441','2018-07-03',4),(25,'biy-9438','2019-07-10',5),(26,'cyg-5072','2018-08-23',6),(27,'cef-1407','2019-06-16',7),(28,'xtv-1392','2018-12-18',8),(29,'ngb-0626','2019-12-29',9),(30,'lvl-7198','2019-06-17',10);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-04 13:07:25
