-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: 28-Maio-2018 às 14:10
-- Versão do servidor: 5.7.21
-- PHP Version: 5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaex`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE IF NOT EXISTS `produto` (
  `cod` int(11) NOT NULL,
  `precoCompra` double NOT NULL,
  `precoVenda` double NOT NULL,
  `lucro` double NOT NULL,
  `peso` double NOT NULL,
  `origem` text NOT NULL,
  `descricao` text NOT NULL,
  `qtd` int(11) NOT NULL,
  `marca` text NOT NULL,
  `prod` text NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`cod`, `precoCompra`, `precoVenda`, `lucro`, `peso`, `origem`, `descricao`, `qtd`, `marca`, `prod`) VALUES
(2, 6, 4, 5, 5, 'Nacional', '1', 3, 'Intel', '1'),
(12, 50.5, 22, 5, 0.22, 'Nacional', 'Desc', 5, 'NVidia', 'Placa de Video'),
(45, 345, 345, 345, 4, 'Internacional', 'gfdfgh', 5, 'HyperX', 'sdfsdsdf');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
