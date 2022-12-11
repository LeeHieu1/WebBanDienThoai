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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin01@gmail.com',_binary '','test','$2a$10$7rxnnxRfFXf1zdjxyqnbV.CvddCAD.d7u/icqAkexVMeIPNBCJwMi','0337445596','ADMIN',_binary '','admin01',NULL),(2,'thebest11447@gmail.com',_binary '','test2','$2a$10$xaTJ3FnH4Z56kObuzm.o8OS5g1TlUwVMt8wJ7tvG9vkCQVuxmD38S','0123456788','ADMIN',_binary '','admin02','5IYsf55XKoxopojJElSrvUbqsk0VREa6yIeAPiDOB9be4HyZjnDaJl9rB7l9LquJ'),(3,'thebest11446@gmail.com',_binary '','Người mua 2','$2a$10$xaTJ3FnH4Z56kObuzm.o8OS5g1TlUwVMt8wJ7tvG9vkCQVuxmD38S','0123456789','USER',_binary '','user02',NULL),(4,'hle38365@gmail.com',_binary '','Hieu','$2a$10$z8l7lAnS5elRX.tKpNDHXOMJtvgsImi3Qvu8TQF3Ub1xDQuwq5uIu','0382751167','USER',_binary '','hieu123','CtQva6jxbqV9sna39VmX9GvqXrMh8WTwJL6wE01uj61k44f22AS3In1YKtO2t2js'),(5,'hle24681012@gmail.com',_binary '','Lê Hiếu','$2a$10$xtAE4CGh.3fwMzSKsKM8au0CPH24yD4diob39GTWjWmIjGe.O1J2i','0123871938','USER',_binary '','hieu13','zayRuG01NUZ2eR9vCK0V5fQJy2vdq93KKOPti0XvivCE1VEMh4xMDAD80dn8eFLk'),(9,'alo@gmail.com',_binary '','abcd','12345678','128727462','USER',_binary '','abcd1',NULL);
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

-- Dump completed on 2022-12-11 22:55:05
