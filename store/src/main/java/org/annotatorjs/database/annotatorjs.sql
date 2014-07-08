-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-07-2014 a las 22:56:25
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
-- Estructura de tabla para la tabla `permissions`
--

CREATE TABLE IF NOT EXISTS `permissions` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT,
  `annotation_id` varchar(255) NOT NULL,
  `read_permission` varchar(500) NOT NULL,
  `admin_permission` varchar(500) NOT NULL,
  `update_permission` varchar(500) NOT NULL,
  `delete_permission` varchar(500) NOT NULL,
  PRIMARY KEY (`permission_id`,`annotation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ranges`
--

CREATE TABLE IF NOT EXISTS `ranges` (
  `range_id` int(11) NOT NULL AUTO_INCREMENT,
  `annotation_id` varchar(255) NOT NULL,
  `start` varchar(500) NOT NULL,
  `end` varchar(500) NOT NULL,
  `startOffset` int(11) NOT NULL,
  `endOffset` int(11) NOT NULL,
  PRIMARY KEY (`range_id`,`annotation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tags`
--

CREATE TABLE IF NOT EXISTS `tags` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT,
  `annotation_id` varchar(255) NOT NULL,
  `tag_label` varchar(500) NOT NULL,
  PRIMARY KEY (`tag_id`,`annotation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
