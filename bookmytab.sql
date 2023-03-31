-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 31, 2023 at 12:17 PM
-- Server version: 8.0.29
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookmytab`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingId` varchar(2) DEFAULT NULL,
  `bookingDate` varchar(11) DEFAULT NULL,
  `bookingTimeFrom` varchar(11) DEFAULT NULL,
  `userId` varchar(11) DEFAULT NULL,
  `resId` varchar(5) DEFAULT NULL,
  `tableId` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`bookingId`, `bookingDate`, `bookingTimeFrom`, `userId`, `resId`, `tableId`) VALUES
('b1', '15-Nov-2023', '31-Dec-1899', 'shanjai1511', 'r1', 'r1t1'),
('b3', '12-Feb-2023', '31-Dec-1899', 'muhil0108', 'r3', 'r3t1'),
('b4', '21-Jun-2023', '31-Dec-1899', 'vasanth0109', 'r4', 'r4t2'),
('b5', '15-Nov-2023', '31-Dec-1899', 'shanjai1512', 'r5', 'r5t3'),
('b7', '12-Feb-2023', '31-Dec-1899', 'muhil0109', 'r7', 'r7t3'),
('b8', '21-Jun-2023', '31-Dec-1899', 'vasanth0110', 'r8', 'r8t10'),
('b9', '15-Nov-2023', '31-Dec-1899', 'shanjai1513', 'r9', 'r9t6');

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `bookingId` varchar(120) DEFAULT NULL,
  `bookingDate` date DEFAULT NULL,
  `bookingTime` time DEFAULT NULL,
  `restaurant_restaurantId` varchar(20) DEFAULT NULL,
  `userName_userId` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `bookings`
--

INSERT INTO `bookings` (`bookingId`, `bookingDate`, `bookingTime`, `restaurant_restaurantId`, `userName_userId`) VALUES
('01', '2002-09-24', '08:30:00', 'r3', 'samrrutha'),
('11', '2002-11-15', '12:54:00', 'e1', 'shanjai1511'),
('21', '2002-11-15', '13:11:00', 'r1', 'shanjai1511'),
('31', '2023-03-16', '12:45:00', 'r1', 'shanjai1511');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `menuId` varchar(50) DEFAULT NULL,
  `itemName` varchar(50) DEFAULT NULL,
  `Description` varchar(200) DEFAULT NULL,
  `restaurant_restaurantId` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`menuId`, `itemName`, `Description`, `restaurant_restaurantId`) VALUES
