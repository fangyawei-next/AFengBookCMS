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

/*Table structure for table `sys_user_detail` */

DROP TABLE IF EXISTS `sys_user_detail`;

CREATE TABLE `sys_user_detail` (
  `detail_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `detail_name` char(12) DEFAULT NULL,
  `detail_sex` char(3) DEFAULT NULL,
  `detail_date` date DEFAULT NULL,
  `detail_phone` char(11) DEFAULT NULL,
  `detail_email` varchar(25) DEFAULT NULL,
  `detail_autograph` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_detail` */

insert  into `sys_user_detail`(`detail_id`,`detail_name`,`detail_sex`,`detail_date`,`detail_phone`,`detail_email`,`detail_autograph`) values (1,'方亚伟','男','2019-12-03','15638623278','206323705@qq.com','人在做,天再看'),(2,'fyww','女','2019-12-16','15638626488','187945@qq.com','ren'),(4,'放呀','男','2019-12-17','1564594897','',''),(5,NULL,NULL,'2019-12-18',NULL,NULL,NULL),(6,NULL,NULL,'2019-12-18',NULL,NULL,NULL),(7,NULL,NULL,'2019-12-18',NULL,NULL,NULL),(8,NULL,NULL,'2019-12-18',NULL,NULL,NULL),(9,NULL,NULL,'2019-12-18',NULL,NULL,NULL),(10,NULL,NULL,'2019-12-18',NULL,NULL,NULL),(11,NULL,NULL,'2019-12-18',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
