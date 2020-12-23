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
-- Table structure for table `carritocompras`
--

DROP TABLE IF EXISTS `carritocompras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carritocompras` (
  `idcarritocompras` int NOT NULL AUTO_INCREMENT,
  `fechacompra` datetime NOT NULL,
  `fechaentrega` datetime NOT NULL,
  `lugaentrega` varchar(45) NOT NULL,
  `idstatuscarrito` int NOT NULL,
  `foliocarritocompras` varchar(256) NOT NULL,
  `nombrecomprador` varchar(256) NOT NULL,
  PRIMARY KEY (`idcarritocompras`),
  KEY `fk_carritocompras_statuscarrito_idx` (`idstatuscarrito`),
  CONSTRAINT `fk_carritocompras_statuscarrito` FOREIGN KEY (`idstatuscarrito`) REFERENCES `statuscarritocompras` (`idstatuscarritocompras`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
  `preciounitarioventa` decimal(4,2) NOT NULL COMMENT 'Precio al que la libreria vende el libro al cliente',
  `preciounitariocompra` decimal(4,2) NOT NULL COMMENT 'Precio al que la libreria compra el libro a la editorial',
  PRIMARY KEY (`iddetallecarritocompras`),
  KEY `fk_detallecarrito_carrito_idx` (`idcarritocompras`),
  KEY `fk_detallecarrito_libro_idx` (`idlibro`),
  CONSTRAINT `fk_detallecarrito_carrito` FOREIGN KEY (`idcarritocompras`) REFERENCES `carritocompras` (`idcarritocompras`),
  CONSTRAINT `fk_detallecarrito_libro` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `idlibro` int NOT NULL AUTO_INCREMENT,
  `isbn` varchar(45) NOT NULL,
  `descripcion` varchar(350) NOT NULL,
  `paginas` varchar(45) NOT NULL,
  `precioventa` decimal(4,2) NOT NULL,
  `preciocompra` decimal(4,2) NOT NULL,
  `inventario` int NOT NULL,
  `status` tinyint DEFAULT '1',
  `titulo` varchar(256) NOT NULL,
  PRIMARY KEY (`idlibro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-23 11:37:09
