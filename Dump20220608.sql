-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: final_doan
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (11,'CreateBy','2022-05-05 09:03:20',NULL,NULL,'Áo sơ mi'),(8,'CreateBy','2022-05-05 09:02:51','Modifier','2022-05-05 09:03:34','Áo jacket'),(7,'CreateBy','2022-05-05 09:02:44',NULL,NULL,'Áo sweater'),(10,'CreateBy','2022-05-05 09:03:05',NULL,NULL,'Quần jacket'),(12,'CreateBy','2022-05-05 09:03:27',NULL,NULL,'Quần kaki'),(13,'CreateBy','2022-05-05 09:03:46',NULL,NULL,'Áo khoác');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `content` varchar(5000) COLLATE utf8_unicode_ci DEFAULT NULL,
  `parent_id` int DEFAULT NULL,
  `total_like` int DEFAULT NULL,
  `review_entity_id` bigint DEFAULT NULL,
  `user_entity_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6w5mmwvixa37cvy8u7u60bik8` (`review_entity_id`),
  KEY `FKulelxhnjl2sf2030105dbc1i` (`user_entity_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (6,'unknowUser','2022-06-05 11:10:12',NULL,'2022-06-05 11:10:12','đẹp quá',NULL,NULL,21,25);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `category_entity_id` bigint DEFAULT NULL,
  `review_id` bigint DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `total` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm3owfv4y4429l2xo043ym447m` (`category_entity_id`),
  KEY `FK63qfnwyiuhg8m8ywe84ehhj9` (`review_id`)
) ENGINE=MyISAM AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (5,'CreateBy','2022-05-05 09:04:44','admin','2022-05-24 08:50:59','5_202216533570595_20221653199465swt_ho____ng_.jpg','Áo sweater Hồng',99000,7,11,NULL,NULL),(6,'CreateBy','2022-05-05 09:05:56','admin','2022-05-24 08:51:45','5_202216533571045_202216531977450ffebfb63809874ddd5c0b2bbdfad2ab.jpg','Áo sweater Đen',199000,7,12,NULL,NULL),(7,'CreateBy','2022-05-05 09:06:50','admin','2022-05-24 08:52:45','5_202216533571645_20221653199552dosiin-myo-ao-sweater-vang-9734197341.jpeg','Áo sweater Cam',199000,7,13,NULL,NULL),(8,'CreateBy','2022-05-05 09:07:23','admin','2022-05-24 08:53:04','5_202216533571845_20221653199672images.jpg','Áo sweater trắng',199000,7,14,NULL,NULL),(9,'CreateBy','2022-05-05 09:08:06','admin','2022-05-24 08:53:36','5_202216533572155_20221653199740o-sweater-in-hop-sua-trai-dao-gia-re-3-8875.jpg','Áo sweater Xanh',299000,7,15,NULL,NULL),(21,'admin','2022-05-24 08:59:02','admin','2022-05-24 08:59:02','5_202216533575415_20221653200432ao-jacket-local-brand-dang-mua-3.jpg','Áo Jacket Set',400000,8,21,NULL,NULL),(20,'admin','2022-05-24 08:57:43','admin','2022-05-24 08:57:43','5_202216533574635_20221653200334ao-jacket-0612-1603940407.jpg','Áo Jacket Nâu',299000,8,20,NULL,NULL),(19,'admin','2022-05-24 08:57:12','admin','2022-05-24 08:57:12','5_202216533574325_20221653200122dsc05271_1.jpg','Áo Jacket Xanh',300000,8,19,NULL,NULL),(18,'admin','2022-05-24 08:56:00','admin','2022-05-24 08:56:00','5_202216533573595_20221653200195do.jpg','Áo Jacket Đỏ',300000,8,18,NULL,NULL),(17,'admin','2022-05-24 08:54:47','admin','2022-05-24 08:55:17','5_202216533573165_20221653200094acket-la-gi7.jpg','Áo Jacket da',300000,8,17,NULL,NULL),(32,'admin','2022-05-26 14:44:47','admin','2022-05-26 14:45:28','5_202216535510875_20221653199465swt_ho____ng_.jpg','122',1,11,37,NULL,NULL);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_history`
--

DROP TABLE IF EXISTS `product_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_history` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `total` int DEFAULT NULL,
  `product_entity_id` bigint DEFAULT NULL,
  `user_entity_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKr4v528xnlt4illcls8hxy6c65` (`product_entity_id`),
  KEY `FKhn5ep66syj26xx3ft8gfmce9p` (`user_entity_id`)
) ENGINE=MyISAM AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_history`
--

