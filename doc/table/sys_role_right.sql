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

/*Table structure for table `sys_role_right` */

DROP TABLE IF EXISTS `sys_role_right`;

CREATE TABLE `sys_role_right` (
  `rf_right_code` varchar(50) NOT NULL,
  `rf_role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`rf_right_code`,`rf_role_id`),
  KEY `FK550439C52683C738` (`rf_role_id`),
  CONSTRAINT `FK550439C51D9DB87A` FOREIGN KEY (`rf_right_code`) REFERENCES `sys_right` (`right_code`),
  CONSTRAINT `FK550439C52683C738` FOREIGN KEY (`rf_role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_right` */

insert  into `sys_role_right`(`rf_right_code`,`rf_role_id`) values ('L01',1),('L0101',1),('L0102',1),('L0103',1),('L0104',1),('L02',1),('L0201',1),('L0202',1),('L0203',1),('L0204',1),('L0205',1),('L03',1),('L0301',1),('L0302',1),('L0303',1),('L04',1),('L0401',1),('L0402',1),('L0403',1),('L05',1),('L0501',1),('L0502',1),('L02',2),('L0201',2),('L03',2),('L0301',2),('L01',3),('L0101',3),('L0102',3),('L0103',3),('L0104',3),('L01',4),('L0101',4),('L0102',4),('L0103',4),('L0104',4),('L01',5),('L03',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
