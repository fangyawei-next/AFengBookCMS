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

/*Table structure for table `sys_user` */

DROP TABLE IF EXISTS `sys_user`;

CREATE TABLE `sys_user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `user_password` varchar(50) NOT NULL COMMENT '用户密码',
  `user_flag` int(11) NOT NULL DEFAULT '1' COMMENT '是否启用 0弃用',
  `user_role_id` bigint(20) DEFAULT '5' COMMENT '用户管理员权限 联表',
  `user_detail_id` bigint(20) DEFAULT NULL COMMENT '用户详情 联表',
  PRIMARY KEY (`user_id`),
  KEY `FK74A81DFD8490B8AC` (`user_role_id`),
  KEY `FK75A81DFD8890B8AC` (`user_detail_id`),
  CONSTRAINT `FK74A81DFD8490B8AC` FOREIGN KEY (`user_role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FK75A81DFD8890B8AC` FOREIGN KEY (`user_detail_id`) REFERENCES `sys_user_detail` (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`user_name`,`user_password`,`user_flag`,`user_role_id`,`user_detail_id`) values (2,'xiaobai','123',0,2,NULL),(4,'admin1','123',1,1,NULL),(5,'admin2','123',1,5,NULL),(6,'admin3','123',1,5,NULL),(7,'admin4','123',1,5,NULL),(8,'admin5','123',1,5,NULL),(9,'admin7','123',1,5,NULL),(10,'admin8','123',1,5,NULL),(11,'admin9','123',1,5,NULL),(12,'admin10','123',0,5,NULL),(13,'admin11','123',1,3,4),(17,'admin','123',1,1,1),(18,'admin12','a123',1,2,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
