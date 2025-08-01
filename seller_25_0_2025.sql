/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.7.2-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: seller
-- ------------------------------------------------------
-- Server version	11.7.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `nit_ci` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_venta`
--

DROP TABLE IF EXISTS `detalle_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_venta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) DEFAULT NULL,
  `descuento` decimal(38,2) DEFAULT NULL,
  `precio_unitario` decimal(38,2) DEFAULT NULL,
  `subtotal` decimal(38,2) DEFAULT NULL,
  `id_producto` bigint(20) NOT NULL,
  `id_venta` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsntaik0t9jxcky777753wytsx` (`id_producto`),
  KEY `FKoknpg31rxsqnjxrsu7iy47p1o` (`id_venta`),
  CONSTRAINT `FKoknpg31rxsqnjxrsu7iy47p1o` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id`),
  CONSTRAINT `FKsntaik0t9jxcky777753wytsx` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_venta`
--

LOCK TABLES `detalle_venta` WRITE;
/*!40000 ALTER TABLE `detalle_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabricante`
--

DROP TABLE IF EXISTS `fabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `fabricante` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricante`
--

LOCK TABLES `fabricante` WRITE;
/*!40000 ALTER TABLE `fabricante` DISABLE KEYS */;
/*!40000 ALTER TABLE `fabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(100) NOT NULL,
  `descripcion` varchar(500) DEFAULT NULL,
  `estado` bit(1) NOT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `precio_costo` decimal(10,2) NOT NULL,
  `precio_venta` decimal(10,2) NOT NULL,
  `stock` int(11) NOT NULL,
  `id_proveedor` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKkxdt4u9c4w6vveo7ylph4pd09` (`codigo`),
  KEY `FKkinjnx6sxv6kf9s6i21ttfnfo` (`id_proveedor`),
  CONSTRAINT `FKkinjnx6sxv6kf9s6i21ttfnfo` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_fabricante`
--

DROP TABLE IF EXISTS `producto_fabricante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_fabricante` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `id_fabricante` bigint(20) NOT NULL,
  `id_producto` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK17vvlefn5jemmxtxof1sby7d6` (`id_fabricante`),
  KEY `FKdig8vvlib8dmhvy2cgavv8gff` (`id_producto`),
  CONSTRAINT `FK17vvlefn5jemmxtxof1sby7d6` FOREIGN KEY (`id_fabricante`) REFERENCES `fabricante` (`id`),
  CONSTRAINT `FKdig8vvlib8dmhvy2cgavv8gff` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_fabricante`
--

