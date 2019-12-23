/*
SQLyog v10.2 
MySQL - 5.5.50 : Database - books
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`books` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `books`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `price` double(10,2) DEFAULT NULL,
  `num` varchar(10) DEFAULT NULL,
  `image` varchar(110) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `sort` bigint(10) NOT NULL,
  `state` bigint(10) NOT NULL,
  `start_date` timestamp NULL DEFAULT NULL,
  `end_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8u1ne0kawykqwgdja77fpc7xx` (`sort`),
  KEY `FK3myyiknvh9lpjyk3rax0o1dtd` (`state`),
  CONSTRAINT `FK3myyiknvh9lpjyk3rax0o1dtd` FOREIGN KEY (`state`) REFERENCES `bis_dict` (`bis_id`),
  CONSTRAINT `FK8u1ne0kawykqwgdja77fpc7xx` FOREIGN KEY (`sort`) REFERENCES `bis_dict` (`bis_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `book` */

insert  into `book`(`id`,`name`,`price`,`num`,`image`,`detail`,`author`,`sort`,`state`,`start_date`,`end_date`) values (1,'热爱和平',10.01,'21','','这是一本非常美妙的书,内容齐全,丰富多彩适合读者的阅读','Make',1,51,'2019-12-17 17:03:03',NULL),(2,'热爱生命',20.00,'0','http://192.168.25.133/group1/M00/00/01/wKgZhV36M3GAKfvIAABBXjFOxTk947.jpg','热爱生命等于快乐的起始','方',4,51,NULL,NULL),(3,'无极之道',NULL,'1','','','',4,51,NULL,NULL),(4,'无极',NULL,'1','','','',4,51,NULL,NULL),(5,'热爱和平',10.01,'20','','这是一本非常美妙的书,内容齐全,丰富多彩适合读者的阅读','Make',1,51,NULL,NULL),(6,'热爱',20.00,'1','','sda','D.S',4,51,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
