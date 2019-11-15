-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: sp
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
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程的id',
  `course_time` varchar(15) DEFAULT NULL,
  `course_name` varchar(45) DEFAULT NULL COMMENT '课程的姓名',
  `course_introduce` varchar(200) DEFAULT NULL COMMENT '课程的介绍',
  `course_photo` varchar(45) DEFAULT '/images/course/课程.png' COMMENT '课程的图标',
  `course_teacher` int(11) DEFAULT NULL,
  `course_hour` varchar(45) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8 COMMENT='课程的信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'2019/10/18','大学生职业发展与就业指导','这是创新创业课','/images/course/1.png',1,NULL),(2,'2019/10/19','解析几何','这是数学课','/images/course/1.png',2,NULL),(3,'2019/10/20','数学分析1(上)','这是数学课','/images/course/1.png',3,NULL),(4,'2019/10/21','高等代数Ⅰ','无','/images/course/1.png',4,NULL),(5,'2019/10/22','计算机基础','无','/images/course/1.png',1,NULL),(6,'2019/10/23','体育','无','/images/course/1.png',2,NULL),(7,'2019/10/24','思想道德修养和法律基础','无','/images/course/1.png',3,NULL),(8,'2019/10/25','形势与政策Ⅰ','无','/images/course/1.png',4,NULL),(9,'2019/10/26','应用文写作','无','/images/course/1.png',1,NULL),(10,'2019/10/27','大学英语精读Ⅰ','无','/images/course/1.png',2,NULL),(11,'2019/10/28','心理健康教育Ⅰ','无','/images/course/1.png',3,NULL),(12,'2019/10/29','计算机基础实验','无','/images/course/1.png',4,NULL),(13,'2019/10/30','大学英语自主学习听说训练课Ⅰ','无','/images/course/1.png',1,NULL),(14,'2019/10/31','孙子兵法','无','/images/course/1.png',2,NULL),(15,'2019/11/1','积极心理学','无','/images/course/1.png',3,NULL),(16,'2019/11/2','数学分析1(中)','无','/images/course/1.png',4,NULL),(17,'2019/11/3','大学物理2','无','/images/course/1.png',1,NULL),(18,'2019/11/4','高等代数Ⅱ','无','/images/course/1.png',2,NULL),(19,'2019/11/5','程序设计基础','无','/images/course/1.png',3,NULL),(20,'2019/11/6','C++','无','/images/course/1.png',4,NULL),(21,'2019/11/7','体育选项课Ⅰ','无','/images/course/1.png',1,NULL),(22,'2019/11/8','马克思主义基本原理','无','/images/course/1.png',2,NULL),(23,'2019/11/9','形势与政策Ⅱ','无','/images/course/1.png',3,NULL),(24,'2019/11/10','大学英语精读Ⅱ','无','/images/course/1.png',4,NULL),(25,'2019/11/11','军事理论','无','/images/course/1.png',1,NULL),(26,'2019/11/12','心理健康教育Ⅱ','无','/images/course/1.png',2,NULL),(27,'2019/11/13','程序设计基础实验','无','/images/course/1.png',3,NULL),(28,'2019/11/14','专业认知实习(信息与计算科学)','无','/images/course/1.png',4,NULL),(29,'2019/11/15','C++实验','无','/images/course/1.png',1,NULL),(30,'2019/11/16','大学英语自主学习听说训练课Ⅱ','无','/images/course/1.png',2,NULL),(31,'2019/11/17','美术鉴赏','无','/images/course/1.png',3,NULL),(32,'2019/11/18','大学生KAB创业基础','无','/images/course/1.png',4,NULL),(33,'2019/11/19','JAVA程序设计','无','/images/course/1.png',1,NULL),(34,'2019/11/20','数学分析1(下)','无','/images/course/1.png',2,NULL),(35,'2019/11/21','数据结构6','无','/images/course/1.png',3,NULL),(36,'2019/11/22','数据库原理及其应用','无','/images/course/1.png',4,NULL),(37,'2019/11/23','专业英语(信息与计算科学)','无','/images/course/1.png',1,NULL),(38,'2019/11/24','中国近现代史纲要','无','/images/course/1.png',2,NULL),(39,'2019/11/25','形势与政策Ⅲ','无','/images/course/1.png',3,NULL),(40,'2019/11/26','大学物理2实验','无','/images/course/1.png',4,NULL),(41,'2019/11/27','JAVA程序设计实验','无','/images/course/1.png',1,NULL),(42,'2019/11/28','程序设计综合课程设计','无','/images/course/1.png',2,NULL),(43,'2019/11/29','数据库原理及其应用实验','无','/images/course/1.png',3,NULL),(44,'2019/11/30','数据结构6实验2','无','/images/course/1.png',4,NULL),(45,'2019/12/1','体育选项课Ⅱ','无','/images/course/1.png',1,NULL),(46,'2019/12/2','大学英语自主学习听说训练课Ⅲ','无','/images/course/1.png',2,NULL),(47,'2019/12/3','大学英语Ⅲ','无','/images/course/1.png',3,NULL),(48,'2019/12/4','概率论与数理统计4','无','/images/course/1.png',4,NULL),(49,'2019/12/5','最优化方法','无','/images/course/1.png',1,NULL),(50,'2019/12/6','信息与计算科学专业导论','无','/images/course/1.png',2,NULL),(51,'2019/12/7','VC++高级程序设计','无','/images/course/1.png',3,NULL),(52,'2019/12/8','面向对象分析与设计','无','/images/course/1.png',4,NULL),(53,'2019/12/9','数学软件','无','/images/course/1.png',1,NULL),(54,'2019/12/10','体育选项课Ⅲ','无','/images/course/1.png',2,NULL),(55,'2019/12/11','毛泽东思想和中国特色社会主义理论体系概论(上)','无','/images/course/1.png',3,NULL),(56,'2019/12/12','形势与政策Ⅳ','无','/images/course/1.png',4,NULL),(57,'2019/12/13','数学软件实验','无','/images/course/1.png',1,NULL),(58,'2019/12/14','WEB前端设计技术Ⅰ','无','/images/course/1.png',2,NULL),(59,'2019/12/15','VC++高级程序设计实验','无','/images/course/1.png',3,NULL),(60,'2019/12/16','面向对象分析与设计实验','无','/images/course/1.png',4,NULL),(61,'2019/12/17','面向对象编程课程设计','无','/images/course/1.png',1,NULL),(62,'2019/12/18','大学英语自主学习听说训练课Ⅳ','无','/images/course/1.png',2,NULL),(63,'2019/12/19','大学英语Ⅳ','无','/images/course/1.png',3,NULL),(64,'2019/12/20','算法分析与设计1','无','/images/course/1.png',4,NULL),(65,'2019/12/21','常微分方程','无','/images/course/1.png',1,NULL),(66,'2019/12/22','数值分析2','无','/images/course/1.png',2,NULL),(67,'2019/12/23','软件工程（双语）','无','/images/course/1.png',3,NULL),(68,'2019/12/24','数据可视化技术','无','/images/course/1.png',4,NULL),(69,'2019/12/25','数据挖掘','无','/images/course/1.png',1,NULL),(70,'2019/12/26','计算机网络2课程设计','无','/images/course/1.png',2,NULL),(71,'2019/12/27','软件工程(双语)课程设计','无','/images/course/1.png',3,NULL),(72,'2019/12/28','数值分析2实验','无','/images/course/1.png',4,NULL),(73,'2019/12/29','软件工程（双语）实验2','无','/images/course/1.png',1,NULL),(74,'2019/12/30','数据可视化技术实验','无','/images/course/1.png',2,NULL),(75,'2019/12/31','数据挖掘实验','无','/images/course/1.png',3,NULL),(76,'2020/1/1','WEB前端设计技术Ⅱ','无','/images/course/1.png',4,NULL),(77,'2020/1/2','微分方程数值解','无','/images/course/1.png',1,NULL),(78,'2020/1/3','UNIX操作系统','无','/images/course/1.png',2,NULL),(79,'2020/1/4','操作系统2','无','/images/course/1.png',3,NULL),(80,'2020/1/5','计算机网络2实验','无','/images/course/1.png',4,NULL),(81,'2020/1/6','信息安全','无','/images/course/1.png',1,NULL),(82,'2020/1/7','计算机网络2','无','/images/course/1.png',2,NULL),(83,'2020/1/8','信息与编码','无','/images/course/1.png',3,NULL),(84,'2020/1/9','毛泽东思想和中国特色社会主义理论体系概论(下)','无','/images/course/1.png',4,NULL),(85,'2020/1/10','计算机组成原理2','无','/images/course/1.png',1,NULL),(86,'2020/1/11','Android系统开发技术','无','/images/course/1.png',2,NULL),(87,'2020/1/12','UNIX操作系统实验','无','/images/course/1.png',3,NULL),(88,'2020/1/13','计算机组成原理2实验','无','/images/course/1.png',4,NULL),(89,'2020/1/14','信息安全实验','无','/images/course/1.png',1,NULL),(90,'2020/1/15','Android系统开发技术实验','无','/images/course/1.png',2,NULL),(92,'2020/1/17','综合实习(信息与计算科学)','无','/images/course/1.png',3,NULL),(93,'2020/1/18','政治理论实践课(概论下)','无','/images/course/1.png',4,NULL);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-04 17:18:47
