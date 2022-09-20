/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80030
Source Host           : localhost:13306
Source Database       : seafood

Target Server Type    : MYSQL
Target Server Version : 80030
File Encoding         : 65001

Date: 2022-09-18 10:35:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for addresses
-- ----------------------------
DROP TABLE IF EXISTS `addresses`;
CREATE TABLE `addresses` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `street1` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `street2` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `apt_num` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `city` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `state` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `country` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT 'USA',
  `zipcode` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户地址簿';

-- ----------------------------
-- Records of addresses
-- ----------------------------
INSERT INTO `addresses` VALUES ('1', '1', '1', '1', '1', '1', '1', 'USA', '1111', '2022-09-10 23:31:47', null);

-- ----------------------------
-- Table structure for catalog
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `short_desc` varchar(256) DEFAULT NULL,
  `img_url` varchar(256) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分类表';

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', 'Seafood', 'Delicious seafood direct to your home', 'http://localhost:8088/seafood/images/a.jpg', '2022-09-01 22:03:21', '2022-09-01 22:03:23');

-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `catalog_id` bigint NOT NULL,
  `parent_id` bigint DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `short_desc` varchar(255) DEFAULT NULL,
  `full_desc` text,
  `icon_url` varchar(64) DEFAULT NULL,
  `img_url` varchar(64) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品分类表';

-- ----------------------------
-- Records of categories
-- ----------------------------
INSERT INTO `categories` VALUES ('1', '1', '0', 'Fish', 'Fresh fishes', null, null, null, '2022-09-01 22:09:46', '2022-09-01 22:09:46');
INSERT INTO `categories` VALUES ('2', '1', '0', 'Seaweed', 'sea weed', null, null, null, '2022-09-01 22:16:33', '2022-09-01 22:16:31');
INSERT INTO `categories` VALUES ('3', '1', '1', 'Chondrichthyes ', 'Chondrichthyes , like shark', null, null, null, '2022-09-01 22:22:58', '2022-09-01 22:22:58');
INSERT INTO `categories` VALUES ('4', '1', '1', 'Osteichthyes', 'Osteichthyes', null, null, null, '2022-09-01 22:23:21', '2022-09-01 22:23:21');
INSERT INTO `categories` VALUES ('5', '1', '2', 'Kelp', 'Kelp', null, null, null, '2022-09-01 22:18:16', null);
INSERT INTO `categories` VALUES ('6', '1', '2', 'Sargassum pallidum', 'Sargassum pallidum', null, null, null, '2022-09-01 22:19:49', null);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(64) NOT NULL,
  `shipping_address_id` bigint NOT NULL,
  `order_amount` double DEFAULT NULL,
  `tax_subtotal` double DEFAULT NULL,
  `shipping_subtotal` double DEFAULT NULL,
  `order_total` double DEFAULT NULL,
  `status` tinyint DEFAULT '0' COMMENT '0：待支付;1支付完成；2取消支付;3已经发货;4已完成',
  `payment_info` text,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '1', '1', '1', '1', '1', '0', '{\'method\': \'CR\', \'account\': \'1234567890123456\', \'holdername\': \'Pooky Doo\', \'expirydate\': \'2911\', \'billingzipcode\': \'98004\' }', '2022-09-11 09:47:30', '2022-09-11 09:47:30');
INSERT INTO `orders` VALUES ('2', '1', '1', null, null, null, null, '0', '{\"method\": \"CR\", \"account\": \"1234567890123456\", \"holdername\": \"Pooky Doo\", \"expirydate\": \"2911\", \"billingzipcode\": \"98004\"}', '2022-09-17 23:43:44', null);
INSERT INTO `orders` VALUES ('3', '1', '1', null, null, null, null, '0', '{\"method\": \"CR\", \"account\": \"1234567890123456\", \"holdername\": \"Pooky Doo\", \"expirydate\": \"2911\", \"billingzipcode\": \"98004\"}', '2022-09-17 23:47:40', null);
INSERT INTO `orders` VALUES ('4', '1', '1', null, null, null, null, '0', '{\"method\": \"CR\", \"account\": \"1234567890123456\", \"holdername\": \"Pooky Doo\", \"expirydate\": \"2911\", \"billingzipcode\": \"98004\"}', '2022-09-18 08:04:13', null);
INSERT INTO `orders` VALUES ('5', '1', '1', null, null, null, null, '0', '{\"method\": \"CR\", \"account\": \"1234567890123456\", \"holdername\": \"Pooky Doo\", \"expirydate\": \"2911\", \"billingzipcode\": \"98004\"}', '2022-09-18 08:13:03', null);
INSERT INTO `orders` VALUES ('6', '1', '1', null, null, null, null, '0', '{\"method\": \"CR\", \"account\": \"1234567890123456\", \"holdername\": \"Pooky Doo\", \"expirydate\": \"2911\", \"billingzipcode\": \"98004\"}', '2022-09-18 08:13:52', null);
INSERT INTO `orders` VALUES ('7', '1', '1', null, null, null, null, '0', '{\"method\": \"CR\", \"account\": \"1234567890123456\", \"holdername\": \"Pooky Doo\", \"expirydate\": \"2911\", \"billingzipcode\": \"98004\"}', '2022-09-18 09:24:45', null);

