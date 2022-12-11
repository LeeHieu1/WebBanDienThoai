-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: websach
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdby` varchar(50) DEFAULT NULL,
  `createdate` datetime(6) DEFAULT NULL,
  `modifiedby` varchar(50) DEFAULT NULL,
  `modifieddate` datetime(6) DEFAULT NULL,
  `address` varchar(255) NOT NULL,
  `date` date DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `status` int NOT NULL,
  `total_price` bigint NOT NULL,
  `id_payment` bigint DEFAULT NULL,
  `id_user` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5phng0rr9yex7v321tef65svq` (`id_payment`),
  KEY `FKp1jglhdt6fpf5plvbns0gp5ns` (`id_user`),
  CONSTRAINT `FK5phng0rr9yex7v321tef65svq` FOREIGN KEY (`id_payment`) REFERENCES `payment` (`id`),
  CONSTRAINT `FKp1jglhdt6fpf5plvbns0gp5ns` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (3,'user01','2022-11-22 20:19:24.378000','user01','2022-11-22 20:19:24.378000','Unkown',NULL,'Order 02','0123456789',0,700000,1,2),(4,'user01','2022-11-22 20:19:31.931000','user01','2022-11-22 20:19:31.931000','Unkown',NULL,'Order 02','0123456789',0,700000,2,2),(6,'user01','2022-11-22 20:25:30.888000','user01','2022-11-22 20:25:30.888000','Unkown',NULL,'Order 5','0123456789',0,880000,1,2),(7,'user02','2022-11-22 21:27:21.176000','user02','2022-11-22 21:27:21.176000','Sài Gòn',NULL,'Demo Order ','0337445596',0,600000,1,3),(8,'user02','2022-11-22 21:30:18.766000','user02','2022-11-22 21:30:18.766000','Sài Gòn',NULL,'Demo Order 2','0337445596',0,840000,1,3),(9,'user01','2022-11-23 13:31:04.222000','user01','2022-11-23 13:31:04.222000','Dĩ An, Bình Dương',NULL,'Đặt hàng 01','0337445596',0,620000,1,2),(11,'user01','2022-11-25 23:09:52.764000','user01','2022-11-25 23:09:52.764000','Thu duc',NULL,'Le Minh Hieu','0123456789',0,565000,1,2),(12,'hieu123','2022-12-01 00:58:41.551000','hieu123','2022-12-01 00:58:41.551000','',NULL,' ','',0,110000,1,4),(13,'hieu123','2022-12-01 00:59:16.314000','hieu123','2022-12-01 00:59:16.314000','',NULL,' ','',0,110000,2,4),(14,'hieu123','2022-12-01 08:12:01.433000','hieu123','2022-12-01 08:12:01.433000','',NULL,' ','',0,160000,1,4);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-11 22:55:05
