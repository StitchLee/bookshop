-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: bookshop
-- ------------------------------------------------------
-- Server version	5.6.15

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
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `bookId` int(11) NOT NULL AUTO_INCREMENT,
  `bookName` varchar(255) NOT NULL,
  `bookAuthor` varchar(255) NOT NULL,
  `bookPrice` int(11) NOT NULL,
  `bookPic` varchar(255) NOT NULL,
  `bookPress` varchar(255) NOT NULL,
  `BOOKTYPEID` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookId`),
  KEY `FK1nmumahotclgniakxqwxj39tm` (`BOOKTYPEID`),
  CONSTRAINT `FK1nmumahotclgniakxqwxj39tm` FOREIGN KEY (`BOOKTYPEID`) REFERENCES `booktype` (`booktypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (1,'起风了','崛辰雄',25,'shop/images/book1.jpg','南海出版公司',1),(2,'三毛','三毛',55,'test.jpg','北京十月文艺出版社',2),(6,'Java程序设计',' (美)Y Daniel Liang ',80,'shop/images/book6.jpg','机械工业出版社',2),(7,'Python网络爬虫入门','唐松',39,'shop/images/book7.jpg','机械工业出版社',2),(8,'Android APP开发入门','施威铭',70,'shop/images/book8.jpg','机械工业出版社',2),(9,'深度学习、优化与识别','赵进',101,'shop/images/book9.jpg','清华大学出版社',2),(10,'数据结构预算法分析：Java语言描述','[美]马克·艾伦·维斯',54,'shop/images/book10.jpg','机械工业出版社',2),(11,'我不','大冰',34,'shop/images/book11.jpg','湖南文艺出版社',1),(12,'雪落香杉树','戴维·伽特森',41,'shop/images/book12.jpg','作家出版社',1),(13,'被掩埋的巨人','石黑一雄',19,'shop/images/book13.jpg','上海译文出版社',1),(14,'黑白镜头里的世界史（1850~1979）','美国不列颠百科全书公司、盖蒂图片社',89,'shop/images/book14.jpg','金城出版社',3),(15,'世界历史上的蒙古征服','美] 梅天穆',51,'shop/images/book15.jpg','民主与建设出版社',3),(16,' 品三国','易中天',46,'shop/images/book16.jpg','上海文艺出版社',3),(17,'法国大革命：一部历史','[英国][英]托马斯·卡莱尔',109,'shop/images/book17.jpg','吉林出版社',3),(18,'不可不知的科学','【英】约翰范登',38,'shop/images/book18.jpg','长江少年儿童出版社',4),(19,'安野光雅的十二堂绘画课','（日）安野光雅',44,'shop/images/book19.jpg','九州出版社',4),(20,' DK万物透视图解百科 （精装版）（全彩）','英国DK出版社',64,'shop/images/book20.jpg','电子工业出版社',4),(21,'柳林风声','[英]肯尼斯格雷厄姆著；[英]大卫罗伯茨绘',42,'shop/images/book21.jpg','贵州人民出版社',4),(22,'岛上书店','美）加·泽文 ',24,'shop/images/book22.jpg','江苏文艺出版社',1),(23,'白夜行','[日]东野圭吾',43,'shop/images/book23.jpg','南海出版公司',1),(24,'敦煌','(日)井上靖',24,'shop/images/book24.jpg','北京十月文艺出版社',3),(25,'秦始皇','胡高普',22,'test.jpg','长江文艺出版社',3);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bookorder`
--

DROP TABLE IF EXISTS `bookorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookorder` (
  `BOOKID` int(11) NOT NULL,
  `ORDERBOOKID` int(11) NOT NULL,
  PRIMARY KEY (`BOOKID`,`ORDERBOOKID`),
  KEY `FKm4okl8kxsvwu0inna10m3ljh7` (`ORDERBOOKID`),
  CONSTRAINT `FKh9cy1b7qdbvjkrx569u8ut9wa` FOREIGN KEY (`BOOKID`) REFERENCES `book` (`bookId`),
  CONSTRAINT `FKm4okl8kxsvwu0inna10m3ljh7` FOREIGN KEY (`ORDERBOOKID`) REFERENCES `orderbook` (`orderBookId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookorder`
--

LOCK TABLES `bookorder` WRITE;
/*!40000 ALTER TABLE `bookorder` DISABLE KEYS */;
INSERT INTO `bookorder` VALUES (16,96),(18,96),(1,97),(2,98),(1,99),(7,99),(24,100),(24,101),(1,102),(24,102),(1,103),(2,103),(1,104),(2,104),(1,105),(24,105),(1,106),(24,106),(1,107),(2,107),(24,107),(1,108),(2,108),(24,108),(1,109),(24,109),(1,110),(24,110),(1,111),(24,111),(2,112),(24,112),(24,113),(1,114),(24,114),(1,115),(6,115),(6,116),(8,116),(1,117),(1,118),(6,119),(24,120),(1,121),(1,122),(6,122),(1,123),(2,123),(1,124),(24,124),(6,125),(14,125),(1,126),(14,127),(24,127),(1,128),(24,128),(1,129),(24,129);
/*!40000 ALTER TABLE `bookorder` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booktype`
--

