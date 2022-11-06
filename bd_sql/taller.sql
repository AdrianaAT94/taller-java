-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-04-2017 a las 19:53:44
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `taller`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ficha`
--

CREATE TABLE `ficha` (
  `id` int(11) NOT NULL,
  `descripcion` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `fechaEntrada` date NOT NULL,
  `fechaSalida` date DEFAULT NULL,
  `motivo` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idCliente` int(11) NOT NULL,
  `idVehiculo` int(11) NOT NULL,
  `idMecanico` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `ficha`
--

INSERT INTO `ficha` (`id`, `descripcion`, `estado`, `fechaEntrada`, `fechaSalida`, `motivo`, `idCliente`, `idVehiculo`, `idMecanico`) VALUES
(1, 'Revisión', '2', '2017-04-27', NULL, '', 1, 1, 6),
(2, 'Reparación', '2', '2017-04-27', NULL, '', 4, 2, 7),
(3, 'Reparación', '2', '2017-04-27', NULL, '', 2, 3, 8),
(4, 'Revisión', '2', '2017-04-27', NULL, '', 3, 4, 9),
(5, 'Reparación', '2', '2017-04-27', NULL, '', 5, 5, 10),
(6, 'Revisión', '1', '2017-04-27', NULL, '', 2, 6, 6),
(7, 'Revisión', '1', '2017-04-27', NULL, '', 4, 7, 7),
(8, 'Revisión', '1', '2017-04-27', NULL, '', 5, 8, 8),
(9, 'Reparación', '1', '2017-04-27', NULL, '', 1, 9, 9),
(10, 'Reparación', '1', '2017-04-27', NULL, '', 3, 10, 10),
(11, 'Reparación', '1', '2017-04-27', NULL, '', 4, 11, 6),
(12, 'Revisión', '1', '2017-04-27', NULL, '', 2, 12, 7),
(13, 'Reparación', '1', '2017-04-27', NULL, '', 3, 13, 8),
(14, 'Revisión', '1', '2017-04-27', NULL, '', 2, 14, 9),
(15, 'Reparación', '1', '2017-04-27', NULL, '', 5, 15, 10),
(16, 'Revisión', '1', '2017-04-27', NULL, '', 1, 16, 6),
(17, 'Reparación', '1', '2017-04-28', NULL, '', 4, 17, 7),
(18, 'Reparación', '1', '2017-04-28', NULL, '', 2, 18, 8),
(19, 'Reparación', '1', '2017-04-28', NULL, '', 1, 19, 9),
(20, 'Revisión', '1', '2017-04-28', NULL, '', 5, 20, 10),
(21, 'Revisión', '1', '2017-04-28', NULL, '', 4, 21, 6),
(22, 'Reparación', '1', '2017-04-28', NULL, '', 5, 22, 7),
(23, 'Revisión', '1', '2017-04-28', NULL, '', 1, 23, 8),
(24, 'Reparación', '1', '2017-04-28', NULL, '', 3, 24, 9),
(25, 'Reparación', '1', '2017-04-28', NULL, '', 2, 25, 10),
(26, 'Reparación', '1', '2017-04-28', NULL, '', 4, 26, 6),
(27, 'Revisión', '1', '2017-04-28', NULL, '', 1, 27, 7),
(28, 'Reparación', '1', '2017-04-28', NULL, '', 3, 28, 8),
(29, 'Revisión', '1', '2017-04-28', NULL, '', 5, 29, 9),
(30, 'Reparación', '1', '2017-04-28', NULL, '', 1, 30, 10),
(31, 'Revisión', '1', '2017-04-28', NULL, '', 5, 31, 6),
(32, 'Revisión', '1', '2017-04-28', NULL, '', 1, 32, 7),
(33, 'Reparación', '1', '2017-04-28', NULL, '', 3, 33, 8),
(34, 'Reparación', '1', '2017-04-28', NULL, '', 2, 34, 9),
(35, 'Revisión', '1', '2017-04-28', NULL, '', 4, 35, 10),
(36, 'Reparación', '1', '2017-04-28', NULL, '', 1, 36, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ofertas`
--

CREATE TABLE `ofertas` (
  `id` int(11) NOT NULL,
  `nombre_oferta` varchar(200) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `ofertas`
--

INSERT INTO `ofertas` (`id`, `nombre_oferta`) VALUES
(1, 'Puesta a punto para las vacaciones'),
(2, 'Revisión de neumáticos'),
(3, 'Cambio de filtro y aceite'),
(4, 'Revisión de frenos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta_enviada`
--

CREATE TABLE `oferta_enviada` (
  `id` int(11) NOT NULL,
  `idOferta` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `idComercial` int(11) NOT NULL,
  `fechaenvio` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `oferta_enviada`
--

INSERT INTO `oferta_enviada` (`id`, `idOferta`, `idCliente`, `idComercial`, `fechaenvio`) VALUES
(1, 2, 2, 13, '2016-03-21'),
(2, 1, 1, 11, '2016-04-28'),
(3, 1, 1, 15, '2017-04-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id` int(11) NOT NULL,
  `dni` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `apellidos` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `telf` int(11) NOT NULL,
  `correo` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `fechaAlta` date NOT NULL,
  `tipoPersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id`, `dni`, `nombre`, `apellidos`, `telf`, `correo`, `direccion`, `fechaAlta`, `tipoPersona`) VALUES
(1, '53489431X', 'Adriana', 'Armental Tomé', 654987123, 'adri.13a@gmail.com', 'Caamaño', '2017-04-27', 1),
(2, '14587936C', 'Luis', 'Fernández Gómez', 987546321, 'luisfe@hotmail.com', 'A Coruña', '2017-04-27', 1),
(3, '14785236P', 'Ana', 'Calo Vila', 654782145, 'caloana@yahoo.es', 'Madrid', '2017-04-27', 1),
(4, '85236479S', 'Martin', 'Rodríguez Torres', 985236147, 'vaner@hotmail.com', 'Pontevedra', '2017-04-27', 1),
(5, '54782369J', 'Marcos', 'González Castro', 654782143, 'marcos@gmail.com', 'Lousame', '2017-04-27', 1),
(6, '21458634V', 'Tamara', 'Hermo Romero', 981254763, 'tamara@yahoo.es', 'Toledo', '2017-04-27', 2),
(7, '98563214C', 'Christian', 'Crespo Cuiña', 981475236, 'christian@gmail.com', 'Barcelona', '2017-04-27', 2),
(8, '21478954B', 'Bautista', 'Sanles Ces', 654782147, 'bauti@hotmail.com', 'Ribeira', '2017-04-27', 2),
(9, '98657412L', 'Cintia', 'Pouso Tubio', 653289741, 'cintia@yahoo.es', 'Portugal', '2017-04-27', 2),
(10, '2145369P', 'Pablo', 'Pacho Gómez', 981475862, 'pablo@gmail.com', 'Madrid', '2017-04-27', 2),
(11, '52148796D', 'Raquel', 'García Ruiz', 981475263, 'raquel@hotmail.com', 'Oviedo', '2017-04-27', 3),
(12, '54187963S', 'Victor', 'Sampedro Vidal', 698741254, 'victor@gmail.com', 'Logroño', '2017-04-27', 3),
(13, '54128974F', 'Vanesa', 'Nuñez Abad', 658741258, 'vanesa@hotmail.com', 'Cádiz', '2017-04-27', 3),
(14, '85471236P', 'Alba', 'Carrillo Fernandez', 658914725, 'alaba@hotmail.com', 'Valencia', '2017-04-27', 3),
(15, '87453621G', 'Carlos', 'Rivas Dobarro', 685147247, 'carlos@gmail.com', 'Boiro', '2017-04-27', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `revisionitv`
--

CREATE TABLE `revisionitv` (
  `id` int(11) NOT NULL,
  `idVehiculo` int(11) NOT NULL,
  `fechaAlta` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `revisionitv`
--

INSERT INTO `revisionitv` (`id`, `idVehiculo`, `fechaAlta`) VALUES
(1, 5, '2017-04-29'),
(2, 4, '2017-04-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_estado`
--

CREATE TABLE `tipo_estado` (
  `id` int(11) NOT NULL,
  `nombre_tipo` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_estado`
--

INSERT INTO `tipo_estado` (`id`, `nombre_tipo`) VALUES
(1, 'pendiente'),
(2, 'en proceso'),
(3, 'parado'),
(4, 'fase prueba'),
(5, 'terminado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_persona`
--

CREATE TABLE `tipo_persona` (
  `id` int(11) NOT NULL,
  `nombre_tipo` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_persona`
--

INSERT INTO `tipo_persona` (`id`, `nombre_tipo`) VALUES
(1, 'cliente'),
(2, 'mecanico'),
(3, 'comercial');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_vehiculo`
--

CREATE TABLE `tipo_vehiculo` (
  `id` int(11) NOT NULL,
  `nombre_tipo` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `tipo_vehiculo`
--

INSERT INTO `tipo_vehiculo` (`id`, `nombre_tipo`) VALUES
(1, 'Turismo'),
(2, 'Deportivo'),
(3, 'Monovolumen'),
(4, 'Todoterreno'),
(5, 'Moto de Campo'),
(6, 'Moto de Carretera'),
(7, 'Ambulancia'),
(8, 'Bomberos'),
(9, 'Policía'),
(10, 'Autobus'),
(11, 'Camión'),
(12, 'Furgoneta');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `id` int(11) NOT NULL,
  `marca` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `modelo` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `matricula` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `nPuertas` int(11) NOT NULL,
  `airbags` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `maxVelocidad` int(11) NOT NULL,
  `capMotor` int(11) NOT NULL,
  `combustible` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `capAlmacenamiento` int(11) NOT NULL,
  `nPasajeros` int(11) NOT NULL,
  `ABS` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `GPS` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `climatizacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `descapotable` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `nRuedas` int(11) NOT NULL,
  `motivoVisita` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `tipoVehiculo` int(11) NOT NULL,
  `fechaAlta` date NOT NULL,
  `idCliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`id`, `marca`, `modelo`, `matricula`, `nPuertas`, `airbags`, `maxVelocidad`, `capMotor`, `combustible`, `capAlmacenamiento`, `nPasajeros`, `ABS`, `GPS`, `climatizacion`, `descapotable`, `nRuedas`, `motivoVisita`, `tipoVehiculo`, `fechaAlta`, `idCliente`) VALUES
(1, 'Citroën', 'C3', '1760FNS', 5, 'true', 82, 82, 'gasolina', 200, 5, 'true', 'false', 'true', 'false', 4, 'Revisión', 1, '2017-04-27', 1),
(2, 'BMW', '320d', '0042CKR', 5, 'true', 210, 136, 'diésel', 200, 5, 'true', 'false', 'false', 'false', 4, 'Reparación', 1, '2017-04-27', 4),
(3, 'Mercedes Benz', 'C 220', '6855DSY', 5, 'true', 220, 142, 'diésel', 300, 5, 'true', 'false', 'true', 'false', 4, 'Reparación', 1, '2017-04-27', 2),
(4, 'Audi', 'R8', '1478CKR', 5, 'true', 280, 250, 'gasolina', 200, 5, 'true', 'true', 'true', 'false', 4, 'Revision', 2, '2017-04-27', 3),
(5, 'Porsche', '911 Carrera', '8574JKL', 3, 'true', 250, 230, 'gasolina', 200, 2, 'true', 'true', 'true', 'true', 4, 'Reparación', 2, '2017-04-27', 5),
(6, 'Nissan', 'GTR', '2598FRS', 3, 'true', 350, 530, 'gasolina', 200, 2, 'true', 'true', 'true', 'false', 4, 'Revisión', 2, '2017-04-27', 2),
(7, 'Suzuki', 'Jimny', '2589PLS', 3, 'true', 160, 85, 'gasolina', 100, 5, 'true', 'false', 'true', 'false', 4, 'Revisión', 4, '2017-04-27', 4),
(8, 'SsangYong', 'Tivoli', '3654MNS', 5, 'true', 160, 100, 'diésel', 100, 5, 'true', 'false', 'false', 'false', 4, 'Revisión', 4, '2017-04-27', 5),
(9, 'Jeep', 'Wrangel', '9874PLF', 3, 'true', 150, 110, 'gasolina', 200, 5, 'true', 'false', 'false', 'false', 4, 'Reparación', 4, '2017-04-27', 1),
(10, 'Citroën ', 'Grand C4 Picasso', '4758FRS', 5, 'true', 210, 130, 'diésel', 200, 7, 'true', 'false', 'true', 'true', 4, 'Reparación', 3, '2017-04-27', 3),
(11, 'Opel', 'Zafira', '5871RST', 5, 'true', 180, 115, 'diésel', 200, 7, 'true', 'false', 'true', 'true', 4, 'Reparación', 3, '2017-04-27', 4),
(12, 'Renault', 'Space', '9841RTP', 5, 'true', 210, 150, 'gasolina', 200, 5, 'true', 'true', 'true', 'false', 4, 'Revisión', 3, '2017-04-27', 2),
(13, 'KTM', '250 EXC', '2586LKS', 0, 'false', 250, 250, 'gasolina', 50, 2, 'false', 'false', 'false', 'false', 2, 'Reparación', 5, '2017-04-27', 3),
(14, 'Yamaha', 'WR 450', '1257TRS', 0, 'false', 310, 450, 'gasolina', 50, 2, 'false', 'false', 'false', 'false', 2, 'Revisión', 5, '2017-04-27', 2),
(15, 'Honda', 'CRF250', '8175HTR', 0, 'false', 210, 250, 'gasolina', 50, 2, 'false', 'false', 'false', 'false', 2, 'Reparación', 5, '2017-04-27', 5),
(16, 'BMW', 'R 1200 Rt', '6387HTR', 0, 'false', 250, 250, 'gasolina', 50, 2, 'false', 'false', 'false', 'false', 2, 'Revisión', 6, '2017-04-27', 1),
(17, 'Honda', 'Surf 100', '2816FRS', 0, 'false', 150, 100, 'gasolina', 50, 2, 'false', 'false', 'false', 'false', 2, 'Reparación', 6, '2017-04-28', 4),
(18, 'Yamaha', 'Streeter', '1973TPV', 0, 'false', 120, 125, 'gasolina', 50, 2, 'false', 'false', 'false', 'false', 2, 'Reparación', 6, '2017-04-28', 2),
(19, 'Man', 'Camión', '8317FSD', 2, 'true', 140, 200, 'diésel', 300, 2, 'true', 'true', 'true', 'false', 6, 'Reparación', 11, '2017-04-28', 1),
(20, 'Renault', 'Camión', '3875BFR', 2, 'true', 140, 200, 'diésel', 200, 2, 'true', 'true', 'true', 'false', 6, 'Revisión', 11, '2017-04-28', 5),
(21, 'Daff', 'Camión', '5369JKT', 2, 'true', 160, 210, 'diésel', 300, 2, 'true', 'true', 'true', 'false', 6, 'Revisión', 11, '2017-04-28', 4),
(22, 'Peugeot', 'Expert', '3522GRS', 4, 'true', 180, 130, 'diésel', 300, 3, 'true', 'false', 'true', 'false', 4, 'Reparación', 12, '2017-04-28', 5),
(23, 'Volkswagen', 'Caddy', '6955RST', 4, 'true', 180, 90, 'diésel', 200, 5, 'true', 'true', 'true', 'false', 4, 'Revisión', 12, '2017-04-28', 1),
(24, 'Citroën', 'Jumpy', '2142TRP', 4, 'true', 180, 130, 'diésel', 300, 5, 'true', 'false', 'false', 'false', 4, 'Reparación', 12, '2017-04-28', 3),
(25, 'Man', 'Autobus', '2545PLS', 3, 'true', 150, 130, 'diésel', 200, 50, 'true', 'true', 'true', 'false', 6, 'Reparación', 10, '2017-04-28', 2),
(26, 'Mercedes Benz', 'Autobus', '2582CDS', 3, 'true', 180, 130, 'diésel', 200, 50, 'true', 'false', 'false', 'false', 6, 'Reparación', 10, '2017-04-28', 4),
(27, 'Renault', 'Autobus', '3693DSR', 3, 'true', 160, 140, 'diésel', 200, 50, 'true', 'true', 'true', 'false', 6, 'Revisión', 10, '2017-04-28', 1),
(28, 'Mercedes Benz', 'Vito', '2353DTP', 4, 'true', 180, 130, 'diésel', 200, 5, 'true', 'true', 'true', 'false', 4, 'Reparación', 7, '2017-04-28', 3),
(29, 'Renault', 'Trafic', '2582PLT', 4, 'true', 160, 100, 'gasolina', 300, 5, 'true', 'true', 'true', 'false', 4, 'Revisión', 7, '2017-04-28', 5),
(30, 'Fiat', 'Scudo', '2146RPV', 4, 'true', 160, 110, 'diésel', 300, 5, 'true', 'true', 'true', 'false', 4, 'Reparación', 7, '2017-04-28', 1),
(31, 'Renault', 'Megane', '1236FDP', 5, 'true', 210, 110, 'diésel', 200, 5, 'true', 'false', 'false', 'false', 4, 'Revisión', 9, '2017-04-28', 5),
(32, 'Citroën', 'Cactus', '1232RPL', 5, 'true', 210, 136, 'diésel', 300, 5, 'true', 'true', 'true', 'false', 4, 'Revisión', 9, '2017-04-28', 1),
(33, 'Peugeot', '406', '3696TRL', 5, 'true', 230, 150, 'gasolina', 200, 5, 'true', 'false', 'true', 'false', 4, 'Reparación', 9, '2017-04-28', 3),
(34, 'Iveco', '65C18', '3659CVP', 2, 'true', 230, 150, 'diésel', 200, 3, 'true', 'true', 'true', 'false', 6, 'Reparación', 8, '2017-04-28', 2),
(35, 'Scania', 'P 93ML', '2123GTR', 2, 'true', 210, 130, 'diésel', 300, 3, 'true', 'false', 'false', 'false', 6, 'Revisión', 8, '2017-04-28', 4),
(36, 'Volvo', 'FL16-15', '2562PLN', 2, 'true', 250, 150, 'gasolina', 300, 3, 'true', 'true', 'true', 'false', 6, 'Reparación', 8, '2017-04-28', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ficha`
--
ALTER TABLE `ficha`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ofertas`
--
ALTER TABLE `ofertas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `oferta_enviada`
--
ALTER TABLE `oferta_enviada`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- Indices de la tabla `revisionitv`
--
ALTER TABLE `revisionitv`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_estado`
--
ALTER TABLE `tipo_estado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_persona`
--
ALTER TABLE `tipo_persona`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `matricula` (`matricula`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ficha`
--
ALTER TABLE `ficha`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
--
-- AUTO_INCREMENT de la tabla `ofertas`
--
ALTER TABLE `ofertas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `oferta_enviada`
--
ALTER TABLE `oferta_enviada`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `revisionitv`
--
ALTER TABLE `revisionitv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `tipo_estado`
--
ALTER TABLE `tipo_estado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `tipo_persona`
--
ALTER TABLE `tipo_persona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `tipo_vehiculo`
--
ALTER TABLE `tipo_vehiculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
