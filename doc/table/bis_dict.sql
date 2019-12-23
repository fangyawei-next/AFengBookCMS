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

/*Table structure for table `bis_dict` */

DROP TABLE IF EXISTS `bis_dict`;

CREATE TABLE `bis_dict` (
  `bis_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `bis_name` varchar(50) DEFAULT NULL,
  `bis_detail` varchar(255) DEFAULT NULL COMMENT '详细',
  `bis_sort` bigint(10) DEFAULT NULL COMMENT '类别',
  `bis_flag` int(1) DEFAULT '1' COMMENT '1 启用(默认) 0弃用',
  PRIMARY KEY (`bis_id`),
  KEY `FK86A81DFD5290B8AC` (`bis_sort`),
  CONSTRAINT `FK86A81DFD5290B8AC` FOREIGN KEY (`bis_sort`) REFERENCES `bis_dict_sort` (`sort_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

/*Data for the table `bis_dict` */

insert  into `bis_dict`(`bis_id`,`bis_name`,`bis_detail`,`bis_sort`,`bis_flag`) values (1,'科技','',1,1),(2,'文艺','',1,1),(3,'医用','',1,1),(4,'未知','',1,1),(51,'在库','',2,1),(52,'上架','',2,1),(53,'下架','',2,1),(54,'预定','',2,1),(55,'已领读','',2,1),(56,'弃用','',2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