LOCK TABLES `producto_fabricante` WRITE;
/*!40000 ALTER TABLE `producto_fabricante` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_fabricante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_farmaceutico`
--

DROP TABLE IF EXISTS `producto_farmaceutico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_farmaceutico` (
  `administracion` varchar(100) DEFAULT NULL,
  `clasificacion` varchar(255) DEFAULT NULL,
  `composicion` varchar(100) DEFAULT NULL,
  `concentracion` varchar(100) DEFAULT NULL,
  `condicion_almacenamiento` varchar(255) DEFAULT NULL,
  `contraindicacion` varchar(255) DEFAULT NULL,
  `dosificacion` varchar(100) DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `forma_farmaceutica` varchar(100) DEFAULT NULL,
  `lote` varchar(100) DEFAULT NULL,
  `registro_sanitario` varchar(100) DEFAULT NULL,
  `requiere_receta` bit(1) DEFAULT NULL,
  `uso_terapeutico` varchar(255) DEFAULT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKeqt0a58g12utdsyheqoijsgsi` FOREIGN KEY (`id`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_farmaceutico`
--

LOCK TABLES `producto_farmaceutico` WRITE;
/*!40000 ALTER TABLE `producto_farmaceutico` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_farmaceutico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_foto`
--

DROP TABLE IF EXISTS `producto_foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_foto` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `orden` int(11) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `id_producto` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ni9tkkup08md4ssxyqx4vmpp` (`id_producto`),
  CONSTRAINT `FK2ni9tkkup08md4ssxyqx4vmpp` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_foto`
--

LOCK TABLES `producto_foto` WRITE;
/*!40000 ALTER TABLE `producto_foto` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_ubicacion`
--

DROP TABLE IF EXISTS `producto_ubicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_ubicacion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `almacen` varchar(100) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `estante` varchar(100) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `nivel` varchar(100) DEFAULT NULL,
  `observacion` varchar(250) DEFAULT NULL,
  `sector` varchar(100) DEFAULT NULL,
  `id_producto` bigint(20) NOT NULL,
  `id_ubicacion` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mpr3gsuskri4eslp5n6sa9td` (`id_producto`),
  KEY `FKh7ahsxh77f8tpck2llbt9601a` (`id_ubicacion`),
  CONSTRAINT `FK1mpr3gsuskri4eslp5n6sa9td` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`),
  CONSTRAINT `FKh7ahsxh77f8tpck2llbt9601a` FOREIGN KEY (`id_ubicacion`) REFERENCES `ubicacion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_ubicacion`
--

LOCK TABLES `producto_ubicacion` WRITE;
/*!40000 ALTER TABLE `producto_ubicacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_ubicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_venta`
--

DROP TABLE IF EXISTS `producto_venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_venta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` int(11) NOT NULL,
  `descuento` decimal(38,2) NOT NULL,
  `precio_unitario` decimal(38,2) NOT NULL,
  `sub_total` decimal(38,2) NOT NULL,
  `id_producto` bigint(20) NOT NULL,
  `id_venta` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8kivvednv551u6vlw1kc6ven4` (`id_producto`),
  KEY `FK8h82j85vtrwupxok60t5l5g9l` (`id_venta`),
  CONSTRAINT `FK8h82j85vtrwupxok60t5l5g9l` FOREIGN KEY (`id_venta`) REFERENCES `venta` (`id`),
  CONSTRAINT `FK8kivvednv551u6vlw1kc6ven4` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_venta`
--

LOCK TABLES `producto_venta` WRITE;
/*!40000 ALTER TABLE `producto_venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_venta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `direccion` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `nit` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `razon_social` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES
(1,NULL,NULL,'2025-07-24 15:22:20.556593',NULL,'Inti',NULL,NULL),
(2,NULL,NULL,'2025-07-24 15:27:35.361222',NULL,'Inti',NULL,NULL),
(3,NULL,NULL,'2025-07-24 16:01:49.695310',NULL,'Inti',NULL,NULL),
(4,NULL,NULL,'2025-07-24 16:33:22.791375',NULL,'FarmaOlivos',NULL,NULL),
(5,'Av. Tun├®l el Abra','farmaolivos@gmail.com','2025-07-24 16:35:47.227669',NULL,'FarmaOlivos','Cadena de Farmacias Olivos',NULL);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tienda`
--

DROP TABLE IF EXISTS `tienda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `tienda` (
  `id` bigint(20) NOT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `fecha_registro` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tienda`
--

LOCK TABLES `tienda` WRITE;
/*!40000 ALTER TABLE `tienda` DISABLE KEYS */;
/*!40000 ALTER TABLE `tienda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubicacion`
--

DROP TABLE IF EXISTS `ubicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ubicacion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `id_tienda` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4f28kb108a8085gn5v0hjmk3m` (`id_tienda`),
  CONSTRAINT `FK4f28kb108a8085gn5v0hjmk3m` FOREIGN KEY (`id_tienda`) REFERENCES `tienda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubicacion`
--

LOCK TABLES `ubicacion` WRITE;
/*!40000 ALTER TABLE `ubicacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `ubicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `rol` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `apellido` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `telefono` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK863n1y3x0jalatoir4325ehal` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES
(3,'Pablexo','Pase123','Administrador','pablo','Vargas','Sacaba, c/Colombia','75979100'),
(4,'Cesar','pase123','Cajero','cesar','Moralejas','Quillacollo plaza Bolivar','72426985'),
(5,'Javier','Pass123','Cajero','javo','Vargas','Calle coronel sanchez, nro. 722',NULL),
(6,'Natalia','Pass123','Vendedor','navito','Osinaga','Calle coronel sanchez, nro. 722',NULL),
(7,'Mateo','Pass123','Vendedor','mate','Osinaga','Calle coronel sanchez, nro. 722',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_registro` datetime(6) NOT NULL,
  `observacion` varchar(255) NOT NULL,
  `total` decimal(38,2) NOT NULL,
  `id_cliente` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsor2qmi3thao7a8or49vlohp9` (`id_cliente`),
  KEY `FKoilu1fdfgmu7sfe0spen005ms` (`id_usuario`),
  CONSTRAINT `FKoilu1fdfgmu7sfe0spen005ms` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`),
  CONSTRAINT `FKsor2qmi3thao7a8or49vlohp9` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-07-25 16:26:02
