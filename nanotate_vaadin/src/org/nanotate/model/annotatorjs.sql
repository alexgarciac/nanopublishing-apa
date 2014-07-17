-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 18-07-2014 a las 00:25:44
-- Versión del servidor: 5.6.16
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `annotatorjs`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `annotations`
--

DROP TABLE IF EXISTS `annotations`;
CREATE TABLE IF NOT EXISTS `annotations` (
  `annotation_id` varchar(255) NOT NULL,
  `annotator_schema_version` varchar(255) NOT NULL DEFAULT 'v1.0',
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `text` text NOT NULL,
  `quote` text NOT NULL,
  `uri` varchar(500) NOT NULL,
  `user` varchar(500) NOT NULL,
  `consumer` varchar(500) NOT NULL,
  PRIMARY KEY (`annotation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documents`
--

DROP TABLE IF EXISTS `documents`;
CREATE TABLE IF NOT EXISTS `documents` (
  `doc_uuid` varchar(255) NOT NULL,
  `doi` varchar(255) DEFAULT NULL,
  `title` varchar(500) DEFAULT NULL,
  `full_citation` varchar(1500) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `uploaded_by` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`doc_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permissions`
--

DROP TABLE IF EXISTS `permissions`;
CREATE TABLE IF NOT EXISTS `permissions` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `annotation_id` varchar(255) NOT NULL,
  `read_permission` varchar(500) NOT NULL,
  `admin_permission` varchar(500) NOT NULL,
  `update_permission` varchar(500) NOT NULL,
  `delete_permission` varchar(500) NOT NULL,
  PRIMARY KEY (`permission_id`,`annotation_id`),
  KEY `annotation_id` (`annotation_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ranges`
--

DROP TABLE IF EXISTS `ranges`;
CREATE TABLE IF NOT EXISTS `ranges` (
  `range_id` int(11) NOT NULL AUTO_INCREMENT,
  `annotation_id` varchar(255) NOT NULL,
  `start` varchar(500) NOT NULL,
  `end` varchar(500) NOT NULL,
  `startOffset` int(11) NOT NULL,
  `endOffset` int(11) NOT NULL,
  PRIMARY KEY (`range_id`,`annotation_id`),
  KEY `annotation_id` (`annotation_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tags`
--

DROP TABLE IF EXISTS `tags`;
CREATE TABLE IF NOT EXISTS `tags` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `annotation_id` varchar(255) NOT NULL,
  `tag_label` varchar(500) NOT NULL,
  `automatic_tag` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tag_id`,`annotation_id`),
  KEY `annotation_id` (`annotation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `twitter_id` varchar(255) DEFAULT NULL,
  `facebook_id` varchar(255) DEFAULT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `facebook_token` varchar(1000) DEFAULT NULL,
  `facebook_token_expires` bigint(20) DEFAULT NULL,
  `twitter_token` varchar(255) DEFAULT NULL,
  `twitter_token_secret` varchar(500) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `permissions`
--
ALTER TABLE `permissions`
  ADD CONSTRAINT `permissions_ibfk_1` FOREIGN KEY (`annotation_id`) REFERENCES `annotations` (`annotation_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `ranges`
--
ALTER TABLE `ranges`
  ADD CONSTRAINT `ranges_ibfk_1` FOREIGN KEY (`annotation_id`) REFERENCES `annotations` (`annotation_id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `tags`
--
ALTER TABLE `tags`
  ADD CONSTRAINT `tags_ibfk_1` FOREIGN KEY (`annotation_id`) REFERENCES `annotations` (`annotation_id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
