	CREATE DATABASE  IF NOT EXISTS `elibrary` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
	USE `elibrary`;
	-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
	--
	-- Host: localhost    Database: elibrary
	-- ------------------------------------------------------
	-- Server version	8.0.20

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
	-- Table structure for table `autor`
	--

	DROP TABLE IF EXISTS `autor`;
	/*!40101 SET @saved_cs_client     = @@character_set_client */;
	/*!50503 SET character_set_client = utf8mb4 */;
	CREATE TABLE `autor` (
	  `idautor` int NOT NULL AUTO_INCREMENT,
	  `nombrecompleto` varchar(55) NOT NULL,
	  `nacionalidad` varchar(45) NOT NULL,
	  `claveautor` varchar(20) NOT NULL,
	  PRIMARY KEY (`idautor`)
	) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	/*!40101 SET character_set_client = @saved_cs_client */;

	--
	-- Dumping data for table `autor`
	--

	LOCK TABLES `autor` WRITE;
	/*!40000 ALTER TABLE `autor` DISABLE KEYS */;
	INSERT INTO `autor` VALUES (1,'John Green','Estadounidense','Jogr'),(2,'Ernest Hemingway','Estadounidense','Erhe'),(3,'Ali Cronnin ','Inglesa','AlCr');
	/*!40000 ALTER TABLE `autor` ENABLE KEYS */;
	UNLOCK TABLES;

	--
	-- Table structure for table `carritocompras`
	--

	DROP TABLE IF EXISTS `carritocompras`;
	/*!40101 SET @saved_cs_client     = @@character_set_client */;
	/*!50503 SET character_set_client = utf8mb4 */;
	CREATE TABLE `carritocompras` (
	  `idcarritocompras` int NOT NULL AUTO_INCREMENT,
	  `fechacompra` datetime NOT NULL,
	  `fechaentrega` datetime NOT NULL,
	  `lugarentrega` varchar(45) DEFAULT NULL,
	  `idstatuscarrito` int NOT NULL,
	  `foliocarritocompras` varchar(256) NOT NULL,
	  `nombrecomprador` varchar(256) NOT NULL,
	  PRIMARY KEY (`idcarritocompras`),
	  KEY `fk_carritocompras_statuscarrito_idx` (`idstatuscarrito`),
	  CONSTRAINT `fk_carritocompras_statuscarrito` FOREIGN KEY (`idstatuscarrito`) REFERENCES `statuscarritocompras` (`idstatuscarritocompras`)
	) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	/*!40101 SET character_set_client = @saved_cs_client */;

	--
	-- Dumping data for table `carritocompras`
	--

	LOCK TABLES `carritocompras` WRITE;
	/*!40000 ALTER TABLE `carritocompras` DISABLE KEYS */;
	INSERT INTO `carritocompras` VALUES (1,'2012-12-19 00:00:00','2019-12-19 00:00:00','Jilotepec',3,'Ji12Ro','Rosario'),(2,'2012-12-19 00:00:00','2019-12-19 00:00:00','Jilotepec',3,'Ji12Ro','Rosario'),(3,'2012-12-19 00:00:00','2019-12-19 00:00:00','Jilotepec',3,'Ji12Ro','Rosario');
	/*!40000 ALTER TABLE `carritocompras` ENABLE KEYS */;
	UNLOCK TABLES;

	--
	-- Table structure for table `detallecarritocompras`
	--

	DROP TABLE IF EXISTS `detallecarritocompras`;
	/*!40101 SET @saved_cs_client     = @@character_set_client */;
	/*!50503 SET character_set_client = utf8mb4 */;
	CREATE TABLE `detallecarritocompras` (
	  `iddetallecarritocompras` int NOT NULL AUTO_INCREMENT,
	  `idcarritocompras` int NOT NULL,
	  `idlibro` int NOT NULL,
	  `cantidad` int NOT NULL,
	  `preciounitarioventa` decimal(6,2) NOT NULL COMMENT 'Precio al que la libreria vende el libro al cliente',
	  `preciounitariocompra` decimal(6,2) NOT NULL COMMENT 'Precio al que la libreria compra el libro a la editorial',
	  PRIMARY KEY (`iddetallecarritocompras`),
	  KEY `fk_detallecarrito_carrito_idx` (`idcarritocompras`),
	  KEY `fk_detallecarrito_libro_idx` (`idlibro`),
	  CONSTRAINT `fk_detallecarrito_carrito` FOREIGN KEY (`idcarritocompras`) REFERENCES `carritocompras` (`idcarritocompras`),
	  CONSTRAINT `fk_detallecarrito_libro` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`)
	) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	/*!40101 SET character_set_client = @saved_cs_client */;

	--
	-- Dumping data for table `detallecarritocompras`
	--

	LOCK TABLES `detallecarritocompras` WRITE;
	/*!40000 ALTER TABLE `detallecarritocompras` DISABLE KEYS */;
	INSERT INTO `detallecarritocompras` VALUES (1,1,2,2,80.00,150.00);
	/*!40000 ALTER TABLE `detallecarritocompras` ENABLE KEYS */;
	UNLOCK TABLES;

	--
	-- Table structure for table `editorial`
	--

	DROP TABLE IF EXISTS `editorial`;
	/*!40101 SET @saved_cs_client     = @@character_set_client */;
	/*!50503 SET character_set_client = utf8mb4 */;
	CREATE TABLE `editorial` (
	  `ideditorial` int NOT NULL AUTO_INCREMENT,
	  `nombreeditorial` varchar(45) NOT NULL,
	  `lugardeimpresion` varchar(45) NOT NULL,
	  PRIMARY KEY (`ideditorial`)
	) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	/*!40101 SET character_set_client = @saved_cs_client */;

	--
	-- Dumping data for table `editorial`
	--

	LOCK TABLES `editorial` WRITE;
	/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
	INSERT INTO `editorial` VALUES (1,'Planeta Verde','México'),(2,'IDeBolsillo','Ciudad de México'),(3,'Oceano','Barcelona');
	/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
	UNLOCK TABLES;

	--
	-- Table structure for table `libro`
	--

	DROP TABLE IF EXISTS `libro`;
	/*!40101 SET @saved_cs_client     = @@character_set_client */;
	/*!50503 SET character_set_client = utf8mb4 */;
	CREATE TABLE `libro` (
	  `idlibro` int NOT NULL AUTO_INCREMENT,
	  `isbn` varchar(45) NOT NULL,
	  `descripcion` varchar(350) DEFAULT NULL,
	  `paginas` varchar(45) NOT NULL,
	  `precioventa` decimal(6,2) NOT NULL,
	  `preciocompra` decimal(6,2) NOT NULL,
	  `inventario` int NOT NULL,
	  `status` tinyint DEFAULT '1',
	  `titulo` varchar(256) NOT NULL,
	  PRIMARY KEY (`idlibro`)
	) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	/*!40101 SET character_set_client = @saved_cs_client */;

	--
	-- Dumping data for table `libro`
	--

	LOCK TABLES `libro` WRITE;
	/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
	INSERT INTO `libro` VALUES (1,'843032707X','Pasta Rustica','140',20.00,50.00,0,1,'El viejo y el mar',NULL),(2,'843983707X','Pasta Dura','160',80.00,150.00,8,1,'Bajo la misma estrella',NULL),(3,'843230707X','Pasta Rustica','210',120.00,50.00,10,1,'Nada es para siempre',NULL);
	/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
	UNLOCK TABLES;

	--
	-- Table structure for table `libroautor`
	--

	DROP TABLE IF EXISTS `libroautor`;
	/*!40101 SET @saved_cs_client     = @@character_set_client */;
	/*!50503 SET character_set_client = utf8mb4 */;
	CREATE TABLE `libroautor` (
	  `idlibro` int NOT NULL,
	  `idautor` int NOT NULL,
	  PRIMARY KEY (`idlibro`,`idautor`),
	  KEY `fk_libroautor_autor_idx` (`idautor`),
	  CONSTRAINT `fk_libroautor_autor` FOREIGN KEY (`idautor`) REFERENCES `autor` (`idautor`),
	  CONSTRAINT `fk_libroautor_libro` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	/*!40101 SET character_set_client = @saved_cs_client */;

	--
	-- Dumping data for table `libroautor`
	--

	LOCK TABLES `libroautor` WRITE;
	/*!40000 ALTER TABLE `libroautor` DISABLE KEYS */;
	INSERT INTO `libroautor` VALUES (2,1),(1,2),(3,3);
	/*!40000 ALTER TABLE `libroautor` ENABLE KEYS */;
	UNLOCK TABLES;

	--
	-- Table structure for table `libroeditorial`
	--

	DROP TABLE IF EXISTS `libroeditorial`;
	/*!40101 SET @saved_cs_client     = @@character_set_client */;
	/*!50503 SET character_set_client = utf8mb4 */;
	CREATE TABLE `libroeditorial` (
	  `idlibro` int NOT NULL,
	  `ideditorial` int NOT NULL,
	  PRIMARY KEY (`idlibro`,`ideditorial`),
	  KEY `fk_editorial_idx` (`ideditorial`),
	  CONSTRAINT `fk_editorial` FOREIGN KEY (`ideditorial`) REFERENCES `editorial` (`ideditorial`),
	  CONSTRAINT `fk_libro` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	/*!40101 SET character_set_client = @saved_cs_client */;

	--
	-- Dumping data for table `libroeditorial`
	--

	LOCK TABLES `libroeditorial` WRITE;
	/*!40000 ALTER TABLE `libroeditorial` DISABLE KEYS */;
	INSERT INTO `libroeditorial` VALUES (3,1),(2,2),(1,3);
	/*!40000 ALTER TABLE `libroeditorial` ENABLE KEYS */;
	UNLOCK TABLES;

	--
	-- Table structure for table `statuscarritocompras`
	--

	DROP TABLE IF EXISTS `statuscarritocompras`;
	/*!40101 SET @saved_cs_client     = @@character_set_client */;
	/*!50503 SET character_set_client = utf8mb4 */;
	CREATE TABLE `statuscarritocompras` (
	  `idstatuscarritocompras` int NOT NULL AUTO_INCREMENT,
	  `descriptionstatus` varchar(20) NOT NULL,
	  PRIMARY KEY (`idstatuscarritocompras`)
	) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	/*!40101 SET character_set_client = @saved_cs_client */;

	--
	-- Dumping data for table `statuscarritocompras`
	--

	LOCK TABLES `statuscarritocompras` WRITE;
	/*!40000 ALTER TABLE `statuscarritocompras` DISABLE KEYS */;
	INSERT INTO `statuscarritocompras` VALUES (1,'LISTO_PARA_ENTREGAR'),(2,'ENTREGADO'),(3,'NO ENTREGADO');
	/*!40000 ALTER TABLE `statuscarritocompras` ENABLE KEYS */;
	UNLOCK TABLES;

	--
	-- Table structure for table `usuario`
	--

	DROP TABLE IF EXISTS `usuario`;
	/*!40101 SET @saved_cs_client     = @@character_set_client */;
	/*!50503 SET character_set_client = utf8mb4 */;
	CREATE TABLE `usuario` (
	  `idusuario` int NOT NULL AUTO_INCREMENT,
	  `nombre` varchar(25) NOT NULL,
	  `password` varchar(25) NOT NULL,
	  `status` tinyint NOT NULL DEFAULT '1',
	  PRIMARY KEY (`idusuario`)
	) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
	/*!40101 SET character_set_client = @saved_cs_client */;

	--
	-- Dumping data for table `usuario`
	--

	LOCK TABLES `usuario` WRITE;
	/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
	INSERT INTO `usuario` VALUES (1,'root','1234',1),(2,'Rosario','1234',1);
	/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
	UNLOCK TABLES;
	/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

	/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
	/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
	/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
	/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
	/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
	/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
	/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

	-- Dump completed on 2020-12-29 20:29:20