LOCK TABLES `product_history` WRITE;
/*!40000 ALTER TABLE `product_history` DISABLE KEYS */;
INSERT INTO `product_history` VALUES (14,'1','2022-05-26 18:36:48',NULL,NULL,1,18,23),(13,'1','2022-05-26 18:36:48',NULL,NULL,4,19,23),(12,'1','2022-05-26 18:36:48',NULL,NULL,1,21,23),(15,'1','2022-05-28 16:25:55',NULL,NULL,2,19,23),(16,'1','2022-05-30 14:02:03',NULL,NULL,2,18,23),(17,'Hữu Quang','2022-05-30 22:14:36',NULL,NULL,1,19,22),(18,'Hữu Quang','2022-05-30 22:14:36',NULL,NULL,1,18,22),(19,'Hữu Quang','2022-05-30 22:17:20',NULL,NULL,1,19,22),(20,'Hữu Quang','2022-05-30 22:17:20',NULL,NULL,1,18,22),(21,'Hữu Quang','2022-06-01 22:33:28',NULL,'2022-06-01 22:33:28',1,21,22),(22,'Hữu Quang','2022-06-01 22:38:51',NULL,'2022-06-01 22:38:51',1,21,22),(23,'Hữu Quang','2022-06-01 22:38:51',NULL,'2022-06-01 22:38:51',1,18,22),(24,'Hữu Quang','2022-06-04 16:59:31',NULL,'2022-06-04 16:59:31',1,21,22),(25,'Hữu Quang','2022-06-05 11:13:32',NULL,'2022-06-05 11:13:32',1,21,22),(26,'Hữu Quang','2022-06-08 08:23:16',NULL,'2022-06-08 08:23:16',1,21,22),(27,'Hữu Quang','2022-06-08 08:23:39',NULL,'2022-06-08 08:23:39',1,18,22),(28,'Hữu Quang','2022-06-08 08:24:07',NULL,'2022-06-08 08:24:07',1,21,22),(29,'Hữu Quang','2022-06-08 08:24:48',NULL,'2022-06-08 08:24:48',1,19,22);
/*!40000 ALTER TABLE `product_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `name_recipt` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `price_ship` bigint DEFAULT NULL,
  `status` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt`
--

LOCK TABLES `receipt` WRITE;
/*!40000 ALTER TABLE `receipt` DISABLE KEYS */;
INSERT INTO `receipt` VALUES (1,'quang','2022-06-01 23:11:25','unknowUser','2022-06-01 23:11:25','1','a','1',30000,1,NULL),(2,'quang','2022-06-01 23:14:37','unknowUser','2022-06-01 23:14:37','2',NULL,'2',30000,1,NULL),(3,'quang\'','2022-06-01 23:04:13','unknowUser','2022-06-01 23:04:13','11',NULL,'11',30000,4,'11'),(4,'quang','2022-06-02 09:04:19','admin','2022-06-02 09:04:19','hoài Đức',NULL,'0963089510',30000,5,'quang'),(5,NULL,'2022-06-05 14:51:30','admin','2022-06-05 14:51:30','ha noi',NULL,'17877878',30000,3,'tét'),(6,NULL,'2022-06-05 12:44:30','admin','2022-06-05 12:44:30','hà nội',NULL,'0963089510',30000,3,'mua tặng vợ'),(7,NULL,'2022-06-08 08:25:29','admin','2022-06-08 08:25:29','Hà Nội',NULL,'0963089510',30000,3,'quang'),(8,NULL,'2022-06-08 08:25:34','admin','2022-06-08 08:25:34','HA NOI',NULL,'09',30000,3,'quang '),(9,NULL,'2022-06-08 08:25:37','admin','2022-06-08 08:25:37','Hà Nội',NULL,'0977880888',30000,3,'OK'),(10,NULL,'2022-06-08 08:25:41','admin','2022-06-08 08:25:41','nghệ tĩnh',NULL,'0987878899',30000,3,'test');
/*!40000 ALTER TABLE `receipt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt_product_historys`
--

DROP TABLE IF EXISTS `receipt_product_historys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt_product_historys` (
  `receipt_entity_id` bigint NOT NULL,
  `product_historys_id` bigint NOT NULL,
  UNIQUE KEY `UK_5kocp3qvm9thcfi8onrj9bh0h` (`product_historys_id`),
  KEY `FK7fx46jqaeee7ub2cjvjkry6t8` (`receipt_entity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt_product_historys`
--

LOCK TABLES `receipt_product_historys` WRITE;
/*!40000 ALTER TABLE `receipt_product_historys` DISABLE KEYS */;
INSERT INTO `receipt_product_historys` VALUES (1,18),(1,17),(2,20),(2,19),(3,21),(4,22),(4,23),(5,24),(6,25),(7,26),(8,27),(9,28),(10,29);
/*!40000 ALTER TABLE `receipt_product_historys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `rating` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (20,'admin','2022-05-24 08:57:43',NULL,NULL,5),(2,'CreateBy','2022-05-05 10:44:52','Modifier','2022-05-05 10:47:47',1),(3,'CreateBy','2022-05-05 10:46:55','Modifier','2022-05-05 11:24:30',2),(4,'CreateBy','2022-05-05 10:47:47',NULL,NULL,3),(5,'CreateBy','2022-05-05 10:47:47','Modifier','2022-05-05 21:06:04',2),(6,'CreateBy','2022-05-05 10:47:47','Modifier','2022-05-05 21:06:04',2),(19,'admin','2022-05-24 08:57:12','1','2022-05-26 18:36:57',2),(18,'admin','2022-05-24 08:56:00','1','2022-05-26 18:36:57',2),(17,'admin','2022-05-24 08:55:17',NULL,NULL,5),(16,'admin','2022-05-24 08:54:47',NULL,NULL,5),(11,'admin','2022-05-24 08:50:59',NULL,NULL,5),(12,'admin','2022-05-24 08:51:45',NULL,NULL,5),(13,'admin','2022-05-24 08:52:45',NULL,NULL,5),(14,'admin','2022-05-24 08:53:04',NULL,NULL,5),(15,'admin','2022-05-24 08:53:36',NULL,NULL,5),(21,'admin','2022-05-24 08:59:02','1','2022-05-26 18:36:57',2),(27,'admin','2022-05-25 14:51:37',NULL,NULL,5),(28,'admin','2022-05-25 14:52:08',NULL,NULL,5),(29,'admin','2022-05-25 14:52:38',NULL,NULL,5),(31,'admin','2022-05-25 14:56:46',NULL,NULL,5),(36,'admin','2022-05-26 14:44:47',NULL,NULL,5),(37,'admin','2022-05-26 14:45:28',NULL,NULL,5);
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `modifier_by` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modifier_date` datetime DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `token` bigint DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (23,'unknowUser','2022-05-26 18:36:19',NULL,NULL,'$2a$10$DHqv/wMVduThG8dxfsc.feI/bYQfl7DEY9yE0QwC37nF4I7n8HDbK','1','coolquanghuu@gmail.com','1',NULL),(24,'unknowUser','2022-06-05 11:04:17',NULL,'2022-06-05 11:04:17',NULL,NULL,'coolquanghuu@gmail.com','quanf',NULL),(6,'CreateBy','2022-05-05 14:56:12','admin','2022-05-25 13:50:19','$2a$10$VZrbioeWd1qE46opeI5r8u9sy85k6Mh83Jm3mH0.ZOjV0m9n/yl3y','admin','quyenproxxxxx@gmail.com','Nguyễn Hữu Quang',NULL),(25,'unknowUser','2022-06-05 11:10:12',NULL,'2022-06-05 11:10:12',NULL,NULL,'coolquanghuu@gmail.com','quang',NULL),(22,'unknowUser','2022-05-24 11:20:23','unknowUser','2022-05-24 11:20:23',NULL,'coolquanghuu@gmail.com',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_roles` (
  `user_entity_id` bigint NOT NULL,
  `roles_id` bigint NOT NULL,
  PRIMARY KEY (`user_entity_id`,`roles_id`),
  KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (6,1),(9,2),(14,2),(22,2),(23,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-08  9:04:30
