-- MySQL dump 10.13  Distrib 5.6.17, for Linux (x86_64)
--
-- Host: localhost    Database: constancias
-- ------------------------------------------------------
-- Server version	5.6.17

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
-- Table structure for table `asistente`
--

DROP TABLE IF EXISTS `asistente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asistente` (
  `noFolio` int(11) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `asistencia` bit(1) NOT NULL,
  `constancia` bit(1) NOT NULL,
  `correo_electronico` varchar(50) NOT NULL,
  `nivel_academico` varchar(12) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `taller_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`noFolio`),
  KEY `FK55530FF29E33FA60` (`taller_id`),
  CONSTRAINT `FK55530FF29E33FA60` FOREIGN KEY (`taller_id`) REFERENCES `taller` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asistente`
--

LOCK TABLES `asistente` WRITE;
/*!40000 ALTER TABLE `asistente` DISABLE KEYS */;
INSERT INTO `asistente` VALUES (1,2,'Silva Hernández','','\0','parientefernandox@hotmail.com','Licenciatura','José Fernando',NULL),(2,0,'Gonzalez Martinez','\0','\0','pack_132@hotmail.com','Licenciatura','Francisco Javier',NULL),(3,0,'Viveros Guerrero','\0','\0','espino_rotten@hotmail.com','Licenciatura','José Manuel',NULL),(4,0,'Acosta Romero','\0','\0','popotes_2304@hotmail.com','Licenciatura','Luis Angel',NULL),(5,0,'Islas del Angel','\0','\0','islas_91@hotmail.com','Licenciatura','Edwin',NULL);
/*!40000 ALTER TABLE `asistente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prueba`
--

DROP TABLE IF EXISTS `prueba`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prueba` (
  `noFolio` int(11) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `apellidos` varchar(30) NOT NULL,
  `asistencia` bit(1) NOT NULL,
  `constancia` bit(1) NOT NULL,
  `correo_electronico` varchar(50) NOT NULL,
  `nivel_academico` varchar(12) NOT NULL,
  `nombres` varchar(30) NOT NULL,
  `taller_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`noFolio`),
  KEY `FKC59BF3D19E33FA60` (`taller_id`),
  CONSTRAINT `FKC59BF3D19E33FA60` FOREIGN KEY (`taller_id`) REFERENCES `taller` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prueba`
--

LOCK TABLES `prueba` WRITE;
/*!40000 ALTER TABLE `prueba` DISABLE KEYS */;
/*!40000 ALTER TABLE `prueba` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `authority` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `authority` (`authority`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,0,'ROLE_ADMIN'),(2,0,'ROLE_USER');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taller`
--

DROP TABLE IF EXISTS `taller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `taller` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `numero_lugares` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taller`
--

LOCK TABLES `taller` WRITE;
/*!40000 ALTER TABLE `taller` DISABLE KEYS */;
INSERT INTO `taller` VALUES (1,0,'Taller básico Grupo 1 (10:30 - 11:30)',30),(2,0,'Taller básico Grupo 2 (10:30 - 11:30)',30),(3,0,'Taller básico Grupo 3 (12:30 - 13:30)',30),(4,0,'Taller básico Grupo 4 (12:30 - 13:30)',30),(5,0,'Taller intermedio 1 (10:30 - 11: 30)',20),(6,0,'Taller intermedio 2 (12:30 - 13: 30)',20);
/*!40000 ALTER TABLE `taller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `version` bigint(20) NOT NULL,
  `account_expired` bit(1) NOT NULL,
  `account_locked` bit(1) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) NOT NULL,
  `password_expired` bit(1) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,0,'\0','\0','','$2a$10$iyNcwQbnIuMlj1SvpqbXMeNCPoRYibwWG.b8qpD3EiQ1/23spYQ9.','\0','admin'),(2,0,'\0','\0','','$2a$10$q9plh.rOO9Emr2V2OslU5OeAdhocZ8zBpbSuPNv6X.YiFV5pxZeNu','\0','usuario 1');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_rol` (
  `rol_id` bigint(20) NOT NULL,
  `usuario_id` bigint(20) NOT NULL,
  PRIMARY KEY (`rol_id`,`usuario_id`),
  KEY `FK3118953EB045CE34` (`rol_id`),
  KEY `FK3118953E543960D4` (`usuario_id`),
  CONSTRAINT `FK3118953E543960D4` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FK3118953EB045CE34` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,1),(2,2);
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-07 12:29:50