('m1', 'Gremolate', 'Cream base with tuti fruits', 'r1'),
('m2', 'Pancetta', 'Italian pana cotta with crumbs', 'r1'),
('m4', 'Aubergines', 'Mexican air bubble', 'r1'),
('m5', 'Gorgettes', 'Italian Mascapone cheese grill', 'r1'),
('m6', 'Gorganzoda', 'Garanated vanilla nugge', 'r1'),
('m7', 'Valdarno', 'Valconic stone steamed chicken', 'r1'),
('m8', 'Pollo Alla', 'Steamed alla', 'r1'),
('m9', 'Gelato', 'Scoop of tuti vanila icecream', 'r1'),
('m10', 'PannaCotta', 'Jelly cream', 'r2'),
('m11', 'Biscotti', 'Crumbs cookie', 'r2'),
('m12', 'Tiramisu', 'Coffee flavoured italian dessert', 'r2'),
('m13', 'Zabaglione', 'Egg custard wine cream', 'r2'),
('m14', 'Mascarpone', 'Italian acid set cream cheese', 'r2'),
('m15', 'Tart Peach', 'Pastry filled with peach', 'r2'),
('m16', 'Bonboloni', 'Donuts rolled in sugar filled with italina pastry cream', 'r2'),
('m17', 'Nonna', 'Old age grand ma recipe', 'r2'),
('m18', 'Tarta Della', 'Custard tart made with nonna', 'r3'),
('m19', 'Caponata', 'Cicilian dish with chopped berry', 'r3'),
('m20', 'Spiedini', 'Bread loaded with cheese and grill', 'r3'),
('m21', 'Grosthi', 'Gauva grilled topped with vanila', 'r3'),
('m22', 'Bruschetta', 'anitpessato from italy', 'r3'),
('m23', 'Focaccia', 'Forzen ice cream', 'r3'),
('m24', 'Mozzarella', 'Cheese grill', 'r3'),
('m25', 'Anitpasto', 'Mexican cheese spegati', 'r3'),
('m26', 'Parmesan', 'Para cheese', 'r3'),
('m32', 'Caprese stuffed chicken', 'chicken stuffed with caprese', 'r4'),
('m33', 'Spinach Artichoke Stuffed chicken', 'Chicken stuffed with spinach artichoke', 'r4'),
('m34', 'Quick soft cinnamon rolls', 'cinnamon roll with soft tissue', 'r4'),
('m35', 'Mutton stew', 'Stewed mutton', 'r4'),
('m36', 'Plazza Pie', 'Pie made with plazza', 'r4'),
('m37', 'Lasagna', 'Lasagna sheet with sauce', 'r4'),
('m50', 'Marzipan cherry', 'Tasty marzepan icecream', 'r5'),
('m51', 'Honey date', 'Date floated with honey', 'r5'),
('m52', 'Ginger latte', 'Latte made with ginger', 'r5'),
('m53', 'Oatmeal raisin', 'Raisin made with oats', 'r5'),
('m54', 'Fudge swrill', 'Fudged swrill', 'r5'),
('m57', 'Baguette swrill', 'Swrill with baguette', 'r6'),
('m58', 'Moroccan msemen', 'msemen made in morrocco', 'r6'),
('m59', 'Pikelets', 'Pickles with lets', 'r6'),
('m60', 'Kaiserchmarn', 'Fish grill', 'r6'),
('m61', 'Boikette', 'Australian biscuit', 'r6'),
('m62', 'Tapiocas', 'Boboa milk with taps', 'r7'),
('m63', 'Aebleskiver', 'Alaska mone putch baby', 'r7'),
('m64', 'Pfannkuchen & putch baby', 'Mexican air bubble', 'r7'),
('m65', 'Tiganites', 'Tiagniteedeee', 'r7'),
('m73', 'Barquillo', 'Mexican air bubble', 'r8'),
('m74', 'Cay Cay', 'Cayed cay', 'r8'),
('m75', 'Cavalluci', 'Caviar with original fruits', 'r8'),
('m76', 'Tim Tams', 'Timmy tammm', 'r8'),
('m78', 'Macadamia nuts', 'Nuts from macademia', 'r9'),
('m79', 'Damper', 'Damped chicken', 'r9'),
('m80', 'Weet-Bix', 'Bix made with weet', 'r9'),
('m81', 'Lamingtons', 'tins made with lambs', 'r9'),
('m88', 'parmigiana', 'Cheese grill', 'r9'),
('m89', 'Chiko roll', 'Roll made choko steam', 'r0'),
('m92', 'Chicken parmigiana', 'Pamesam cheese chicken', 'r0'),
('m93', 'Golden Gatime', 'Gatime made with gold plates', 'r0'),
('m94', 'Milo', 'Mexican air bubble', 'r0'),
('m95', 'BBQs', 'Grilled chicken', 'r0'),
('m60', 'coffee', 'taste to mouth', 'r0'),
('m60', 'tes', 'refresh with tea', 'r0'),
('m62', 'Stew', 'A chicken grill', 'r12'),
('m62', 'Coast', 'Chicken dish', 'r12'),
('m64', 'Barbeque Duck', 'A smoked duck', 'r1'),
('1', 'Coffee', 'A sip of coffee', 'r1'),
(NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `restaurantId` varchar(20) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `restaurantName` varchar(200) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `vegNon` varchar(5) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`restaurantId`, `location`, `restaurantName`, `description`, `vegNon`, `password`) VALUES
('r1', 'Coimbatore', 'Pavilion', 'Authentic multicuisine restaurant with multiple menu options', 'Non', 'Pavilion@02'),
('r2', 'Chennai', 'Igloo gloves', 'Italian chinese fusion restaurant with limited menu options', 'Non', 'Igloo@02'),
('r3', 'Coimbatore', 'Residency Towers', 'Mexican desert fusioned with british toppings', 'Veg', 'Towers@02'),
('r4', 'Kothagiri', 'Odea', 'Chettinad style restaurant with limited menu options', 'Non', 'Odea@02'),
('r5', 'Coimbatore', 'Urban Barbeque', 'Multicusine buffet restaurant with high class Ambience', 'Non', 'Urban@02'),
('r6', 'Ooty', 'Dominos', 'Original Italian pizza with high end offers', 'Non', 'Dominos@02'),
('r7', 'RS Puram', 'Keventers', 'Varieties of milkshake in a single place', 'Veg', 'Keventers@02'),
('r8', 'Brookfields', 'PizzaHut', 'Barbeque Italian Mexican fusioned pizzas', 'Non', 'Pizzahut@02'),
('r9', 'Sitra', 'Born with Butter BornQuenella', 'Store kind open kitchen suitable for spending long hours', 'Non', 'Butter@02'),
('r0', 'Neelambur', 'Gokulam Park', 'Multicuisine 5 star hotel with multiple cusine menu options', 'Non', 'Gokulam@02'),
('r12', 'r14', 'Urban Barbeque', 'A barbeque restaurant', 'Non', 'Urban@2002');

-- --------------------------------------------------------

--
-- Table structure for table `tables`
--

