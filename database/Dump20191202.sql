-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: solotoband
-- ------------------------------------------------------
-- Server version	8.0.18

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
-- Table structure for table `annonce`
--

DROP TABLE IF EXISTS `annonce`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `annonce` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `instrument` int(11) NOT NULL,
  `style` int(11) NOT NULL,
  `level` varchar(45) NOT NULL,
  `info` text NOT NULL,
  `departement` int(11) NOT NULL,
  `groupe` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_idx` (`groupe`),
  KEY `instrument_idx` (`instrument`),
  KEY `departement_idx` (`departement`),
  KEY `style_idx` (`style`),
  CONSTRAINT `departement` FOREIGN KEY (`departement`) REFERENCES `departement` (`id`) ON DELETE CASCADE,
  CONSTRAINT `groupe` FOREIGN KEY (`groupe`) REFERENCES `groupe` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `instrument` FOREIGN KEY (`instrument`) REFERENCES `instrument` (`idinstrument`) ON DELETE CASCADE,
  CONSTRAINT `style` FOREIGN KEY (`style`) REFERENCES `style` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Table qui rassemble les annonces';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annonce`
--

LOCK TABLES `annonce` WRITE;
/*!40000 ALTER TABLE `annonce` DISABLE KEYS */;
/*!40000 ALTER TABLE `annonce` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departement`
--

DROP TABLE IF EXISTS `departement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departement` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departement_code` varchar(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `departement_nom` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departement`
--

LOCK TABLES `departement` WRITE;
/*!40000 ALTER TABLE `departement` DISABLE KEYS */;
INSERT INTO `departement` VALUES (1,'01','Ain'),(2,'02','Aisne'),(3,'03','Allier'),(4,'04','Alpes-de-Haute-Provence'),(5,'05','Hautes-Alpes'),(6,'06','Alpes-Maritimes'),(7,'07','Ardèche'),(8,'08','Ardennes'),(9,'09','Ariège'),(10,'10','Aube'),(11,'11','Aude'),(12,'12','Aveyron'),(13,'13','Bouches-du-Rhône'),(14,'14','Calvados'),(15,'15','Cantal'),(16,'16','Charente'),(17,'17','Charente-Maritime'),(18,'18','Cher'),(19,'19','Corrèze'),(20,'2a','Corse-du-sud'),(21,'2b','Haute-corse'),(22,'21','Côte-d\'or'),(23,'22','Côtes-d\'armor'),(24,'23','Creuse'),(25,'24','Dordogne'),(26,'25','Doubs'),(27,'26','Drôme'),(28,'27','Eure'),(29,'28','Eure-et-Loir'),(30,'29','Finistère'),(31,'30','Gard'),(32,'31','Haute-Garonne'),(33,'32','Gers'),(34,'33','Gironde'),(35,'34','Hérault'),(36,'35','Ile-et-Vilaine'),(37,'36','Indre'),(38,'37','Indre-et-Loire'),(39,'38','Isère'),(40,'39','Jura'),(41,'40','Landes'),(42,'41','Loir-et-Cher'),(43,'42','Loire'),(44,'43','Haute-Loire'),(45,'44','Loire-Atlantique'),(46,'45','Loiret'),(47,'46','Lot'),(48,'47','Lot-et-Garonne'),(49,'48','Lozère'),(50,'49','Maine-et-Loire'),(51,'50','Manche'),(52,'51','Marne'),(53,'52','Haute-Marne'),(54,'53','Mayenne'),(55,'54','Meurthe-et-Moselle'),(56,'55','Meuse'),(57,'56','Morbihan'),(58,'57','Moselle'),(59,'58','Nièvre'),(60,'59','Nord'),(61,'60','Oise'),(62,'61','Orne'),(63,'62','Pas-de-Calais'),(64,'63','Puy-de-Dôme'),(65,'64','Pyrénées-Atlantiques'),(66,'65','Hautes-Pyrénées'),(67,'66','Pyrénées-Orientales'),(68,'67','Bas-Rhin'),(69,'68','Haut-Rhin'),(70,'69','Rhône'),(71,'70','Haute-Saône'),(72,'71','Saône-et-Loire'),(73,'72','Sarthe'),(74,'73','Savoie'),(75,'74','Haute-Savoie'),(76,'75','Paris'),(77,'76','Seine-Maritime'),(78,'77','Seine-et-Marne'),(79,'78','Yvelines'),(80,'79','Deux-Sèvres'),(81,'80','Somme'),(82,'81','Tarn'),(83,'82','Tarn-et-Garonne'),(84,'83','Var'),(85,'84','Vaucluse'),(86,'85','Vendée'),(87,'86','Vienne'),(88,'87','Haute-Vienne'),(89,'88','Vosges'),(90,'89','Yonne'),(91,'90','Territoire de Belfort'),(92,'91','Essonne'),(93,'92','Hauts-de-Seine'),(94,'93','Seine-Saint-Denis'),(95,'94','Val-de-Marne'),(96,'95','Val-d\'oise'),(97,'976','Mayotte'),(98,'971','Guadeloupe'),(99,'973','Guyane'),(100,'972','Martinique'),(101,'974','Réunion');
/*!40000 ALTER TABLE `departement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(100) NOT NULL,
  `contact_name` varchar(100) NOT NULL,
  `group_phone` varchar(10) NOT NULL,
  `group_email` varchar(100) NOT NULL,
  `image` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idgroupe_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `groupe`
--

LOCK TABLES `groupe` WRITE;
/*!40000 ALTER TABLE `groupe` DISABLE KEYS */;
INSERT INTO `groupe` VALUES (57,'Les dark stripes','rose','2565859659','rosalita@gmial.fr','https://www.numerama.com/content/uploads/2019/05/trou-noir-astronomie-univers-espace.jpg'),(58,'Les dark stripes','rose','2565859659','rosalita@gmial.fr','https://www.numerama.com/content/uploads/2019/05/trou-noir-astronomie-univers-espace.jpg'),(59,'Les dark stripes','rose','2565859659','rosalita@gmial.fr','https://www.numerama.com/content/uploads/2019/05/trou-noir-astronomie-univers-espace.jpg'),(60,'Rosalenti','hiu','0234523822','rosalita@gmial.fr','https://www.numerama.com/content/uploads/2019/05/trou-noir-astronomie-univers-espace.jpg');
/*!40000 ALTER TABLE `groupe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instrument`
--

DROP TABLE IF EXISTS `instrument`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `instrument` (
  `idinstrument` int(11) NOT NULL AUTO_INCREMENT,
  `vent` varchar(100) DEFAULT NULL,
  `corde` varchar(100) DEFAULT NULL,
  `percution` varchar(100) DEFAULT NULL,
  `electrique` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idinstrument`),
  UNIQUE KEY `idinstrument_UNIQUE` (`idinstrument`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='table des instruments de musique par type';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instrument`
--

LOCK TABLES `instrument` WRITE;
/*!40000 ALTER TABLE `instrument` DISABLE KEYS */;
INSERT INTO `instrument` VALUES (1,'Clarinette',NULL,NULL,NULL),(2,'hautbois',NULL,NULL,NULL),(3,'clarinette',NULL,NULL,NULL);
/*!40000 ALTER TABLE `instrument` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `style`
--

DROP TABLE IF EXISTS `style`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `style` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `classique` varchar(100) DEFAULT NULL,
  `rock` varchar(100) DEFAULT NULL,
  `pop` varchar(100) DEFAULT NULL,
  `rap` varchar(100) DEFAULT NULL,
  `jazz` varchar(100) DEFAULT NULL,
  `divers` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `style`
--

LOCK TABLES `style` WRITE;
/*!40000 ALTER TABLE `style` DISABLE KEYS */;
INSERT INTO `style` VALUES (1,'Symphonie',NULL,NULL,NULL,NULL,NULL),(2,'Concerto',NULL,NULL,NULL,NULL,NULL),(3,'sonate',NULL,NULL,NULL,NULL,NULL),(4,'Lied',NULL,NULL,NULL,NULL,NULL),(5,'Opéra',NULL,NULL,NULL,NULL,NULL),(6,'Choral',NULL,NULL,NULL,NULL,NULL),(7,NULL,'Blues rock',NULL,NULL,NULL,NULL),(8,NULL,'Emo',NULL,NULL,NULL,NULL),(9,NULL,'Alternatif',NULL,NULL,NULL,NULL),(10,NULL,'Cowpunk',NULL,NULL,NULL,NULL),(11,NULL,'Gothique',NULL,NULL,NULL,NULL),(12,NULL,'Celte',NULL,NULL,NULL,NULL),(13,NULL,'Instrumental',NULL,NULL,NULL,NULL),(14,NULL,NULL,'Indie',NULL,NULL,NULL),(15,NULL,NULL,'Cowntry',NULL,NULL,NULL),(16,NULL,NULL,'Pop Rock',NULL,NULL,NULL),(17,NULL,NULL,'Danse pop',NULL,NULL,NULL),(18,NULL,NULL,'Dream pop',NULL,NULL,NULL),(19,NULL,NULL,NULL,'RnB',NULL,NULL),(20,NULL,NULL,NULL,'Rap conscient',NULL,NULL),(21,NULL,NULL,NULL,'Rap égotrip',NULL,NULL),(22,NULL,NULL,NULL,'Rap poétique',NULL,NULL),(23,NULL,NULL,NULL,'Rap gangsta',NULL,NULL),(24,NULL,NULL,NULL,'Rap hardcore',NULL,NULL),(25,NULL,NULL,NULL,'Rap commercial',NULL,NULL),(26,NULL,NULL,NULL,NULL,'Free jazz',NULL),(27,NULL,NULL,NULL,NULL,'cool jazz',NULL),(28,NULL,NULL,NULL,NULL,'Swing',NULL),(29,NULL,NULL,NULL,NULL,'Bepop',NULL),(30,NULL,NULL,NULL,NULL,'Ragtime',NULL),(31,NULL,NULL,NULL,NULL,'Smooth jazz',NULL);
/*!40000 ALTER TABLE `style` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-02  9:36:30
