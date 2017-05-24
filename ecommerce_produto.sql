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
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produto` (
  `idproduto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` blob,
  `estoque` int(11) DEFAULT NULL,
  `valor` float DEFAULT NULL,
  `img1` blob,
  `img2` blob,
  `img3` blob,
  `tipo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idproduto`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (22,'Camisa  DIVERSO','DETALHES DO PRODUTO\r\n\r\nCamiseta FiveBlu Manga Curta Snoopy Nerd Branca, com gola redonda, manga curta e modelagem ampla. Possui estampa frontal do personagem Snoopy e recortes na cor azul.\r\n\r\nConfeccionada em malha 100% algod\ão.\r\n\r\nMedidas: Ombro 13cm/ Manga 15cm/ Busto 94cm/ Comprimento 62cm/ Tamanho P. (medidas sem elasticidade)\r\n\r\nMedidas da Modelo: Altura 1,75m/ Busto: 83cm/ Cintura: 62cm/ Quadril: 90cm.',8,8,'https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg','https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg','https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg',4),(23,'Adesivo','ADESIVO',8,8,'https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg','https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg','https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg',1),(24,'Curso','rwwrwr',8,8,'https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg','https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg','https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg',2),(25,'JOgo','jogo',8,8,'https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg','https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg','https://dafitistatic-a.akamaihd.net/p/Handbook-Jaqueta-Bomber-Handbook-Axial-Off-White-9303-8574982-1-catalog.jpg',3);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
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
