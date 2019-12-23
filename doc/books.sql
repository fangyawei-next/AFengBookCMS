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

/*Table structure for table `bis_dict_sort` */

DROP TABLE IF EXISTS `bis_dict_sort`;

CREATE TABLE `bis_dict_sort` (
  `sort_id` bigint(10) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(20) DEFAULT NULL,
  `sort_detail` varchar(100) DEFAULT NULL,
  `sort_flag` varchar(6) DEFAULT '1',
  PRIMARY KEY (`sort_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `bis_dict_sort` */

insert  into `bis_dict_sort`(`sort_id`,`sort_name`,`sort_detail`,`sort_flag`) values (1,'图书类别',NULL,'1'),(2,'图书状态',NULL,'1');

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

/*Table structure for table `file_upload` */

DROP TABLE IF EXISTS `file_upload`;

CREATE TABLE `file_upload` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `suffix` varchar(10) DEFAULT NULL,
  `address` varchar(110) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `file_upload` */

insert  into `file_upload`(`id`,`file_name`,`name`,`suffix`,`address`,`status`) values (1,'e2a607a6aa213286eaca2409affc0576.png','e2a607a6aa213286eaca2409affc0576','png','http://192.168.25.133/group1/M00/00/01/wKgZhV36M3GAKfvIAABBXjFOxTk947.jpg','已使用');

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

/*Table structure for table `sys_role` */

DROP TABLE IF EXISTS `sys_role`;

CREATE TABLE `sys_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户权限id',
  `role_name` varchar(50) NOT NULL COMMENT '用户权限昵称',
  `role_desc` varchar(50) DEFAULT NULL COMMENT '用户权限备注',
  `role_flag` int(11) DEFAULT '0' COMMENT '用户权限是否启用 1启用',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_desc`,`role_flag`) values (1,'开发者','最高权限',1),(2,'管理员',NULL,1),(3,'会员',NULL,1),(4,'普通成员','注册后即成为普通会员',1),(5,'游客','只拥有浏览看书的权限',1);

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