-- ----------------------------
-- Table structure for order_line_items
-- ----------------------------
DROP TABLE IF EXISTS `order_line_items`;
CREATE TABLE `order_line_items` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `order_id` bigint NOT NULL,
  `product_id` bigint NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `quantity` int DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `express_number` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `express_company` varchar(64) DEFAULT NULL,
  `express_type` tinyint DEFAULT NULL COMMENT '0:顺丰;',
  `measuring_unit` varchar(64) DEFAULT NULL,
  `units_ordered` bigint DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `line_amount` double DEFAULT NULL,
  `line_tax` double DEFAULT NULL,
  `line_total` double(255,0) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单与商品关系表';

-- ----------------------------
-- Records of order_line_items
-- ----------------------------
INSERT INTO `order_line_items` VALUES ('1', '1', '10101', '2022-09-11 08:40:52', '2022-09-11 08:40:52', '7', '64.3', 'SF1370217729273', '顺丰速递', '0', null, null, null, null, null, null);
INSERT INTO `order_line_items` VALUES ('2', '2', '10101', '2022-09-18 09:30:30', '2022-09-18 09:30:30', '10', '0', 'SF1370217729273', '顺丰速递', '0', null, '0', null, null, null, null);
INSERT INTO `order_line_items` VALUES ('3', '3', '10101', '2022-09-18 09:30:23', '2022-09-18 09:30:23', '10', '0', 'SF1370217729273', '顺丰速递', '0', null, '0', '0', '0', '0', '0');
INSERT INTO `order_line_items` VALUES ('4', '4', '10101', '2022-09-18 09:30:23', '2022-09-18 09:30:23', '10', '0', 'SF1370217729273', '顺丰速递', '0', null, '0', '0', '0', '0', '0');
INSERT INTO `order_line_items` VALUES ('5', '5', '10101', '2022-09-18 09:30:24', '2022-09-18 09:30:24', '10', '0', 'SF1370217729273', '顺丰速递', '0', null, '0', '0', '0', '0', '0');
INSERT INTO `order_line_items` VALUES ('6', '6', '10101', '2022-09-18 09:30:25', '2022-09-18 09:30:25', '10', '0', 'SF1370217729273', '顺丰速递', '0', null, '0', '0', '0', '0', '0');
INSERT INTO `order_line_items` VALUES ('7', '7', '10101', '2022-09-18 09:30:25', '2022-09-18 09:30:25', '10', '0', 'SF1370217729273', '顺丰速递', '0', null, '0', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for pay_info
-- ----------------------------
DROP TABLE IF EXISTS `pay_info`;
CREATE TABLE `pay_info` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `method` varchar(32) DEFAULT NULL,
  `account` varchar(256) DEFAULT NULL,
  `holder_name` varchar(128) DEFAULT NULL,
  `expiry_date` varchar(128) DEFAULT NULL,
  `billing_zip_code` varchar(64) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of pay_info
-- ----------------------------

-- ----------------------------
-- Table structure for products
-- ----------------------------
DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `catalog_id` bigint NOT NULL,
  `category_id` bigint NOT NULL,
  `name` varchar(32) NOT NULL,
  `short_desc` varchar(256) DEFAULT NULL,
  `full_desc` text,
  `icon_url` varchar(256) DEFAULT NULL,
  `img_url` varchar(256) DEFAULT NULL,
  `inventory` bigint DEFAULT NULL,
  `price` varchar(128) DEFAULT NULL,
  `measuring_unit` varchar(16) DEFAULT NULL,
  `min_order_units` bigint DEFAULT '0',
  `max_order_units` bigint DEFAULT NULL,
  `order_step_units` bigint DEFAULT '1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='单品';

-- ----------------------------
-- Records of products
-- ----------------------------
INSERT INTO `products` VALUES ('10101', '1', '3', 'fish2', '10102', '10102', '10102', '10102', '1000', '9.99', '10102', '10102', '10102', '10102', '2022-09-14 23:22:47', '2022-09-14 23:22:47');
INSERT INTO `products` VALUES ('10102', '1', '3', 'fish', 'fish', 'fish fish', '10102', '10102', '2000', '11.11', '10102', '0', '10102', '1', '2022-09-14 23:22:57', '2022-09-14 23:22:57');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `id_type` tinyint DEFAULT NULL COMMENT '0:aws;1:google;2github',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `id_authority` varchar(128) NOT NULL,
  `email` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `is_disable` tinyint DEFAULT '0' COMMENT '是否禁用，1表示禁用',
  `user_img` varchar(128) DEFAULT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户信息表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '1', 'EasonFeng5870', '1', 'eason.fengys@gamil.com', '0', 'https://avatars.githubusercontent.com/u/8294666?s=40&v=4', '2022-09-10 21:30:22', '2022-09-10 21:30:22');
