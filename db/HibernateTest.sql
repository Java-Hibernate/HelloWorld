CREATE DATABASE IF NOT EXISTS `HibernateTest`;
USE `HibernateTest`;

GRANT ALL ON HibernateTest.* TO 'hibernateUser'@'localhost' IDENTIFIED BY 'hibernateUser';
FLUSH PRIVILEGES;

-- ------------------------------------------------------
-- Host: 127.0.0.1    Database: HibernateTest
-- Auth: Kemal Sami KARACA
-- ------------------------------------------------------
-- Server version	5.6.26

DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

LOCK TABLES `User` WRITE;
INSERT INTO `User` VALUES (1,'kemalsami','kemalsami','kskaraca@gmail.com');
UNLOCK TABLES;

