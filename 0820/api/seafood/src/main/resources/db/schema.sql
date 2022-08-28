use seafood;


--
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
CREATE TABLE `addresses` (
                             `id` bigint NOT NULL,
                             `user_id` bigint NOT NULL,
                             `street1` varchar(128) NOT NULL,
                             `street2` varchar(128) DEFAULT NULL,
                             `apt_num` varchar(16) DEFAULT NULL,
                             `city` varchar(32) NOT NULL,
                             `state` varchar(32) NOT NULL,
                             `country` varchar(8) DEFAULT 'USA',
                             `zipcode` varchar(32) NOT NULL,
                             PRIMARY KEY (`id`),
                             UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `catalog`
--

DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
                           `id` bigint NOT NULL,
                           `name` varchar(256) DEFAULT NULL,
                           `short_desc` varchar(256) DEFAULT NULL,
                           `img_url` varchar(256) DEFAULT NULL,
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `id_UNIQUE` (`id`),
                           UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='分类表';

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
                              `id` bigint NOT NULL,
                              `catalog_id` bigint NOT NULL,
                              `parent_id` bigint DEFAULT NULL,
                              `name` varchar(32) DEFAULT NULL,
                              `short_desc` varchar(255) DEFAULT NULL,
                              `full_desc` text,
                              `icon_url` varchar(64) DEFAULT NULL,
                              `img_url` varchar(64) DEFAULT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `id_UNIQUE` (`id`),
                              UNIQUE KEY `catalog_id_UNIQUE` (`catalog_id`),
                              UNIQUE KEY `parent_id_UNIQUE` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Dumping data for table `categories`
--

--
-- Table structure for table `order_line_items`
--

DROP TABLE IF EXISTS `order_line_items`;
CREATE TABLE `order_line_items` (
                                    `id` bigint NOT NULL,
                                    `order_id` bigint NOT NULL,
                                    `product_id` bigint NOT NULL,
                                    PRIMARY KEY (`id`),
                                    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `order_line_items`
--

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `user_id` varchar(64) NOT NULL,
                          `shipping_address_id` bigint NOT NULL,
                          `order_amount` double DEFAULT NULL,
                          `tax_subtotal` double DEFAULT NULL,
                          `shipping_subtotal` double DEFAULT NULL,
                          `order_total` double DEFAULT NULL,
                          `payment_info` text,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `orders`
--

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
                            `id` bigint NOT NULL,
                            `catalog_id` bigint NOT NULL,
                            `category_id` bigint NOT NULL,
                            `name` varchar(32) NOT NULL,
                            `short_desc` varchar(256) DEFAULT NULL,
                            `full_desc` text,
                            `icon_url` varchar(256) DEFAULT NULL,
                            `img_url` varchar(256) DEFAULT NULL,
                            `measuring_unit` varchar(16) DEFAULT NULL,
                            `min_order_units` bigint DEFAULT '0',
                            `max_order_units` bigint DEFAULT NULL,
                            `order_step_units` bigint DEFAULT '1',
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='单品';

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
                         `id` bigint NOT NULL,
                         `id_authority` varchar(128) NOT NULL,
                         `email` varchar(256) NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;