-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: 127.0.0.1    Database: ecommerce
-- ------------------------------------------------------
-- Server version	5.7.17

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
-- Table structure for table `banner`
--

DROP TABLE IF EXISTS `banner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `banner` (
  `idbanner` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(145) DEFAULT NULL,
  `descricao` blob,
  `url1` blob,
  `url2` blob,
  `url3` blob,
  `valor` float DEFAULT NULL,
  `estoque` int(11) DEFAULT NULL,
  `imgprincipal` blob,
  PRIMARY KEY (`idbanner`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `banner`
--

LOCK TABLES `banner` WRITE;
/*!40000 ALTER TABLE `banner` DISABLE KEYS */;
INSERT INTO `banner` VALUES (8,'MAc do tiago','Armazenamento em flash integrado de 256GB com PCIe1 Dual core de 1,1GHz Processador Intel Core m3 Turbo Boost de at\é 2,2GHz 8GB de memória Intel HD Graphics 515 R$ 9.799,00 em at\é 12x de R$ 816,58','http://s2.glbimg.com/Sj0H5_NqH7YAJUArzku7QB0kl_s=/1080x608/top/smart/s.glbimg.com/po/tt2/f/original/2016/11/10/macbook-air-e-muito-mais-barato-do-que-o-pro.jpg','http://s2.glbimg.com/Sj0H5_NqH7YAJUArzku7QB0kl_s=/1080x608/top/smart/s.glbimg.com/po/tt2/f/original/2016/11/10/macbook-air-e-muito-mais-barato-do-que-o-pro.jpg','http://s2.glbimg.com/Sj0H5_NqH7YAJUArzku7QB0kl_s=/1080x608/top/smart/s.glbimg.com/po/tt2/f/original/2016/11/10/macbook-air-e-muito-mais-barato-do-que-o-pro.jpg',899999,12,'http://s2.glbimg.com/Sj0H5_NqH7YAJUArzku7QB0kl_s=/1080x608/top/smart/s.glbimg.com/po/tt2/f/original/2016/11/10/macbook-air-e-muito-mais-barato-do-que-o-pro.jpg');
/*!40000 ALTER TABLE `banner` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-24  8:37:39
