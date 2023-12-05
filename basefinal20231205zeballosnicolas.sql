-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-12-2023 a las 16:50:11
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basefinal20231205zeballosnicolas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `atemesa`
--

CREATE TABLE `atemesa` (
  `IdMesa` int(11) NOT NULL,
  `Capacidad` int(5) NOT NULL,
  `Consumo` decimal(5,0) DEFAULT NULL,
  `Estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `atemesa`
--

INSERT INTO `atemesa` (`IdMesa`, `Capacidad`, `Consumo`, `Estado`) VALUES
(1, 2, 0, 'LIBRE'),
(2, 2, 0, 'LIBRE'),
(3, 2, 0, 'LIBRE'),
(4, 2, 0, 'LIBRE'),
(5, 4, 0, 'LIBRE'),
(6, 4, 0, 'LIBRE'),
(7, 4, 0, 'LIBRE'),
(8, 4, 0, 'LIBRE'),
(9, 6, 0, 'LIBRE'),
(10, 6, 0, 'LIBRE'),
(11, 6, 0, 'LIBRE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `atereserva`
--

CREATE TABLE `atereserva` (
  `Fecha` date NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(20) NOT NULL,
  `Comensales` int(8) NOT NULL,
  `id_mesa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `primesa`
--

CREATE TABLE `primesa` (
  `IdMesa` int(11) NOT NULL,
  `Capacidad` int(5) NOT NULL,
  `Consumo` decimal(5,0) NOT NULL,
  `Estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `primesa`
--

INSERT INTO `primesa` (`IdMesa`, `Capacidad`, `Consumo`, `Estado`) VALUES
(1, 10, 0, 'LIBRE'),
(2, 10, 0, 'LIBRE'),
(3, 10, 0, 'LIBRE'),
(4, 10, 0, 'LIBRE'),
(5, 6, 0, 'LIBRE'),
(6, 6, 0, 'LIBRE'),
(7, 6, 0, 'LIBRE'),
(8, 6, 0, 'LIBRE'),
(9, 6, 0, 'LIBRE'),
(10, 6, 0, 'LIBRE'),
(10, 8, 0, 'LIBRE'),
(11, 8, 0, 'LIBRE'),
(12, 8, 0, 'LIBRE'),
(13, 8, 0, 'LIBRE'),
(14, 8, 0, 'LIBRE'),
(15, 8, 0, 'LIBRE'),
(16, 8, 0, 'LIBRE'),
(17, 8, 0, 'LIBRE'),
(18, 8, 0, 'LIBRE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prireserva`
--

CREATE TABLE `prireserva` (
  `Fecha` date NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(20) NOT NULL,
  `Comensales` int(8) NOT NULL,
  `id_mesa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
