CREATE DATABASE  IF NOT EXISTS `libreria` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `libreria`;
-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: libreria
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(45) NOT NULL,
  `detalle` varchar(90) NOT NULL,
  `ruta_imagen` varchar(200) DEFAULT NULL,
  `codigo_lote` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'3154148457244','Marcador MAPED x10 Océano',NULL,NULL),(2,'7798000080711','Lapicera Simball Glitter x10',NULL,NULL),(3,'3154140182113','Trinchetas Maped 18mm',NULL,NULL),(4,'7797467000058','Plasticola MAXXUM x50g',NULL,NULL),(5,'25','Marcador resaltador ITO',NULL,NULL),(6,'3154148132202','Acuarela MODEL x12',NULL,NULL),(7,'7791762000577','Cuaderno ÉXITO Nº 3 x48 hojas',NULL,NULL),(8,'7796893002063','Papel glace metalizado LUMA',NULL,NULL),(9,'7796893002070','Papel glace flúor',NULL,NULL),(10,'7796893002056','Papel glace común',NULL,NULL),(11,'30','Adhesivo SEÑORITA color flúor x30grs',NULL,NULL),(12,'070330125308','Bolígrafo BIC negro trazo grueso',NULL,NULL),(13,'070330183575','Bolígrafo BIC azul fino',NULL,NULL),(14,'070330183599','Bolígrafo BIC rojo fino',NULL,NULL),(15,'070330126268','Bolígrafo BIC verde trazo grueso',NULL,NULL),(16,'4971850137931','Calculadora CASIO FX-82MS 240',NULL,NULL),(17,'7791762486128','Repuesto ÉXITO común rayado x96 hojas',NULL,NULL),(18,'7791762480423','Repuesto ÉXITO cuadriculado c/margen reforzado x96 hojas',NULL,NULL),(19,'7791762480126','Repuesto ÉXITO c/margen reforzado x 96 hojas',NULL,NULL),(20,'7798109600056','Cotillón globo Nº 90 Feliz cumpleaños',NULL,NULL),(21,'7796569010019','Mapa MUNDO TRIUNFANTE Nº3',NULL,NULL),(22,'7891360533016','Lápices bicolor FABER-CASTELL x12u',NULL,NULL),(23,'3154141832123','Lápices de colores MAPED COLOR PEPS simple x12u',NULL,NULL),(24,'070330422117','Lápices de colores BIC BICOLOR x 18u',NULL,NULL),(25,'7793198471204','Lápices de colores PIZZINI BICOLOR x 12u',NULL,NULL),(26,'7793198271231','Lápices de colores PIZZINI x12u + 3 negros',NULL,NULL),(27,'3154148340102','Lápices de colores MAPED COLOR PEPS x12u',NULL,NULL),(28,'7891360644293','Lápices de colores FABER-CASTELL x18u c/ +6 neón',NULL,NULL),(29,'7795245104011','Lápices de colores SYLVAPEN x12u',NULL,NULL),(30,'3154148296003','Lápices de colores MAPED DUO COLOR PEPS x 12u = 24 colores',NULL,NULL),(31,'7798159810863','Tèmpera Suelta PLAY COLOR',NULL,NULL),(32,'7798159810832','Tèmpera suelta PLAY COLOR color violeta',NULL,NULL),(33,'7798159810276','Tèmpera surtida PLAY COLOR 10 unidades',NULL,NULL),(34,'7798159810818','Tèmpera suelta PLAY COLOR blanco',NULL,NULL),(35,'7798159810849','Tèmpera suelta PLAY COLOR color amarillo medio',NULL,NULL),(36,'7798159810825','Tèmpera suelta PLAY COLOR color negro',NULL,NULL),(37,'1','Afiche comùn',NULL,NULL),(38,'7798000082197','Portamina 0,5mm',NULL,NULL),(39,'7798000082203','Lapicera portamina',NULL,NULL),(40,'7798006808692','Recibo chico Mil 28',NULL,NULL),(41,'7798006803055','Repuesto de Dibujo Nº 3 Blanco Mil 28',NULL,NULL),(42,'7798006803116','Repuesto de Dibujo Nº 5 Blanco Mil 28',NULL,NULL),(43,'7792216155102','Repuesto de Dibujo Nº 3 Blanco Rivadavia',NULL,NULL),(44,'7441030677542','Mezcladora PROARTE 6 cavidades',NULL,NULL),(45,'6939540573085','Regla 20 cm KeyRoad Flex',NULL,NULL),(46,'7795245102024','Marcadores gruesos Silvapen x 12',NULL,NULL),(47,'7795513053638','Marcadores gruesos Filgo Jumbo x 10',NULL,NULL),(48,'7795513077337','Marcador Resaltador Pastel Filgo x 4',NULL,NULL),(49,'7798000089226','Bolígrafos Micro Dolce largos 10 colores',NULL,NULL),(50,'7798000082166','Bolígrafos Micro Dolce Mini x 10',NULL,NULL),(51,'7798000080650','Marcador Simball x 12 Largo',NULL,NULL),(52,'7795513075098','Marcador Filgo Largo Finos x 6',NULL,NULL),(53,'7795513049617','Lapices Colores Filgo x 12 Cortos',NULL,NULL),(54,'7798147970357','Bengala Holog. Party Store x 1',NULL,NULL),(55,'3154141342103','Minas Maped p/Compás x 10',NULL,NULL),(56,'3154140632113','Sacapuntas Maped Plastico color',NULL,NULL),(57,'7796569700545','Plastilina x 1 unidad',NULL,NULL),(58,'7798100576688','Acrilico A.D. Decorativo Chico colores',NULL,NULL),(59,'7798159810450','Témpera PLAYCOLOR Rojo Señal x300 g',NULL,NULL),(60,'7798006803161','Repuesto de Dibujo Nº 6 Blanco Mil 28',NULL,NULL),(61,'3154148360117','Lápices de colores Maped AQUA x12 colores',NULL,NULL),(62,'7795513044728','Lápices de colores Filgo x12 colores',NULL,NULL),(63,'070330946446','Lápices de colores Bic x12 colores + 4 negros',NULL,NULL),(64,'7891360631101','Lápices de colores Faber-Castell x12 colores + 3 negros',NULL,NULL),(65,'7891360638681','Lápices de colores cortos Faber-Castell x12 colores',NULL,NULL),(66,'070330411906','Lápices Bic de colores cortos x12 colores',NULL,NULL),(67,'7891360638667','Lápices de colores cortos Faber-Castell x6 colores',NULL,NULL),(68,'3154148325000','Lápices de colores  cortos Maped x12 colores',NULL,NULL),(69,'7891360637042','Lápices de colores largos Faber-Castell x24 colores',NULL,NULL),(70,'3154141832246','Lápices de colores largos Maped x24 colores',NULL,NULL),(71,'7796569700842','Plastilina suelta tintoretto color roja',NULL,NULL),(72,'7796569701047','Plastilina suelta Tintoretto color celeste',NULL,NULL),(73,'7796569700248','Plastilina suelta Tintoretto color verde',NULL,NULL),(74,'7796569700644','Plastilina suelta Tintoretto color amarilla',NULL,NULL),(75,'7796569700941','Plastilina suelta Tintoretto color rosa',NULL,NULL),(76,'7796569700347','Plastilina suelta Tintoretto color marron',NULL,NULL),(77,'7796569700743','Plastilina suelta Tintoretto color naranja',NULL,NULL),(78,'7796569701146','Plastilina suelta Tintoretto color azul',NULL,NULL),(79,'7794765004054','Block Adhesivo UTIL-OF x 100 hojas',NULL,NULL),(80,'7805500003253','Adhesivo PRITT silicona x105 grm',NULL,NULL),(81,'7805500003260','Adhesivo PRITT silicona x30 grms',NULL,NULL),(82,'7798159810153','Adhesivo vinílico PLAYCOLOR x50 grms',NULL,NULL),(83,'7793300417083','Pistola encolada SUPRABOND HX 100',NULL,NULL),(84,'7792533819657','Acuarela SIMBALL x12 colores',NULL,NULL),(85,'3154148454205','Marcador MAPED JUNGLE x12 colores',NULL,NULL),(86,'7792451121177','Pintura para tela DELARTE x37 cc',NULL,NULL),(87,'7798128947125','Acrílico AD decorativo x60 ml',NULL,NULL),(88,'7793198373287','Regla escuadra PIZZINI x35 cm x 60º',NULL,NULL),(89,'3252','Regla PIZZINI x50 cm',NULL,NULL),(90,'7793198373263','Regla escuadra PIZZINI x30cm x60º',NULL,NULL),(91,'3154144681100','Tijera MAPED OFFICE x21cm',NULL,NULL),(92,'7794757260017','Tempera caja MAPED x12 colores',NULL,NULL),(93,'7795513053881','Marcador permanente FILGO',NULL,NULL),(94,'0805','Hilo de algodón para barrilete',NULL,NULL),(95,'7200','Adhesivo vinílico FORTEX x200 grms',NULL,NULL),(96,'7502277855312','Cartuchera canopla cuadrada SABONIS',NULL,NULL),(97,'7502277855244','Cartuchera canopla SABONIS tubo',NULL,NULL),(98,'4511','Cartuchera canopla HOTWHELLS RACING TIME x2 pisos',NULL,NULL),(99,'4512','Cartuchera canopla AVENGERS x3 pisos',NULL,NULL),(100,'28202','Tempera PLAY COLOR MAXXUM ACUEREL pote x250 grms',NULL,NULL),(101,'1620200162019','Papel secante TASMAN x20u x 200grms',NULL,NULL),(102,'7790667011251','Marcador TOYO microfibra - varios colores',NULL,NULL),(103,'7798047120128','Cinta adhesiva de papel AUCA x24mm x 50cm',NULL,NULL),(104,'7798047120517','Cinta adhesiva doble faz AUCA x24mm x 25cm',NULL,NULL),(105,'7798047120494','Cinta adhesiva AUCA bifaz x12mm x 25cm',NULL,NULL),(106,'7798047120470','Cinta adhesiva AUCA escolar x18mm x 20cm',NULL,NULL),(107,'7798047120135','Cinta adhesiva de papel AUCA x36mm x 50cm',NULL,NULL),(108,'7792971000099','Cinta adhesiva de papel STIKO x18mm x 50mts',NULL,NULL),(109,'7798047120043','Cinta adhesiva AUCA transparente',NULL,NULL),(110,'7792533002202','Mojadedo SIFAP',NULL,NULL),(111,'7754111685405','Marcador FABER-CASTELL FABERCITO x10 colores',NULL,NULL),(112,'7794360016711','Marcador FABER-CASTELL FABERCITO x6 colores',NULL,NULL),(113,'7798136890024','Porcelana fría NICRON x250 grms',NULL,NULL),(114,'7798314120240','Acuarela SIMBALL x12 colores',NULL,NULL),(115,'7798047120265','Cinta ancha embalaje x50 x 48 mm',NULL,NULL),(116,'7798047120111','Cinta adhesiva de papel AUCA x18 x 50 mts.',NULL,NULL),(117,'7798047120142','Cinta adhesiva de papel AUCA x48 mm x 50 mts',NULL,NULL),(118,'7795513049860','Marcador FILGO tinta al agua',NULL,NULL),(119,'798047120104','Cinta adhesiva papel AUCA x12 mm x 50 mts',NULL,NULL),(120,'7798194155240','Globo PARTY TIME x50 unidades',NULL,NULL),(121,'7791762480379','Repuesto ÉXITO con margen reforzado x48 hojas',NULL,NULL),(122,'7791762480034','Repuesto ÉXITO con margen reforzado x24 hojas',NULL,NULL),(123,'7795513053362','Marcador FILGO permanente 2 puntas',NULL,NULL),(124,'70','Marcador FILGO LINER microfibra 038 x0.4mm',NULL,NULL),(125,'7798000082050','Corrector mini TAIKO SIMBALL x3ml',NULL,NULL),(126,'7791762480188','Repuesto ÉXITO 480HS rayado con margen reforzado Nº3',NULL,NULL),(127,'7792216050834','Block de dibujo EL NENE nº5 x24 hojas',NULL,NULL),(128,'6925625401725','Calculadora chica CALCU-MAX',NULL,NULL),(129,'7792216041658','Repuesto RIVADAVIA rayado nº3 x96 hojas',NULL,NULL),(130,'7792216041610','Repuesto RIVADAVIA cuadriculado nº3 x24 hojas',NULL,NULL),(131,'7798112712104','Plasticola STA x100 grms',NULL,NULL),(132,'7798156483671','Bolsa de regalo ROMI TROPICAL 14x20 cm',NULL,NULL),(133,'7798156483640','Bolsa de regalo TROPICAL 14x38 cm',NULL,NULL),(134,'7798156485651','Bolsa de regalo ROMI GUARDIA 14x20 cm',NULL,NULL),(135,'798166487679','Bolsa ACUARIO AZUL x14 cm',NULL,NULL),(136,'7798159810498','Tempera PLAYCOLOR Magenta x300 g',NULL,NULL),(137,'7798159810429','Tempera PLAYCOLOR Azul Medio x300 g',NULL,NULL),(138,'7798159810467','Tempera PLAYCOLOR Verde Medio x300 g',NULL,NULL),(139,'7798159810528','Tempera PLAYCOLOR Celeste x300 g',NULL,NULL),(140,'754697543837','Tempera ACUAREL Magenta x250 g',NULL,NULL),(141,'7798159810504','Tempera PLAYCOLOR Marron Madera x300 g',NULL,NULL),(142,'7794757265418','Tempera MODEL Negro x250 g',NULL,NULL),(143,'7798159810511','Tempera PLAYCOLOR Violeta x300 g',NULL,NULL);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-13  1:48:15
