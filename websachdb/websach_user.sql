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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(120) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `verification_code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'hle38365@gmail.com',_binary '','Thanh Trần','$2a$10$o0KiAR/l01pKjXCqikoHleVVlQ09zjodIkOQwvNKv698csUUBYlBe','0355815813','USER',_binary '','thanh03','DnBjBfrlMH97OGqF8doHRVZUs9VxynDxUIfmSTRMdnJHkO6eI2NEJParSpqJnoBQ'),(3,'hle12345@gmail.com',_binary '\0','Hieu','$2a$10$O84exrvet7g83Po18TWaLuK3WD8IvbvFZ1/KlNcFWP058C1H36cna','0382751167','ADMIN',_binary '','lehieu',NULL),(4,'lehieu130301@gmail.com',_binary '','Hieu','$2a$10$yqOuX.Mhjzdi8yXBzZ9Ul.27gND1p/lyY.bcIAbDcQxS6a/1dKR7q','0927110527','USER',_binary '','hieu13','VqBXXIZpEVzdyOCosNJWrnTJNch3CceF8kTXR5hzP5MvQeDy3svz7u64Q6S06orZ');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-22 15:58:18
