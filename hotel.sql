-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-09-2023 a las 03:54:30
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `idreserva` int(5) NOT NULL,
  `username` varchar(20) NOT NULL,
  `fecha_ingreso` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `valor` double NOT NULL,
  `Forma_pago` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`idreserva`, `username`, `fecha_ingreso`, `fecha_salida`, `valor`, `Forma_pago`) VALUES
(5, 'bryan', '2023-09-18', '2023-09-20', 50, 'Tarjeta de Crédito'),
(7, 'bryan', '2023-09-25', '2023-09-27', 40, 'Tarjeta de Débito'),
(8, 'bryan', '2023-09-25', '2023-09-30', 100, 'Efectivo'),
(10, 'jara', '2023-09-26', '2023-09-30', 80, 'Tarjeta de Crédito'),
(11, 'jara', '2023-09-30', '2023-10-05', 100, 'Efectivo'),
(12, 'jime', '2023-09-26', '2023-09-28', 40, 'Tarjeta de Débito'),
(13, 'jime', '2023-09-30', '2023-10-03', 80, 'Efectivo'),
(15, 'bryan', '2023-10-03', '2023-10-05', 40, 'Efectivo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `email` varchar(20) NOT NULL,
  `Fecha_nac` date NOT NULL,
  `Nacionalidad` varchar(20) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `Sexo` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellidos`, `email`, `Fecha_nac`, `Nacionalidad`, `telefono`, `Sexo`, `username`, `password`) VALUES
(4, 'Bryan', 'Gonzales Guzman', 'bryan@gmail.com', '2023-09-18', 'Perú	', '978645234', 'Masculino', 'bryan', '123'),
(5, 'Piero Sandro', 'Jara Anticona', 'piero@gmail.com', '1999-09-14', 'Bolivia	', '3921147', 'Masculino', 'jara', 'anticona'),
(6, 'Jimena', 'Chavarria Alfaro', 'jimena@hotmail.com', '1998-04-07', 'Perú	', '907856345', 'Femenino', 'jime', 'alfaro');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`idreserva`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `idreserva` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
