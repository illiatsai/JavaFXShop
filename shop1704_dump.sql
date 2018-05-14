-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Бытовая техника'),(2,'Компьютеры'),(3,'Мобильные телефоны'),(5,'Drons'),(8,'Садовая техника');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id_goods` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `goods_description` mediumtext COLLATE utf8_unicode_ci NOT NULL,
  `goods_category` int(11) NOT NULL,
  `goods_price` int(11) NOT NULL,
  `goods_remaining` int(11) NOT NULL,
  PRIMARY KEY (`id_goods`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'ноутбук ASUS','Intel Core i3 7100U, 8 ГБ, 500 ГБ, NVIDIA GeForce 940MX, Endless, серый',2,1000,3),(3,'ноутбук HP','Intel Core i5, 12 ГБ, 1000 ГБ, чёрный',2,1450,2),(4,'смартфон Apple 6s','Apple iOS, экран 4.7\" IPS (750x1334), Apple A9, ОЗУ 2 ГБ, флэш-память 16 ГБ, камера 12 Мп, аккумулятор 1715 мАч, 1 SIM, цвет серебристый',3,520,38),(5,'смартфон Apple 7','Apple iOS, экран 5.5\" IPS (1080x1920)',3,800,21),(6,'ноутбук Dell Inspirion','15.6\" 1366 x 768, Intel Core i3 6006U 2000 МГц, 4 ГБ, 1000 ГБ (HDD), Intel HD Graphics 520, Linux',2,740,5),(8,'холодильник Минск','белый',1,400,5),(9,'смартфон Xiaomi Redmi Note 5 Pro','Android, экран 6\" IPS (1080x2160)',3,570,17),(10,'смартфон HTC U11','Android, экран 5.5\" IPS (1440x2560)',3,500,27),(11,'смартфон Samsung Galaxy S8','Android, экран 5.8\" AMOLED (1440x2960), Exynos 8895, ОЗУ 4 ГБ, флэш-память 64 ГБ',3,720,17),(13,'ТРимер','красивый',8,123,31);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `id_sales` int(11) NOT NULL AUTO_INCREMENT,
  `name_customer` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `tel_number_customer` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `goods_saled` int(11) NOT NULL,
  `goods_saled_name` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `amount_goods_saled` int(11) NOT NULL,
  `date_sale` date NOT NULL,
  `price_with_discont` int(11) NOT NULL,
  PRIMARY KEY (`id_sales`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,'Дунаев Р.А.','9868758757',2,'холодильник AEG',1,'2017-12-20',1785),(7,'Петров П.П.','+375296573421',4,'смартфон Apple 6s',3,'2017-12-20',1560),(8,'Иванов И.И.','8(017)3429547',7,'холодильник Samsung',2,'2018-03-03',1620),(9,' Johnson J.J.','+2362473246246',7,'холодильник Samsung',2,'2017-12-20',1620),(10,'Сидоров С.С.','2505611',7,'холодильник Samsung',2,'2017-01-15',1620),(11,'Федоров Ф.Ф.','3453463463',4,'смартфон Apple 6s',2,'2018-03-26',1040);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `lastName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `login` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Geaorge','Washington','gw','3f071f4f163d68551f4fc1544c7f69a6'),(2,'Ilya','Cay','it','0d149b90e7394297301c90191ae775f0'),(3,'user','user','user','ee11cbb19052e40b07aac0ca060c23ee');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-17 21:28:41
