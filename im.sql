/*
SQLyog Community v8.7 RC
MySQL - 5.5.46-0ubuntu0.14.04.2 : Database - imanagement
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`imanagement` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `imanagement`;

/*Table structure for table `inventory` */

DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `inventory_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_path` varchar(255) DEFAULT NULL,
  `inventory_name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `purchase_date` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `is_busy` int(11) DEFAULT NULL,
  PRIMARY KEY (`inventory_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

/*Data for the table `inventory` */

insert  into `inventory`(`inventory_id`,`file_path`,`inventory_name`,`price`,`serial_number`,`purchase_date`,`type`,`is_busy`) values (1,'path','jabra',2000,'j-0001','12-03-2015','Speakers',1),(2,'path','TT Ball',10,'t-0002','12-03-2016','Sports',1),(3,'path','TT Bat',879,'TT-8776','12-03-2015','Sports',1),(4,'path','HP Laptop',45000,'HP-120012','12-03-2015','Electronics',1),(5,'path','Lenovo Laptop',50000,'T410','12-03-2015','Electronics',1),(6,'path','Airtel Dongle',2000,'D-001','12-03-2015','Electronics',0),(7,'path','Docomo Dongle',2000,'D-002','12-03-2015','Electronics',0);

/*Table structure for table `transaction_details` */

DROP TABLE IF EXISTS `transaction_details`;

CREATE TABLE `transaction_details` (
  `transaction_id` int(11) NOT NULL AUTO_INCREMENT,
  `flag` varchar(255) DEFAULT NULL,
  `inventory_name` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaction_details` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `blood_group` varchar(255) DEFAULT NULL,
  `doj` varchar(255) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `project` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`user_id`,`blood_group`,`doj`,`email_id`,`file_path`,`gender`,`phone_number`,`user_name`,`project`) values (1,'O+ve','15th Aug','pratyush@gmail.com','give you local path','male','778565886','Pratyush','ML'),(2,'O+ve','15th Aug','Shree@gmail.com','give your local path','male','767657698','Shreesha','Shreds'),(3,'O+ve','15th Aug','Swamy@gmail.com','give your local path','male','868755869','Swamy','Shreds'),(4,'O+ve','15th Aug','Abish@gmail.com','give your local path','male','665409867','Abish','Dev-Ops'),(5,'O+ve','15th Aug','Nitanka ','give your local path','male','897867687','Nitanka','Dev-Ops');

/*Table structure for table `user_inventory` */

DROP TABLE IF EXISTS `user_inventory`;

CREATE TABLE `user_inventory` (
  `user_user_id` int(11) NOT NULL,
  `inventory_inventory_id` int(11) NOT NULL,
  PRIMARY KEY (`user_user_id`,`inventory_inventory_id`),
  UNIQUE KEY `UK_moghloha3nrp47qw8qlf023kb` (`inventory_inventory_id`),
  CONSTRAINT `FK_enrxspsj60qbegvb2ivr6u52` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `FK_moghloha3nrp47qw8qlf023kb` FOREIGN KEY (`inventory_inventory_id`) REFERENCES `inventory` (`inventory_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `user_inventory` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
