-- MySQL dump 10.13  Distrib 8.0.45, for Linux (x86_64)
--
-- Host: localhost    Database: geek_system
-- ------------------------------------------------------
-- Server version	8.0.45

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shop_id` int NOT NULL COMMENT '店舗ID',
  `last_name` varchar(255) NOT NULL COMMENT '姓',
  `first_name` varchar(255) NOT NULL COMMENT '名',
  `email` varchar(255) NOT NULL COMMENT 'メールアドレス',
  `post` varchar(255) DEFAULT NULL COMMENT '役職',
  `authority` varchar(255) NOT NULL COMMENT '権限',
  `phone_number` varchar(20) DEFAULT NULL COMMENT '電話番号',
  `password` varchar(255) NOT NULL COMMENT 'パスワード',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  PRIMARY KEY (`id`),
  KEY `shop_id` (`shop_id`),
  CONSTRAINT `admins_ibfk_1` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `big_categories`
--

DROP TABLE IF EXISTS `big_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `big_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '大カテゴリ名',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `big_categories`
--

LOCK TABLES `big_categories` WRITE;
/*!40000 ALTER TABLE `big_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `big_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `makers`
--

DROP TABLE IF EXISTS `makers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `makers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT 'メーカ名',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `makers`
--

LOCK TABLES `makers` WRITE;
/*!40000 ALTER TABLE `makers` DISABLE KEYS */;
/*!40000 ALTER TABLE `makers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchandise_shops`
--

DROP TABLE IF EXISTS `merchandise_shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchandise_shops` (
  `id` int NOT NULL AUTO_INCREMENT,
  `shop_id` int NOT NULL COMMENT '店舗ID',
  `merchandise_id` int NOT NULL COMMENT '商品ID',
  `purchase_cost` int DEFAULT NULL COMMENT '仕入原価',
  `retail_price` int DEFAULT NULL COMMENT '定価',
  `sales_price` int DEFAULT NULL COMMENT '販売価格',
  `stock` int DEFAULT NULL COMMENT '在庫数',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日',
  PRIMARY KEY (`id`),
  KEY `fk_shop_merchandises_shop` (`shop_id`),
  KEY `fk_shop_merchandises_merchandise` (`merchandise_id`),
  CONSTRAINT `fk_shop_merchandises_merchandise` FOREIGN KEY (`merchandise_id`) REFERENCES `merchandises` (`id`),
  CONSTRAINT `fk_shop_merchandises_shop` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchandise_shops`
--

LOCK TABLES `merchandise_shops` WRITE;
/*!40000 ALTER TABLE `merchandise_shops` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchandise_shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchandises`
--

DROP TABLE IF EXISTS `merchandises`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchandises` (
  `id` int NOT NULL AUTO_INCREMENT,
  `small_category_id` int NOT NULL COMMENT '小カテゴリID',
  `maker_id` int NOT NULL COMMENT 'メーカーID',
  `name` varchar(255) DEFAULT NULL COMMENT '商品名',
  `comment` text COMMENT '商品説明',
  `image` varchar(255) DEFAULT NULL COMMENT '画像パス',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日',
  PRIMARY KEY (`id`),
  KEY `fk_merchandise_small_category` (`small_category_id`),
  KEY `fk_merchandise_maker` (`maker_id`),
  CONSTRAINT `fk_merchandise_maker` FOREIGN KEY (`maker_id`) REFERENCES `makers` (`id`),
  CONSTRAINT `fk_merchandise_small_category` FOREIGN KEY (`small_category_id`) REFERENCES `small_categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchandises`
--

LOCK TABLES `merchandises` WRITE;
/*!40000 ALTER TABLE `merchandises` DISABLE KEYS */;
/*!40000 ALTER TABLE `merchandises` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `middle_categories`
--

DROP TABLE IF EXISTS `middle_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `middle_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `big_category_id` int NOT NULL COMMENT '大カテゴリID',
  `name` varchar(255) NOT NULL COMMENT '中カテゴリ名',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `middle_categories`
--

LOCK TABLES `middle_categories` WRITE;
/*!40000 ALTER TABLE `middle_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `middle_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_histories`
--

DROP TABLE IF EXISTS `order_histories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_histories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `admin_id` int NOT NULL COMMENT '管理者ID',
  `merchandise_id` int NOT NULL COMMENT '商品ID',
  `shop_id` int NOT NULL COMMENT '店舗ID',
  `number_of_order` int NOT NULL COMMENT '発注数',
  `total_amount` int NOT NULL COMMENT '合計金額',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  PRIMARY KEY (`id`),
  KEY `admin_id` (`admin_id`),
  KEY `merchandise_id` (`merchandise_id`),
  KEY `shop_id` (`shop_id`),
  CONSTRAINT `order_histories_ibfk_1` FOREIGN KEY (`admin_id`) REFERENCES `admins` (`id`),
  CONSTRAINT `order_histories_ibfk_2` FOREIGN KEY (`merchandise_id`) REFERENCES `merchandises` (`id`),
  CONSTRAINT `order_histories_ibfk_3` FOREIGN KEY (`shop_id`) REFERENCES `admins` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_histories`
--

LOCK TABLES `order_histories` WRITE;
/*!40000 ALTER TABLE `order_histories` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_histories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shops`
--

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shops` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '店舗名',
  `address` varchar(255) NOT NULL COMMENT '住所',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops`
--

LOCK TABLES `shops` WRITE;
/*!40000 ALTER TABLE `shops` DISABLE KEYS */;
/*!40000 ALTER TABLE `shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `small_categories`
--

DROP TABLE IF EXISTS `small_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `small_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `middle_category_id` int NOT NULL COMMENT '中カテゴリID',
  `big_category_id` int NOT NULL COMMENT '大カテゴリID',
  `name` varchar(255) NOT NULL COMMENT '小カテゴリ名',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '作成日時',
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新日時',
  PRIMARY KEY (`id`),
  KEY `middle_category_id` (`middle_category_id`),
  KEY `big_category_id` (`big_category_id`),
  CONSTRAINT `small_categories_ibfk_1` FOREIGN KEY (`middle_category_id`) REFERENCES `middle_categories` (`id`),
  CONSTRAINT `small_categories_ibfk_2` FOREIGN KEY (`big_category_id`) REFERENCES `big_categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `small_categories`
--

LOCK TABLES `small_categories` WRITE;
/*!40000 ALTER TABLE `small_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `small_categories` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-03-24 16:37:23
