-- Adminer 4.8.1 MySQL 11.3.2-MariaDB-1:11.3.2+maria~ubu2204 dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

CREATE DATABASE `dungeons_and_dragons` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `dungeons_and_dragons`;

DROP TABLE IF EXISTS `DefensiveEquipment`;
CREATE TABLE `DefensiveEquipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` mediumtext DEFAULT NULL,
  `type` mediumtext NOT NULL,
  `heroType` int(11) NOT NULL,
  `defense` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `DefensiveEquipment_HeroType_id_fk` (`heroType`),
  CONSTRAINT `DefensiveEquipment_HeroType_id_fk` FOREIGN KEY (`heroType`) REFERENCES `HeroType` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `Hero`;
CREATE TABLE `Hero` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` mediumtext NOT NULL,
  `life` int(11) DEFAULT NULL,
  `type` int(11) NOT NULL,
  `offensiveEquipment` int(11) NOT NULL,
  `defensiveEquipment` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Hero_DefensiveEquipment_id_fk` (`defensiveEquipment`),
  KEY `Hero_OffensiveEquipment_id_fk` (`offensiveEquipment`),
  KEY `Hero_HeroType_id_fk` (`type`),
  CONSTRAINT `Hero_DefensiveEquipment_id_fk` FOREIGN KEY (`defensiveEquipment`) REFERENCES `DefensiveEquipment` (`id`),
  CONSTRAINT `Hero_HeroType_id_fk` FOREIGN KEY (`type`) REFERENCES `HeroType` (`id`),
  CONSTRAINT `Hero_OffensiveEquipment_id_fk` FOREIGN KEY (`offensiveEquipment`) REFERENCES `OffensiveEquipment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `HeroType`;
CREATE TABLE `HeroType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` mediumtext NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


DROP TABLE IF EXISTS `OffensiveEquipment`;
CREATE TABLE `OffensiveEquipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` mediumtext DEFAULT NULL,
  `type` mediumtext NOT NULL,
  `heroType` int(11) NOT NULL,
  `damage` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `OffensiveEquipment_HeroType_id_fk` (`heroType`),
  CONSTRAINT `OffensiveEquipment_HeroType_id_fk` FOREIGN KEY (`heroType`) REFERENCES `HeroType` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


-- 2024-05-17 14:23:46
