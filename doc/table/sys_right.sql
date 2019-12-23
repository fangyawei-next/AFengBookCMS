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

/*Table structure for table `sys_right` */

DROP TABLE IF EXISTS `sys_right`;

CREATE TABLE `sys_right` (
  `right_code` varchar(50) NOT NULL,
  `right_parent_code` varchar(50) DEFAULT NULL,
  `right_type` varchar(20) DEFAULT NULL,
  `right_text` varchar(50) DEFAULT NULL,
  `right_url` varchar(100) DEFAULT NULL,
  `right_tip` varchar(50) DEFAULT NULL,
  `right_img` varchar(100) DEFAULT NULL,
  `right_isCurrent` char(5) DEFAULT 'false',
  `right_isFlag` int(5) DEFAULT '1' COMMENT '是否弃用,0弃用1启用',
  PRIMARY KEY (`right_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_right` */

insert  into `sys_right`(`right_code`,`right_parent_code`,`right_type`,`right_text`,`right_url`,`right_tip`,`right_img`,`right_isCurrent`,`right_isFlag`) values ('L01','ROOT_MENU','Folder','主数据',NULL,'主数据','&#xe61e;','false',1),('L0101','L01','Document','首页','workbench.html','首页',NULL,'true',1),('L0102','L01','Folder','二级页面',NULL,'二级页面',NULL,'false',1),('L0103','L01','Document','招标流程','process.html','招标流程',NULL,'false',1),('L0104','L01','Document','供应商列表','providers.html','供应商列表',NULL,'false',1),('L02','ROOT_MENU','Folder','用户管理',NULL,'用户管理','&#xe62f;','false',1),('L0201','L02','Document','用户列表','../bookcms/user_manager/user/list','用户列表',NULL,'false',1),('L0202','L02','Document','管理员列表',NULL,'管理员列表',NULL,'false',1),('L0203','L02','Document','会员列表',NULL,'会员列表',NULL,'false',1),('L0204','L02','Document','普通成员列表',NULL,'普通成员列表',NULL,'false',1),('L0205','L02','Document','游客列表',NULL,'游客列表',NULL,'false',1),('L03','ROOT_MENU','Folder','图书管理','','图书管理','&#xe611;','false',1),('L0301','L03','Document','图书列表','../bookcms/book_manager/book/list','图书列表',NULL,'false',1),('L0302','L03','Document','上架图书列表',NULL,'上架图书列表',NULL,'false',1),('L0303','L03','Document','库存图书列表',NULL,'库存图书列表',NULL,'false',1),('L04','ROOT_MENU','Folder','电子书管理',NULL,'电子书管理','&#xe64b;','false',1),('L0401','L04','Document','电子书列表',NULL,'电子书列表',NULL,'false',1),('L0402','L04','Document','最新电子书列表',NULL,'最新电子书列表',NULL,'false',1),('L0403','L04','Document','最热电子书列表',NULL,'最热电子书列表',NULL,'false',1),('L05','ROOT_MENU','Folder','权限管理',NULL,'权限管理','&#xe620;','false',1),('L0501','L05','Document','权限列表',NULL,'权限列表',NULL,'false',1),('L0502','L05','Document','弃用权限列表',NULL,'弃用权限列表',NULL,'false',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