DROP TABLE IF EXISTS `booktype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booktype` (
  `booktypeId` int(11) NOT NULL AUTO_INCREMENT,
  `booktypeName` varchar(255) NOT NULL,
  PRIMARY KEY (`booktypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booktype`
--

LOCK TABLES `booktype` WRITE;
/*!40000 ALTER TABLE `booktype` DISABLE KEYS */;
INSERT INTO `booktype` VALUES (1,'小说类'),(2,'科技类'),(3,'历史类'),(4,'儿童文学类');
/*!40000 ALTER TABLE `booktype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customerId` int(11) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(255) NOT NULL,
  `customerPwd` varchar(255) NOT NULL,
  `customerTel` int(20) NOT NULL,
  `customerEmail` varchar(255) NOT NULL,
  `customerAddr` varchar(255) DEFAULT NULL,
  `customerTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'lee','123456',1573265770,'17635565@qq.com','河北省石家庄市裕华区河北师范大学新校区','2017-11-20 10:14:43'),(13,'zhangsan','123456',1329988563,'1568423@qq.com','北京','2017-12-19 16:10:58'),(16,'lisi','123456',1543216550,'1525@qq.com','石家庄','2017-12-20 09:16:22');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manager`
--

DROP TABLE IF EXISTS `manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `manager` (
  `adminId` int(11) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(255) NOT NULL,
  `adminPwd` varchar(255) NOT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manager`
--

LOCK TABLES `manager` WRITE;
/*!40000 ALTER TABLE `manager` DISABLE KEYS */;
INSERT INTO `manager` VALUES (1,'admin','123456');
/*!40000 ALTER TABLE `manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderbook`
--

DROP TABLE IF EXISTS `orderbook`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderbook` (
  `orderBookId` int(11) NOT NULL AUTO_INCREMENT,
  `bookAmount` int(11) NOT NULL,
  `ORDERID` int(11) DEFAULT NULL,
  `totalMoney` int(11) NOT NULL,
  PRIMARY KEY (`orderBookId`),
  KEY `FK302tubfbrv4eye9h4nn92v506` (`ORDERID`),
  CONSTRAINT `FK302tubfbrv4eye9h4nn92v506` FOREIGN KEY (`ORDERID`) REFERENCES `orders` (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderbook`
--

LOCK TABLES `orderbook` WRITE;
/*!40000 ALTER TABLE `orderbook` DISABLE KEYS */;
INSERT INTO `orderbook` VALUES (96,10,NULL,480),(97,9,NULL,231),(98,8,NULL,500),(99,5,NULL,167),(100,7,NULL,172),(101,7,NULL,172),(102,102,NULL,2550),(103,4,NULL,150),(104,4,NULL,150),(105,5,NULL,122),(106,7,NULL,173),(107,9,NULL,297),(108,9,NULL,296),(109,4,NULL,98),(110,53,NULL,1322),(111,5,NULL,122),(112,7,NULL,246),(113,8,NULL,330),(114,3,NULL,73),(115,3,NULL,185),(116,5,NULL,370),(117,5,NULL,128),(118,2,NULL,50),(119,5,NULL,400),(120,6,NULL,150),(121,2,NULL,50),(122,5,NULL,235),(123,3,NULL,125),(124,5,NULL,122),(125,7,NULL,596),(126,2,NULL,50),(127,5,NULL,315),(128,4,NULL,98),(129,5,NULL,123);
/*!40000 ALTER TABLE `orderbook` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `isPay` int(11) NOT NULL,
  `orderTime` varchar(255) NOT NULL,
  `CUSTOMERID` int(11) DEFAULT NULL,
  `ORDERBOOKID` int(11) DEFAULT NULL,
  PRIMARY KEY (`orderId`),
  KEY `FKqdh2gexqbi0payyhdysfpnp0p` (`CUSTOMERID`),
  KEY `FK2dn6aw8vt6mq84a6p3dsqunoy` (`ORDERBOOKID`),
  CONSTRAINT `FK2dn6aw8vt6mq84a6p3dsqunoy` FOREIGN KEY (`ORDERBOOKID`) REFERENCES `orderbook` (`orderBookId`),
  CONSTRAINT `FKqdh2gexqbi0payyhdysfpnp0p` FOREIGN KEY (`CUSTOMERID`) REFERENCES `customer` (`customerId`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (30,1,'2017-12-15 10:47:33',1,96),(31,1,'2017-12-18 14:12:55',1,97),(33,1,'2017-12-19 08:11:33',1,99),(35,0,'2017-12-19 16:15:46',13,102),(41,1,'2017-12-19 19:26:29',1,109),(45,1,'2017-12-19 20:28:56',1,113),(47,1,'2017-12-19 20:43:21',1,115),(48,0,'2017-12-19 20:59:02',1,116),(49,1,'2017-12-19 21:00:54',1,118),(50,0,'2017-12-19 21:01:05',1,119),(51,1,'2017-12-20 08:08:26',1,123),(52,1,'2017-12-20 08:13:31',1,124),(53,1,'2017-12-20 08:41:59',1,125),(55,0,'2017-12-20 09:21:23',16,127),(56,1,'2017-12-20 09:21:43',16,128);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temporary`
--

DROP TABLE IF EXISTS `temporary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temporary` (
  `orderId` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `orderTime` varchar(45) NOT NULL,
  `bookSet` varchar(255) DEFAULT NULL,
  `bookAmonut` int(11) NOT NULL,
  `isPay` int(11) NOT NULL,
  `totalMoney` int(11) NOT NULL,
  `customerAddr` varchar(255) NOT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temporary`
--

LOCK TABLES `temporary` WRITE;
/*!40000 ALTER TABLE `temporary` DISABLE KEYS */;
INSERT INTO `temporary` VALUES (48,1,'2017-12-19 20:59:02','Android APP开发入门,Java程序设计,',5,0,370,'河北省石家庄市裕华区河北师范大学新校区'),(51,1,'2017-12-20 08:08:26','起风了,三毛集,',3,1,125,'河北省石家庄市裕华区河北师范大学新校区'),(53,1,'2017-12-20 08:41:59','黑白镜头里的世界史（1850~1979）,Java程序设计,',7,1,596,'河北省石家庄市裕华区河北师范大学新校区'),(55,16,'2017-12-20 09:21:23','黑白镜头里的世界史（1850~1979）,敦煌,',5,0,315,'石家庄');
/*!40000 ALTER TABLE `temporary` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-20  9:34:36