CREATE TABLE `tables` (
  `tableId` varchar(6) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL,
  `resId` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tables`
--

INSERT INTO `tables` (`tableId`, `status`, `resId`) VALUES
('t1r1', 'Y', 'r1'),
('t1r2', 'N', 'r2'),
('t1r3', 'Y', 'r3'),
('t1r4', 'Y', 'r4'),
('t1r5', 'Y', 'r5'),
('t1r6', 'N', 'r6'),
('t1r7', 'Y', 'r7'),
('t1r8', 'Y', 'r8'),
('t1r9', 'Y', 'r9'),
('t1r10', 'N', 'r10'),
('t2r1', 'Y', 'r1'),
('t2r2', 'N', 'r2'),
('t2r3', 'Y', 'r3'),
('t2r4', 'Y', 'r4'),
('t2r5', 'Y', 'r5'),
('t2r6', 'N', 'r6'),
('t2r7', 'Y', 'r7'),
('t2r8', 'Y', 'r8'),
('t2r9', 'Y', 'r9'),
('t2r10', 'N', 'r10'),
('t3r1', 'Y', 'r1'),
('t3r2', 'N', 'r2'),
('t3r3', 'Y', 'r3'),
('t3r4', 'Y', 'r4'),
('t3r5', 'Y', 'r5'),
('t3r6', 'N', 'r6'),
('t3r7', 'Y', 'r7'),
('t3r8', 'Y', 'r8'),
('t3r9', 'Y', 'r9'),
('t3r10', 'N', 'r10'),
('t4r1', 'Y', 'r1'),
('t4r2', 'N', 'r2'),
('t4r3', 'Y', 'r3'),
('t4r4', 'Y', 'r4'),
('t4r5', 'Y', 'r5'),
('t4r6', 'N', 'r6'),
('t4r7', 'Y', 'r7'),
('t4r8', 'Y', 'r8'),
('t4r9', 'Y', 'r9'),
('t4r10', 'N', 'r10'),
('t5r1', 'Y', 'r1'),
('t5r2', 'N', 'r2'),
('t5r3', 'Y', 'r3'),
('t5r4', 'Y', 'r4'),
('t5r5', 'Y', 'r5'),
('t5r6', 'N', 'r6'),
('t5r7', 'Y', 'r7'),
('t5r8', 'Y', 'r8'),
('t5r9', 'Y', 'r9'),
('t5r10', 'N', 'r10'),
('t6r1', 'Y', 'r1'),
('t6r2', 'N', 'r2'),
('t6r3', 'Y', 'r3'),
('t6r4', 'Y', 'r4'),
('t6r5', 'Y', 'r5'),
('t6r6', 'N', 'r6'),
('t6r7', 'Y', 'r7'),
('t6r8', 'Y', 'r8'),
('t6r9', 'Y', 'r9'),
('t6r10', 'N', 'r10'),
('t7r1', 'Y', 'r1'),
('t7r2', 'N', 'r2'),
('t7r3', 'Y', 'r3'),
('t7r4', 'Y', 'r4'),
('t7r5', 'Y', 'r5'),
('t7r6', 'N', 'r6'),
('t7r7', 'Y', 'r7'),
('t7r8', 'Y', 'r8'),
('t7r9', 'Y', 'r9'),
('t7r10', 'N', 'r10'),
('t8r1', 'Y', 'r1'),
('t8r2', 'N', 'r2'),
('t8r3', 'Y', 'r3'),
('t8r4', 'Y', 'r4'),
('t8r5', 'Y', 'r5'),
('t8r6', 'N', 'r6'),
('t8r7', 'Y', 'r7'),
('t8r8', 'Y', 'r8'),
('t8r9', 'Y', 'r9'),
('t8r10', 'N', 'r10'),
('t9r1', 'Y', 'r1'),
('t9r2', 'N', 'r2'),
('t9r3', 'Y', 'r3'),
('t9r4', 'Y', 'r4'),
('t9r5', 'Y', 'r5'),
('t9r6', 'N', 'r6'),
('t9r7', 'Y', 'r7'),
('t9r8', 'Y', 'r8'),
('t9r9', 'Y', 'r9'),
('t9r10', 'N', 'r10'),
('t10r1', 'Y', 'r1'),
('t10r2', 'N', 'r2'),
('t10r3', 'Y', 'r3'),
('t10r4', 'Y', 'r4'),
('t10r5', 'Y', 'r5'),
('t10r6', 'N', 'r6'),
('t10r7', 'Y', 'r7'),
('t10r8', 'Y', 'r8'),
('t10r9', 'Y', 'r9'),
('t10r10', 'N', 'r10');

-- --------------------------------------------------------

--
-- Table structure for table `username`
--

CREATE TABLE `username` (
  `userId` varchar(50) DEFAULT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `phoneNumber` char(13) DEFAULT NULL,
  `userMail` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `password` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `username`
--

INSERT INTO `username` (`userId`, `userName`, `phoneNumber`, `userMail`, `location`, `password`) VALUES
('shanjai1511', 'Shanjai R', '8300512800', 'shanjai1511@gmail.com', 'Coimbatore', 'Shanjai@02'),
('muhil0108', 'Muhil R', '9159856570', 'muhil0108@gmail.com', 'Chennai', 'Muhil@0108');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
