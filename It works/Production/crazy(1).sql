-- phpMyAdmin SQL Dump
-- version 4.9.7deb1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 07, 2021 at 03:11 PM
-- Server version: 8.0.25-0ubuntu0.20.10.1
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `crazy`
--

-- --------------------------------------------------------

--
-- Table structure for table `account_type`
--

CREATE TABLE `account_type` (
  `account_type_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `address_type`
--

CREATE TABLE `address_type` (
  `address_type_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `asset_maintanance`
--

CREATE TABLE `asset_maintanance` (
  `asset_maintanance_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `asset_maintanance_description` varchar(255) DEFAULT NULL,
  `asset_maintanance_product` varchar(255) DEFAULT NULL,
  `asset_maintanance_status` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `company_bank_details` varchar(255) DEFAULT NULL,
  `cost` double NOT NULL,
  `maintanance_company` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `asset_maintanance`
--

INSERT INTO `asset_maintanance` (`asset_maintanance_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `asset_maintanance_description`, `asset_maintanance_product`, `asset_maintanance_status`, `status`, `created_by`, `modified_by`, `voided_by`, `company_address`, `company_bank_details`, `cost`, `maintanance_company`) VALUES
('51a2d813-1019-46e9-b624-fde4bd3b59ba', b'1', '2021-05-20', '2021-05-20', NULL, NULL, NULL, 'Roof Leak', 'Warehouse 1', 'Pending', b'1', NULL, 'admin@softhub.com', NULL, '25 Ryden Rd', 'Barclays 2545698756784536', 25000, 'The Real Plumbers');

-- --------------------------------------------------------

--
-- Table structure for table `batch_status`
--

CREATE TABLE `batch_status` (
  `batch_status_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `product_no` varchar(255) DEFAULT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `batch_status`
--

INSERT INTO `batch_status` (`batch_status_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `description`, `in_stock`, `name`, `product_no`, `retire_reason`, `uuid`, `created_by`, `modified_by`, `voided_by`) VALUES
('1d92f54e-d145-4b2a-b739-a44fb1da3def', b'1', '2021-06-14', NULL, NULL, NULL, NULL, NULL, NULL, 'Processing', NULL, NULL, '3e74ba02-e3bc-45ca-b3b2-795e00fd6821', 'admin@softhub.com', NULL, NULL),
('4accac84-352c-45d9-8c89-d97fff96ae76', b'1', '2021-06-14', NULL, NULL, NULL, NULL, NULL, NULL, 'Pending', NULL, NULL, '60ff4df8-3c10-4b67-92b9-1109de809fa1', 'admin@softhub.com', NULL, NULL),
('f7ebcc16-50d3-484d-b1b3-8de33a75b167', b'1', '2021-06-14', '2021-06-29', NULL, NULL, NULL, NULL, NULL, 'Complete', NULL, NULL, '13f65bee-daa0-4332-b3c5-0d37cbca775c', NULL, 'admin@softhub.com', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `capacity_plan`
--

CREATE TABLE `capacity_plan` (
  `capacity_plan_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `capacity_plan_description` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `demand` varchar(255) DEFAULT NULL,
  `equipment` varchar(255) DEFAULT NULL,
  `labour` varchar(255) DEFAULT NULL,
  `machinery` varchar(255) DEFAULT NULL,
  `manager` varchar(255) DEFAULT NULL,
  `material` varchar(255) DEFAULT NULL,
  `plan_date` datetime DEFAULT NULL,
  `work_order` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `city_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `client_maintanance`
--

CREATE TABLE `client_maintanance` (
  `client_maintanance_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `client_maintanance_description` varchar(255) DEFAULT NULL,
  `client_maintanance_product` varchar(255) DEFAULT NULL,
  `client_maintanance_status` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `client_cost` double NOT NULL,
  `client_name` varchar(255) DEFAULT NULL,
  `company_cost` double NOT NULL,
  `team` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `client_maintanance`
--

INSERT INTO `client_maintanance` (`client_maintanance_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `client_maintanance_description`, `client_maintanance_product`, `client_maintanance_status`, `status`, `created_by`, `modified_by`, `voided_by`, `client_cost`, `client_name`, `company_cost`, `team`) VALUES
('a17a8b17-6cc4-40ef-83b5-84343b933e20', b'1', '2021-05-19', NULL, NULL, NULL, NULL, 'Students failing to register', 'E-Learning Software', 'Pending', b'1', 'admin@softhub.com', NULL, NULL, 100, 'Ryden High', 20, 'Team 3');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `company_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `company_no` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `shares` double NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `company_status_id` varchar(36) DEFAULT NULL,
  `company_type_id` varchar(36) NOT NULL,
  `province_id` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `company_address`
--

CREATE TABLE `company_address` (
  `company_address_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `address1` varchar(255) NOT NULL,
  `address2` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `address_type_id` varchar(36) NOT NULL,
  `company_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `company_bank_detail`
--

CREATE TABLE `company_bank_detail` (
  `company_bank_detail_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `account_name` varchar(100) NOT NULL,
  `account_number` varchar(50) NOT NULL,
  `bank` varchar(150) NOT NULL,
  `branch` varchar(100) NOT NULL,
  `status` bit(1) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `account_type_id` varchar(36) NOT NULL,
  `company_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `company_contact`
--

CREATE TABLE `company_contact` (
  `company_contact_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `contact_detail` varchar(255) NOT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `company_id` varchar(36) NOT NULL,
  `contact_type_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `company_director`
--

CREATE TABLE `company_director` (
  `company_director_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `director_address` varchar(255) DEFAULT NULL,
  `director_contact` varchar(255) DEFAULT NULL,
  `director_middle_name` varchar(255) DEFAULT NULL,
  `director_name` varchar(255) DEFAULT NULL,
  `director_surname` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `company_id` varchar(36) NOT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `company_status`
--

CREATE TABLE `company_status` (
  `company_status_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `company_type`
--

CREATE TABLE `company_type` (
  `company_type_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `contact_type`
--

CREATE TABLE `contact_type` (
  `contact_type_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `district_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `district_code` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `province_id` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`district_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `description`, `name`, `retire_reason`, `uuid`, `district_code`, `created_by`, `modified_by`, `voided_by`, `province_id`, `in_stock`, `product_description`, `product_no`) VALUES
('403f1bd6-1c21-448a-a764-961a2ebdaddd', b'1', '2018-12-11', NULL, NULL, NULL, NULL, 'Mutasa', 'Mutasa', NULL, '592b7b47-ef78-4781-b915-6e717a6385c8', '1001', 'admin@softhub.com', NULL, NULL, 'b56ca02e-a399-4b7f-983b-bd792122dec1', NULL, NULL, NULL),
('cbe87ccc-d8fa-4574-8200-abee7dc14876', b'1', '2018-12-11', NULL, NULL, NULL, NULL, 'Buhera', 'Buhera', NULL, '35ff1f85-4600-4308-9d6d-0f995f7829ef', '1002', 'admin@softhub.com', NULL, NULL, 'b56ca02e-a399-4b7f-983b-bd792122dec1', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date DEFAULT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `employee_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `employee_address` varchar(255) DEFAULT NULL,
  `qualifications` varchar(255) DEFAULT NULL,
  `qualification` varchar(255) DEFAULT NULL,
  `employee_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `employee_name`, `created_by`, `modified_by`, `voided_by`, `employee_address`, `qualifications`, `qualification`, `employee_no`) VALUES
(',63-2129268E43', b'1', NULL, '2021-05-31', NULL, NULL, NULL, 'Rachel Makwara', NULL, 'admin@softhub.com', NULL, NULL, NULL, 'Developer', '63-2129268E43'),
(',xx', b'0', NULL, '2021-05-12', NULL, NULL, NULL, 'x', NULL, 'admin@softhub.com', NULL, NULL, NULL, 'xxx', NULL),
(',xx,,xx', b'0', NULL, '2021-05-12', NULL, NULL, NULL, 'x', NULL, 'admin@softhub.com', NULL, NULL, NULL, 'xxx', NULL),
('1375e289-3563-4243-af50-f1b35aade41b', b'0', '2021-05-11', NULL, NULL, NULL, NULL, 'x', 'admin@softhub.com', NULL, NULL, 'xx', NULL, 'xxx', NULL),
('fe929883-46b6-45d9-9e21-fec99876c972', b'0', '2021-05-12', NULL, NULL, NULL, NULL, 'x', 'admin@softhub.com', NULL, NULL, 'xx', NULL, 'xxx', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `finished_products`
--

CREATE TABLE `finished_products` (
  `finished_products_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `order_no` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `finished_products`
--

INSERT INTO `finished_products` (`finished_products_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `order_no`, `product_name`, `product_no`, `status`, `created_by`, `modified_by`, `voided_by`) VALUES
('d77419d6-d3a4-4c45-8741-0f0ae1a8c452', b'1', '2021-05-19', NULL, NULL, NULL, NULL, 'E43', 'House', '5', b'1', 'admin@softhub.com', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `inventory_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `inventory_description` varchar(255) DEFAULT NULL,
  `inventory_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`inventory_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `created_by`, `modified_by`, `voided_by`, `inventory_description`, `inventory_name`) VALUES
('dcfb3712-24de-4fb2-aae0-6d85ce761cb1', b'1', '2021-05-10', '2021-05-12', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, 'nnn', 'n'),
('e68dd858-9359-40a0-8831-4a2407c34a92', b'1', '2021-05-11', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, NULL, 'xxx', 'x');

-- --------------------------------------------------------

--
-- Table structure for table `machinery`
--

CREATE TABLE `machinery` (
  `machinery_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `machinery_description` varchar(255) DEFAULT NULL,
  `machinery_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `machinery`
--

INSERT INTO `machinery` (`machinery_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `created_by`, `modified_by`, `voided_by`, `machinery_description`, `machinery_name`) VALUES
('3961d756-5d57-495d-b0ba-93962ed69af2', b'1', '2021-05-12', '2021-05-20', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, '2.5l diesel engine with 25 sqm per hour capacity', 'Grader'),
('81c2dfd2-a61f-44a2-8799-6790613dd055', b'0', '2021-05-12', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, NULL, 'xx', 'x');

-- --------------------------------------------------------

--
-- Table structure for table `maintanance`
--

CREATE TABLE `maintanance` (
  `maintanance_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `maintanance_description` varchar(255) DEFAULT NULL,
  `maintanance_product` varchar(255) DEFAULT NULL,
  `maintanance_status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `maintanance`
--

INSERT INTO `maintanance` (`maintanance_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `status`, `created_by`, `modified_by`, `voided_by`, `maintanance_description`, `maintanance_product`, `maintanance_status`) VALUES
('991e774e-60d4-4d54-baf8-73f25c0d9101', b'1', '2021-05-17', '2021-05-17', NULL, NULL, NULL, b'1', NULL, 'admin@softhub.com', NULL, 'Roof Leaks', 'Warehouse', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `material`
--

CREATE TABLE `material` (
  `material_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `contact_details` varchar(255) DEFAULT NULL,
  `material_cost` double NOT NULL,
  `material_description` varchar(255) DEFAULT NULL,
  `material_name` varchar(255) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `material`
--

INSERT INTO `material` (`material_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `company_address`, `company_name`, `contact_details`, `material_cost`, `material_description`, `material_name`, `quantity`, `created_by`, `modified_by`, `voided_by`) VALUES
('35c80f66-ad7b-44bd-bd59-c4613bccd83d', b'1', '2021-05-17', NULL, NULL, NULL, NULL, '7 Lezard Rd Milton Park', 'Lumber Timbers', '+263 71 342 4718', 15, '5mm white wood', 'Timber', 4, 'admin@softhub.com', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `nationality`
--

CREATE TABLE `nationality` (
  `nationality_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `priority`
--

CREATE TABLE `priority` (
  `priority_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `privilege`
--

CREATE TABLE `privilege` (
  `name` varchar(50) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `privilege_id` char(36) NOT NULL DEFAULT '',
  `created_by` varchar(50) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `modified_by` varchar(50) DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `retired` tinyint(1) DEFAULT '0',
  `date_retired` datetime DEFAULT NULL,
  `retired_by` varchar(50) DEFAULT NULL,
  `retire_reason` varchar(250) DEFAULT NULL,
  `privilege` varchar(50) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `processing_plant`
--

CREATE TABLE `processing_plant` (
  `processing_plant_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `processing_plant_description` varchar(255) DEFAULT NULL,
  `processing_plant_location` varchar(255) DEFAULT NULL,
  `capacity` varchar(255) DEFAULT NULL,
  `capacity_status` varchar(255) DEFAULT NULL,
  `functionality` varchar(255) DEFAULT NULL,
  `processing_plant_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `processing_plant`
--

INSERT INTO `processing_plant` (`processing_plant_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `created_by`, `modified_by`, `voided_by`, `processing_plant_description`, `processing_plant_location`, `capacity`, `capacity_status`, `functionality`, `processing_plant_name`) VALUES
('581a1329-25c7-489b-97df-f277b2e5b3ac', b'1', '2021-05-20', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, NULL, '3 floors, 10 bays', 'Avonlea', '50 ppd', 'Capacity Full', 'Fully Functional', 'Plant 1');

-- --------------------------------------------------------

--
-- Table structure for table `processing_plant_machinery`
--

CREATE TABLE `processing_plant_machinery` (
  `processing_plant_machinery_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `machinery_usage_status` varchar(255) DEFAULT NULL,
  `processing_plant_machinery_capacity` varchar(255) DEFAULT NULL,
  `processing_plant_machinery_description` varchar(255) DEFAULT NULL,
  `processing_plant_machinery_name` varchar(255) DEFAULT NULL,
  `user_location` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `processing_plant_machinery_no` varchar(255) DEFAULT NULL,
  `processing_plant` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `processing_plant_machinery`
--

INSERT INTO `processing_plant_machinery` (`processing_plant_machinery_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `machinery_usage_status`, `processing_plant_machinery_capacity`, `processing_plant_machinery_description`, `processing_plant_machinery_name`, `user_location`, `user_name`, `created_by`, `modified_by`, `voided_by`, `processing_plant_machinery_no`, `processing_plant`) VALUES
('4fef423d-0a1d-4500-9407-9555e8b74578', b'1', '2021-05-31', '2021-06-03', NULL, NULL, NULL, 'Occupied', '50 ppm', '2.5 l diesel ', 'Caterpillar', '2nd Floor, Left Wing, Office 5', 'Occupied', NULL, 'admin@softhub.com', NULL, '5', '581a1329-25c7-489b-97df-f277b2e5b3ac');

-- --------------------------------------------------------

--
-- Table structure for table `processing_plant_processing_plant_material`
--

CREATE TABLE `processing_plant_processing_plant_material` (
  `processing_plant_material_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `date_acquired` varchar(255) DEFAULT NULL,
  `processing_plant_material_description` varchar(255) DEFAULT NULL,
  `processing_plant_material_name` varchar(255) DEFAULT NULL,
  `quantity` double NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `processing_plant` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `processing_plant_processing_plant_material`
--

INSERT INTO `processing_plant_processing_plant_material` (`processing_plant_material_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `date_acquired`, `processing_plant_material_description`, `processing_plant_material_name`, `quantity`, `created_by`, `modified_by`, `voided_by`, `processing_plant`) VALUES
('621fa35d-2fa4-498a-8aff-0910d5ae2a4d', b'1', '2021-05-31', NULL, NULL, NULL, NULL, '31/05/2021', 'Deisel 50', 'Diesel', 15.57, 'admin@softhub.com', NULL, NULL, '581a1329-25c7-489b-97df-f277b2e5b3ac');

-- --------------------------------------------------------

--
-- Table structure for table `processing_plant_production_run`
--

CREATE TABLE `processing_plant_production_run` (
  `processing_plant_production_run_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `completion_date` varchar(255) DEFAULT NULL,
  `processing_plant_production_run_description` varchar(255) DEFAULT NULL,
  `processing_plant_production_run_no` double NOT NULL,
  `start_date` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `processing_plant` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `processing_plant_production_run`
--

INSERT INTO `processing_plant_production_run` (`processing_plant_production_run_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `completion_date`, `processing_plant_production_run_description`, `processing_plant_production_run_no`, `start_date`, `created_by`, `modified_by`, `voided_by`, `processing_plant`) VALUES
('1d6b0fa9-bc7d-4498-8255-ecb32ed52e5d', b'1', '2021-05-31', '2021-06-03', NULL, NULL, NULL, '16/05/2021', 'Order No 65\'s run', 5, '05/05/2021', NULL, 'admin@softhub.com', NULL, '581a1329-25c7-489b-97df-f277b2e5b3ac');

-- --------------------------------------------------------

--
-- Table structure for table `processing_plant_production_team`
--

CREATE TABLE `processing_plant_production_team` (
  `processing_plant_production_team_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `processing_plant_production_team_description` varchar(255) DEFAULT NULL,
  `processing_plant_production_team_duties` varchar(255) DEFAULT NULL,
  `processing_plant_production_team_name` varchar(255) DEFAULT NULL,
  `time_till_free` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `processing_plant_production_team_no` varchar(255) DEFAULT NULL,
  `processing_plant` varchar(36) DEFAULT NULL,
  `product_warehouse_production_team_description` varchar(255) DEFAULT NULL,
  `product_warehouse_production_team_duties` varchar(255) DEFAULT NULL,
  `product_warehouse_production_team_name` varchar(255) DEFAULT NULL,
  `product_warehouse_production_team_no` varchar(255) DEFAULT NULL,
  `product_warehouse` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `processing_plant_production_team`
--

INSERT INTO `processing_plant_production_team` (`processing_plant_production_team_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `processing_plant_production_team_description`, `processing_plant_production_team_duties`, `processing_plant_production_team_name`, `time_till_free`, `created_by`, `modified_by`, `voided_by`, `processing_plant_production_team_no`, `processing_plant`, `product_warehouse_production_team_description`, `product_warehouse_production_team_duties`, `product_warehouse_production_team_name`, `product_warehouse_production_team_no`, `product_warehouse`) VALUES
('a4b55bd7-5566-47e9-b22d-c1276f73220b', b'1', '2021-05-31', NULL, NULL, NULL, NULL, 'Rachel Makwara, Benjamin Nyaruviro, Edward Zengeni, Blessing Nyamashuka', 'Building and maintanance of conveyor belt', 'Team 5', '5 weeks', 'admin@softhub.com', NULL, NULL, 'E65', '581a1329-25c7-489b-97df-f277b2e5b3ac', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `processing_plant_tool`
--

CREATE TABLE `processing_plant_tool` (
  `processing_plant_tool_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `processing_plant_tool_description` varchar(36) NOT NULL,
  `processing_plant_tool_name` varchar(36) NOT NULL,
  `processing_plant_tool_no` varchar(255) DEFAULT NULL,
  `processing_plant_usage_status` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `user_location` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `processing_plant` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `processing_plant_tool`
--

INSERT INTO `processing_plant_tool` (`processing_plant_tool_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `processing_plant_tool_description`, `processing_plant_tool_name`, `processing_plant_tool_no`, `processing_plant_usage_status`, `status`, `user_location`, `user_name`, `created_by`, `modified_by`, `voided_by`, `processing_plant`) VALUES
('6124e1d1-866a-46fd-87d8-228855f10b62', b'1', '2021-06-03', NULL, NULL, NULL, NULL, '5mm', 'Spanner', '5', 'Occupied', b'1', '2nd Floor, Left Wing, Office 5', 'Team 3', 'admin@softhub.com', NULL, NULL, '581a1329-25c7-489b-97df-f277b2e5b3ac');

-- --------------------------------------------------------

--
-- Table structure for table `process_plan`
--

CREATE TABLE `process_plan` (
  `process_plan_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `process_plan_description` varchar(255) DEFAULT NULL,
  `product_batch_id` varchar(36) DEFAULT NULL,
  `order_no` varchar(255) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `process_stages` varchar(255) DEFAULT NULL,
  `processing_plant` varchar(255) DEFAULT NULL,
  `stage_no` varchar(255) DEFAULT NULL,
  `time_to_complete` varchar(255) DEFAULT NULL,
  `warehouse_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `process_plan`
--

INSERT INTO `process_plan` (`process_plan_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `created_by`, `modified_by`, `voided_by`, `process_plan_description`, `product_batch_id`, `order_no`, `order_status`, `process_stages`, `processing_plant`, `stage_no`, `time_to_complete`, `warehouse_name`) VALUES
('e2dd3ddc-db2f-437b-bfb4-96fab3e4c73c', b'1', '2021-06-29', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, NULL, NULL, NULL, '5', 'Processing', '5', 'Plant 3', '1', '2 weeks', 'Warehouse 5');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `in_stock`, `product_no`, `created_by`, `modified_by`, `voided_by`, `description`, `name`, `retire_reason`, `uuid`) VALUES
('8bba7e7d-0de4-4bc2-94bb-8f20c4c28eb1', b'1', '2021-06-14', '2021-06-29', NULL, NULL, NULL, 'In Stock', 'E43', NULL, 'admin@softhub.com', NULL, 'Curved Edge', 'Laptop', NULL, '724683c2-e023-4bbc-839f-9f92a0ec63e1');

-- --------------------------------------------------------

--
-- Table structure for table `production_cost`
--

CREATE TABLE `production_cost` (
  `production_cost_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `production_cost_description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `production_run`
--

CREATE TABLE `production_run` (
  `production_run_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `production_run_description` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `production_run_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `production_team`
--

CREATE TABLE `production_team` (
  `production_team_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `production_team_description` varchar(255) DEFAULT NULL,
  `production_team_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `product_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(36) NOT NULL,
  `product_name` varchar(36) NOT NULL,
  `product_no` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_batch`
--

CREATE TABLE `product_batch` (
  `product_batch_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `product_batch_description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `product_batch_name` varchar(255) DEFAULT NULL,
  `batch_description` varchar(255) DEFAULT NULL,
  `batch_quantity` double DEFAULT NULL,
  `batch_status` varchar(255) DEFAULT NULL,
  `processing_plant` varchar(255) DEFAULT NULL,
  `warehouse` varchar(255) DEFAULT NULL,
  `batch_status_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product_batch`
--

INSERT INTO `product_batch` (`product_batch_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `created_by`, `modified_by`, `voided_by`, `product_batch_description`, `name`, `product_batch_name`, `batch_description`, `batch_quantity`, `batch_status`, `processing_plant`, `warehouse`, `batch_status_id`) VALUES
('36dc98a2-cb9d-4cd4-9cb9-5acbbd75a299', b'1', '2021-06-29', '2021-06-29', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, NULL, NULL, 'Bread', '69-1317563G56', 50, NULL, 'Plant 3', 'warehouse 5', '4accac84-352c-45d9-8c89-d97fff96ae76');

-- --------------------------------------------------------

--
-- Table structure for table `product_detail`
--

CREATE TABLE `product_detail` (
  `product_detail_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `product_detail_description` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `product_batch_id` varchar(36) DEFAULT NULL,
  `order_no` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product_detail`
--

INSERT INTO `product_detail` (`product_detail_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `product_detail_description`, `status`, `created_by`, `modified_by`, `voided_by`, `product_batch_id`, `order_no`, `product_name`, `product_no`) VALUES
('f9d855d3-df9d-4ef1-9814-abb7dfd4e745', b'1', '2021-05-17', NULL, NULL, NULL, NULL, NULL, b'1', 'admin@softhub.com', NULL, NULL, NULL, '5', 'Iphone', '343E47');

-- --------------------------------------------------------

--
-- Table structure for table `product_requirements`
--

CREATE TABLE `product_requirements` (
  `product_requirements_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `product_requirements_description` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_warehouse_machinery`
--

CREATE TABLE `product_warehouse_machinery` (
  `product_warehouse_machinery_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `machinery_usage_status` varchar(255) DEFAULT NULL,
  `product_warehouse_machinery_capacity` varchar(255) DEFAULT NULL,
  `product_warehouse_machinery_description` varchar(255) DEFAULT NULL,
  `product_warehouse_machinery_name` varchar(255) DEFAULT NULL,
  `product_warehouse_machinery_no` varchar(255) DEFAULT NULL,
  `user_location` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `product_warehouse` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product_warehouse_machinery`
--

INSERT INTO `product_warehouse_machinery` (`product_warehouse_machinery_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `machinery_usage_status`, `product_warehouse_machinery_capacity`, `product_warehouse_machinery_description`, `product_warehouse_machinery_name`, `product_warehouse_machinery_no`, `user_location`, `user_name`, `created_by`, `modified_by`, `voided_by`, `product_warehouse`) VALUES
('1b6ac959-2e89-4176-b649-3d4e9e668fe7', b'0', '2021-06-02', NULL, NULL, NULL, NULL, 'Occupied', 'x', 'x', 'x', 'x', '2nd Floor, Left Wing, Office 5', 'x', 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840'),
('90c8871a-5db5-4d10-8992-624ab78e0f05', b'1', '2021-06-03', NULL, NULL, NULL, NULL, 'Occupied', '5ppm', '2.5 l diesel engine  ', 'Caterpillar', '7', '2nd Floor, Left Wing, Office 5', 'Free', 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840'),
('a677986d-851a-43a4-aa82-34c6bc482e5e', b'0', '2021-06-02', NULL, NULL, NULL, NULL, 'x', 'x', 'x', 'x', 'x', 'x', 'x', 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840');

-- --------------------------------------------------------

--
-- Table structure for table `product_warehouse_pos`
--

CREATE TABLE `product_warehouse_pos` (
  `product_warehouse_pos_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `order_no` varchar(255) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `product_warehouse` varchar(36) DEFAULT NULL,
  `product_warehouse_pos_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product_warehouse_pos`
--

INSERT INTO `product_warehouse_pos` (`product_warehouse_pos_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `order_no`, `order_status`, `status`, `created_by`, `modified_by`, `voided_by`, `product_warehouse`, `product_warehouse_pos_no`) VALUES
('1c5d9526-84ff-4065-a886-68a2c842fe15', b'0', '2021-06-03', '2021-06-03', NULL, NULL, NULL, 'z', 'z', NULL, NULL, 'admin@softhub.com', NULL, '3c870bd1-9336-4a4c-a934-8996a4795840', NULL),
('d7c5215e-56d3-46a0-88e1-14fa0eeb429e', b'1', '2021-06-03', NULL, NULL, NULL, NULL, 'E43', 'Sold', NULL, 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `product_warehouse_product`
--

CREATE TABLE `product_warehouse_product` (
  `product_warehouse_product_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_warehouse_product_description` varchar(36) NOT NULL,
  `product_warehouse_product_name` varchar(36) NOT NULL,
  `product_warehouse_product_no` varchar(255) DEFAULT NULL,
  `qty` double NOT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `product_warehouse` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product_warehouse_product`
--

INSERT INTO `product_warehouse_product` (`product_warehouse_product_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `in_stock`, `product_warehouse_product_description`, `product_warehouse_product_name`, `product_warehouse_product_no`, `qty`, `status`, `created_by`, `modified_by`, `voided_by`, `product_warehouse`) VALUES
('6ddb50e1-1024-4c96-88c9-3e1e8e0a0965', b'0', '2021-06-03', NULL, NULL, NULL, NULL, 'x', 'x', 'x', 'x', 10, b'1', 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840'),
('df2540ee-0d14-479f-be5c-87c2e6ee24bf', b'1', '2021-06-03', NULL, NULL, NULL, NULL, 'In Stock', '2.5 gb ram, 64-bit processor', 'Acer Laptop', '4', 5, b'1', 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840');

-- --------------------------------------------------------

--
-- Table structure for table `product_warehouse_production_team`
--

CREATE TABLE `product_warehouse_production_team` (
  `product_warehouse_production_team_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `product_warehouse_production_team_description` varchar(255) DEFAULT NULL,
  `product_warehouse_production_team_duties` varchar(255) DEFAULT NULL,
  `product_warehouse_production_team_name` varchar(255) DEFAULT NULL,
  `product_warehouse_production_team_no` varchar(255) DEFAULT NULL,
  `time_till_free` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `product_warehouse` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product_warehouse_production_team`
--

INSERT INTO `product_warehouse_production_team` (`product_warehouse_production_team_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `product_warehouse_production_team_description`, `product_warehouse_production_team_duties`, `product_warehouse_production_team_name`, `product_warehouse_production_team_no`, `time_till_free`, `created_by`, `modified_by`, `voided_by`, `product_warehouse`) VALUES
('6eb822f6-7cfc-49e7-8701-9206e64f86c2', b'1', '2021-06-03', NULL, NULL, NULL, NULL, 'Rachel Makwara, Julius Nyerere, Robson Manyika', 'Development', 'Team 5', '5', '5 Months', 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840'),
('bf7b64e4-5fc2-4b74-a7fe-b581739d4c94', b'0', '2021-06-03', NULL, NULL, NULL, NULL, 'x', 'x', 'x', 'x', 'x', 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840');

-- --------------------------------------------------------

--
-- Table structure for table `product_warehouse_tool`
--

CREATE TABLE `product_warehouse_tool` (
  `product_warehouse_tool_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `product_warehouse_tool_description` varchar(255) DEFAULT NULL,
  `product_warehouse_tool_name` varchar(255) DEFAULT NULL,
  `product_warehouse_tool_no` varchar(255) DEFAULT NULL,
  `product_warehouse_usage_status` varchar(255) DEFAULT NULL,
  `user_location` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `product_warehouse` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `product_warehouse_tool`
--

INSERT INTO `product_warehouse_tool` (`product_warehouse_tool_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `product_warehouse_tool_description`, `product_warehouse_tool_name`, `product_warehouse_tool_no`, `product_warehouse_usage_status`, `user_location`, `user_name`, `created_by`, `modified_by`, `voided_by`, `product_warehouse`) VALUES
('26387121-f288-49f3-8e6c-3f1ad3c00c93', b'1', '2021-06-03', NULL, NULL, NULL, NULL, '5mm head', 'Spanner', '5', 'In use', '2nd Floor, Left Wing, Office 5', 'Team 3', 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840'),
('f3e5dd72-058b-48b1-aded-c0f522079e19', b'0', '2021-06-03', NULL, NULL, NULL, NULL, 'x', 'x', 'x', 'x', 'x', 'x', 'admin@softhub.com', NULL, NULL, '3c870bd1-9336-4a4c-a934-8996a4795840');

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `province_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`province_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `description`, `name`, `retire_reason`, `uuid`, `created_by`, `modified_by`, `voided_by`, `in_stock`, `product_description`, `product_no`) VALUES
('23d2e87b-f60b-4999-84b9-06ef5ab6ee6b', b'1', '2018-12-11', NULL, NULL, NULL, NULL, 'Harare', 'Harare', NULL, '94a0c8cb-5b08-4ab5-9829-fe579de3eb1c', NULL, 'admin@softhub.com', NULL, NULL, NULL, NULL),
('b56ca02e-a399-4b7f-983b-bd792122dec1', b'1', '2018-12-11', NULL, NULL, NULL, NULL, 'Manicaland', 'Manicaland', NULL, 'a72eff36-fc74-4d19-8175-88f7f89e4358', NULL, 'admin@softhub.com', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `description` varchar(250) DEFAULT NULL,
  `role_id` char(36) NOT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `retired` tinyint(1) DEFAULT '0',
  `retired_by` varchar(50) DEFAULT NULL,
  `date_retired` datetime DEFAULT NULL,
  `retire_reason` varchar(250) DEFAULT NULL,
  `modified_by` varchar(50) DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`description`, `role_id`, `created_by`, `date_created`, `retired`, `retired_by`, `date_retired`, `retire_reason`, `modified_by`, `date_modified`, `name`, `uuid`, `voided`, `date_voided`, `version`, `void_reason`, `voided_by`, `in_stock`, `product_description`, `product_no`) VALUES
(NULL, '44d0da4a-d026-11e1-aea7-24b6fd073a6c', NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 'ROLE_USER', NULL, b'1', NULL, 0, NULL, NULL, NULL, NULL, NULL),
(NULL, 'ff808181385b65b701385b65d1570001', NULL, '2012-07-06 10:26:35', 0, NULL, NULL, NULL, NULL, NULL, 'DATA ENTRY CLERK', NULL, b'1', NULL, 0, NULL, NULL, NULL, NULL, NULL),
(NULL, 'ff808181385b67cf01385b67e47f0001', NULL, '2012-07-06 10:28:51', 0, NULL, NULL, NULL, NULL, NULL, 'ROLE_ADMINISTRATOR', NULL, b'1', NULL, 0, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `role_privilege`
--

CREATE TABLE `role_privilege` (
  `role_id` char(36) NOT NULL,
  `privilege_id` char(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- --------------------------------------------------------

--
-- Table structure for table `station`
--

CREATE TABLE `station` (
  `station_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `external_station_id` varchar(50) DEFAULT NULL,
  `latitude_coordinate` varchar(50) DEFAULT NULL,
  `longitude_coordinate` varchar(50) DEFAULT NULL,
  `station_code` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `station_category_id` varchar(36) DEFAULT NULL,
  `district_id` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `station_category`
--

CREATE TABLE `station_category` (
  `station_category_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `station_category`
--

INSERT INTO `station_category` (`station_category_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `description`, `name`, `retire_reason`, `uuid`, `created_by`, `modified_by`, `voided_by`, `in_stock`, `product_description`, `product_no`) VALUES
('dd3b0f39-377f-4a0b-8841-69977efb1dff', b'1', '2018-12-11', NULL, NULL, NULL, NULL, 'Local Authority', 'Local Authority', NULL, '75ae9ab4-fee3-4ac8-94fc-e7de187144c4', NULL, 'admin@softhub.com', NULL, NULL, NULL, NULL),
('f2ed41cf-e897-4e07-b946-143e36812c3c', b'1', '2018-12-11', NULL, NULL, NULL, NULL, 'Central Hospital', 'Central Hospital', NULL, '316028cd-6a95-49e1-985e-b8d74d84710c', NULL, 'admin@softhub.com', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `supporting_document`
--

CREATE TABLE `supporting_document` (
  `supporting_document_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `retire_reason` varchar(255) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `testing`
--

CREATE TABLE `testing` (
  `testing_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tool`
--

CREATE TABLE `tool` (
  `tool_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `tool_description` varchar(36) NOT NULL,
  `tool_name` varchar(36) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `tool`
--

INSERT INTO `tool` (`tool_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `status`, `tool_description`, `tool_name`, `created_by`, `modified_by`, `voided_by`) VALUES
('63a999aa-a641-47eb-82f0-846829af1adc', b'1', '2021-05-12', '2021-05-20', NULL, NULL, NULL, b'1', '5mm sharp plier', 'Plier', NULL, 'admin@softhub.com', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(128) DEFAULT NULL,
  `employee_id` char(36) CHARACTER SET latin1 COLLATE latin1_swedish_ci DEFAULT NULL,
  `retired` smallint NOT NULL DEFAULT '0',
  `retired_by` varchar(50) DEFAULT NULL,
  `date_retired` datetime DEFAULT NULL,
  `retire_reason` varchar(45) DEFAULT NULL,
  `created_by` varchar(50) DEFAULT NULL,
  `date_created` datetime DEFAULT NULL,
  `changed_by` varchar(50) DEFAULT NULL,
  `date_changed` datetime DEFAULT NULL,
  `secret_question` varchar(255) DEFAULT NULL,
  `secret_answer` varchar(255) DEFAULT NULL,
  `date_modified` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `user_level` int DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `district` varchar(36) DEFAULT NULL,
  `province` varchar(36) DEFAULT NULL,
  `station` varchar(36) DEFAULT NULL,
  `designation` int DEFAULT NULL,
  `in_stock` varchar(255) DEFAULT NULL,
  `product_description` varchar(255) DEFAULT NULL,
  `product_no` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `salt`, `employee_id`, `retired`, `retired_by`, `date_retired`, `retire_reason`, `created_by`, `date_created`, `changed_by`, `date_changed`, `secret_question`, `secret_answer`, `date_modified`, `description`, `name`, `modified_by`, `uuid`, `voided`, `date_voided`, `version`, `void_reason`, `first_name`, `last_name`, `user_level`, `voided_by`, `district`, `province`, `station`, `designation`, `in_stock`, `product_description`, `product_no`, `enabled`) VALUES
('admin@softhub.com', '$2a$10$SPS0S8iPPp5oCS/H7xe5qO/kcwWwgZigkU4j7fZiQjfe6pa7/LCq.', '60a9ee981b700cf4340ada060f86d3ad83e0c3a3bf32335504afaeca32d183947877150f6ba307c370ae514495da545fc517540972a8332185c98214f37b0139', NULL, 0, NULL, NULL, '', NULL, '2012-09-06 15:39:32', NULL, NULL, NULL, NULL, '2018-12-11 00:00:00', NULL, 'A', 'admin@softhub.com', NULL, b'1', NULL, 0, NULL, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, b'0');

-- --------------------------------------------------------

--
-- Table structure for table `user_property`
--

CREATE TABLE `user_property` (
  `user_id` varchar(36) NOT NULL,
  `property_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `username` varchar(36) NOT NULL,
  `role_id` varchar(36) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`username`, `role_id`) VALUES
('admin@softhub.com', 'ff808181385b67cf01385b67e47f0001');

-- --------------------------------------------------------

--
-- Table structure for table `warehouse`
--

CREATE TABLE `warehouse` (
  `warehouse_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `warehouse_description` varchar(255) DEFAULT NULL,
  `warehouse_name` varchar(255) DEFAULT NULL,
  `warehouse_capacity` varchar(255) DEFAULT NULL,
  `maintanance_status` varchar(36) DEFAULT NULL,
  `work_incident_id` varchar(36) DEFAULT NULL,
  `work_order_id` varchar(36) DEFAULT NULL,
  `pos` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `warehouse`
--

INSERT INTO `warehouse` (`warehouse_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `created_by`, `modified_by`, `voided_by`, `warehouse_description`, `warehouse_name`, `warehouse_capacity`, `maintanance_status`, `work_incident_id`, `work_order_id`, `pos`) VALUES
('3c870bd1-9336-4a4c-a934-8996a4795840', b'1', '2021-05-12', '2021-06-03', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, '5 floors, left & right wing', 'Warehouse 5', NULL, NULL, NULL, NULL, NULL),
('60300e7b-62d7-42f9-ae53-bb6eaf976633', b'0', '2021-05-12', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, NULL, 'xx', 'x', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `work_incident`
--

CREATE TABLE `work_incident` (
  `work_incident_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `work_incident_description` varchar(255) DEFAULT NULL,
  `work_incident_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `work_incident`
--

INSERT INTO `work_incident` (`work_incident_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `status`, `created_by`, `modified_by`, `voided_by`, `work_incident_description`, `work_incident_name`) VALUES
('4ef4238c-07f7-41e0-9281-8da06ecf9cf2', b'1', '2021-05-12', '2021-05-20', NULL, NULL, NULL, b'1', NULL, 'admin@softhub.com', NULL, 'Fire in Bay 2 and 3', 'Warehouse 1');

-- --------------------------------------------------------

--
-- Table structure for table `work_order`
--

CREATE TABLE `work_order` (
  `work_order_id` varchar(36) NOT NULL,
  `voided` bit(1) DEFAULT NULL,
  `date_created` date NOT NULL,
  `date_modified` date DEFAULT NULL,
  `date_voided` date DEFAULT NULL,
  `version` bigint DEFAULT NULL,
  `void_reason` varchar(255) DEFAULT NULL,
  `created_by` varchar(36) DEFAULT NULL,
  `modified_by` varchar(36) DEFAULT NULL,
  `voided_by` varchar(36) DEFAULT NULL,
  `work_order_description` varchar(255) DEFAULT NULL,
  `collection_date` datetime DEFAULT NULL,
  `customer_contact` varchar(255) DEFAULT NULL,
  `customer_name` varchar(255) DEFAULT NULL,
  `date_ordered` datetime DEFAULT NULL,
  `work_order_status` varchar(255) DEFAULT NULL,
  `work_order_no` varchar(255) DEFAULT NULL,
  `product_id` varchar(36) NOT NULL,
  `cost` double NOT NULL,
  `quantity` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `work_order`
--

INSERT INTO `work_order` (`work_order_id`, `voided`, `date_created`, `date_modified`, `date_voided`, `version`, `void_reason`, `created_by`, `modified_by`, `voided_by`, `work_order_description`, `collection_date`, `customer_contact`, `customer_name`, `date_ordered`, `work_order_status`, `work_order_no`, `product_id`, `cost`, `quantity`) VALUES
('abe910c4-905d-46aa-90ec-49733326861c', b'1', '2021-06-28', '2021-06-28', NULL, NULL, NULL, NULL, 'admin@softhub.com', NULL, NULL, '2021-07-17 00:00:00', '0772567891', 'Ryden', '2021-06-17 00:00:00', 'Pending', 'b', '8bba7e7d-0de4-4bc2-94bb-8f20c4c28eb1', 10, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account_type`
--
ALTER TABLE `account_type`
  ADD PRIMARY KEY (`account_type_id`);

--
-- Indexes for table `address_type`
--
ALTER TABLE `address_type`
  ADD PRIMARY KEY (`address_type_id`);

--
-- Indexes for table `asset_maintanance`
--
ALTER TABLE `asset_maintanance`
  ADD PRIMARY KEY (`asset_maintanance_id`);

--
-- Indexes for table `batch_status`
--
ALTER TABLE `batch_status`
  ADD PRIMARY KEY (`batch_status_id`);

--
-- Indexes for table `capacity_plan`
--
ALTER TABLE `capacity_plan`
  ADD PRIMARY KEY (`capacity_plan_id`);

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`city_id`);

--
-- Indexes for table `client_maintanance`
--
ALTER TABLE `client_maintanance`
  ADD PRIMARY KEY (`client_maintanance_id`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`company_id`),
  ADD KEY `FK_o0mr66fokm14621o2to4p3mlt` (`company_status_id`),
  ADD KEY `FK_njbr3fo297jf5plmoa5mlj9au` (`company_type_id`);

--
-- Indexes for table `company_address`
--
ALTER TABLE `company_address`
  ADD PRIMARY KEY (`company_address_id`),
  ADD KEY `FK_5j814os1i7goi9ui27c1sxbha` (`address_type_id`),
  ADD KEY `FK_2da3xscp9prbnb537ahvjbj3c` (`company_id`);

--
-- Indexes for table `company_bank_detail`
--
ALTER TABLE `company_bank_detail`
  ADD PRIMARY KEY (`company_bank_detail_id`),
  ADD KEY `FK_oivuob2f8jm2x9b40lht8ucj6` (`account_type_id`),
  ADD KEY `FK_ua9shvqb7cu53rmmjrfcuncr` (`company_id`);

--
-- Indexes for table `company_contact`
--
ALTER TABLE `company_contact`
  ADD PRIMARY KEY (`company_contact_id`),
  ADD KEY `FK_74pcgiu6g8qicj22xnsnrnr41` (`company_id`),
  ADD KEY `FK_i2pg244slbsvrvd3wmdbu563n` (`contact_type_id`);

--
-- Indexes for table `company_director`
--
ALTER TABLE `company_director`
  ADD PRIMARY KEY (`company_director_id`),
  ADD KEY `FK_l9rutwif3a4u3cy1il50m54rq` (`company_id`);

--
-- Indexes for table `company_status`
--
ALTER TABLE `company_status`
  ADD PRIMARY KEY (`company_status_id`);

--
-- Indexes for table `company_type`
--
ALTER TABLE `company_type`
  ADD PRIMARY KEY (`company_type_id`);

--
-- Indexes for table `contact_type`
--
ALTER TABLE `contact_type`
  ADD PRIMARY KEY (`contact_type_id`);

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`district_id`),
  ADD KEY `FK_5x8813je991s9iukbp3q5blkq` (`province_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `finished_products`
--
ALTER TABLE `finished_products`
  ADD PRIMARY KEY (`finished_products_id`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`inventory_id`);

--
-- Indexes for table `machinery`
--
ALTER TABLE `machinery`
  ADD PRIMARY KEY (`machinery_id`);

--
-- Indexes for table `maintanance`
--
ALTER TABLE `maintanance`
  ADD PRIMARY KEY (`maintanance_id`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`material_id`);

--
-- Indexes for table `nationality`
--
ALTER TABLE `nationality`
  ADD PRIMARY KEY (`nationality_id`);

--
-- Indexes for table `priority`
--
ALTER TABLE `priority`
  ADD PRIMARY KEY (`priority_id`);

--
-- Indexes for table `privilege`
--
ALTER TABLE `privilege`
  ADD PRIMARY KEY (`privilege_id`) USING BTREE,
  ADD UNIQUE KEY `UK_h7iwbdg4ev8mgvmij76881tx8` (`name`),
  ADD KEY `FKA1FAF6B1EE34A869` (`created_by`),
  ADD KEY `FKA1FAF6B171027008` (`retired_by`),
  ADD KEY `FKA1FAF6B140868CE8` (`modified_by`),
  ADD KEY `FK_3889eqolaagllikms5uy2kg1l` (`voided_by`);

--
-- Indexes for table `processing_plant`
--
ALTER TABLE `processing_plant`
  ADD PRIMARY KEY (`processing_plant_id`);

--
-- Indexes for table `processing_plant_machinery`
--
ALTER TABLE `processing_plant_machinery`
  ADD PRIMARY KEY (`processing_plant_machinery_id`),
  ADD KEY `FK_7ykv8nb6y8so2pav7rocy04cx` (`processing_plant`);

--
-- Indexes for table `processing_plant_processing_plant_material`
--
ALTER TABLE `processing_plant_processing_plant_material`
  ADD PRIMARY KEY (`processing_plant_material_id`),
  ADD KEY `FK_bxi85oe0v9f5fvhiyrpkutxua` (`processing_plant`);

--
-- Indexes for table `processing_plant_production_run`
--
ALTER TABLE `processing_plant_production_run`
  ADD PRIMARY KEY (`processing_plant_production_run_id`),
  ADD KEY `FK_tfqawyq4mj88yj7inay3w682y` (`processing_plant`);

--
-- Indexes for table `processing_plant_production_team`
--
ALTER TABLE `processing_plant_production_team`
  ADD PRIMARY KEY (`processing_plant_production_team_id`),
  ADD KEY `FK_po7w4m6btpmxhq9to6fncjf84` (`processing_plant`),
  ADD KEY `FK_ndbra84ljihsd4mgubfri9qnf` (`product_warehouse`);

--
-- Indexes for table `processing_plant_tool`
--
ALTER TABLE `processing_plant_tool`
  ADD PRIMARY KEY (`processing_plant_tool_id`),
  ADD KEY `FK_4cpfxco2vgruw8mg74yp0mwtp` (`processing_plant`);

--
-- Indexes for table `process_plan`
--
ALTER TABLE `process_plan`
  ADD PRIMARY KEY (`process_plan_id`),
  ADD KEY `FK_i63sd6yo9cng8wu1dc61h17yh` (`product_batch_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `production_cost`
--
ALTER TABLE `production_cost`
  ADD PRIMARY KEY (`production_cost_id`);

--
-- Indexes for table `production_run`
--
ALTER TABLE `production_run`
  ADD PRIMARY KEY (`production_run_id`);

--
-- Indexes for table `production_team`
--
ALTER TABLE `production_team`
  ADD PRIMARY KEY (`production_team_id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `product_batch`
--
ALTER TABLE `product_batch`
  ADD PRIMARY KEY (`product_batch_id`),
  ADD KEY `FK_jtqjfacscfkrr4k656hhf8c3x` (`batch_status_id`);

--
-- Indexes for table `product_detail`
--
ALTER TABLE `product_detail`
  ADD PRIMARY KEY (`product_detail_id`),
  ADD KEY `FK_jltxv6i7tvdl8vddgwjlvkfy8` (`product_batch_id`);

--
-- Indexes for table `product_requirements`
--
ALTER TABLE `product_requirements`
  ADD PRIMARY KEY (`product_requirements_id`);

--
-- Indexes for table `product_warehouse_machinery`
--
ALTER TABLE `product_warehouse_machinery`
  ADD PRIMARY KEY (`product_warehouse_machinery_id`),
  ADD KEY `FK_suveau5xahgvjn3uf1shdfrtt` (`product_warehouse`);

--
-- Indexes for table `product_warehouse_pos`
--
ALTER TABLE `product_warehouse_pos`
  ADD PRIMARY KEY (`product_warehouse_pos_id`),
  ADD KEY `FK_e7q2tnewmu3w1b37wc5ob9ii6` (`product_warehouse`);

--
-- Indexes for table `product_warehouse_product`
--
ALTER TABLE `product_warehouse_product`
  ADD PRIMARY KEY (`product_warehouse_product_id`),
  ADD KEY `FK_2ihq5p3tdexomlsaxa9dmxp3a` (`product_warehouse`);

--
-- Indexes for table `product_warehouse_production_team`
--
ALTER TABLE `product_warehouse_production_team`
  ADD PRIMARY KEY (`product_warehouse_production_team_id`),
  ADD KEY `FK_d5wlr2w89payx52ebh87ss5vr` (`product_warehouse`);

--
-- Indexes for table `product_warehouse_tool`
--
ALTER TABLE `product_warehouse_tool`
  ADD PRIMARY KEY (`product_warehouse_tool_id`),
  ADD KEY `FK_t3c3w6jrwtbnvrol45q2jkv6t` (`product_warehouse`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`province_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`) USING BTREE,
  ADD UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`),
  ADD KEY `FK358076EE34A869` (`created_by`),
  ADD KEY `FK35807671027008` (`retired_by`),
  ADD KEY `FK35807640868CE8` (`modified_by`),
  ADD KEY `FK_p3melh3h00l88p3twd88vxhv4` (`voided_by`);

--
-- Indexes for table `role_privilege`
--
ALTER TABLE `role_privilege`
  ADD PRIMARY KEY (`role_id`,`privilege_id`) USING BTREE,
  ADD KEY `FK45FBD6281811A1BA` (`privilege_id`),
  ADD KEY `FK45FBD628A7B5F594` (`role_id`),
  ADD KEY `FK45FBD628E399CE8A` (`privilege_id`),
  ADD KEY `FK45FBD628EEA1298A` (`role_id`);

--
-- Indexes for table `station`
--
ALTER TABLE `station`
  ADD PRIMARY KEY (`station_id`),
  ADD KEY `FK_odfn36sjg97v7h9sx606ou6o6` (`station_category_id`),
  ADD KEY `FK_l0ycj5lyinu55orobpige5f8p` (`district_id`);

--
-- Indexes for table `station_category`
--
ALTER TABLE `station_category`
  ADD PRIMARY KEY (`station_category_id`);

--
-- Indexes for table `supporting_document`
--
ALTER TABLE `supporting_document`
  ADD PRIMARY KEY (`supporting_document_id`);

--
-- Indexes for table `testing`
--
ALTER TABLE `testing`
  ADD PRIMARY KEY (`testing_id`);

--
-- Indexes for table `tool`
--
ALTER TABLE `tool`
  ADD PRIMARY KEY (`tool_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD KEY `fk_user_creator` (`created_by`),
  ADD KEY `fk_user_person` (`employee_id`),
  ADD KEY `FK36EBCB28768235` (`changed_by`),
  ADD KEY `FK36EBCB7BF35120` (`retired_by`),
  ADD KEY `FK36EBCBEE34A869` (`created_by`),
  ADD KEY `FK36EBCB71027008` (`retired_by`),
  ADD KEY `FK36EBCB40868CE8` (`modified_by`),
  ADD KEY `FK_mesw6uib7dy3acv70aoj3m4tp` (`voided_by`);

--
-- Indexes for table `user_property`
--
ALTER TABLE `user_property`
  ADD PRIMARY KEY (`user_id`,`property_id`),
  ADD UNIQUE KEY `property_id` (`property_id`),
  ADD KEY `FKC7D137C98BEF12A` (`property_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`username`,`role_id`);

--
-- Indexes for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD PRIMARY KEY (`warehouse_id`),
  ADD KEY `FK_pywju2x6wp7efjrgyx5jg2ya7` (`maintanance_status`),
  ADD KEY `FK_80wu2v7v230rbmki1h0po7ck7` (`work_incident_id`),
  ADD KEY `FK_3ov7n3ikdfcqag82yripbsibd` (`work_order_id`);

--
-- Indexes for table `work_incident`
--
ALTER TABLE `work_incident`
  ADD PRIMARY KEY (`work_incident_id`);

--
-- Indexes for table `work_order`
--
ALTER TABLE `work_order`
  ADD PRIMARY KEY (`work_order_id`),
  ADD KEY `FK_l4bht6jvkltsirihf496wx94w` (`product_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `FK_njbr3fo297jf5plmoa5mlj9au` FOREIGN KEY (`company_type_id`) REFERENCES `company_type` (`company_type_id`),
  ADD CONSTRAINT `FK_o0mr66fokm14621o2to4p3mlt` FOREIGN KEY (`company_status_id`) REFERENCES `company_status` (`company_status_id`);

--
-- Constraints for table `company_address`
--
ALTER TABLE `company_address`
  ADD CONSTRAINT `FK_2da3xscp9prbnb537ahvjbj3c` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `FK_5j814os1i7goi9ui27c1sxbha` FOREIGN KEY (`address_type_id`) REFERENCES `address_type` (`address_type_id`);

--
-- Constraints for table `company_bank_detail`
--
ALTER TABLE `company_bank_detail`
  ADD CONSTRAINT `FK_oivuob2f8jm2x9b40lht8ucj6` FOREIGN KEY (`account_type_id`) REFERENCES `account_type` (`account_type_id`),
  ADD CONSTRAINT `FK_ua9shvqb7cu53rmmjrfcuncr` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- Constraints for table `company_contact`
--
ALTER TABLE `company_contact`
  ADD CONSTRAINT `FK_74pcgiu6g8qicj22xnsnrnr41` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`),
  ADD CONSTRAINT `FK_i2pg244slbsvrvd3wmdbu563n` FOREIGN KEY (`contact_type_id`) REFERENCES `contact_type` (`contact_type_id`);

--
-- Constraints for table `company_director`
--
ALTER TABLE `company_director`
  ADD CONSTRAINT `FK_l9rutwif3a4u3cy1il50m54rq` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`);

--
-- Constraints for table `district`
--
ALTER TABLE `district`
  ADD CONSTRAINT `FK_5x8813je991s9iukbp3q5blkq` FOREIGN KEY (`province_id`) REFERENCES `province` (`province_id`);

--
-- Constraints for table `privilege`
--
ALTER TABLE `privilege`
  ADD CONSTRAINT `FK_3889eqolaagllikms5uy2kg1l` FOREIGN KEY (`voided_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FK_ajhuk2pg04j4qsejvn5sweaw7` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FK_ggtskjnhqownshsfy9ju8jl3w` FOREIGN KEY (`modified_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `processing_plant_machinery`
--
ALTER TABLE `processing_plant_machinery`
  ADD CONSTRAINT `FK_7ykv8nb6y8so2pav7rocy04cx` FOREIGN KEY (`processing_plant`) REFERENCES `processing_plant` (`processing_plant_id`);

--
-- Constraints for table `processing_plant_processing_plant_material`
--
ALTER TABLE `processing_plant_processing_plant_material`
  ADD CONSTRAINT `FK_bxi85oe0v9f5fvhiyrpkutxua` FOREIGN KEY (`processing_plant`) REFERENCES `processing_plant` (`processing_plant_id`);

--
-- Constraints for table `processing_plant_production_run`
--
ALTER TABLE `processing_plant_production_run`
  ADD CONSTRAINT `FK_tfqawyq4mj88yj7inay3w682y` FOREIGN KEY (`processing_plant`) REFERENCES `processing_plant` (`processing_plant_id`);

--
-- Constraints for table `processing_plant_production_team`
--
ALTER TABLE `processing_plant_production_team`
  ADD CONSTRAINT `FK_ndbra84ljihsd4mgubfri9qnf` FOREIGN KEY (`product_warehouse`) REFERENCES `warehouse` (`warehouse_id`),
  ADD CONSTRAINT `FK_po7w4m6btpmxhq9to6fncjf84` FOREIGN KEY (`processing_plant`) REFERENCES `processing_plant` (`processing_plant_id`);

--
-- Constraints for table `processing_plant_tool`
--
ALTER TABLE `processing_plant_tool`
  ADD CONSTRAINT `FK_4cpfxco2vgruw8mg74yp0mwtp` FOREIGN KEY (`processing_plant`) REFERENCES `processing_plant` (`processing_plant_id`);

--
-- Constraints for table `process_plan`
--
ALTER TABLE `process_plan`
  ADD CONSTRAINT `FK_i63sd6yo9cng8wu1dc61h17yh` FOREIGN KEY (`product_batch_id`) REFERENCES `product_batch` (`product_batch_id`);

--
-- Constraints for table `product_batch`
--
ALTER TABLE `product_batch`
  ADD CONSTRAINT `FK_jtqjfacscfkrr4k656hhf8c3x` FOREIGN KEY (`batch_status_id`) REFERENCES `batch_status` (`batch_status_id`);

--
-- Constraints for table `product_detail`
--
ALTER TABLE `product_detail`
  ADD CONSTRAINT `FK_jltxv6i7tvdl8vddgwjlvkfy8` FOREIGN KEY (`product_batch_id`) REFERENCES `product_batch` (`product_batch_id`);

--
-- Constraints for table `product_warehouse_machinery`
--
ALTER TABLE `product_warehouse_machinery`
  ADD CONSTRAINT `FK_suveau5xahgvjn3uf1shdfrtt` FOREIGN KEY (`product_warehouse`) REFERENCES `warehouse` (`warehouse_id`);

--
-- Constraints for table `product_warehouse_pos`
--
ALTER TABLE `product_warehouse_pos`
  ADD CONSTRAINT `FK_e7q2tnewmu3w1b37wc5ob9ii6` FOREIGN KEY (`product_warehouse`) REFERENCES `warehouse` (`warehouse_id`);

--
-- Constraints for table `product_warehouse_product`
--
ALTER TABLE `product_warehouse_product`
  ADD CONSTRAINT `FK_2ihq5p3tdexomlsaxa9dmxp3a` FOREIGN KEY (`product_warehouse`) REFERENCES `warehouse` (`warehouse_id`);

--
-- Constraints for table `product_warehouse_production_team`
--
ALTER TABLE `product_warehouse_production_team`
  ADD CONSTRAINT `FK_d5wlr2w89payx52ebh87ss5vr` FOREIGN KEY (`product_warehouse`) REFERENCES `warehouse` (`warehouse_id`);

--
-- Constraints for table `product_warehouse_tool`
--
ALTER TABLE `product_warehouse_tool`
  ADD CONSTRAINT `FK_t3c3w6jrwtbnvrol45q2jkv6t` FOREIGN KEY (`product_warehouse`) REFERENCES `warehouse` (`warehouse_id`);

--
-- Constraints for table `role`
--
ALTER TABLE `role`
  ADD CONSTRAINT `FK_an2y0kmx8d0foer8i5vj2rfy5` FOREIGN KEY (`modified_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FK_lrvd68ij3575vbcre9bfudvy0` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FK_p3melh3h00l88p3twd88vxhv4` FOREIGN KEY (`voided_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `role_privilege`
--
ALTER TABLE `role_privilege`
  ADD CONSTRAINT `FK_9xg496yxp3mpqmnsdskahammb` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  ADD CONSTRAINT `FK_ibv7nokkl4msov5sl1wyl99n2` FOREIGN KEY (`privilege_id`) REFERENCES `privilege` (`privilege_id`);

--
-- Constraints for table `station`
--
ALTER TABLE `station`
  ADD CONSTRAINT `FK_l0ycj5lyinu55orobpige5f8p` FOREIGN KEY (`district_id`) REFERENCES `district` (`district_id`),
  ADD CONSTRAINT `FK_odfn36sjg97v7h9sx606ou6o6` FOREIGN KEY (`station_category_id`) REFERENCES `station_category` (`station_category_id`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK_90va3gtpnkq1jr6lbb2048dfi` FOREIGN KEY (`created_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FK_b3gh5m8csda04qssow1d6537v` FOREIGN KEY (`modified_by`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FK_mesw6uib7dy3acv70aoj3m4tp` FOREIGN KEY (`voided_by`) REFERENCES `user` (`username`);

--
-- Constraints for table `warehouse`
--
ALTER TABLE `warehouse`
  ADD CONSTRAINT `FK_3ov7n3ikdfcqag82yripbsibd` FOREIGN KEY (`work_order_id`) REFERENCES `work_order` (`work_order_id`),
  ADD CONSTRAINT `FK_80wu2v7v230rbmki1h0po7ck7` FOREIGN KEY (`work_incident_id`) REFERENCES `work_incident` (`work_incident_id`),
  ADD CONSTRAINT `FK_pywju2x6wp7efjrgyx5jg2ya7` FOREIGN KEY (`maintanance_status`) REFERENCES `maintanance` (`maintanance_id`);

--
-- Constraints for table `work_order`
--
ALTER TABLE `work_order`
  ADD CONSTRAINT `FK_l4bht6jvkltsirihf496wx94w` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
